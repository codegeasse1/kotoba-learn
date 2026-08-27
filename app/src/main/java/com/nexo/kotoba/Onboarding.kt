package com.nexo.kotoba

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingDialog(store: Store, onDone: () -> Unit) {
    var step by remember { mutableStateOf(0) }
    var native by remember { mutableStateOf("en") }

    val targets = listOf(
        Direction.JAPANESE to "🇯🇵 Japanese",
        Direction.ENGLISH to "🇬🇧 English",
        Direction.BOTH to "🌍 Both"
    )

    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(
                if (step == 0) "What is your native language?" else "What do you want to learn?",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(
                Modifier.verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (step == 0) {
                    NATIVE_LANGUAGES.forEach { (code, name) ->
                        FilterChip(
                            selected = native == code,
                            onClick = { native = code },
                            label = { Text(name) }
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "Kotoba teaches you with explanations in YOUR language. " +
                            "More languages are always being added — if yours isn't listed yet, English works as a fallback.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                } else {
                    targets.forEach { (dir, name) ->
                        FilterChip(
                            selected = when (dir) {
                                Direction.JAPANESE -> store.direction == Direction.JAPANESE
                                Direction.ENGLISH -> store.direction == Direction.ENGLISH
                                Direction.BOTH -> store.direction == Direction.BOTH
                            },
                            onClick = {
                                store.finishOnboarding(native, dir)
                                onDone()
                            },
                            label = { Text(name) }
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(
                        if (native == "hi")
                            "Hindi is set as your teaching language. Every word, phrase and grammar rule will show a Hindi meaning."
                        else if (native == "ja")
                            "Japanese is set as your teaching language."
                        else
                            "Explanations will be shown in ${nativeName(native)} when available, else English.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        confirmButton = {
            if (step == 0) {
                TextButton(onClick = { step = 1 }) { Text("Next") }
            }
        },
        dismissButton = {
            if (step == 0) {
                TextButton(onClick = {
                    store.finishOnboarding("en", Direction.JAPANESE)
                    onDone()
                }) { Text("Skip") }
            }
        }
    )
}
