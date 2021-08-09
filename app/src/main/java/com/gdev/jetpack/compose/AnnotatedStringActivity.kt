package com.gdev.jetpack.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdev.jetpack.compose.ui.theme.HelloComposeTheme

class AnnotatedStringActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            MainScreenAnnotatedString(darkTheme = true)
        }
    }
}

@Composable
fun MainScreenAnnotatedString(darkTheme: Boolean) {
    HelloComposeTheme(darkTheme = darkTheme) {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GoogleText()
            }
        }
    }
}


@Composable
fun GoogleText() {
    Card{
        Column(modifier = Modifier.padding(16.dp)) {
            Text(modifier = Modifier.padding(16.dp), text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = colorResource(id = R.color.lightBlue), fontSize = 80.sp, fontWeight = FontWeight.Bold)){ append("G") }
                withStyle(style = SpanStyle(color = colorResource(id = android.R.color.holo_red_light), fontSize = 60.sp, fontWeight = FontWeight.SemiBold)){ append("o") }
                withStyle(style = SpanStyle(color = colorResource(id = R.color.yellow), fontSize = 60.sp, fontWeight = FontWeight.SemiBold)){ append("o") }
                withStyle(style = SpanStyle(color = colorResource(id = R.color.lightBlue), fontSize = 60.sp, fontWeight = FontWeight.SemiBold)){ append("g") }
                withStyle(style = SpanStyle(color = colorResource(id = R.color.green), fontSize = 60.sp, fontWeight = FontWeight.SemiBold)){ append("l") }
                withStyle(style = SpanStyle(color = colorResource(id = android.R.color.holo_red_light), fontSize = 50.sp, fontWeight = FontWeight.SemiBold)){ append("e") }
            })
        }
    }
}

@Preview(name = "Google Text Preview Dark", showBackground = true, showSystemUi = true)
@Composable
fun GoogleTextPreviewDark(){
    MainScreenAnnotatedString(darkTheme = true)
}

@Preview(name = "Google Text Preview Light", showBackground = true, showSystemUi = true)
@Composable
fun GoogleTextPreviewLight(){
    MainScreenAnnotatedString(darkTheme = false)
}