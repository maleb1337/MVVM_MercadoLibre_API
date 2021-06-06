package cl.maleb.mercadolibre.challenge.api.list

data class PriceConditions(
    val context_restrictions: List<String>? = null,
    val eligible: Boolean? = null,
    val end_time: String? = null,
    val start_time: String? = null
)