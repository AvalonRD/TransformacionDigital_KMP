package org.navigation.guide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

// --- 1. DEFINICIÓN DE LAS 5 RUTAS ---
@Serializable
object Home

@Serializable
data class Profile(val name: String) // Esta recibe datos

@Serializable
object Settings

@Serializable
object Gallery

@Serializable
object About

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        // Mapa de Nav
        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
        ) {

            // Ruta 1: Inicio
            composable<Home> {
                HomeScreen(
                    onNavigateToProfile = { navController.navigate(Profile("Usuario VIP")) },
                    onNavigateToSettings = { navController.navigate(Settings) },
                    onNavigateToGallery = { navController.navigate(Gallery) },
                    onNavigateToAbout = { navController.navigate(About) }
                )
            }

            // Ruta 2: Perfil
            composable<Profile> { backStackEntry ->
                val profile: Profile = backStackEntry.toRoute()
                ProfileScreen(name = profile.name, onBack = { navController.popBackStack() })
            }

            // Ruta 3: Configuración
            composable<Settings> {
                SettingsScreen(onBack = { navController.popBackStack() })
            }

            // Ruta 4: Galería
            composable<Gallery> {
                GalleryScreen(onBack = { navController.popBackStack() })
            }

            // Ruta 5: Sobre nosotros o algoasi
            composable<About> {
                AboutScreen(onBack = { navController.popBackStack() })
            }
        }
    }
}

// --- 3. PANTALLAS

@Composable
fun HomeScreen(
    onNavigateToProfile: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToGallery: () -> Unit,
    onNavigateToAbout: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Menú Principal", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(30.dp))

        // Botones para ir a las otras 4 rutas
        BotonMenu("Ir a Perfil (con datos)", onNavigateToProfile)
        BotonMenu("Ir a Configuración", onNavigateToSettings)
        BotonMenu("Ir a Galería", onNavigateToGallery)
        BotonMenu("Acerca de la App", onNavigateToAbout)
    }
}

// Boton reutilizable
@Composable
fun BotonMenu(texto: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth(0.7f).padding(8.dp)) {
        Text(texto)
    }
}

// --- SECUNDARIAS

@Composable
fun ProfileScreen(name: String, onBack: () -> Unit) {
    PantallaBase("Perfil de Usuario") {
        Text("Bienvenido, $name", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onBack) { Text("Regresar") }
    }
}

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
        Text(" Fotos aqui", style = MaterialTheme.typography.bodyLarge)
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

// Una plantilla para que todas las pantallas se vean centradas y limpias
@Composable
fun PantallaBase(titulo: String, contenido: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(titulo, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(20.dp))
        contenido()
    }
}