package com.example.testovyo.presentation.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.Modifier
import com.example.testovyo.presentation.di.appModule
import com.example.testovyo.presentation.theme.AppTheme
import com.example.testovyo.presentation.ui.compose.HomeScreen
import com.example.testovyo.presentation.viewmodel.MyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class MainActivity : AppCompatActivity() {

    private val _myViewModel: MyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(appModule)
        setContent {
            AppTheme {
                HomeScreen(
                    modifier = Modifier,
                    viewModel = _myViewModel
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(appModule)
    }
}