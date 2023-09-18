package com.igotfr.system.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.igotfr.system.ui.theme.SystemTheme
import com.igotfr.system.navigation.HomeNavGraph
import com.igotfr.system.ui.components.BottomBar

@Composable
fun ViewContent(name: String, onClick: () -> Unit) {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Text(
      text = name,
      modifier = Modifier.clickable { onClick() },
      fontSize = MaterialTheme.typography.bodyLarge.fontSize,
      fontWeight = FontWeight.Bold
    )
  }
}

@Preview
@Composable
fun ViewContentPreview() {
  SystemTheme {
    ViewContent("Conteúdo que exibirei!") {}
  }
}

@Composable
fun LoginContent(
  onLoginClick: () -> Unit,
  onSignUpClick: () -> Unit,
  onForgotClick: () -> Unit
) {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      modifier = Modifier.clickable { onLoginClick() },
      text = "Login",
      fontSize = MaterialTheme.typography.bodyLarge.fontSize,
      fontWeight = FontWeight.Bold
    )
    Text(
      modifier = Modifier.clickable { onSignUpClick() },
      text = "Sign Up",
      fontSize = MaterialTheme.typography.bodyLarge.fontSize,
      fontWeight = FontWeight.Medium
    )
    Text(
      modifier = Modifier.clickable { onForgotClick() },
      text = "Forgot Password",
      fontSize = MaterialTheme.typography.bodyLarge.fontSize,
      fontWeight = FontWeight.Medium
    )
  }
}

@Preview
@Composable
fun LoginContentPreview() {
  SystemTheme {
    LoginContent(
      onLoginClick = {},
      onSignUpClick = {},
      onForgotClick = {}
    )
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeViewContent(navController: NavHostController = rememberNavController()) {
  Scaffold(
    bottomBar = { BottomBar(navController) }
  ) {
    HomeNavGraph(navController)
  }
}

@Preview
@Composable
fun HomeViewContentPreview() {
  SystemTheme {
    HomeViewContent(rememberNavController())
  }
}