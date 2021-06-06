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
    private val detailDao = appDatabase.detailDao()

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

    fun getDetailById(identifier: String) = networkBoundResource(
        databaseQuery = {
            detailDao.getDetail(identifier)
        },
        networkCall = {
            mlApiService.getDetailById(identifier)
        },
        saveCallResult = { detailDataItem ->
            appDatabase.withTransaction {
                detailDao.deleteDetail()
                detailDataItem.first().body?.let { body -> detailDao.insertDetail(body) }
            }

        }
    )

}