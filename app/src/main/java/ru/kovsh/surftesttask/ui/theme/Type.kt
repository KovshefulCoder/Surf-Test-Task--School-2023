package ru.kovsh.surftesttask.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.kovsh.surftesttask.R

val didactGothic = FontFamily(
    Font(R.font.didactgothic_regular, FontWeight.Normal),
)

val typography = Typography(
    body1 = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Black
    ),
    h1 = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Bold,
        fontSize = 44.sp,
        color = Black
    ),
    h2 = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = Black
    ),
    h4 = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Black
    ),
    subtitle1 = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Black
    ),
    subtitle2 = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Black
    ),
    caption = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        color = Black
    )
)