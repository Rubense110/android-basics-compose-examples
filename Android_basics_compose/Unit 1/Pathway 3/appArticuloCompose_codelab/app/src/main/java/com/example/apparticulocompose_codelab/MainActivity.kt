package com.example.apparticulocompose_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apparticulocompose_codelab.ui.theme.AppArticuloCompose_codelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppArticuloCompose_codelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val image = painterResource(R.drawable.bg_compose_background)
                    Greeting(image,
                        stringResource(R.string.title_text),
                        stringResource(R.string.intro_text),
                        stringResource(R.string.descr_text) )
                }
            }
        }
    }
}

@Composable
fun Greeting(image: Painter,
             title: String,
             intro: String,
             description: String,
             modifier: Modifier = Modifier) {
    Column{
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = title,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = intro,
            fontSize = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = description,
            fontSize = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppArticuloCompose_codelabTheme {
        val image = painterResource(R.drawable.bg_compose_background)
        Greeting(image,
            stringResource(R.string.title_text),
            stringResource(R.string.intro_text),
            stringResource(R.string.descr_text) )
    }
}