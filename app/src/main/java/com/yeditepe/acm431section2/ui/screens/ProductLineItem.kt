package com.yeditepe.acm431section2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yeditepe.acm431section2.ui.theme.Acm431Section2Theme
import com.yeditepe.acm431section2.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yeditepe.acm431section2.ui.viewmodels.ProductViewModel

val data = mutableListOf<Product>()
public data class Product(
    val id: Int,
    val imageRes: Int,
    val productName: String,
    val productPrice: String
)
@Composable
fun ProductLineItem(
   product: Product,
   controller: NavHostController
) {
    Row(
        modifier = Modifier.clickable {controller.navigate("ProductDetail/${product.id}") }
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .padding(end = 8.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = product.productName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = product.productPrice,
                fontSize = 16.sp,
                color = androidx.compose.ui.graphics.Color.Gray
            )
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun ProductLineScreenPreview(){

    val model :ProductViewModel = viewModel()
    val controller = rememberNavController()
    Acm431Section2Theme {
        Surface(

        ) {
            ProductListScreen(model,controller)
        }
    }
}

@Composable
fun ProductDetail(
    productID: Int,
    model: ProductViewModel
) {
    val product = model.getProductById(productID)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (product != null) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 16.dp)
            )
        }

        if (product != null) {
            Text(
                text = product.productName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        if (product != null) {
            Text(
                text = product.productPrice,
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
            )
        }


    }
}

@Composable
fun ProductListScreen(model:ProductViewModel,controller: NavHostController){
    val productList = model.allProduct.collectAsState()
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        items(productList.value){
            item->
            ProductLineItem(item,controller)
        }
    }
}