package cl.maleb.mercadolibre.challenge.data.result

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: List<MLResultViewData>)

    @Query("SELECT * FROM resultDataTable")
    fun getAllResults(): Flow<List<MLResultViewData>>
}