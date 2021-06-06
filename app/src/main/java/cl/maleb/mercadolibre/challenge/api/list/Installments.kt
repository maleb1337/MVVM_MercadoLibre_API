package cl.maleb.mercadolibre.challenge.api.list

data class Installments(
    val amount: Double? = null,
    val currency_id: String? = null,
    val quantity: Int? = null,
    val rate: Int? = null
)