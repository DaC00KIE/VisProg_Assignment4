package com.example.visprog_assignment4.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visprog_assignment4.R
import com.example.visprog_assignment4.ui.dummydata.IGDataSource
import com.example.visprog_assignment4.ui.model.Explore
import com.example.visprog_assignment4.ui.theme.VisProg_Assignment4Theme

val IGcolor = Color(0xFF1B1A1F)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Soal4View(){
    val exploreList: List<Explore> = IGDataSource().loadExplore()
    val context = LocalContext.current

    Scaffold (
        bottomBar = { BottomBarThing() }
    ){
        LazyVerticalGrid(columns = GridCells.Fixed(3)){
            item(span = {
                GridItemSpan(3)
            }) {
                SearchBarThing()
            }
            items(convertStringResourceNamesToIds(context, exploreList)){
                Image(
                    painter = painterResource(id = it),
                    contentDescription = "The Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .aspectRatio(1f))
            }
        }
    }
}

@Composable
fun BottomBarThing(){
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .background(IGcolor)
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.home),
            contentDescription = "home button",
            tint = Color.LightGray,
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Home", Toast.LENGTH_SHORT)
                        .show()
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "search button",
            tint = Color.LightGray,
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Explore", Toast.LENGTH_SHORT)
                        .show()
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.post),
            contentDescription = "post button",
            tint = Color.LightGray,
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Upload", Toast.LENGTH_SHORT)
                        .show()
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.reels),
            contentDescription = "reels button",
            tint = Color.LightGray,
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Reels", Toast.LENGTH_SHORT)
                        .show()
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_person_2_24),
            contentDescription = "pfp button",
            tint = Color.LightGray,
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Profile", Toast.LENGTH_SHORT)
                        .show()
                }
        )
    }
}

@Composable
fun SearchBarThing(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(IGcolor)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.98f)
                .fillMaxHeight(0.8f)
                .background(IGcolor, RoundedCornerShape(40))
                .border(1.dp, Color.Gray, RoundedCornerShape(45)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "search button",
                tint = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Text(text = "Search", color = Color.Gray)
        }
    }
}

@SuppressLint("DiscouragedApi")
fun convertStringResourceNamesToIds(context: Context, resource: List<Explore>): List<Int> {
    val resourceIds = mutableListOf<Int>()

    for (resourceName in resource) {
        val resourceId = context.resources.getIdentifier(resourceName.imageName, "drawable", context.packageName)
        if (resourceId != 0) {
            resourceIds.add(resourceId)
        }
    }

    return resourceIds
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Soal4Preview(){
    VisProg_Assignment4Theme {
        Soal4View()
    }
}