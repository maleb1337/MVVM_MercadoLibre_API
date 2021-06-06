package cl.maleb.mercadolibre.challenge.data.detail

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.maleb.mercadolibre.challenge.api.detail.Body
import kotlinx.coroutines.flow.Flow

@Dao
interface DetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(result: Body)

    @Query("SELECT * FROM detailDataTable where id = :identifier")
    fun getDetail(identifier: String): Flow<Body>

    @Query("DELETE FROM detailDataTable")
    suspend fun deleteDetail()
}