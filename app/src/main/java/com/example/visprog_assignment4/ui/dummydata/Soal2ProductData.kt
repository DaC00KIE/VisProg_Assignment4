package com.example.visprog_assignment4.ui.dummydata

import com.example.visprog_assignment4.R
import com.example.visprog_assignment4.ui.model.ProductData

class Soal2ProductData(){
    fun get_data_tokopedia_product(): List<ProductData> {
        return listOf(
            ProductData(
                image_path = R.drawable.phone,
                product_name = "Samsung S23",
                price = 699000,
                location = "New York",
                sold = 50
            ),

            ProductData(
                image_path = R.drawable.laptop,
                product_name = "Laptop ABC",
                price = 129009,
                location = "Los Angeles",
                sold = 30
            ),
            ProductData(
                image_path = R.drawable.smartwatch,
                product_name = "Smartwatch QRS",
                price = 19009,
                location = "San Francisco",
                sold = 20
            ),
            ProductData(
                image_path = R.drawable.camera,
                product_name = "Canon EOS 718D",
                price = 5990000,
                location = "Chicago",
                sold = 10
            )
        )
    }
}