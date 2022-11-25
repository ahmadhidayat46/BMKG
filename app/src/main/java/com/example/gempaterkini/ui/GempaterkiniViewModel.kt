package com.example.gempaterkini.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gempaterkini.network.Gempaterkini
import com.example.gempaterkini.network.GempaterkiniApi
import kotlinx.coroutines.launch

enum class GempaterkiniApiStatus { LOADING, ERROR, DONE }

class GempaterkiniViewModel : ViewModel() {
    private val _status = MutableLiveData<GempaterkiniApiStatus>()
    val status: LiveData<GempaterkiniApiStatus> = _status

    private val _gempaterkinis = MutableLiveData<List<Gempaterkini>>()
    val gempaterkinis: LiveData<List<Gempaterkini>> = _gempaterkinis

    private val _gempaterkini = MutableLiveData<Gempaterkini>()
    val gempaterkini: LiveData<Gempaterkini> = _gempaterkini

    fun getGempaterkiniList() {
        _status.value = GempaterkiniApiStatus.LOADING
        viewModelScope.launch {
            try {
                _gempaterkinis.value = GempaterkiniApi.service.getGempaterkinis()
                _status.value = GempaterkiniApiStatus.DONE
            } catch (e: Exception) {
                _gempaterkinis.value = emptyList()
                _status.value = GempaterkiniApiStatus.ERROR
            }
        }
    }

    fun onGempaterkiniClicked(gempaterkini: Gempaterkini) {
        _gempaterkini.value = gempaterkini
    }
}
