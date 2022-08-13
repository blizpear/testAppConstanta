package com.blizpear.testappconstanta.features.filmsscreen.domain.entity

data class FilmsEntity(
	val title: String,
	val directorName: String,
	val releaseYear: Short,
	val actors: Set<String>
)