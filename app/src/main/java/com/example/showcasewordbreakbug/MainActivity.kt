package com.example.showcasewordbreakbug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.showcasewordbreakbug.ui.theme.ShowcaseWordBreakBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShowcaseWordBreakBugTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val text by remember { mutableStateOf("https://en.m.wikipedia.org/wiki/2025_Iberian_Peninsula_blackout") }

    Column(
        modifier = modifier
            .padding(2.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("The full text to show:")
        Text(
            text = text,
            modifier = Modifier.border(2.dp, Color.Green),
            fontSize = 17.sp,
        )

        HorizontalDivider(thickness = 50.dp, color = Color.Transparent)

        Text("Is cut off with space still available to render")
        Text(
            text = text,
            modifier = Modifier.border(2.dp, Color.Red),
            fontSize = 17.sp,
            maxLines = 1,
        )

        HorizontalDivider(thickness = 50.dp, color = Color.Transparent)

        Text("The automatic word break")
        Text("Does not happen if using softWrap = false")
        Text(
            text = text,
            modifier = Modifier.border(2.dp, Color.Blue),
            fontSize = 17.sp,
            softWrap = false,
            maxLines = 1,
        )

        HorizontalDivider(thickness = 50.dp, color = Color.Transparent)

        Text("The automatic word break")
        Text("Does not happen if using an ellipsis")
        Text(
            text = text,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.border(2.dp, Color.Blue),
            fontSize = 17.sp,
            maxLines = 1,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShowcaseWordBreakBugTheme {
        Greeting()
    }
}