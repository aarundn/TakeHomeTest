package com.example.takehometest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.takehometest.core.navigation.Destination
import com.example.takehometest.core.navigation.MainNavHost
import com.example.takehometest.ui.theme.TakeHomeTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state = rememberAppState(
                mainStartDestination = Destination.List,
                mainNavController = rememberNavController()
            )
            TakeHomeTestTheme {
                    MainNavHost(appState = state)
            }
        }
    }
}