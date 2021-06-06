package cl.maleb.mercadolibre.challenge.util

import androidx.room.TypeConverter
import cl.maleb.mercadolibre.challenge.api.detail.*
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

    @TypeConverter
    fun restoreDescriptionData(objectToRestore: String?): List<Description>? {
        return Gson().fromJson(objectToRestore, object : TypeToken<List<Description>?>() {}.type)
    }

    @TypeConverter
    fun saveDescriptionData(objectToSave: List<Description>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restorePictureData(objectToRestore: String?): List<Picture>? {
        return Gson().fromJson(objectToRestore, object : TypeToken<List<Picture>?>() {}.type)
    }

    @TypeConverter
    fun savePictureData(objectToSave: List<Picture>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreSaleTermData(objectToRestore: String?): List<SaleTerm>? {
        return Gson().fromJson(objectToRestore, object : TypeToken<List<SaleTerm>?>() {}.type)
    }

    @TypeConverter
    fun saveSaleTermData(objectToSave: List<SaleTerm>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreAttributeDetailData(objectToRestore: String?): List<AttributeDetail>? {
        return Gson().fromJson(
            objectToRestore,
            object : TypeToken<List<AttributeDetail>?>() {}.type
        )
    }

    @TypeConverter
    fun saveAttributeDetailData(objectToSave: List<AttributeDetail>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreSellerAddressDetailData(objectToRestore: String?): SellerAddressDetail? {
        return Gson().fromJson(objectToRestore, object : TypeToken<SellerAddressDetail?>() {}.type)
    }

    @TypeConverter
    fun saveSellerAddressDetailData(objectToSave: SellerAddressDetail?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreShippingDetailData(objectToRestore: String?): ShippingDetail? {
        return Gson().fromJson(objectToRestore, object : TypeToken<ShippingDetail?>() {}.type)
    }

    @TypeConverter
    fun saveShippingDetailData(objectToSave: ShippingDetail?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreVariationData(objectToRestore: String?): List<Variation>? {
        return Gson().fromJson(objectToRestore, object : TypeToken<List<Variation>?>() {}.type)
    }

    @TypeConverter
    fun saveVariationData(objectToSave: List<Variation>?): String? {
        return Gson().toJson(objectToSave)
    }


}