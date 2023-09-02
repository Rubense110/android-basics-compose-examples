package com.example.app30tips_codelab

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app30tips_codelab.model.CountriesDataSource
import com.example.app30tips_codelab.model.Country
import com.example.app30tips_codelab.ui.theme.App30tips_codelabTheme

@Composable
fun CountryCard(
    country: Country,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var diploMap by remember { mutableStateOf(false) }

    Card(modifier = modifier) {
        Column (modifier = Modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium)
        )) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small)),
                verticalAlignment = Alignment.CenterVertically,
            ){
                CountryShield(country.countryIconRes)
                CountryName(country.countryNameRes)
                Spacer(modifier.weight(1f))
                CountryExpandButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }
            if (expanded) {
                var img = when (diploMap) {
                    true -> country.countryDipMapRes
                    false -> country.countryMapRes
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MapButtonOptions(
                        diploMap = diploMap,
                        onClickf = { diploMap = false },
                        onClickt = { diploMap = true }
                    )
                    MapImage(img)
                    CountryDescriptionText(country.countryDescRes)
                }
            }
        }
    }
}

@Composable
fun MapButtonOptions(
    diploMap: Boolean,
    modifier: Modifier = Modifier,
    onClickf: () -> Unit,
    onClickt: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            colors = if (!diploMap){
                 ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSecondaryContainer)
            } else {
                 ButtonDefaults.buttonColors()
                   },

            modifier = Modifier
                .size(112.dp, 24.dp)
                .padding(horizontal = 8.dp),
            contentPadding = PaddingValues(
                horizontal = 8.dp, vertical = 2.dp
            ),
            onClick = onClickf
        ) {
            Text(
                text = stringResource(R.string.political_map),
                style = MaterialTheme.typography.labelSmall)
        }

        Button(
            colors = if (diploMap){
                ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSecondaryContainer)
            } else {
                ButtonDefaults.buttonColors()
            },
            modifier = Modifier
                .size(112.dp, 24.dp)
                .padding(horizontal = 8.dp),
            contentPadding = PaddingValues(
                horizontal = 8.dp, vertical = 2.dp
            ),
            onClick = onClickt
        ) {
            Text(
                text = stringResource(R.string.diplomatic_map),
                style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
fun CountryDescriptionText(
    @StringRes countryDescRes: Int,
    modifier: Modifier = Modifier) {
    val scroll = rememberScrollState(0)
    Text(
        text = stringResource(countryDescRes),
        style = MaterialTheme.typography.bodySmall,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(horizontal = 24.dp)
            .padding(bottom = 32.dp)
            .size(352.dp, 160.dp)
            .verticalScroll(scroll)
        )
}

@Composable
fun MapImage(
    @DrawableRes countryMapRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(
            id = countryMapRes),
        contentDescription = null)
}

@Composable
fun CountryExpandButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ){
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun CountryName(
    @StringRes countryNameRes: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(countryNameRes),
        style = MaterialTheme.typography.displaySmall)
}

@Composable
fun CountryShield(
    @DrawableRes countryIconRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(countryIconRes),
        contentDescription = null
    )
}

@Preview
@Composable
fun CountryCardPreview() {
    App30tips_codelabTheme {
        CountryCard(country = CountriesDataSource.countries[0])
    }
}
