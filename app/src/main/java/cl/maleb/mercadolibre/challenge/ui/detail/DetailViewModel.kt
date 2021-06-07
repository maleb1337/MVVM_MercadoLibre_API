package cl.maleb.mercadolibre.challenge.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.maleb.mercadolibre.challenge.api.detail.Body
import cl.maleb.mercadolibre.challenge.data.MLRepository
import cl.maleb.mercadolibre.challenge.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.concurrent.locks.Condition
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MLRepository
) : ViewModel() {

    private val detailMutableLiveData = MutableLiveData<Resource<Body>>()
    val detailLiveData: LiveData<Resource<Body>> = detailMutableLiveData

    fun getDetailData(identifier: String) =
        viewModelScope.launch {
            repository.getDetailById(identifier).collect {
                detailMutableLiveData.value = it
            }
        }

    fun getConditionValue(condition: String): String {
        return when (condition) {
            "new" -> "Nuevo"
            "used" -> "Usado"
            else -> condition
        }
    }


}