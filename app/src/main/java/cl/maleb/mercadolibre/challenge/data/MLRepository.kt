package cl.maleb.mercadolibre.challenge.data

import androidx.room.withTransaction
import cl.maleb.mercadolibre.challenge.api.MLApiService
import cl.maleb.mercadolibre.challenge.util.networkBoundResource
import javax.inject.Inject

class MLRepository @Inject constructor(
    private val mlApiService: MLApiService,
    private val appDatabase: AppDatabase
) {
    private val resultDao = appDatabase.resultDao()

    fun getListBySearch(searchQuery: String) = networkBoundResource(
        databaseQuery = {
            resultDao.getAllResults()
        },
        networkCall = {
            mlApiService.getListBySearch(searchQuery)
        },
        saveCallResult = {
            appDatabase.withTransaction {
                resultDao.deleteAllResults()
                it.results?.let { results -> resultDao.insertResult(results) }
            }
        }

    )

}