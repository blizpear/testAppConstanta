package com.blizpear.testappconstanta.features.filmsscreen.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blizpear.testappconstanta.features.filmsscreen.domain.usecases.GetFilmsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FilmsViewModel(
	private val getFilmsUseCase: GetFilmsUseCase
) : ViewModel() {

	private val _state = MutableStateFlow<FilmsState>(FilmsState.Initialize)
	val state = _state.asStateFlow()

	init {
		getFilms()
	}

	fun getFilms() {
		viewModelScope.launch {
			try {
				_state.value = FilmsState.Loading

				val films = getFilmsUseCase().sortedBy { it.releaseYear }

				_state.value = FilmsState.Content(films)
			} catch (e: Exception) {
				Log.d("FilmsViewModel", e.message!!)
				_state.value = FilmsState.Error
			}
		}
	}
}