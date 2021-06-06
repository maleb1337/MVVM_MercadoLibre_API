package cl.maleb.mercadolibre.challenge.api.detail

data class Body(
    val accepts_mercadopago: Boolean,
    val attributes: List<Attribute>,
    val automatic_relist: Boolean,
    val available_quantity: Int,
    val base_price: Int,
    val buying_mode: String,
    val catalog_listing: Boolean,
    val catalog_product_id: String,
    val category_id: String,
    val channels: List<String>,
    val condition: String,
    val currency_id: String,
    val date_created: String,
    val descriptions: List<Description>,
    val domain_id: String,
    val health: Double,
    val id: String,
    val initial_quantity: Int,
    val international_delivery_mode: String,
    val last_updated: String,
    val listing_source: String,
    val listing_type_id: String,
    val location: Location,
    val permalink: String,
    val pictures: List<Picture>,
    val price: Int,
    val sale_terms: List<SaleTerm>,
    val secure_thumbnail: String,
    val seller_address: SellerAddress,
    val seller_id: Int,
    val shipping: Shipping,
    val site_id: String,
    val sold_quantity: Int,
    val start_time: String,
    val status: String,
    val stop_time: String,
    val tags: List<String>,
    val thumbnail: String,
    val thumbnail_id: String,
    val title: String,
    val variations: List<Variation>,
    val video_id: String,
    val warranty: String
)