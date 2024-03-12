package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

data class QuadrantState(
    val title: String = "title",
    val body: String = "Displays text and follows the recommended Material Design guidelines.",
    val background: Color
)

@Composable
fun QuadrantView(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        QuadrantRow(
            modifier = Modifier.weight(1f),
            leftQuadrant = QuadrantState(background = Color.Magenta),
            rightQuadrant = QuadrantState(background = Color.Blue)
        )
        QuadrantRow(
            modifier = Modifier.weight(1f),
            leftQuadrant = QuadrantState(background = Color.Blue),
            rightQuadrant = QuadrantState(background = Color.Magenta)
        )
    }
}

@Composable
private fun QuadrantRow(
    modifier: Modifier = Modifier,
    leftQuadrant: QuadrantState,
    rightQuadrant: QuadrantState
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        QuadrantComponentView(
            modifier = Modifier.weight(1f),
            state = leftQuadrant
        )
        QuadrantComponentView(
            modifier = Modifier.weight(1f),
            state = rightQuadrant
        )
    }
}

@Composable
private fun QuadrantComponentView(modifier: Modifier = Modifier, state: QuadrantState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(state.background)
            .fillMaxSize()
            .padding(8.dp)

    ) {
        Text(
            state.title,
            fontWeight = FontWeight.Bold
        )

        Text(
            state.body,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun QuadrantViewPreview() {
    MyApplicationTheme {
        QuadrantView()
    }
}
