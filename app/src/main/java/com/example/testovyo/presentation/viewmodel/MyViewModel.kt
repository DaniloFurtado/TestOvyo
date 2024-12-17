package com.example.testovyo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testovyo.domain.repository.MyRepository
import com.example.testovyo.presentation.ui.state.MyViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyViewModel(
    private val repository: MyRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(MyViewState())
    val viewState = _viewState.asStateFlow()

    init {
        requestData()
    }

    private fun requestData() {
        viewModelScope.launch {
            _viewState.update {
                it.copy(isLoading = true)
            }

            repository.getMyData().let { listItem ->
                _viewState.update {
                    it.copy(items = listItem)
                }
            }
            _viewState.update {
                it.copy(isLoading = false)
            }
        }
    }
}