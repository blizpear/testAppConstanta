package com.blizpear.testappconstanta.features.filmsscreen.domain.usecases

import com.blizpear.testappconstanta.features.filmsscreen.domain.repository.FilmsRepository

class GetFilmsUseCase(
	private val repository: FilmsRepository
) {

	suspend operator fun invoke() = repository.getFilmsInfo()
}