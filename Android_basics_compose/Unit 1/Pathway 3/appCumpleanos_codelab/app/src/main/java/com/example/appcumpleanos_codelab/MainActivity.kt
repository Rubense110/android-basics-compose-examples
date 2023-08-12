package com.example.appcumpleanos_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcumpleanos_codelab.ui.theme.AppCumpleanos_codelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCumpleanos_codelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Extraemos string para facilitar localizacion
                    // luego lo llamamos con getString() o stringResource()
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text), // mejor
                        from = getString(R.string.from_text))
                }
            }
        }
    }
}
/* Nos piden eliminarn esto
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
*/
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {

    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}
// todas las fun composable deben tener modifier como parametro opcional
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {

    // R es una clase que se crea sola, tiene todos los recursos del proyecto
    // painterResource() carga un recurso de imagen, toma su ID como argumento
    val image = painterResource(R.drawable.androidparty)
    Box {// Box nos permite apilar elementos, por ej texto encima de la imagen
        Image(
            painter = image,
            contentDescription = null,          // solo fines decorativos, no necesita descripcion
            contentScale = ContentScale.Crop,   // Para ajustar escala y que quede bien
            alpha = 0.5F                        // Contraste/Opacidad
        )
        GreetingText(
            message = message,
            from = from,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
)
    }

}

// Para ver en Design als cosas, hacemos una funcion nueva para un caso especifico reutilizando
// la anterior, no lo hacemos directamente en la original, para esto es @Preview
// todo lo hecho en @Preview no se ve reflejado en la app

/*
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    AppCumpleanos_codelabTheme {
//        Greeting("Ruben")
        GreetingText(message = "Happy Birthday Ruben!", from ="From Emma")
    }
}
*/

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    AppCumpleanos_codelabTheme {
        GreetingImage(
            stringResource(R.string.happy_birthday_text),
            stringResource(R.string.from_text))
    }
}