package com.rolo.gltestrolando.data.repository

import com.rolo.gltestrolando.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getItemsGL() = apiHelper.getItemsGL()

}