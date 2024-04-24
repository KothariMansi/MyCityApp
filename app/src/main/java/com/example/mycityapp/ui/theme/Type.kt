package com.example.mycityapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mycityapp.R

// Set of Material typography styles to start with

val VarelaAround = FontFamily(Font(R.font.varelaround_regular))

val Cabin = FontFamily(
    Font(R.font.cabin_bold),
    Font(R.font.cabin_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Cabin,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
    ),

    displayMedium = TextStyle(
        fontFamily = Cabin,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    ),

    labelSmall = TextStyle(
        fontFamily = VarelaAround,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    ),
    labelMedium = TextStyle(
        fontFamily = VarelaAround,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),


    bodyMedium = TextStyle(
        fontFamily = VarelaAround,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    )

)
