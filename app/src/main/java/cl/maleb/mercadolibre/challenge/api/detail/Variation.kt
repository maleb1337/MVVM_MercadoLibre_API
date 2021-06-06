package cl.maleb.mercadolibre.challenge.api.detail

data class Variation(
    val attribute_combinations: List<AttributeCombination>? = null,
    val available_quantity: Int? = null,
    val catalog_product_id: String? = null,
    val id: Long? = null,
    val picture_ids: List<String>? = null,
    val price: Double? = null,
    val sold_quantity: Int? = null
)