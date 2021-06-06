package cl.maleb.mercadolibre.challenge.api.detail

data class ShippingDetail(
    val free_methods: List<FreeMethod>? = null,
    val free_shipping: Boolean? = null,
    val local_pick_up: Boolean? = null,
    val logistic_type: String? = null,
    val mode: String? = null,
    val store_pick_up: Boolean? = null,
    val tags: List<String>? = null
)