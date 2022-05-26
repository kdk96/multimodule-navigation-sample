package com.kdk96.multimodulenavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.kdk96.featurea.navigation.AScreen
import com.kdk96.featurea.navigation.AScreenArgs
import com.kdk96.featureb.navigation.BScreen
import com.kdk96.multimodulenavigation.featurea.AScreenBinder
import com.kdk96.multimodulenavigation.featureb.BScreenBinder
import com.kdk96.multimodulenavigation.navigation.GlobalRouterHolder

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.fragment_container_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            GlobalRouterHolder.router.apply {
                registerBinder(AScreen::class.java, AScreenBinder())
                registerBinder(BScreen::class.java, BScreenBinder())

                replaceScreen(AScreen(AScreenArgs(0, "Hello")))
            }
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        GlobalRouterHolder.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        GlobalRouterHolder.navigatorHolder.removeNavigator()
        super.onPause()
    }
}
