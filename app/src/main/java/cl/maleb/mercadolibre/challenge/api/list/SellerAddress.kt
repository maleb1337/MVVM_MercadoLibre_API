package cl.maleb.mercadolibre.challenge.api.list

data class SellerAddress(
    val address_line: String? = null,
    val city: SellerCity? = null,
    val comment: String? = null,
    val country: SellerCountry? = null,
    val id: String? = null,
    val latitude: String? = null,
    val longitude: String? = null,
    val state: SellerState? = null,
    val zip_code: String? = null
)