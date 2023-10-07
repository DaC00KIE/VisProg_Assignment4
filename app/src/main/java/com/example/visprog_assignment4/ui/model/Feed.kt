package com.example.visprog_assignment4.ui.model

data class Feed(
    val name: String, val profilePic: String, val post: String,
    val boolean1: Boolean, val boolean2: Boolean,
    val followers: Int, val caption: String, val date:String
)

//Feed("john_doe", "profile_1", "content_1", true, false, 50, "Caption 1. This is a long and detailed caption that spans multiple paragraphs. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac libero at purus scelerisque ultrices. Integer malesuada a justo eu facilisis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam vel nunc nec metus interdum efficitur. Nulla facilisi. Nulla rhoncus est et neque facilisis, vel venenatis quam blandit. Sed viverra justo at mi vestibulum eleifend. Vestibulum ut felis ut tortor tincidunt vehicula at id lacus. Donec feugiat dolor in metus congue, id vestibulum nulla posuere. Fusce a quam purus. Vivamus egestas et nisi in bibendum. Praesent id hendrerit ex. Nullam vel tortor nec neque pharetra congue.", "2023-10-01"),