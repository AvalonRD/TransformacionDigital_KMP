package org.navigation.guide.navigation

import kotlinx.serialization.Serializable

@Serializable object Home
@Serializable data class Profile(val name: String)
@Serializable object Settings
@Serializable object Gallery
@Serializable object About