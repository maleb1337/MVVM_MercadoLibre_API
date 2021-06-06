package cl.maleb.mercadolibre.challenge.data.result

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.maleb.mercadolibre.challenge.api.list.MLResultData
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: List<MLResultData>)

    @Query("SELECT * FROM resultDataTable")
    fun getAllResults(): Flow<List<MLResultData>>

    @Query("DELETE FROM resultDataTable")
    suspend fun deleteAllResults()

}