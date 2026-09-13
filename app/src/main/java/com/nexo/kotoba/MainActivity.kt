package com.nexo.kotoba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

enum class Screen { HOME, LEARN, REVIEW, GRAMMAR, DICTIONARY, PROFILE }

private data class Tab(val screen: Screen, val label: String, val filled: ImageVector, val outlined: ImageVector)

private val tabs = listOf(
    Tab(Screen.HOME, "Home", Icons.Filled.Home, Icons.Outlined.Home),
    Tab(Screen.LEARN, "Learn", Icons.Filled.MenuBook, Icons.Outlined.MenuBook),
    Tab(Screen.REVIEW, "Review", Icons.Filled.Quiz, Icons.Outlined.Quiz),
    Tab(Screen.GRAMMAR, "Grammar", Icons.Filled.Translate, Icons.Outlined.Translate),
    Tab(Screen.DICTIONARY, "Words", Icons.Filled.Search, Icons.Outlined.Search),
    Tab(Screen.PROFILE, "Profile", Icons.Filled.Person, Icons.Outlined.Person)
)

class MainActivity : ComponentActivity() {

    private lateinit var speaker: Speaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val store = Store(applicationContext)
        store.load()
        KanjiData.init(applicationContext)
        Gloss.attach(applicationContext)
        Gloss.ensure(store.nativeLang)
        Gloss.ensureTarget(store.target)
        Thread { DictionaryData.init(applicationContext) }.start()
        Thread { Verbs.init(applicationContext) }.start()
        speaker = Speaker(applicationContext)

        setContent {
            KotobaTheme {
                Gloss.ensure(store.nativeLang)
                Gloss.ensureTarget(store.target)
                var screen by remember { mutableStateOf(Screen.HOME) }
                val ctx = LocalContext.current
                var updateInfo by remember { mutableStateOf<UpdateInfo?>(null) }
                LaunchedEffect(store.onboarded) {
                    if (!store.onboarded) return@LaunchedEffect
                    val info = Updater.check(ctx)
                    if (info != null && info.version != store.dismissedUpdate) updateInfo = info
                }
                BackHandler(enabled = screen != Screen.HOME) { screen = Screen.HOME }
                if (!store.onboarded) {
                    OnboardingDialog(store, onDone = { screen = Screen.HOME })
                }
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            tabs.forEach { tab ->
                                NavigationBarItem(
                                    selected = screen == tab.screen,
                                    onClick = { screen = tab.screen },
                                    icon = {
                                        Icon(
                                            imageVector = if (screen == tab.screen) tab.filled else tab.outlined,
                                            contentDescription = tab.label
                                        )
                                    },
                                    label = {
                                        Text(
                                            tab.label,
                                            fontSize = 10.sp,
                                            fontWeight = if (screen == tab.screen) FontWeight.Bold else FontWeight.Normal,
                                            maxLines = 1,
                                            overflow = TextOverflow.Clip
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { pad ->
                    val contentMod = Modifier.padding(pad)
                    key(store.nativeLang, store.target) {
                        when (screen) {
                            Screen.HOME -> HomeScreen(store, speaker, contentMod, onNav = { screen = it })
                            Screen.LEARN -> LearnScreen(store, speaker, contentMod)
                            Screen.REVIEW -> ReviewScreen(store, speaker, contentMod)
                            Screen.GRAMMAR -> GrammarScreen(store, speaker, contentMod)
                            Screen.DICTIONARY -> WordsScreen(store, speaker, contentMod)
                            Screen.PROFILE -> ProfileScreen(store, speaker, contentMod)
                        }
                    }
                }
                updateInfo?.let { info ->
                    UpdateAvailableDialog(
                        info = info,
                        currentVersion = Updater.currentVersion(ctx),
                        onDismiss = {
                            store.dismissUpdate(info.version)
                            updateInfo = null
                        }
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::speaker.isInitialized) speaker.shutdown()
    }
}
