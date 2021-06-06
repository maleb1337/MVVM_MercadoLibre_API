package cl.maleb.mercadolibre.challenge.api.detail

data class AttributeCombination(
    val id: String? = null,
    val name: String? = null,
    val value_id: String? = null,
    val value_name: String? = null,
    val value_struct: Any? = null,
    val values: List<ValueAttributeCombination>? = null
)