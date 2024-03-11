package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R.drawable.androidparty
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article()
//                    GreetingsImage(
//                        stringResource(R.string.happy_birthday) + " Sam",
//                        from = "Merouane",
//                        modifier = Modifier
//                            .padding(8.dp)
//                    )
                }
            }
        }
    }
}

@Composable
fun GreetingsImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = androidparty)
    Box(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.8F
        )

        GreetingsText(
            message,
            from = from,
            modifier = modifier
                .fillMaxSize()
        )
    }
}

@Composable
private fun GreetingsText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 112.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "from $from",
            fontSize = 30.sp,
            lineHeight = 35.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(20))
                .padding(8.dp)
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        GreetingsImage(
            "Bon anniv carlos",
            "Bib"
        )
    }
}
