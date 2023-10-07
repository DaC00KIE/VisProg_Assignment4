package com.example.visprog_assignment4.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_assignment4.R
import com.example.visprog_assignment4.ui.dummydata.Soal2CatData
import com.example.visprog_assignment4.ui.dummydata.Soal2ProductData
import com.example.visprog_assignment4.ui.model.CategoryData
import com.example.visprog_assignment4.ui.model.ProductData
import com.example.visprog_assignment4.ui.theme.VisProg_Assignment4Theme

@Composable
fun Soal2View(){
    val categoryData: List<CategoryData> =  Soal2CatData().get_data_tokopedia_category()
    val productData: List<ProductData> = Soal2ProductData().get_data_tokopedia_product()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column ( //Header
            Modifier
                .fillMaxWidth(0.85f)
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "Tokopedia",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_more_vert_24),
                    contentDescription = "more",
                    tint = Color.Black
                )
            }
            Image(
                painter = painterResource(id = R.drawable.discountbanner),
                contentDescription = "Discount Banner",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth(1f))
        }
        
        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            Text(text = "Categories",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(categoryData){
                    CategoryCard(
                        it
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Products",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(productData){
                    ProductsCard(it)
                }
            }
        }
    }
}

@Composable
fun CategoryCard(category: CategoryData){
    val imageID: Int = category.image_path
    val categoryName: String = category.category_name
    val amountOfProducts: Int = category.number_of_items

    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .width(100.dp),
    ){
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                    space = 6.dp,
                    alignment = Alignment.CenterVertically
            )
        ) {
            Image(
                painter = painterResource(id = imageID),
                contentDescription = "Desc Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(75.dp)
                    .padding(top = 12.5.dp)
            )
            Text(
                text = categoryName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$amountOfProducts Products",
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
    }
}

@Composable
fun ProductsCard(product: ProductData){
    val imageID: Int = product.image_path
    val productName: String = product.product_name
    val price: Int = product.price
    val location: String = product.location
    val sold: Int = product.sold

    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .fillMaxWidth(0.45f),
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
        ) {
            Image(
                painter = painterResource(id = imageID),
                contentDescription = "Desc Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f)
                    .padding(top = 12.5.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = productName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Rp. $price",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                )
                Text(
                    text = "Kota $location",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                )
                Text(
                    text = "$sold Sold",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal2Preview(){
    VisProg_Assignment4Theme {
        Soal2View()
    }
}