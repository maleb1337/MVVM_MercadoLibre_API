package cl.maleb.mercadolibre.challenge.api.list

data class Shipping(
    val free_shipping: Boolean? = null,
    val logistic_type: String? = null,
    val mode: String? = null,
    val store_pick_up: Boolean? = null,
    val tags: List<String>? = null
)