package com.gdev.jetpack.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdev.jetpack.compose.ui.theme.HelloComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    HelloComposeTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //Button Move to Text Field Stateless Sample
                Button(onClick = { context.startActivity(Intent(context, StatelessMainActivity::class.java)) }) {
                    Text(text = "Text Field Stateless")
                }
                //Button Move to Expandable CardView sample
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { context.startActivity(Intent(context, StatefulExpandableCardActivity::class.java)) }) {
                    Text(text = "Expandable CardView Stateful")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { context.startActivity(Intent(context, AnnotatedStringActivity::class.java)) }) {
                    Text(text = "Annotated String")
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}