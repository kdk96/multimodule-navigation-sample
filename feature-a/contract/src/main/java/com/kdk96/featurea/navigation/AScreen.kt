package com.kdk96.featurea.navigation

import android.os.Parcelable
import com.github.terrakok.cicerone.Screen
import kotlinx.parcelize.Parcelize

open class AScreen(val args: AScreenArgs) : Screen

@Parcelize
data class AScreenArgs(
    val id: Long,
    val title: String,
) : Parcelable