package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


// Data classes only contain properties, and provide some methods to work with them
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)