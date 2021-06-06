package cl.maleb.mercadolibre.challenge.api.detail

data class SellerAddressDetail(
    val city: City? = null,
    val country: Country? = null,
    val id: Int? = null,
    val search_location: SearchLocation? = null,
    val state: StateSellerAddress? = null
)