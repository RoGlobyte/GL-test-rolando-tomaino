package com.rolo.gltestrolando.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.rolo.gltestrolando.data.model.ItemGL
import org.koin.core.component.KoinComponent

class SharedViewModel(
) : BaseViewModel(), KoinComponent {
    val _item_selected = MutableLiveData<ItemGL>()

    fun select(item: ItemGL) {
        _item_selected.value = item
    }
}