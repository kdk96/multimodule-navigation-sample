package com.kdk96.multimodulenavigation.navigation

import com.github.terrakok.cicerone.Cicerone

object GlobalRouterHolder {
    private val cicerone = Cicerone.create(CustomRouter())

    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()
}