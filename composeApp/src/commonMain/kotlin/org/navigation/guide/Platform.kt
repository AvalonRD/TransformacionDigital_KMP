package org.navigation.guide

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform