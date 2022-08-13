package com.blizpear.testappconstanta.features.filmsscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.blizpear.testappconstanta.features.filmsscreen.R
import com.blizpear.testappconstanta.features.filmsscreen.databinding.FilmsFragmentBinding
import com.blizpear.testappconstanta.features.filmsscreen.presentation.FilmsState
import com.blizpear.testappconstanta.features.filmsscreen.presentation.FilmsViewModel
import com.blizpear.testappconstanta.features.filmsscreen.ui.adapter.FilmsAdapter
import com.blizpear.testappconstanta.shared.ui.fragment.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmsFragment :
	BaseFragment<FilmsFragmentBinding>(R.layout.films_fragment) {

	companion object {

		fun getInstance() = FilmsFragment()
	}

	private val viewModel: FilmsViewModel by viewModel()

	private lateinit var filmsAdapter: FilmsAdapter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setAdapter()
		setListeners()
		setObservers()
	}

	private fun setAdapter() {
		filmsAdapter = FilmsAdapter(::showDialog)
		binding.content.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
		binding.content.adapter = filmsAdapter
	}

	private fun showDialog(title: String) {
		Toast.makeText(
			requireContext(),
			getString(R.string.film_click, title),
			Toast.LENGTH_SHORT
		).show()
	}

	private fun setListeners() {
		binding.retryButton.setOnClickListener {
			viewModel.getFilms()
		}
	}

	private fun setObservers() {
		viewLifecycleOwner.lifecycleScope.launchWhenStarted {
			viewModel.state.collect {
				handleState(it)
			}
		}
	}

	private fun handleState(state: FilmsState) {
		when (state) {
			is FilmsState.Initialize,
			FilmsState.Loading    -> renderLoading()

			is FilmsState.Error   -> renderError()

			is FilmsState.Content -> renderContent(state)
		}
	}

	private fun renderLoading() {
		with(binding) {
			error.isVisible = false
			content.isVisible = false

			progressBar.isVisible = true
		}
	}

	private fun renderError() {
		with(binding) {
			content.isVisible = false
			progressBar.isVisible = false

			error.isVisible = true
		}
	}

	private fun renderContent(state: FilmsState.Content) {
		with(binding) {
			error.isVisible = false
			progressBar.isVisible = false

			content.isVisible = true

			filmsAdapter.submitList(state.data)
		}
	}

	override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FilmsFragmentBinding =
		FilmsFragmentBinding.inflate(inflater, container, false)
}