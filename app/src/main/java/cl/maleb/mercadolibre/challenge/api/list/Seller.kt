package cl.maleb.mercadolibre.challenge.api.list

data class Seller(
    val car_dealer: Boolean? = null,
    val id: Int? = null,
    val permalink: String? = null,
    val real_estate_agency: Boolean? = null,
    val registration_date: String? = null,
    val seller_reputation: SellerReputation? = null,
    val tags: List<String>? = null
)