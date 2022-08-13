package com.blizpear.testappconstanta.di

import com.blizpear.testappconstanta.navigation.provideCicerone
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module

val globalNavigationModule = module {

	single { provideCicerone() }
	single { get<Cicerone<Router>>().router }
	single { get<Cicerone<Router>>().getNavigatorHolder() }
}