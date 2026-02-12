package org.navigation.guide.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.navigation.guide.navigation.*
import org.navigation.guide.ui.components.BotonMenu
import org.navigation.guide.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigate: (Any) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(viewModel.tituloPrincipal, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(30.dp))

        BotonMenu("Ir a Perfil") { onNavigate(Profile(viewModel.obtenerNombreUsuarioVip())) }
        BotonMenu("Ir a Configuración") { onNavigate(Settings) }
        BotonMenu("Ir a Galería") { onNavigate(Gallery) }
        BotonMenu("Acerca de la App") { onNavigate(About) }
    }
}