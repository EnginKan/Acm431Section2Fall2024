package com.yeditepe.acm431section2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yeditepe.acm431section2.ui.theme.Acm431Section2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Acm431Section2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v("ONSTART","ın on start callback")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ONRESUME","ın on resume callback")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ONPAUSE","ın on pause callback")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ONSTOP","in on stop callback")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ONDESTROY","in on DESTROY callback")

    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ONRESTART","in on RESTART callback")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Acm431Section2Theme {
        Greeting("Android")
    }
}