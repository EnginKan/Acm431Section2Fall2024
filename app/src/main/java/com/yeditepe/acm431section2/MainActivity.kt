package com.yeditepe.acm431section2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yeditepe.acm431section2.ui.screens.ProductDetail
import com.yeditepe.acm431section2.ui.screens.ProductListScreen
import com.yeditepe.acm431section2.ui.theme.Acm431Section2Theme
import com.yeditepe.acm431section2.ui.viewmodels.ProductViewModel

class MainActivity : ComponentActivity() {

enum class Route(name : String){
    HOME("HOME"),
    SETTING("SETTING"),
    FAV("Favourite")
}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val controller = rememberNavController()
            val stackEntry= controller.currentBackStackEntryAsState()
            val currentDestination = stackEntry.value?.destination
            Acm431Section2Theme {
                Scaffold(
                    //topBar = {},
                    bottomBar = {
                       /* NavigationBar {
                            NavigationBarItem(
                                icon={Icon(Icons.Outlined.Home, contentDescription = Route.HOME.name)},
                                onClick = {controller.navigate(Route.HOME.name)},
                                selected = currentDestination?.route.equals(Route.HOME.name)
                                                            )


                            NavigationBarItem(
                                icon={Icon(Icons.Outlined.Favorite, contentDescription = Route.FAV.name)},
                                onClick = {controller.navigate(Route.FAV.name)},
                                selected = currentDestination?.route.equals(Route.FAV.name)
                            )


                            NavigationBarItem(
                                icon={Icon(Icons.Outlined.Settings, contentDescription = Route.SETTING.name)},
                                onClick = {controller.navigate(Route.SETTING.name)},
                                selected = currentDestination?.route.equals(Route.SETTING.name)
                            )
                        }*/
                    }
                    ,
                    modifier = Modifier.fillMaxSize()) {
                    it->
                    Column(modifier = Modifier.padding(it).fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {

                        Text("Main Acitivity")
                        Button(onClick = {
                            Intent(Intent.ACTION_MAIN).also{
                                it.`package`="com.google.android.youtube"
                                if(it.resolveActivity(packageManager)!=null)
                                        startActivity(it)
                            }
                            /*Intent(applicationContext,SecondActivity::class.java).also {
                                startActivity(it)
                            }*/
                        }) {
                            Text("SecondActivity")
                        }
                     /*NavHost(navController = controller, startDestination = Route.HOME.name ){
                         composable(Route.HOME.name){
                             MainView()
                         }
                         composable(Route.FAV.name){
                             FavouriteView()
                         }
                         composable(Route.SETTING.name){
                             SettingView()
                         }
                     }*/
                    }
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
@Composable
fun MainScreen(){

    val navController = rememberNavController()
    val model:ProductViewModel= viewModel()

    NavHost(navController,"ProductList") {
        composable("ProductList"){
            ProductListScreen(model,navController)
        }
        composable("ProductDetail/{id}",
            arguments = listOf(navArgument("id"){type= NavType.IntType})) {
            backStackEntry ->
            ProductDetail(
                backStackEntry.arguments?.getInt("id")!!,model
            )
        }
        }
    }
@Composable
fun MainView(){
    Column {
        Text("This is main screen")
    }
}

@Composable
fun FavouriteView(){
    Column {
        Text("This is favaourite screen")
    }
}
@Composable
fun SettingView(){
    Column {
        Text("This is setting screen")
    }
}