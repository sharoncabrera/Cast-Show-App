package com.example.castshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import com.example.castshow.core.presentation.Navigation
import com.example.castshow.ui.theme.CastShowTheme
import com.example.castshow.ui.theme.DarkerGreen
import com.example.castshow.ui.theme.Green
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Green.toArgb()
            window.navigationBarColor = DarkerGreen.toArgb()
            CastShowTheme {
                Navigation()
            }
        }
    }
}