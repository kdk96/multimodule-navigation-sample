package com.kdk96.multimodulenavigation.featurea

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kdk96.featurea.navigation.AScreen
import com.kdk96.featurea.navigation.AScreenArgs
import com.kdk96.multimodulenavigation.navigation.ScreenBinder

class AScreenImpl(args: AScreenArgs) : AScreen(args), FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment {
        return AFragment().apply {
            arguments = bundleOf("args" to args)
        }
    }
}

class AScreenBinder : ScreenBinder<AScreen, AScreenImpl> {
    override fun bind(screen: AScreen): AScreenImpl {
        return AScreenImpl(screen.args)
    }
}