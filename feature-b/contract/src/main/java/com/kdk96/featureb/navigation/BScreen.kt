package com.kdk96.featureb.navigation

import android.os.Parcelable
import com.github.terrakok.cicerone.Screen
import kotlinx.parcelize.Parcelize

open class BScreen(val args: BScreenArgs) : Screen

@Parcelize
data class BScreenArgs(
    val id: Long,
    val title: String,
) : Parcelable