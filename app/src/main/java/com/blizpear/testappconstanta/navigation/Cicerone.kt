package com.blizpear.testappconstanta.navigation

import com.github.terrakok.cicerone.Cicerone

fun provideCicerone() = Cicerone.create().apply {
	router.newRootScreen(provideRootScreen())
}