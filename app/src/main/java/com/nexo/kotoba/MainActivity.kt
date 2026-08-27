package com.nexo.kotoba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home as FHome
import androidx.compose.material.icons.filled.MenuBook as FMenuBook
import androidx.compose.material.icons.filled.Person as FPerson
import androidx.compose.material.icons.filled.Quiz as FQuiz
import androidx.compose.material.icons.filled.Translate as FTranslate
import androidx.compose.material.icons.outlined.Home as OHome
import androidx.compose.material.icons.outlined.MenuBook as OMenuBook
import androidx.compose.material.icons.outlined.Person as OPerson
import androidx.compose.material.icons.outlined.Quiz as OQuiz
import androidx.compose.material.icons.outlined.Translate as OTranslate
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
    Tab(Screen.HOME, "Home", FHome, OHome),
    Tab(Screen.LEARN, "Learn", FMenuBook, OMenuBook),
    Tab(Screen.REVIEW, "Review", FQuiz, OQuiz),
    Tab(Screen.GRAMMAR, "Grammar", FTranslate, OTranslate),
    Tab(Screen.PROFILE, "Profile", FPerson, OPerson)
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
