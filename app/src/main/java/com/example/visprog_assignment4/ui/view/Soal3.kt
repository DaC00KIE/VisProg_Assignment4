package com.example.visprog_assignment4.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_assignment4.R
import com.example.visprog_assignment4.ui.dummydata.IGDataSource
import com.example.visprog_assignment4.ui.model.Feed
import com.example.visprog_assignment4.ui.model.Story
import com.example.visprog_assignment4.ui.theme.VisProg_Assignment4Theme
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

val MainColor = Color(0xFF1B1A1F)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun formatDate(inputDate: String): String {
    // Define a DateTimeFormatter for parsing the input date
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val parsedDate = LocalDate.parse(inputDate, inputFormatter)

    // Define a DateTimeFormatter for formatting the output date

    val outputFormatter =    when(parsedDate.year){
        2023 -> DateTimeFormatter.ofPattern("MMMM dd")
        else -> DateTimeFormatter.ofPattern("MMMM dd, yyyy")
    }


    // Format the date and display it
    return parsedDate.format(outputFormatter)
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Soal3View(){
    val context = LocalContext.current

    Scaffold(
        bottomBar = { BottomBarThing() },
        modifier = Modifier.background(MainColor)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(MainColor)
        ){
            items(1){
                IGHeader()
            }
            item{
                LazyRow(
                    modifier = Modifier.background(MainColor)
                ){
                    items(IGDataSource().loadStory()){
                        StoryPeoples(it, context)
                    }
                }
            }
            item { PostForIG(context) }
        }
    }
}

@Composable
fun IGHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(MainColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_dropdown),
            contentDescription = "Logo",
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier.padding(start = 12.dp)
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(end = 12.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.like),
                contentDescription = "Like",
                tint = Color.LightGray)
            Icon(
                painter = painterResource(id = R.drawable.dm),
                contentDescription = "DM",
                tint = Color.LightGray)
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun StoryPeoples(story: Story, context: Context){
    val username: String = story.name
    val toastMessage: String = "$username story"

    // Use Resources.getIdentifier to get the resource ID
    val resourceId = context.resources.getIdentifier(story.profilePic, "drawable", context.packageName)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                Toast
                    .makeText(context, toastMessage, Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        Box(modifier = Modifier
            .size(100.dp)
        ){
            Image(
                painter = painterResource(id = resourceId),
                contentDescription = "User profile pic",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(80.dp)
                    .clip(CircleShape))
            Image(
                painter = painterResource(id = R.drawable.story),
                contentDescription = "Story Border",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(90.dp)
            )
        }
        Text(
            text = story.name,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("DiscouragedApi")
@Composable
fun PostForIG(context: Context){
    val feedList: List<Feed> = IGDataSource().loadFeed()
    val feed = feedList[0]

    val profilePic: String = feed.profilePic
    val username: String = feed.name
    val postPic: String = feed.post
    val caption: String = feed.caption
    val likes = NumberFormat.getNumberInstance(Locale.US).format(feed.likes)
    val date: String = formatDate(inputDate = feed.date)

    // Use Resources.getIdentifier to get the resource ID
    val profileID = context.resources.getIdentifier(profilePic, "drawable", context.packageName)
    // Use Resources.getIdentifier to get the resource ID
    val postID = context.resources.getIdentifier(postPic, "drawable", context.packageName)


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.padding(start = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = profileID),
                    contentDescription = "User profile pic",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
//                        .padding(horizontal = 10.dp)
                        )
                Text(text = username, color = Color.White, fontSize = 12.sp)
            }
            Icon(
                painter = painterResource(id = R.drawable.baseline_more_vert_24),
                contentDescription = "more",
                tint = Color.White,
                modifier = Modifier.padding(end = 12.dp)
            )
        }
        Image(
            painter = painterResource(id = postID),
            contentDescription = "Post Image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = "like button",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .clickable {
                            Toast
                                .makeText(context, "Liked $username's post", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
                Icon(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "comment button",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .clickable {
                            Toast
                                .makeText(context, "Comment button", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
                Icon(
                    painter = painterResource(id = R.drawable.messanger),
                    contentDescription = "send button",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .clickable {
                            Toast
                                .makeText(context, "Send this post", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.save),
                contentDescription = "save button",
                tint = Color.LightGray,
                modifier = Modifier
                    .clickable {
                        Toast
                            .makeText(context, "Saved", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = "$likes likes", color = Color.White, fontSize = 12.sp)
            val annotatedCaption = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)){
                    append(username)
                }
                append(" ")
                append(caption)
            }
            Text(
                text = annotatedCaption,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 16.sp,
                maxLines = when(feed.captionClicked){
                    false -> 2
                    true -> Int.MAX_VALUE
                },
                fontSize = 12.sp
            )
            Text(
                text = date,
                color = Color.Gray,
                fontSize = 10.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Soal3Preview(){
    VisProg_Assignment4Theme {
        Soal3View()
    }
}