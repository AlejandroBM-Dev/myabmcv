package com.raiseralex.myabmcv

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    application: Application,
) : AndroidViewModel(application) {
    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    private val delaySplash = 3000L

    init {
        viewModelScope.launch {
            delay(delaySplash)
            _loading.value = false
        }
    }
}
