package com.blizpear.testappconstanta.features.filmsscreen.ui.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blizpear.testappconstanta.features.filmsscreen.R
import com.blizpear.testappconstanta.features.filmsscreen.databinding.FilmItemBinding
import com.blizpear.testappconstanta.features.filmsscreen.domain.entity.FilmsEntity

class FilmHolder(
	private val binding: FilmItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		fun from(parent: ViewGroup): FilmHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = FilmItemBinding.inflate(inflater, parent, false)
			return FilmHolder(binding)
		}
	}

	fun bind(
		film: FilmsEntity,
		onFilmClick: (String) -> Unit
	) {
		binding.filmName.text = binding.root.context.getString(R.string.film_title, film.title, film.releaseYear)
		binding.filmDirector.text = binding.root.context.getString(R.string.film_director, fullNameToInitials(film.directorName))
		binding.filmActors.text = binding.root.context.getString(R.string.film_actors, film.actors.joinToString())

		binding.filmCard.setOnClickListener {
			onFilmClick(film.title)
		}
	}

	private fun fullNameToInitials(name: String): String {
		val firstName = name.substring(0, 1)
		val secondName = name.substring(name.indexOf(' ') + 1, name.indexOf(' ') + 2)
		val surname = name.substring(name.lastIndexOf(' '))

		return "$surname $firstName.$secondName."
	}
}