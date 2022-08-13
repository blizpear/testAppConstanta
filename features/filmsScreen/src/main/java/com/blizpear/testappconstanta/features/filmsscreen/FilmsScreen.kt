package com.blizpear.testappconstanta.features.filmsscreen

import com.blizpear.testappconstanta.features.filmsscreen.ui.FilmsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getFilmsScreen() = FragmentScreen { FilmsFragment.getInstance() }