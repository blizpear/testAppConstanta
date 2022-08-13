package com.blizpear.testappconstanta.features.filmsscreen.data.mappers

import com.blizpear.testappconstanta.features.filmsscreen.data.models.ActorModel
import com.blizpear.testappconstanta.features.filmsscreen.data.models.FilmsModel
import com.blizpear.testappconstanta.features.filmsscreen.domain.entity.FilmsEntity

fun FilmsModel.toEntity() = FilmsEntity(
	title = title,
	directorName = directorName,
	releaseYear = releaseYear,
	actors = actors.toStringList().toSet()
)

fun ActorModel.toStringValue() = this.actorName

fun List<ActorModel>.toStringList() = map(ActorModel::toStringValue)

fun List<FilmsModel>.toEntityList() = map(FilmsModel::toEntity)