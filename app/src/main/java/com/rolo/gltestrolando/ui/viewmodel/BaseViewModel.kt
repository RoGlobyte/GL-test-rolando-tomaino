package com.rolo.gltestrolando.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.component.KoinComponent
import kotlin.coroutines.CoroutineContext

// To avoid writing the same extensions multiple times, we'll make an abstract class for ViewModels
open class BaseViewModel : ViewModel(), CoroutineScope, KoinComponent {
    companion object {
        const val ERROR_TAG = "BaseViewModel"
    }

    // Coroutine's background job
    private val job = SupervisorJob()

    // Define default thread for Coroutine as Main and add planDataJob
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

}