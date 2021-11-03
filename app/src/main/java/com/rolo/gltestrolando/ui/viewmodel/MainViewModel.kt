package com.rolo.gltestrolando.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rolo.gltestrolando.data.model.ItemGL
import com.rolo.gltestrolando.data.repository.MainRepository
import com.rolo.gltestrolando.utils.NetworkHelper
import com.rolo.gltestrolando.utils.Resource
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel(), KoinComponent {

    private val _items = MutableLiveData<Resource<List<ItemGL>>>()
    val items: LiveData<Resource<List<ItemGL>>>
        get() = _items

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            _items.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getItemsGL().let {
                    if (it.isSuccessful) {
                        _items.postValue(Resource.success(it.body()))
                    } else _items.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _items.postValue(Resource.error("No internet connection", null))
        }
    }

}