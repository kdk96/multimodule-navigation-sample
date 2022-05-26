package com.kdk96.multimodulenavigation.featureb

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kdk96.featureb.navigation.BScreen
import com.kdk96.featureb.navigation.BScreenArgs
import com.kdk96.multimodulenavigation.navigation.ScreenBinder

class BScreenImpl(args: BScreenArgs) : BScreen(args), FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment {
        return BFragment().apply {
            arguments = bundleOf("args" to args)
        }
    }
}

class BScreenBinder : ScreenBinder<BScreen, BScreenImpl> {
    override fun bind(screen: BScreen): BScreenImpl {
        return BScreenImpl(screen.args)
    }
}

