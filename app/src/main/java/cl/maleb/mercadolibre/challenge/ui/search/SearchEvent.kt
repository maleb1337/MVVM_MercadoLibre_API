package cl.maleb.mercadolibre.challenge.ui.search

import cl.maleb.mercadolibre.challenge.api.list.MLResultData

sealed class SearchEvent {
    data class NavigateToDetailScreen(val resultData: MLResultData) : SearchEvent()
}