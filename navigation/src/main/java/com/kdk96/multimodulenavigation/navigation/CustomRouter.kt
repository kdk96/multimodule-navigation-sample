package com.kdk96.multimodulenavigation.navigation

import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.BackTo
import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.Screen

class CustomRouter : BaseRouter() {

    private val binders = HashMap<Class<out Screen>, ScreenBinder<Screen, Screen>>()

    fun navigateTo(screen: Screen) {
        executeCommands(Forward(screen.bind()))
    }

    fun newRootScreen(screen: Screen) {
        executeCommands(BackTo(null), Replace(screen.bind()))
    }

    fun replaceScreen(screen: Screen) {
        executeCommands(Replace(screen.bind()))
    }

    fun backTo(screen: Screen?) {
        executeCommands(BackTo(screen?.bind()))
    }

    fun newChain(vararg screens: Screen) {
        val commands = screens.map { Forward(it.bind()) }
        executeCommands(*commands.toTypedArray())
    }

    fun newRootChain(vararg screens: Screen) {
        val commands = screens.mapIndexed { index, screen ->
            val boundScreen = screen.bind()
            if (index == 0) {
                Replace(boundScreen)
            } else {
                Forward(boundScreen)
            }
        }
        executeCommands(BackTo(null), *commands.toTypedArray())
    }

    fun finishChain() {
        executeCommands(BackTo(null), Back())
    }

    fun exit() {
        executeCommands(Back())
    }

    fun <S : Screen, Impl : Screen> registerBinder(screenClass: Class<S>, binder: ScreenBinder<S, Impl>) {
        @Suppress("UNCHECKED_CAST")
        binders[screenClass] = binder as ScreenBinder<Screen, Screen>
    }

    private fun Screen.bind(): Screen = binders[this::class.java]?.bind(this)
        ?: throw IllegalStateException("binder for $this has not found")
}
