package com.example.app30tips_codelab.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Country(
    @StringRes val countryNameRes: Int,
    @StringRes val countryDescRes: Int,
    @DrawableRes val countryIconRes: Int,
    @DrawableRes val countryMapRes: Int,
    @DrawableRes val countryDipMapRes: Int,
)
