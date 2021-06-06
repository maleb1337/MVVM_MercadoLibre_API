package cl.maleb.mercadolibre.challenge.ui.search

import androidx.lifecycle.*
import cl.maleb.mercadolibre.challenge.api.list.MLResultData
import cl.maleb.mercadolibre.challenge.data.MLRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
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

    /**
     * Events section
     */

    private val searchEventChannel = Channel<SearchEvent>()
    val searchEvent = searchEventChannel.receiveAsFlow()

    fun onResultSelected(resultData: MLResultData) = viewModelScope.launch {
        searchEventChannel.send(SearchEvent.NavigateToDetailScreen(resultData))
    }

}