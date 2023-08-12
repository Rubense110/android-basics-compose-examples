package com.example.appcuadrante_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcuadrante_codelab.ui.theme.AppCuadrante_codelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCuadrante_codelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
    ){
        Column(modifier.weight(1f)) {
            createText(title = stringResource(R.string.title_1), descr = stringResource(R.string.descr_1),
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(
                        Color(0xFFEADDFF)
                    )
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally))
            createText(title = stringResource(R.string.title_2), descr = stringResource(R.string.descr_2),
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(
                        Color(0xFFD0BCFF)
                    )
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally))
        }
        Column(modifier.weight(1f)) {
            createText(title = stringResource(R.string.title_3), descr = stringResource(R.string.descr_3),
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(
                        Color(0xFFB69DF8)
                    )
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally))
            createText(title = stringResource(R.string.title_4), descr = stringResource(R.string.descr_4),
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(
                        Color(0xFFF6EDFF)
                    )
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally))
        }
    }
}

@Composable
fun createText(title : String, descr : String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    Text(
        text = descr,
        modifier = modifier,
        textAlign = TextAlign.Center)

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppCuadrante_codelabTheme {
        Greeting("Android")
    }
}