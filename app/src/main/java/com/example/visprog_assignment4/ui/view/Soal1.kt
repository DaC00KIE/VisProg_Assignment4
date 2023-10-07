package com.example.visprog_assignment4.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_assignment4.R
import com.example.visprog_assignment4.ui.dummydata.Soal1Data
import com.example.visprog_assignment4.ui.model.ChatData
import com.example.visprog_assignment4.ui.theme.VisProg_Assignment4Theme

@Composable
fun Soal1View(chatDataList: List<ChatData>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 18.dp)
        ) {
            Text(text = "Chats",
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_more_vert_24),
                contentDescription = "more",
                tint = Color.White
            )
        }
        LazyColumn(){
            items(chatDataList){
                ChatCard(
                    it
                )
            }
        }
    }
}

@Composable
fun ChatCard(chatData: ChatData){
    val playerName: String = chatData.name
    val toastMessage: String = "$playerName Clicked"
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp, vertical = 18.dp)
            .clickable {
                Toast
                    .makeText(context, toastMessage, Toast.LENGTH_SHORT)
                    .show()
            },
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.pakevan),
            contentDescription = "profile pic",
//            tint = Color.White,
            modifier = Modifier
                .size(50.dp)
//                .background(Color.Gray, CircleShape)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = chatData.name,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = chatData.message,
                maxLines = 2,
                color = Color.LightGray,
                fontWeight = FontWeight.Normal
            )
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = chatData.date,
                color = Color.LightGray,
                fontSize = 12.sp,
                overflow = TextOverflow.Visible,
                textAlign = TextAlign.End,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun Soal1Preview() {
    VisProg_Assignment4Theme {
        Soal1View(Soal1Data().get_data_line())
    }
}