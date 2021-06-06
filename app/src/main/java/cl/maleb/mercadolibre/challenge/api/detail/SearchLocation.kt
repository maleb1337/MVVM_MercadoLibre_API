package cl.maleb.mercadolibre.challenge.api.detail

data class SearchLocation(
    val city: CitySearchLocation,
    val neighborhood: Neighborhood,
    val state: State
)