package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    companion object {
        const val MAX_NO_OF_WORDS = 10
        private const val SCORE_INCREASE = 20
    }

    private val _currentScrambleWord = MutableLiveData<String>()
    val currentScrambledWord: LiveData<String> get() = _currentScrambleWord

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> get() = _score

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int> get() = _currentWordCount

    private var wordsList = mutableListOf<String>()
    private lateinit var currentWord: String

    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    private fun increaseScore() {
        _score.value = _score.value?.plus(SCORE_INCREASE)
    }

    private fun getNextWord() {
        currentWord = AllWordsList.data.random()
        val tempWord = getTempWord()
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambleWord.value = String(tempWord)
            Log.d("GameFragment", "Current word: $currentWord")
            _currentWordCount.value = _currentWordCount.value?.inc()
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
    fun nextWord() = if (_currentWordCount.value!! < MAX_NO_OF_WORDS) {
        getNextWord()
        true
    } else false

    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }
}