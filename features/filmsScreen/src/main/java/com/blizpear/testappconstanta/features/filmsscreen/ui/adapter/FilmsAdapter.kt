package com.blizpear.testappconstanta.features.filmsscreen.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.blizpear.testappconstanta.features.filmsscreen.domain.entity.FilmsEntity
import com.blizpear.testappconstanta.features.filmsscreen.ui.viewHolder.FilmHolder

class FilmsAdapter(
	private val onFilmClick: (String) -> Unit
) : ListAdapter<FilmsEntity, FilmHolder>(FilmDiffUtil()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder =
		FilmHolder.from(parent)

	override fun onBindViewHolder(holder: FilmHolder, position: Int) {
		holder.bind(getItem(position), onFilmClick)
	}

	private class FilmDiffUtil : DiffUtil.ItemCallback<FilmsEntity>() {

		override fun areItemsTheSame(oldItem: FilmsEntity, newItem: FilmsEntity): Boolean =
			oldItem.title == newItem.title

		override fun areContentsTheSame(oldItem: FilmsEntity, newItem: FilmsEntity): Boolean =
			oldItem == newItem
	}
}