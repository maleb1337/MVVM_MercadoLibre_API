package cl.maleb.mercadolibre.challenge.api.list

data class Prices(
    val id: String? = null,
    val payment_method_prices: List<String>? = null,
    val presentation: Presentation? = null,
    val prices: List<Price>? = null,
    val purchase_discounts: List<String>? = null,
    val reference_prices: List<ReferencePrice>? = null
)