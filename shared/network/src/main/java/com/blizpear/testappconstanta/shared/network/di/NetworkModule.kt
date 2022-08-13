package com.blizpear.testappconstanta.shared.network.di

import com.blizpear.testappconstanta.shared.network.RetrofitProvider
import org.koin.dsl.module

val networkModule = module {

	single { RetrofitProvider.retrofit }
}