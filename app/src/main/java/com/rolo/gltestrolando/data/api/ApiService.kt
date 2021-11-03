package com.rolo.gltestrolando.data.api

import com.rolo.gltestrolando.data.model.ItemGL
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    suspend fun getItemsGL(): Response<List<ItemGL>>

}