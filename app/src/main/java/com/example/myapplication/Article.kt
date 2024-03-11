package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R.string.article_body
import com.example.myapplication.R.string.article_intro
import com.example.myapplication.R.string.article_title
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Article(modifier: Modifier = Modifier) {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = modifier) {
                TopImageView()
                ArticleView(
                    title = stringResource(article_title),
                    intro = stringResource(article_intro),
                    body = stringResource(article_body)
                )
            }
        }
    }
}

@Composable
private fun TopImageView(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun ArticleView(title: String, intro: String, body: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        Text(
            intro,
            textAlign = TextAlign.Justify,
            lineHeight = 24.sp
        )

        Text(
            body,
            textAlign = TextAlign.Justify,
            lineHeight = 24.sp,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun ArticlePreview() {
    MyApplicationTheme {
        Article()
    }
}
