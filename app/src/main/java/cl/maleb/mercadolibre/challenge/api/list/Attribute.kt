package cl.maleb.mercadolibre.challenge.api.list

data class Attribute(
    val attribute_group_id: String? = null,
    val attribute_group_name: String? = null,
    val id: String? = null,
    val name: String? = null,
    val source: Long? = null,
    val value_id: String? = null,
    val value_name: String? = null,
    val value_struct: String? = null,
    val values: List<AttributeValue>? = null
)