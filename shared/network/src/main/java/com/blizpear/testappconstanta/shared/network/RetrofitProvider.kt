package com.blizpear.testappconstanta.shared.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

	private const val BASE_URL = "https://raw.githubusercontent.com/"

	private val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

	private val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

	val retrofit: Retrofit = Retrofit.Builder()
		.baseUrl(BASE_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.client(okHttpClient)
		.build()
}