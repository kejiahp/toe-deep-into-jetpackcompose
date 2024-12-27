package com.example.getting_started

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.getting_started.countyInfo.CountryInfoMainView


import com.example.getting_started.ui.theme.Getting_startedTheme


class MainActivity : ComponentActivity() {
    /**
     * Init viewModel outside the onCreate lifecycle method, since viewModel, by default, is lifecycle aware; to preserve component state on change in device orientation (in which onSaveInstanceState & onRestoreInstanceState are triggered)
     */
//    private val mainActivityViewModel by viewModels<>()

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * ##Lifecycle Methods##
         * onCreate()
         * onStart()
         * onRestoreInstanceState()
         * onResume()
         * onPause()
         * onSaveInstanceState()
         * onStop()
         * onDestroy()
         * ##Lifecycle Methods##
         */
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    CountryInfoMainView();
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}