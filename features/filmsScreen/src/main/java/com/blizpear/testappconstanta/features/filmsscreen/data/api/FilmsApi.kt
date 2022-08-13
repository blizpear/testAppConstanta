package com.blizpear.testappconstanta.features.filmsscreen.data.api

import com.blizpear.testappconstanta.features.filmsscreen.data.models.FilmsDataModel
import retrofit2.http.GET

interface FilmsApi {

	@GET("constanta-android-dev/intership-wellcome-task/main/films.json")
	suspend fun getFilms(): FilmsDataModel
}