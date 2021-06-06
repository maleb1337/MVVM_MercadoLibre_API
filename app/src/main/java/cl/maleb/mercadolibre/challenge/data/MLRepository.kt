package cl.maleb.mercadolibre.challenge.data

import cl.maleb.mercadolibre.challenge.api.MLApiService
import javax.inject.Inject

class MLRepository @Inject constructor(
    private val mlApiService: MLApiService,
    private val appDatabase: AppDatabase
) {
    private val resultDao = appDatabase.resultDao()


}