package com.example.takehometest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.takehometest.core.navigation.Destination
import com.example.takehometest.presentation.details.navigation.navigateToDetailsScreen
import com.example.takehometest.presentation.list.navigation.navigateToListScreen


@Composable
fun rememberAppState(
    mainStartDestination: Destination,
    mainNavController: NavHostController = rememberNavController(),
): AppState {
    return remember(
        mainStartDestination,
        mainNavController,
    ) {
        AppState(
            mainStartDestination = mainStartDestination,
            mainNavController = mainNavController
        )
    }
}

class AppState(
    val mainStartDestination: Destination,
    val mainNavController: NavHostController,
) {
    fun goToList(itemId: Int) = mainNavController.navigateToListScreen()
    fun goToDetail(itemId: Int) = mainNavController.navigateToDetailsScreen(itemId = itemId)
}