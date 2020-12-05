package com.digitalhouse.dsafiowebservices.modelo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.dsafiowebservices.comics.Result
import br.com.digitalhouse.dsafiowebservices.repository.Service
import br.com.digitalhouse.dsafiowebservices.repository.service
import kotlinx.coroutines.launch

class ListHQViewModel(serv: Service) : ViewModel() {

    val listComics = MutableLiveData<List<Result>>()

    fun getListHQs(offset: Int) {
        viewModelScope.launch {
            listComics.value = service.getAllHQRepo(offset).data.results
        }
    }

}