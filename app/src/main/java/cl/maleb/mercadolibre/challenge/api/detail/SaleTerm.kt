package cl.maleb.mercadolibre.challenge.api.detail

data class SaleTerm(
    val id: String,
    val name: String,
    val value_name: String,
    val value_struct: ValueStructSaleTerm,
    val values: List<ValueSaleTerm>
)