package com.example.visprog_assignment4.ui.dummydata

import com.example.visprog_assignment4.ui.model.ChatData

class Soal1Data(){
    fun get_data_line(): List<ChatData> {
        return listOf(
            ChatData("Lebron James",  "Practice starts in 10, where are you?", "4/10/2023"),
            ChatData("Kobe Bryant", "Hey, how's it going?", "3/10/2023"),
            ChatData("Michael Jordan", "I heard you had a great game last night!", "2/10/2023"),
            ChatData("Stephen Curry",  "Let's grab dinner tonight.", "1/10/2023"),
            ChatData("Kevin Durant", "Can you pass me the ball more often?", "30/9/2023"),
            ChatData("Magic Johnson", "We need to work on our defense.", "30/9/2023"),
            ChatData("Larry Bird",  "I'll be late for practice tomorrow.", "28/9/2023"),
            ChatData("Tim Duncan",  "I'm excited about the upcoming game.", "25/9/2023"),
            ChatData("Shaquille O'Neal",  "I need new sneakers.", "21/9/2023"),
            ChatData("Charles Barkley", "Let's hit the gym early.", "18/9/2023")
        )
    }
}