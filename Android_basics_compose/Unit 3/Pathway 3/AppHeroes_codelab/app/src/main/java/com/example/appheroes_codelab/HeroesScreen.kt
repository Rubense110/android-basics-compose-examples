package com.example.appheroes_codelab

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appheroes_codelab.model.Hero
import com.example.appheroes_codelab.model.Heroes
import com.example.appheroes_codelab.ui.theme.AppHeroes_codelabTheme


// Creates each card, calls HeroItems() for the text and HeroIcon() for the Icon
@Composable
fun HeroCard(hero: Hero,  modifier : Modifier = Modifier) {

    Card (
        modifier = modifier
            .fillMaxWidth(),
        elevation = cardElevation(2.dp)
    ) {

        Row (modifier = Modifier
                .fillMaxWidth().padding(12.dp).height(72.dp),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            HeroItems(hero.nameRes, hero.descriptionRes, Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            HeroIcon(hero.imageRes)
        }
    }
}

// Creates both the Name and Description of the Hero, following MaterialTheme styles
@Composable
fun HeroItems(
    @StringRes heroName: Int,
    @StringRes heroDesc: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(heroDesc),
            style = MaterialTheme.typography.bodyLarge

        )
    }
}

// Creates the Icon, nothing special
@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(heroIcon),
        modifier = modifier
            .size(72.dp)
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        contentDescription = null)
}


@Preview
@Composable
fun HeroCardPreview(){
    AppHeroes_codelabTheme {
        HeroCard(hero = Heroes.heroes[0])
    }
}