package org.navigation.guide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import androidx.navigation.toRoute
import org.navigation.guide.navigation.*
import org.navigation.guide.ui.screens.*
import org.navigation.guide.viewmodel.HomeViewModel

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
        ) {
            composable<Home> {
                val vm: HomeViewModel = viewModel()
                HomeScreen(viewModel = vm, onNavigate = { navController.navigate(it) })
            }

            composable<Profile> { backStackEntry ->
                val profile: Profile = backStackEntry.toRoute()
                ProfileScreen(name = profile.name, onBack = { navController.popBackStack() })
            }

            composable<Settings> {
                SettingsScreen(onBack = { navController.popBackStack() })
            }

            composable<Gallery> {
                GalleryScreen(onBack = { navController.popBackStack() })
            }

            composable<About> {
                AboutScreen(onBack = { navController.popBackStack() })
            }
        }
    }
}