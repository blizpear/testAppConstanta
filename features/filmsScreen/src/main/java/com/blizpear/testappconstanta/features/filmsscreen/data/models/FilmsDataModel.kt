package com.blizpear.testappconstanta.features.filmsscreen.data.models

import com.google.gson.annotations.SerializedName

data class FilmsDataModel(
	@SerializedName("items")
	val items: List<FilmsModel>
)