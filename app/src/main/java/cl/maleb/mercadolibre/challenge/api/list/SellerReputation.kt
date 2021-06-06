package cl.maleb.mercadolibre.challenge.api.list

data class SellerReputation(
    val level_id: String? = null,
    val metrics: Metrics? = null,
    val power_seller_status: String? = null,
    val transactions: Transactions? = null
)