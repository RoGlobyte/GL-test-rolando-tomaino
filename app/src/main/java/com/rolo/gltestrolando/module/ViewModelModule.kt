package com.rolo.gltestrolando.module

import com.rolo.gltestrolando.ui.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
}