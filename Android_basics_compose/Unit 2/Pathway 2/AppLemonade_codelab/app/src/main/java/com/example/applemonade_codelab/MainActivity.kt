package com.example.applemonade_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applemonade_codelab.ui.theme.AppLemonade_codelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppLemonade_codelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    AppLemonade_codelabTheme {
        Lemonade(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {

    var status by remember { mutableStateOf(1) }
    var count by remember { mutableStateOf(0) }

    val imageResource = when (status) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val imageDescription = when (status) {
        1 -> R.string.tree_text
        2 -> R.string.lemon_text
        3 -> R.string.lemonade_text
        else -> R.string.glass_text
    }

    val contentDescription = when (status){
        1 -> R.string.tree_content_descr
        2 -> R.string.lemon_content_descr
        3 -> R.string.lemonade_content_descr
        else -> R.string.glass_content_descr
    }

    Column (
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Card (
            colors = cardColors(containerColor = Color(0xFFFFFF51),),
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .weight(1f))
        {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Lemonade",
                fontWeight = FontWeight.Bold ,
                fontSize =  24.sp,
                textAlign = TextAlign.Center,
            )
        }

        Column (
            modifier = Modifier.weight(5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        )
        {
            Box (contentAlignment = Alignment.Center,)
            {
                Card (
                    modifier = Modifier.padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = cardColors(containerColor = Color(0xFFD1FFD0),))
                {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = stringResource(contentDescription)
                    )
                }
                Button(
                    onClick = { status = when (status)
                    {
                    1 -> { count = (2..4).random(); 2 }
                    2 -> { count--; when (count){ 0 -> 3 else -> 2 } }
                    3 -> 4
                    else -> 1
                    }},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black.copy(
                            alpha = 0F,)),
                    modifier = Modifier
                        .width(160.dp)
                        .height(200.dp),
                    shape = RoundedCornerShape(16.dp)
                ){/*empty*/}
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(imageDescription))
        }
    }
}

