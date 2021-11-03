package com.rolo.gltestrolando.data.api

import com.rolo.gltestrolando.data.model.ItemGL
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getItemsGL(): Response<List<ItemGL>> = apiService.getItemsGL()

}