package io.stupacki.kotestsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.stupacki.kotestsample.composable.MainScreen
import io.stupacki.kotestsample.ui.theme.KotestSampleTheme

internal class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotestSampleTheme {
                MainScreen()
            }
        }
    }
}