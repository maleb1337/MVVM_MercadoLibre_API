package cl.maleb.mercadolibre.challenge.ui.search

import androidx.lifecycle.ViewModel
import cl.maleb.mercadolibre.challenge.data.MLRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MLRepository
) : ViewModel() {
}