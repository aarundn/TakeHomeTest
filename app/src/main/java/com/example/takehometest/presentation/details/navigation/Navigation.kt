package com.example.takehometest.presentation.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.takehometest.AppState
import com.example.takehometest.core.navigation.Destination.Details
import com.example.takehometest.presentation.details.DetailsRout

fun NavController.navigateToDetailsScreen(itemId: Int) {
    navigate(Details(itemId = itemId))
}
fun NavGraphBuilder.detailsRoute(appState: AppState) {
    composable<Details> { backStackEntry ->
        val itemId = backStackEntry.toRoute<Details>().itemId
        DetailsRout(
            appState = appState,
            itemId = itemId,
        )
    }
}