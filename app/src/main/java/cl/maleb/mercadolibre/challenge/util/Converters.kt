package cl.maleb.mercadolibre.challenge.util

import androidx.room.TypeConverter
import cl.maleb.mercadolibre.challenge.api.list.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun restoreListInt(listOfInt: String?): List<Int?>? {
        return Gson().fromJson(listOfInt, object : TypeToken<List<Int?>?>() {}.type)
    }

    @TypeConverter
    fun saveListInt(listOfInt: List<Int?>?): String? {
        return Gson().toJson(listOfInt)
    }

    @TypeConverter
    fun restoreListString(listOfString: String?): List<String?>? {
        return Gson().fromJson(listOfString, object : TypeToken<List<String?>?>() {}.type)
    }

    @TypeConverter
    fun saveListString(listOfString: List<String?>?): String? {
        return Gson().toJson(listOfString)
    }

    @TypeConverter
    fun restoreListAttributeData(objectToRestore: String?): List<Attribute>? {
        return Gson().fromJson(objectToRestore, object : TypeToken<List<Attribute>?>() {}.type)
    }

    @TypeConverter
    fun saveListAttributeData(objectToSave: List<Attribute>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreDifferentialPricingData(objectToRestore: String?): DifferentialPricing? {
        return Gson().fromJson(objectToRestore, object : TypeToken<DifferentialPricing?>() {}.type)
    }

    @TypeConverter
    fun saveDifferentialPricingData(objectToSave: DifferentialPricing?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreInstallmentsData(objectToRestore: String?): Installments? {
        return Gson().fromJson(objectToRestore, object : TypeToken<Installments?>() {}.type)
    }

    @TypeConverter
    fun saveInstallmentsData(objectToSave: Installments?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restorePricesData(objectToRestore: String?): Prices? {
        return Gson().fromJson(objectToRestore, object : TypeToken<Prices?>() {}.type)
    }

    @TypeConverter
    fun savePricesData(objectToSave: Prices?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreSellerData(objectToRestore: String?): Seller? {
        return Gson().fromJson(objectToRestore, object : TypeToken<Seller?>() {}.type)
    }

    @TypeConverter
    fun saveSellerData(objectToSave: Seller?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreSellerAddressData(objectToRestore: String?): SellerAddress? {
        return Gson().fromJson(objectToRestore, object : TypeToken<SellerAddress?>() {}.type)
    }

    @TypeConverter
    fun saveSellerAddressData(objectToSave: SellerAddress?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreShippingData(objectToRestore: String?): Shipping? {
        return Gson().fromJson(objectToRestore, object : TypeToken<Shipping?>() {}.type)
    }

    @TypeConverter
    fun saveShippingData(objectToSave: Shipping?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreAddressData(objectToRestore: String?): Address? {
        return Gson().fromJson(objectToRestore, object : TypeToken<Address?>() {}.type)
    }

    @TypeConverter
    fun saveAddressData(objectToSave: Address?): String? {
        return Gson().toJson(objectToSave)
    }


}