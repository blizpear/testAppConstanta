package com.blizpear.testappconstanta

import android.app.Application
import com.blizpear.testappconstanta.di.globalNavigationModule
import com.blizpear.testappconstanta.features.filmsscreen.di.filmsScreenModule
import com.blizpear.testappconstanta.shared.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)

			modules(
				globalNavigationModule,
				networkModule,
				filmsScreenModule,
			)
		}
	}
}