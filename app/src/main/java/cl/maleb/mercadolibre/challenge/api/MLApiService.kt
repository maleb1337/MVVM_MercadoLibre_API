package cl.maleb.mercadolibre.challenge.api

import cl.maleb.mercadolibre.challenge.api.list.MLResultData
import retrofit2.http.GET
import retrofit2.http.Query

interface MLApiService {

    companion object {
        const val GET_LIST_BY_QUERY = "sites/MLA/search"
    }

    @GET(GET_LIST_BY_QUERY)
    suspend fun getListBySearch(
        @Query("q") searchQuery: String
    ): MLResultData

}