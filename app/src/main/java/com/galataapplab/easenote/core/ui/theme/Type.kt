package com.galataapplab.easenote.core.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.galataapplab.easenote.R

// Set of Material typography styles to start with

val Bitter = FontFamily(
    Font(R.font.bitter_bold, FontWeight.Bold), Font(R.font.bitter_regular)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Bitter,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    ),
    h2 = TextStyle(
        fontFamily = Bitter,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = Bitter,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    ),
    body2 = TextStyle(
        fontFamily = Bitter,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    ),
)