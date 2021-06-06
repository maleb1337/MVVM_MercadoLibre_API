package cl.maleb.mercadolibre.challenge.api.detail

data class SellerAddress(
    val city: City,
    val country: Country,
    val id: Int,
    val search_location: SearchLocation,
    val state: StateSellerAddress
)