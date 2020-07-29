package com.example.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1, "What's this country?",
            R.drawable.de, listOf("Angola", "Greece", "Germany", "England"), 3
        )
        questionsList.add(que1)

        val que2 = Question(
            2, "What's this country?",
            R.drawable.ar, listOf("Argentina", "Portugal", "Austria", "England"), 1
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "What's this country?",
            R.drawable.ca,
            listOf("USA", "Canada", "Kongo", "Poland"),
            2
        )
        questionsList.add(que3)

        return questionsList
    }
}