package cl.maleb.mercadolibre.challenge.util

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun setNumberMiles(value: Double): String {
    val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
    val symbols = formatter.decimalFormatSymbols

    symbols.groupingSeparator = '.'
    formatter.decimalFormatSymbols = symbols
    return formatter.format(value)
}

fun setNumberMiles(value: Int) = setNumberMiles(value.toDouble())