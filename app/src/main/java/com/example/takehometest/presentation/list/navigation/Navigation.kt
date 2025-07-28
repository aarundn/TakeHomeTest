package com.example.takehometest.presentation.list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.takehometest.AppState
import com.example.takehometest.core.navigation.Destination
import com.example.takehometest.presentation.list.ListScreenRout

fun NavController.navigateToListScreen() {
    navigate(Destination.List)
}
fun NavGraphBuilder.listRoute(appState: AppState) {
    composable<Destination.List> {
        ListScreenRout(appState = appState)
    }
}