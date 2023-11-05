package com.zuoguan.counterdemo.pages.main

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

@Composable
fun PageA(
    viewModel: PageAViewModel = hiltViewModel()
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val countState by viewModel.countState.collectAsState()

        Text(text = "${countState.count}", fontSize = 64.sp, fontWeight = FontWeight.ExtraBold)
        Text(text = "Previous Count: ${viewModel.previousCount}")
        Spacer(modifier = Modifier.padding(32.dp))
        Button(onClick = { viewModel.addOne() }, Modifier.fillMaxWidth()) {
            Text(text = "ADD ONE")
        }
    }
}