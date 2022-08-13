package com.blizpear.testappconstanta.features.filmsscreen.data.datasource

import com.blizpear.testappconstanta.features.filmsscreen.data.models.FilmsModel

interface FilmsDatasource {

	suspend fun getFilms(): List<FilmsModel>
}