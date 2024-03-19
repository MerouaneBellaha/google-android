package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun CardView(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray.copy(alpha = 0.1f))
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max))
        ProfileView()
        UserDetailsView()
    }
}

@Composable
private fun ProfileView(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val image = painterResource(id = R.drawable.ic_task_completed)

        Image(
            painter = image,
            contentDescription = "profile picture",
            modifier = Modifier.size(width = 175.dp, height = 175.dp)
        )
        Text(
            "name lastname",
            fontSize = 35.sp
        )
        Text("A not so short description")
    }
}

@Composable
private fun UserDetailsView(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        DetailsRowView(content = "+00 000 000 000")
        DetailsRowView(content = "john.doe@gmail.com")
        DetailsRowView(content = "@socialMediaAcc")
    }
}

@Composable
private fun DetailsRowView(modifier: Modifier = Modifier, content: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Rounded.Phone,
            tint = Color.Blue,
            contentDescription = null,
            modifier = Modifier.height(22.dp)
        )
        Text(
            content,
            color = Color.Blue
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CardViewPreview() {
    MyApplicationTheme {
        CardView()
    }
}
