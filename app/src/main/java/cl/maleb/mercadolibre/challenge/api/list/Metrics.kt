package cl.maleb.mercadolibre.challenge.api.list

data class Metrics(
    val cancellations: Cancellations? = null,
    val claims: Claims? = null,
    val delayed_handling_time: DelayedHandlingTime? = null,
    val sales: Sales? = null
)