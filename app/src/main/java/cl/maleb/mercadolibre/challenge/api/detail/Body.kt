package cl.maleb.mercadolibre.challenge.api.detail

import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.maleb.mercadolibre.challenge.util.setNumberMiles

@Entity(tableName = "detailDataTable")
data class Body(
    val accepts_mercadopago: Boolean? = null,
    val attributes: List<AttributeDetail>? = null,
    val automatic_relist: Boolean? = null,
    val available_quantity: Int? = null,
    val base_price: Int? = null,
    val buying_mode: String? = null,
    val catalog_listing: Boolean? = null,
    val catalog_product_id: String? = null,
    val category_id: String? = null,
    val channels: List<String>? = null,
    val condition: String? = null,
    val currency_id: String? = null,
    val date_created: String? = null,
    val descriptions: List<Description>? = null,
    val domain_id: String? = null,
    val health: Double? = null,
    @PrimaryKey val id: String,
    val initial_quantity: Int? = null,
    val international_delivery_mode: String? = null,
    val last_updated: String? = null,
    val listing_source: String? = null,
    val listing_type_id: String? = null,
    val permalink: String? = null,
    val pictures: List<Picture>? = null,
    val price: Int? = null,
    val sale_terms: List<SaleTerm>? = null,
    val secure_thumbnail: String? = null,
    val seller_address: SellerAddressDetail? = null,
    val seller_id: Int? = null,
    val shipping: ShippingDetail? = null,
    val site_id: String? = null,
    val sold_quantity: Int? = null,
    val start_time: String? = null,
    val status: String? = null,
    val stop_time: String? = null,
    val tags: List<String>? = null,
    val thumbnail: String? = null,
    val thumbnail_id: String? = null,
    val title: String? = null,
    val variations: List<Variation>? = null,
    val video_id: String? = null,
    val warranty: String? = null
) {
    val priceFormatted: String
        get() {
            return setNumberMiles(price ?: 0)
        }
}