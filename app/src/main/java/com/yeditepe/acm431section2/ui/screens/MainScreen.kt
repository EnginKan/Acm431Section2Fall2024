package com.yeditepe.acm431section2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yeditepe.acm431section2.ui.theme.Acm431Section2Theme

import com.yeditepe.acm431section2.R

@Composable
fun MyText(fontSize: Float = 24f,
           isItalic: Boolean){
    Text(
        text = "Hello Android",
        fontSize = fontSize.sp,
        textAlign = TextAlign.Center,
        modifier= Modifier.fillMaxWidth()
            .background(Color.Blue),
        color=Color.White,
        fontStyle = when(isItalic){
            true->FontStyle.Italic
            else->FontStyle.Normal
        }
    )
}

@Composable
fun MyFunnyScreen(){
    var myFontSize = remember {mutableStateOf(12f)}
    var checked by remember { mutableStateOf(false) }
   
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        MyText(fontSize = myFontSize.value,
            isItalic = checked )
        Slider(
            value = myFontSize.value,
            valueRange = 8f..32f,
            onValueChange = {myFontSize.value = it}
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(text="Normal")
            Switch(checked = checked,
                onCheckedChange={
                    checked=it
                }
            )
            Text(text="Italic")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    var counter by remember { mutableStateOf(0) }
    var username by remember{ mutableStateOf("") }
    Scaffold(
        topBar={
            TopAppBar(
                title= {Text(text = "Top App Bar")},
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(Icons.Default.Search,
                            contentDescription = "")
                    }
                },

            )
        },
        content = {
            it ->
            Column(Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                modifier = Modifier.padding(it),
                text = "$counter", textAlign = TextAlign.Center
            )
                OutlinedTextField(
                    value = username,
                    label = {Text("Username:")},
                    onValueChange = {username= it},
                    placeholder = { Text("username") },
                    leadingIcon = {Icon(Icons.Default.Face,
                        contentDescription = "")}
                )
                OutlinedTextField(
                    value= "",
                    onValueChange = {},
                    leadingIcon = { Icon(Icons.Default.Email,
                        contentDescription = "")},
                    placeholder = {Text(text = "Email")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
            }
        },
        bottomBar ={ BottomAppBar(content = {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(14.dp)) {
                IconButton(onClick = {}) {
                     Icon(imageVector = Icons.Default.Home,
                        contentDescription = "Home")
                 }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Favorite,
                        contentDescription = "")
                }
            }
        }
        )
                   },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton ={ FloatingActionButton(
            onClick = {counter.inc()},
            content = { Column {
                Text(text = "+")}
            }
        )
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun MyTextPreview(){

    Acm431Section2Theme {
        Surface {
            MainScreen()
        }
    }

}