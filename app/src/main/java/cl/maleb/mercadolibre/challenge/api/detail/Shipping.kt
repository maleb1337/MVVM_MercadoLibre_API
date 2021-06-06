package cl.maleb.mercadolibre.challenge.api.detail

data class Shipping(
    val free_methods: List<FreeMethod>,
    val free_shipping: Boolean,
    val local_pick_up: Boolean,
    val logistic_type: String,
    val mode: String,
    val store_pick_up: Boolean,
    val tags: List<String>
)