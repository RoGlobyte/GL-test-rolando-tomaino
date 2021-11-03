package com.rolo.gltestrolando.module

import com.rolo.gltestrolando.data.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MainRepository(get())
    }
}