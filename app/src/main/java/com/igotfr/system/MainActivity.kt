package com.igotfr.system

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.igotfr.system.navigation.RootNavigationGraph
import com.igotfr.system.ui.theme.SystemTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SystemTheme {
        // A surface container using the 'background' color from the theme
        //Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          ComplexNavigationGraph()
        //}
      }
    }
  }
}

@Composable
private fun ComplexNavigationGraph() {
  SystemTheme {
    RootNavigationGraph(navController = rememberNavController())
  }
}

/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  SystemTheme {
    Greeting("Android")
  }
}*/