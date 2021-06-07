package cl.maleb.mercadolibre.challenge.ui.detail

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.maleb.mercadolibre.challenge.R
import cl.maleb.mercadolibre.challenge.api.detail.Body
import cl.maleb.mercadolibre.challenge.data.MLRepository
import cl.maleb.mercadolibre.challenge.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MLRepository
) : ViewModel() {

    companion object {
        private const val NEW_ATTRIBUTE = "new"
        private const val USED_ATTRIBUTE = "used"
        private const val NEW_VALUE = "Nuevo"
        private const val USED_VALUE = "Usado"
    }

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
            NEW_ATTRIBUTE -> NEW_VALUE
            USED_ATTRIBUTE -> USED_VALUE
            else -> condition
        }
    }


}