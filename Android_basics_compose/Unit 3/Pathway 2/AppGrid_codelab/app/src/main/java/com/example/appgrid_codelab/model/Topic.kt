package com.example.appgrid_codelab.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Topic(
    @StringRes val stringResourceId: Int,
    val associatedCourses: Int,
    @DrawableRes val imageResourceId: Int
)

