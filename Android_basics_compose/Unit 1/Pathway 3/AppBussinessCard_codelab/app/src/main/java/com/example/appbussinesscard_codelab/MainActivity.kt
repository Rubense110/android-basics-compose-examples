package com.example.appbussinesscard_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.sharp.Call
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbussinesscard_codelab.ui.theme.AppBussinessCard_codelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppBussinessCard_codelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting(getString(R.string.name_text), getString(R.string.descr_text))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, descr : String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable._23064)

    Column(verticalArrangement = Arrangement.Center, modifier = Modifier
        .background(Color(0xFFD1FFD0))
        .fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = descr,
            fontSize = 20.sp,
            textAlign = TextAlign.Justify,
            color = Color(0xFF025F00),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)

        )
        Spacer(modifier = Modifier.height(200.dp))

        Column (Modifier
            .align(alignment = Alignment.CenterHorizontally)) {
            Row {
                Icon(
                    Icons.Sharp.Call, contentDescription = "Localized description",
                    modifier = Modifier.align(alignment = Alignment.CenterVertically))
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "+11 (222) 333 444 555",
                    modifier = Modifier.align(Alignment.CenterVertically))
                
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Icon(
                    Icons.Sharp.Share, contentDescription = "Localized description",
                    modifier = Modifier.align(alignment = Alignment.CenterVertically))
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "@RubenAndroidDev",
                    modifier = Modifier.align(Alignment.CenterVertically))

            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Icon(
                    Icons.Sharp.Email, contentDescription = "Localized description",
                    modifier = Modifier.align(alignment = Alignment.CenterVertically))
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "ruben@Android.dev",
                    modifier = Modifier.align(Alignment.CenterVertically))

            }

        }
    }





}
