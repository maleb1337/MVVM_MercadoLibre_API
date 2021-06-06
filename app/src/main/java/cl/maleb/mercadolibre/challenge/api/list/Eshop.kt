package cl.maleb.mercadolibre.challenge.api.list

data class Eshop(
    val eshop_experience: Int? = null,
    val eshop_id: Int? = null,
    val eshop_locations: List<EshopLocation>? = null,
    val eshop_logo_url: String? = null,
    val eshop_rubro: String? = null,
    val eshop_status_id: Int? = null,
    val nick_name: String? = null,
    val seller: Int? = null,
    val site_id: String? = null
)