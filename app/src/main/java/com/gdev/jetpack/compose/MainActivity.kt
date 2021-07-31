package com.gdev.jetpack.compose

import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ekn.gruzer.gaugelibrary.HalfGauge
import com.ekn.gruzer.gaugelibrary.Range
import com.gdev.jetpack.compose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                GaugeViewScreen(modifier = Modifier.width(400.dp).height(400.dp))
            }
        }
    }
}

@Composable
fun GaugeViewScreen(modifier: Modifier) {
    AndroidView(modifier = modifier, factory = { context ->
        val halfGauge = HalfGauge(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
        val range1 = Range().apply {
            color = android.graphics.Color.RED
            from = 0.0
            to = 50.0
        }
        val range2 = Range().apply {
            color = android.graphics.Color.YELLOW
            from = 50.0
            to = 100.0
        }
        val range3 = Range().apply {
            color = android.graphics.Color.GREEN
            from = 100.0
            to = 150.0
        }
        halfGauge.apply {
            addRange(range1)
            addRange(range2)
            addRange(range3)
            minValue = 0.0
            maxValue = 150.0
            value = 75.0
        }
        halfGauge
    })
}


@Preview("Preview GaugeView", showBackground = true)
@Composable
fun PreviewGaugeView() {
    GaugeViewScreen(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
}


