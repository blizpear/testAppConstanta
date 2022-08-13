package com.blizpear.testappconstanta.features.filmsscreen.data.repository

import com.blizpear.testappconstanta.features.filmsscreen.data.datasource.FilmsDatasource
import com.blizpear.testappconstanta.features.filmsscreen.data.mappers.toEntityList
import com.blizpear.testappconstanta.features.filmsscreen.domain.entity.FilmsEntity
import com.blizpear.testappconstanta.features.filmsscreen.domain.repository.FilmsRepository

class FilmsRepositoryImpl(
	private val datasource: FilmsDatasource
) : FilmsRepository {

	override suspend fun getFilmsInfo(): List<FilmsEntity> =
		datasource.getFilms().toEntityList()
}