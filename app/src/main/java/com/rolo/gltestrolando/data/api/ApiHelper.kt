package com.rolo.gltestrolando.data.api

import com.rolo.gltestrolando.data.model.ItemGL
import retrofit2.Response

interface ApiHelper {

    suspend fun getItemsGL(): Response<List<ItemGL>>
}