package com.kdk96.multimodulenavigation.featureb

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kdk96.featurea.navigation.AScreen
import com.kdk96.featurea.navigation.AScreenArgs
import com.kdk96.featureb.navigation.BScreen
import com.kdk96.featureb.navigation.BScreenArgs
import com.kdk96.multimodulenavigation.navigation.GlobalRouterHolder

class BFragment : Fragment(R.layout.fragment_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args: BScreenArgs = requireArguments().getParcelable("args")!!

        view.findViewById<TextView>(R.id.title).text = "BFragment id: ${args.id} title: ${args.title}"
        view.findViewById<Button>(R.id.to_a).setOnClickListener {
            GlobalRouterHolder.router.navigateTo(AScreen(AScreenArgs(args.id.inc(), "World")))
        }
        view.findViewById<Button>(R.id.to_b).setOnClickListener {
            GlobalRouterHolder.router.navigateTo(BScreen(BScreenArgs(args.id.inc(), "Hello")))
        }
    }
}
