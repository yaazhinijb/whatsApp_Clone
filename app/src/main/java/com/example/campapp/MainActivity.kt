package com.example.campapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.window.SplashScreenView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.campapp.composable.Center
import com.example.campapp.ui.theme.CampAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CampAppTheme {
                val composableScope = rememberCoroutineScope()
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    SplashView()
                    composableScope.launch{
                        delay(1000)
                        startActivity(Intent(this@MainActivity, HomeActv::class.java))
                    }
                }
            }
        }
    }
}

@Composable
fun SplashView(){
    Center(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }

}