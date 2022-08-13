package com.blizpear.testappconstanta.features.filmsscreen.di

import com.blizpear.testappconstanta.features.filmsscreen.data.api.FilmsApi
import com.blizpear.testappconstanta.features.filmsscreen.data.datasource.FilmsDatasource
import com.blizpear.testappconstanta.features.filmsscreen.data.datasource.FilmsDatasourceImpl
import com.blizpear.testappconstanta.features.filmsscreen.data.repository.FilmsRepositoryImpl
import com.blizpear.testappconstanta.features.filmsscreen.domain.repository.FilmsRepository
import com.blizpear.testappconstanta.features.filmsscreen.domain.usecases.GetFilmsUseCase
import com.blizpear.testappconstanta.features.filmsscreen.presentation.FilmsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val filmsScreenModule = module {

	factory<FilmsApi> { get<Retrofit>().create(FilmsApi::class.java) }

	factory<FilmsDatasource> { FilmsDatasourceImpl(api = get()) }

	factory<FilmsRepository> { FilmsRepositoryImpl(datasource = get()) }

	factory { GetFilmsUseCase(repository = get()) }

	viewModel {
		FilmsViewModel(
			getFilmsUseCase = get()
		)
	}
}