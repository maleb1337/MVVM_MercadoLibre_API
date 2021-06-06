package cl.maleb.mercadolibre.challenge.api.detail

data class SaleTerm(
    val id: String? = null,
    val name: String? = null,
    val value_name: String? = null,
    val value_struct: ValueStructSaleTerm? = null,
    val values: List<ValueSaleTerm>? = null
)