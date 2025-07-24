package com.example.takehometest.core.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.takehometest.AppState
import com.example.takehometest.presentation.details.navigation.detailsRoute
import com.example.takehometest.presentation.list.navigation.listRoute

@Composable
fun MainNavHost(
    appState: AppState,
    modifier: Modifier = Modifier,
) {

    NavHost(
        navController = appState.mainNavController,
        startDestination = appState.mainStartDestination,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(400)
            ) + fadeIn(animationSpec = tween(400))
        },
        exitTransition = {
            scaleOut(
                targetScale = 0.98f,
                animationSpec = tween(500)
            ) + fadeOut(animationSpec = tween(500))
        },
        popEnterTransition = {
            scaleIn(
                initialScale = 0.98f,
                animationSpec = tween(400)
            ) + fadeIn(animationSpec = tween(400))
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(500)
            ) + fadeOut(tween(500))
        },
        modifier = modifier,
    )
    {
        listRoute(appState = appState)
        detailsRoute(appState = appState)
    }

}