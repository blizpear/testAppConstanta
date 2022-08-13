package com.blizpear.testappconstanta.features.filmsscreen.data.models

import com.google.gson.annotations.SerializedName

data class FilmsModel(
	@SerializedName("title")
	val title: String,
	@SerializedName("directorName")
	val directorName: String,
	@SerializedName("releaseYear")
	val releaseYear: Short,
	@SerializedName("actors")
	val actors: List<ActorModel>
)