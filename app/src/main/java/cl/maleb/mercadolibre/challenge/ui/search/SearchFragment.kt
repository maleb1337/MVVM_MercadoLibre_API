package cl.maleb.mercadolibre.challenge.ui.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.maleb.mercadolibre.challenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModels()
}