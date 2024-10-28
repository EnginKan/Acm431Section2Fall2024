package com.yeditepe.acm431section2.ui.screens

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yeditepe.acm431section2.R
import com.yeditepe.acm431section2.ui.theme.Acm431Section2Theme


@Composable
fun SignUp(){

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Image(
            painterResource(R.drawable.yeditepe),
            contentDescription = ""
        )


        TextField(
            value = username,
            label ={ Text("username") },
            onValueChange = {username= it},
            leadingIcon = { Icon(Icons.Default.Face,
                contentDescription = "") }
        )
        OutlinedTextField(
            value=email,
            label = { Text("email") },
            onValueChange = {email = it},
            leadingIcon = {Icon(Icons.Default.Email,
                contentDescription = "")
            }
        )
        OutlinedTextField(
            value = password,
            label = { Text("password") },
            onValueChange = { password = it},
            leadingIcon = { Icon(Icons.Default.Lock,
                contentDescription ="" )
             },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = {}) {
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text= "Sign Up")
                Icon(Icons.Default.Add,
                    contentDescription = "")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMainScreen(
    content: @Composable ()->Unit){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Small Top App Bar")

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = { Icon(Icons.Filled.Menu,
                    contentDescription = "") },
                actions = {
                    IconButton(onClick ={},
                        modifier = Modifier.background(
                            color=MaterialTheme.colorScheme.secondaryContainer,
                            shape = CircleShape).border(2.dp,
                            color = MaterialTheme.colorScheme.onTertiary,
                                shape = CircleShape)

                        ) {
                        Text("E")
                    }
                }

            )
        },
        bottomBar = {
            BottomAppBar(
                tonalElevation = 10.dp,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Home,
                            contentDescription = "")
                                            }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Favorite,
                            contentDescription = "")
                    }
                }
            )

        },
        content = {paddingValues ->
            Column(modifier =Modifier.padding(paddingValues)
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                content()
            }

        }
    )

}
@Preview(showSystemUi = true)
@Composable
fun SignUpPreview(){

    Acm431Section2Theme {

        Surface {
            MyMainScreen(content ={ SignUp()})
        }
    }
}