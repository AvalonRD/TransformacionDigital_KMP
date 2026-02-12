package org.navigation.guide.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.navigation.guide.ui.components.PantallaBase

@Composable
fun ProfileScreen(name: String, onBack: () -> Unit) {
    PantallaBase("Perfil de Usuario") {
        Text("Bienvenido, $name", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onBack) { Text("Regresar") }
    }
}