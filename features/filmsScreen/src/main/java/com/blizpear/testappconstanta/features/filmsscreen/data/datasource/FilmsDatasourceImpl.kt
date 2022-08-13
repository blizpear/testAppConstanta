package com.blizpear.testappconstanta.features.filmsscreen.data.datasource

import com.blizpear.testappconstanta.features.filmsscreen.data.api.FilmsApi
import com.blizpear.testappconstanta.features.filmsscreen.data.models.FilmsModel

class FilmsDatasourceImpl(
	private val api: FilmsApi
) : FilmsDatasource {

	override suspend fun getFilms(): List<FilmsModel> = api.getFilms().items
}