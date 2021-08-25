package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    companion object {
        const val MAX_NO_OF_WORDS = 10
        private const val SCORE_INCREASE = 20
    }

    var currentWordCount = 0
        private set
    var score = 0
        private set
    lateinit var currentScrambledWord: String
        private set

    private var wordsList = mutableListOf<String>()
    private lateinit var currentWord: String

    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    private fun increaseScore() {
        score += SCORE_INCREASE
    }

    private fun getNextWord() {
        currentWord = AllWordsList.data.random()
        val tempWord = getTempWord()
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            currentScrambledWord = String(tempWord)
            Log.d("GameFragment", "Current word: $currentWord")
            ++currentWordCount
            wordsList.add(currentWord)
        }
    }

    private fun getTempWord(): CharArray {
        val tempWord = currentWord.toCharArray()
        do {
            tempWord.shuffle()
        } while (tempWord.toString().equals(currentWord, false))
        return tempWord
    }

    fun isUserWordCorrect(playerWord: String) = if (playerWord.equals(currentWord, true)) {
        increaseScore()
        true
    } else false

    /*Returns true if the current word count is less than MAX_NO_OF_WORDS.
    * Updates the next word.*/
    fun nextWord() = if (currentWordCount < MAX_NO_OF_WORDS) {
        getNextWord()
        true
    } else false

    fun reinitializeData() {
        score = 0
        currentWordCount = 0
        wordsList.clear()
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }
}