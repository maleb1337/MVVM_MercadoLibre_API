package cl.maleb.mercadolibre.challenge.api.list

data class ReferencePrice(
    val amount: Double? = null,
    val conditions: PriceConditions? = null,
    val currency_id: String? = null,
    val exchange_rate_context: String? = null,
    val id: String? = null,
    val last_updated: String? = null,
    val tags: List<String>? = null,
    val type: String? = null
)