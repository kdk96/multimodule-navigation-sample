package com.kdk96.multimodulenavigation.navigation

import com.github.terrakok.cicerone.Screen

fun interface ScreenBinder<S : Screen, I : Screen> {
    fun bind(screen: S): I
}
