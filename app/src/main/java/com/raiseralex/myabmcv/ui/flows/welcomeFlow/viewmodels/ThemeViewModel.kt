package com.raiseralex.myabmcv.ui.flows.welcomeFlow.viewmodels

import android.app.Application
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raiseralex.myabmcv.R
import com.raiseralex.myabmcv.application.MyCvApplication
import com.raiseralex.myabmcv.data.local.datastore.DataStoreUtil
import com.raiseralex.myabmcv.data.local.datastore.DataStoreUtil.Companion.IS_DARK_MODE_KEY
import com.raiseralex.myabmcv.ui.theme.ThemeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    application: Application,
    dataStoreUtil: DataStoreUtil,
) : ViewModel() {

    private val _themeState = MutableStateFlow(ThemeState(false))
    val themeSate: StateFlow<ThemeState> = _themeState

    private val dataStore = dataStoreUtil.dataStore

    init {
        viewModelScope.launch(MyCvApplication.dispatcherIO) {
            dataStore.data.map { preferences ->
                ThemeState(preferences[IS_DARK_MODE_KEY] ?: false)
            }.collect {
                _themeState.value = it
            }
        }
    }

    fun toggleTheme() {
        viewModelScope.launch(MyCvApplication.dispatcherIO) {
            dataStore.edit { preferences ->
                preferences[IS_DARK_MODE_KEY] = !(preferences[IS_DARK_MODE_KEY] ?: false)
            }
        }
    }

    fun getFontFamily(): FontFamily {
        val dark = FontFamily(
            Font(R.font.lcd, FontWeight.Normal, FontStyle.Normal),
        )

        return if (themeSate.value.isDarkMode) {
            dark
        } else {
            FontFamily.Default
        }
    }
}
