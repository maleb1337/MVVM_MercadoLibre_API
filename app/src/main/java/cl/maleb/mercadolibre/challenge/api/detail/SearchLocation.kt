package cl.maleb.mercadolibre.challenge.api.detail

data class SearchLocation(
    val city: CitySearchLocation? = null,
    val neighborhood: Neighborhood? = null,
    val state: State? = null
)