package com.example.takehometest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.takehometest.R

// Set of Material typography styles to start with


// Set of Material typography styles to start with

val Sailec = FontFamily(
    Font(R.font.sailec_light, FontWeight.Normal),
    Font(R.font.sailec_bold, FontWeight.Bold),
    Font(R.font.sailec_medium, FontWeight.Medium),

    )


val Typography = Typography(
    // Headlines
    headlineLarge = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 28.sp // 120% of font size
    ),
    headlineMedium = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 21.6.sp
    ),
    // Body
    bodyLarge = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 2.5.em // 140%
    ),
    bodyMedium = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 20.8.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 18.2.sp
    ),
    // Buttons
    labelLarge = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    // Fields
    // Placeholder
    displaySmall = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    // Title & Description
    displayMedium = TextStyle(
        fontFamily = Sailec,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    )
)

