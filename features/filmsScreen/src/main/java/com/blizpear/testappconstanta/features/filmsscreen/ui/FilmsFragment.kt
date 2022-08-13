package com.blizpear.testappconstanta.features.filmsscreen.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.blizpear.testappconstanta.features.filmsscreen.R
import com.blizpear.testappconstanta.features.filmsscreen.databinding.FilmsFragmentBinding
import com.blizpear.testappconstanta.shared.ui.fragment.BaseFragment

class FilmsFragment :
	BaseFragment<FilmsFragmentBinding>(R.layout.films_fragment) {

	companion object {

		fun getInstance() = FilmsFragment()
	}

	override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FilmsFragmentBinding =
		FilmsFragmentBinding.inflate(inflater, container, false)
}