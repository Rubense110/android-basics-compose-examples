package com.example.app30tips_codelab.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app30tips_codelab.R

// Set of Material typography styles to start with
val Merryweather = FontFamily(
    Font(R.font.merriweather_regular, FontWeight.Normal),
    Font(R.font.merriweather_bold, FontWeight.Bold)
)

val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = Merryweather,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    displayLarge = TextStyle(
        fontFamily = Merryweather,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),

    displayMedium = TextStyle(
        fontFamily = Merryweather,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    displaySmall = TextStyle(
        fontFamily = Merryweather,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
)