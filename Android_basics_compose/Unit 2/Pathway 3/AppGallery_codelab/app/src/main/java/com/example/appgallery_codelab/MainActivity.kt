package com.example.appgallery_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appgallery_codelab.ui.theme.AppGallery_codelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppGallery_codelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GalleryApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GalleryApp() {
    AppGallery_codelabTheme {
        Gallery(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }
}
@Composable
fun Gallery(modifier : Modifier = Modifier) {
    var imageResource = R.drawable.bloom
    var contentDescription = R.string.bloom_img_descr

    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(40.dp))
        Card (
            modifier = Modifier
                .padding(16.dp)
                .width(260.dp),
            elevation = CardDefaults.elevatedCardElevation(20.dp),
            shape = RoundedCornerShape(16.dp),
            colors = cardColors(containerColor = Color(0xFFFFD6FC),)
        ) {
            Image(
                modifier = Modifier
                    .padding(15.dp)
                    .size(400.dp)
                    .clip(RectangleShape),
                contentScale = ContentScale.Fit,
                painter = painterResource(imageResource),
                contentDescription = stringResource(contentDescription))
        }

        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Bloom",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(16.dp),
                text = "La main character",
                textAlign = TextAlign.Justify)
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Spacer(modifier = Modifier.width(1.dp))
            GalleryButton(
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp),
                text = "Previous")

            GalleryButton(
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp),
                text = "Next")
            Spacer(modifier = Modifier.width(1.dp))

            }
        }
    }


@Composable
fun GalleryButton (
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { /*TODO*/ },
    text: String = "xd",
    textModifier: Modifier = Modifier,)
{
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFC2C2)),
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp))
    {
        Text(text, color = Color.Black,)
    }
}

