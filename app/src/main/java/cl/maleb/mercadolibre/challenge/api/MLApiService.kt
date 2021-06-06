package cl.maleb.mercadolibre.challenge.api

import cl.maleb.mercadolibre.challenge.api.detail.MLDetailDataItem
import cl.maleb.mercadolibre.challenge.api.list.MLListData
import retrofit2.http.GET
import retrofit2.http.Query

interface MLApiService {

    companion object {
        const val GET_LIST_BY_QUERY = "sites/MLA/search"
        const val GET_DETAIL_BY_ID = "items"
    }

    @GET(GET_LIST_BY_QUERY)
    suspend fun getListBySearch(
        @Query("q") searchQuery: String
    ): MLListData

    @GET(GET_DETAIL_BY_ID)
    suspend fun getDetailById(
        @Query("ids") identifier: String
    ): List<MLDetailDataItem>

}