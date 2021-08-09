package com.gdev.jetpack.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdev.jetpack.compose.ui.theme.HelloComposeTheme
const val titleCard = "Slatri Utara"
const val body = "Slatri adalah desa di kecamatan Larangan, Brebes, Jawa Tengah, Indonesia. Desa ini berjarak sekitar 9 Km dari ibu kota kecamatan Larangan ke arah utara atau 18 Km dari ibu kota Kabupaten Brebes melalui Sitanggal."
class StatefulExpandableCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableCardScreen(title = titleCard, body = body)
        }
    }
}

@Composable
fun ExpandableCardScreen(title: String, body: String) {
    var expanded by remember { mutableStateOf(false) }
    HelloComposeTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = title)
                        if (expanded) {
                            Text(text = body)
                            IconButton(onClick = { expanded = false }) {
                                Icon(Icons.Default.ExpandLess, contentDescription = "Collapse")
                            }
                        } else {
                            IconButton(onClick = { expanded = true }) {
                                Icon(Icons.Default.ExpandMore, contentDescription = "Expand")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCardScreen(title = titleCard, body = body)
}