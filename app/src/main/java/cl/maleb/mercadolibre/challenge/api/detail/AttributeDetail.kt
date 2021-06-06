package cl.maleb.mercadolibre.challenge.api.detail

data class AttributeDetail(
    val attribute_group_id: String? = null,
    val attribute_group_name: String? = null,
    val id: String? = null,
    val name: String? = null,
    val value_id: String? = null,
    val value_name: String? = null,
    val value_struct: ValueStruct? = null,
    val values: List<Value>? = null
)