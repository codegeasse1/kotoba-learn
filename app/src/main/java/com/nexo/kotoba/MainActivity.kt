package com.nexo.kotoba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen { HOME, LEARN, REVIEW, GRAMMAR, PROFILE }

private data class Tab(val screen: Screen, val label: String, val filled: ImageVector, val outlined: ImageVector)

private val tabs = listOf(
    Tab(Screen.HOME, "Home", Icons.Filled.Home, Icons.Outlined.Home),
    Tab(Screen.LEARN, "Learn", Icons.Filled.MenuBook, Icons.Outlined.MenuBook),
    Tab(Screen.REVIEW, "Review", Icons.Filled.Quiz, Icons.Outlined.Quiz),
    Tab(Screen.GRAMMAR, "Grammar", Icons.Filled.Translate, Icons.Outlined.Translate),
    Tab(Screen.PROFILE, "Profile", Icons.Filled.Person, Icons.Outlined.Person)
)

class MainActivity : ComponentActivity() {

    private lateinit var speaker: Speaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val store = Store(applicationContext)
        store.load()
        speaker = Speaker(applicationContext)

        setContent {
            KotobaTheme {
                var screen by remember { mutableStateOf(Screen.HOME) }
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
                                    label = { Text(tab.label) }
                                )
                            }
                        }
                    }
                ) { pad ->
                    val contentMod = Modifier.padding(pad)
                    when (screen) {
                        Screen.HOME -> HomeScreen(store, speaker, contentMod, onNav = { screen = it })
                        Screen.LEARN -> LearnScreen(store, speaker, contentMod)
                        Screen.REVIEW -> ReviewScreen(store, speaker, contentMod)
                        Screen.GRAMMAR -> GrammarScreen(store, speaker, contentMod)
                        Screen.PROFILE -> ProfileScreen(store, speaker, contentMod)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::speaker.isInitialized) speaker.shutdown()
    }
}
