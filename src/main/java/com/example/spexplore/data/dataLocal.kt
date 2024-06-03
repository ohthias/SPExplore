package com.example.spexplore.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.spexplore.R

data class DataLocal(
    @StringRes val idStringLocal : Int,
    @DrawableRes val idDrawableResLocal : Int,
)

val dataLocal = listOf(
    DataLocal(R.string.cultura, R.drawable.cultura),
    DataLocal(R.string.lazer, R.drawable.lazer),
    DataLocal(R.string.restaurante, R.drawable.restaurante),
)
