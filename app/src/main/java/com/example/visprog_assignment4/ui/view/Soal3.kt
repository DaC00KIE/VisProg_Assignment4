package com.example.visprog_assignment4.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.visprog_assignment4.ui.theme.VisProg_Assignment4Theme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun formatDate(inputDate: String): String {
    // Define a DateTimeFormatter for parsing the input date
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val parsedDate = LocalDate.parse(inputDate, inputFormatter)

    // Define a DateTimeFormatter for formatting the output date
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")

    // Format the date and display it
    return parsedDate.format(outputFormatter)
}

@Composable
fun Soal3View(){

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Soal3Preview(){
    VisProg_Assignment4Theme {
        Soal3View()
    }
}