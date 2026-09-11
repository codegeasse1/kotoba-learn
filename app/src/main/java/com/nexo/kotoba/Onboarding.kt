package com.nexo.kotoba

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
    var target by remember { mutableStateOf("ja") }

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
                            "If yours isn't listed yet, English works as a fallback.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                } else {
                    NATIVE_LANGUAGES.forEach { (code, name) ->
                        FilterChip(
                            selected = target == code,
                            onClick = { target = code },
                            label = { Text(name) }
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(
                        if (target == native)
                            "Learning and native language are the same — pick a different one to study if you can."
                        else
                            "You'll study ${nativeName(target)} with ${nativeName(native)} explanations.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        confirmButton = {
            if (step == 0) {
                TextButton(onClick = { step = 1 }) { Text("Next") }
            } else {
                TextButton(onClick = {
                    store.finishOnboarding(native, target)
                    onDone()
                }) { Text("Start learning") }
            }
        },
        dismissButton = {
            if (step == 0) {
                TextButton(onClick = {
                    store.finishOnboarding("en", "ja")
                    onDone()
                }) { Text("Skip") }
            } else {
                TextButton(onClick = { step = 0 }) { Text("Back") }
            }
        }
    )
}
