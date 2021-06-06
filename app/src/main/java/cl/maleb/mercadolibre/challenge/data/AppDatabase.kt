package cl.maleb.mercadolibre.challenge.data

import androidx.room.Database
import cl.maleb.mercadolibre.challenge.data.result.MLResultViewData
import cl.maleb.mercadolibre.challenge.data.result.ResultDao

@Database(entities = [MLResultViewData::class], version = 1)
abstract class AppDatabase {

    abstract fun resultDao(): ResultDao
}