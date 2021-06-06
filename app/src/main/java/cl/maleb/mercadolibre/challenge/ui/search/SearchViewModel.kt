package cl.maleb.mercadolibre.challenge.ui.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import cl.maleb.mercadolibre.challenge.data.MLRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MLRepository,
    private val state: SavedStateHandle
) : ViewModel() {

    val searchQuery = state.getLiveData("searchQuery", "")

    private val resultsFlow = searchQuery.asFlow().flatMapLatest { query ->
        repository.getListBySearch(query)
    }

    val results = resultsFlow.asLiveData()

}