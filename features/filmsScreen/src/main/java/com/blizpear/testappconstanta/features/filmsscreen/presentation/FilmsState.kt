package com.blizpear.testappconstanta.features.filmsscreen.presentation

import com.blizpear.testappconstanta.features.filmsscreen.domain.entity.FilmsEntity

sealed class FilmsState() {

	object Initialize : FilmsState()

	object Loading : FilmsState()

	object Error : FilmsState()

	class Content(val data: List<FilmsEntity>) : FilmsState()
}