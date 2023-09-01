package com.example.app30tips_codelab.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.app30tips_codelab.R

object CountriesDataSource {
    val aragon = Country(
        countryNameRes = R.string.aragon_name,
        countryDescRes = R.string.aragon_desc,
        countryIconRes = R.drawable.shield_aragon,
        countryDipMapRes = R.drawable.aragon_dip,
        countryMapRes = R.drawable.aragon
    )
}