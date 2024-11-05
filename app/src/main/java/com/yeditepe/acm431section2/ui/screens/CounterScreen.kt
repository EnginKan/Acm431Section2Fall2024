package com.yeditepe.acm431section2.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yeditepe.acm431section2.ui.theme.Acm431Section2Theme
import com.yeditepe.acm431section2.ui.viewmodels.CounterViewModel



@Composable
fun MyCounterScreen(model : CounterViewModel){

          var counter  =model.counter.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text ="${counter.value}"
        )
        Button(onClick = {model.increment()}) {
            Text(text= "Increment")
        }
    }
}

@Preview
@Composable
fun MyCounterScreenPreview(){
    val mymodel : CounterViewModel = viewModel()
    Acm431Section2Theme {
        Surface {
            MyCounterScreen(model =mymodel)
        }
    }
}