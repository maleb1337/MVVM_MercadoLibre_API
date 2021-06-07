package cl.maleb.mercadolibre.challenge.ui.search

import androidx.lifecycle.*
import cl.maleb.mercadolibre.challenge.api.list.MLResultData
import cl.maleb.mercadolibre.challenge.data.MLRepository
import cl.maleb.mercadolibre.challenge.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MLRepository
) : ViewModel() {

    var lastSearchQuery: String? = null

    private val resultListMutableLiveData = MutableLiveData<Resource<List<MLResultData>>>()
    val resultListLiveData: LiveData<Resource<List<MLResultData>>> = resultListMutableLiveData

    fun getListBySearch(searchQuery: String) =
        viewModelScope.launch {
            repository.getListBySearch(searchQuery).collect {
                resultListMutableLiveData.value = it
            }
        }

    /**
     * Events section
     */

    private val searchEventChannel = Channel<SearchEvent>()
    val searchEvent = searchEventChannel.receiveAsFlow()

    fun onResultSelected(resultData: MLResultData) = viewModelScope.launch {
        searchEventChannel.send(SearchEvent.NavigateToDetailScreen(resultData))
    }

}