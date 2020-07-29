package com.example.quizapp

data class Question (
    val id: Int,
    val question: String,
    val image: Int,
    val options: List<String>,
    val correctOption: Int
)