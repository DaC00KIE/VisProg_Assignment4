package com.example.visprog_assignment4.ui.dummydata

import com.example.visprog_assignment4.R
import com.example.visprog_assignment4.ui.model.CategoryData

class Soal2CatData(){
    fun get_data_tokopedia_category(): List<CategoryData> {
        return listOf(
            CategoryData(image_path = R.drawable.car, category_name = "Cars", number_of_items = 100),
            CategoryData(image_path = R.drawable.gadget, category_name = "Gadgets", number_of_items = 50),
            CategoryData(image_path = R.drawable.electronics, category_name = "Electronics", number_of_items = 75),
            CategoryData(image_path = R.drawable.clothing, category_name = "Clothing", number_of_items = 200),
            CategoryData(image_path = R.drawable.furniture, category_name = "Furniture", number_of_items = 120),
            CategoryData(image_path = R.drawable.books, category_name = "Books", number_of_items = 300),
            CategoryData(image_path = R.drawable.sports, category_name = "Sports", number_of_items = 80),
            CategoryData(image_path = R.drawable.beauty, category_name = "Beauty", number_of_items = 150),
        )
    }
}