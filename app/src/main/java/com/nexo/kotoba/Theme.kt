package com.nexo.kotoba

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Light = lightColorScheme(
    primary = Color(0xFF4A5BE8),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFDEE1FF),
    onPrimaryContainer = Color(0xFF00105C),
    secondary = Color(0xFFE5396D),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFFD9E0),
    onSecondaryContainer = Color(0xFF40000F),
    tertiary = Color(0xFF00875F),
    onTertiary = Color.White,
    background = Color(0xFFF6F7FF),
    onBackground = Color(0xFF1A1B22),
    surface = Color(0xFFFCFCFF),
    onSurface = Color(0xFF1A1B22),
    surfaceVariant = Color(0xFFE7E7F0),
    onSurfaceVariant = Color(0xFF45464F)
)

private val Dark = darkColorScheme(
    primary = Color(0xFFB8C0FF),
    onPrimary = Color(0xFF10205E),
    primaryContainer = Color(0xFF2F3A87),
    onPrimaryContainer = Color(0xFFDEE1FF),
    secondary = Color(0xFFFFB1C3),
    onSecondary = Color(0xFF63001F),
    secondaryContainer = Color(0xFF8A002F),
    onSecondaryContainer = Color(0xFFFFD9E0),
    tertiary = Color(0xFF54DBAE),
    onTertiary = Color(0xFF003824),
    background = Color(0xFF121318),
    onBackground = Color(0xFFE4E2EB),
    surface = Color(0xFF121318),
    onSurface = Color(0xFFE4E2EB),
    surfaceVariant = Color(0xFF45464F),
    onSurfaceVariant = Color(0xFFC6C6D0)
)

@Composable
fun KotobaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(colorScheme = if (darkTheme) Dark else Light, content = content)
}
