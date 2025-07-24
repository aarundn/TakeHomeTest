package com.example.takehometest.core.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {

    @Serializable
    data object List:Destination
    @Serializable
    data class Details(val itemId: Int):Destination

}