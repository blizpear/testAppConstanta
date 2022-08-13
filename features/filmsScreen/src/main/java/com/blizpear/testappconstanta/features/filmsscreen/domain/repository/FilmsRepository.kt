package com.blizpear.testappconstanta.features.filmsscreen.domain.repository

import com.blizpear.testappconstanta.features.filmsscreen.domain.entity.FilmsEntity

interface FilmsRepository {

	suspend fun getFilmsInfo(): List<FilmsEntity>
}