package org.navigation.guide.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.navigation.guide.ui.components.PantallaBase

@Composable
fun SettingsScreen(onBack: () -> Unit) {
    PantallaBase("Configuración") {
        Text("Aquí irían los ajustes...", style = MaterialTheme.typography.bodyLarge)
        Switch(checked = true, onCheckedChange = {})
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onBack) { Text("Guardar y Salir") }
    }
}

@Composable
fun GalleryScreen(onBack: () -> Unit) {
    PantallaBase("Galería de Fotos") {
        Text("Fotos aquí", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = onBack) { Text("Cerrar Galería") }
    }
}

@Composable
fun AboutScreen(onBack: () -> Unit) {
    PantallaBase("Acerca de") {
        Text("Versión 1.0.0", style = MaterialTheme.typography.titleMedium)
        Text("Creada con KMP y Nav3", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onBack) { Text("Entendido") }
    }
}