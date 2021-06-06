package cl.maleb.mercadolibre.challenge.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.maleb.mercadolibre.challenge.api.list.MLResultData
import cl.maleb.mercadolibre.challenge.data.result.ResultDao
import cl.maleb.mercadolibre.challenge.util.Converters

@Database(entities = [MLResultData::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun resultDao(): ResultDao
}