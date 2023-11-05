package com.zuoguan.counterdemo.pages.start

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.zuoguan.counterdemo.route.Route


@Composable
fun StartPageView(
    navController: NavController,
    viewModel: StartPageViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val countState by viewModel.countState.collectAsState()

        Text(text = "${countState.count}" , fontSize = 64.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.padding(32.dp))
        Button(onClick = { viewModel.addOne() }, Modifier.fillMaxWidth()) {
            Text(text = "ADD ONE")
        }
        Button(onClick = {
            navController.navigate(Route.Main.route){
                popUpTo(Route.Start.route) { inclusive = true }
            }
        }, Modifier.fillMaxWidth()) {
            Text(text = "ENTER")
        }
    }
}