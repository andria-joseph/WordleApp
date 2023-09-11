package com.example.wordle

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : ComponentActivity() {
    //generate a random 4 letter word from FourLetterWordList
    val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_main)
            //finding the 'GUESS' button for reference
            val button = findViewById<Button>(R.id.guessButton)
            //finding the EditText widget for reference
            val input = findViewById<EditText>(R.id.userGuessEditText)

            //finding TextViews for reference
            val guess1 = findViewById<TextView>(R.id.guess1TextView)
            val check1 = findViewById<TextView>(R.id.check1TextView)
            val firstGuess = findViewById<TextView>(R.id.input1TextView)
            val firstResult = findViewById<TextView>(R.id.result1TextView)

            val guess2 = findViewById<TextView>(R.id.guess2TextView)
            val check2 = findViewById<TextView>(R.id.check2TextView)
            val secondGuess = findViewById<TextView>(R.id.input2TextView)
            val secondResult = findViewById<TextView>(R.id.result2TextView)

            val guess3 = findViewById<TextView>(R.id.guess3TextView)
            val check3 = findViewById<TextView>(R.id.check3TextView)
            val thirdGuess = findViewById<TextView>(R.id.input3TextView)
            val thirdResult = findViewById<TextView>(R.id.result3TextView)

            val hiddenWord = findViewById<TextView>(R.id.secretWord)
            val winOrLose = findViewById<TextView>(R.id.winOrLose)
            val starImage = findViewById<ImageView>(R.id.starImageView)

            var checkIfCorrect: String
            var numGuesses = 0
            //setting On Click Listener
            button.setOnClickListener {
                Log.v("User made a guess", "Button clicked!")
                val str = input.text.toString()
                if (str.all { it.isLetter() }) {

                    numGuesses++
                    if (numGuesses == 1) {
                        firstGuess.text = input.text.toString().uppercase()
                        guess1.visibility = View.VISIBLE
                        firstGuess.visibility = View.VISIBLE
                        check1.visibility = View.VISIBLE
                        checkIfCorrect = checkGuess(firstGuess.text.toString().uppercase())
                        firstResult.text = checkIfCorrect
                        firstResult.visibility = View.VISIBLE
                        input.text.clear()
                        if (firstGuess.text == wordToGuess) {
                            hiddenWord.text = wordToGuess
                            hiddenWord.visibility = View.VISIBLE
                            starImage.visibility = View.VISIBLE
                            winOrLose.text = getString(R.string.winner)
                            winOrLose.visibility = View.VISIBLE
                            button.text = getString(R.string.reset)
                            button.setOnClickListener {
                                val intent = intent
                                finish()
                                startActivity(intent)
                            }
                        }


                    }
                    else if (numGuesses == 2) {
                        secondGuess.text = input.text.toString().uppercase()
                        guess2.visibility = View.VISIBLE
                        secondGuess.visibility = View.VISIBLE
                        check2.visibility = View.VISIBLE
                        checkIfCorrect = checkGuess(secondGuess.text.toString().uppercase())
                        secondResult.text = checkIfCorrect
                        secondResult.visibility = View.VISIBLE
                        input.text.clear()
                        if (secondGuess.text == wordToGuess) {
                            hiddenWord.text = wordToGuess
                            hiddenWord.visibility = View.VISIBLE
                            starImage.visibility = View.VISIBLE
                            winOrLose.text = getString(R.string.winner)
                            winOrLose.visibility = View.VISIBLE
                            button.text = getString(R.string.reset)
                            button.setOnClickListener {
                                val intent = intent
                                finish()
                                startActivity(intent)
                            }
                        }
                    }
                    else if (numGuesses == 3) {
                        thirdGuess.text = input.text.toString().uppercase()
                        guess3.visibility = View.VISIBLE
                        thirdGuess.visibility = View.VISIBLE
                        check3.visibility = View.VISIBLE
                        checkIfCorrect = checkGuess(thirdGuess.text.toString().uppercase())
                        thirdResult.text = checkIfCorrect
                        thirdResult.visibility = View.VISIBLE
                        input.text.clear()
                        if (thirdGuess.text == wordToGuess) {
                            hiddenWord.text = wordToGuess
                            hiddenWord.visibility = View.VISIBLE
                            starImage.visibility = View.VISIBLE
                            winOrLose.text = getString(R.string.winner)
                            winOrLose.visibility = View.VISIBLE
                            button.text = getString(R.string.reset)
                            button.setOnClickListener {
                                val intent = intent
                                finish()
                                startActivity(intent)
                            }
                        }
                        else {
                            hiddenWord.text = wordToGuess
                            hiddenWord.visibility = View.VISIBLE
                            winOrLose.text = getString(R.string.loser)
                            winOrLose.visibility = View.VISIBLE
                            button.text = getString(R.string.reset)
                            button.setOnClickListener {
                                val intent = intent
                                finish()
                                startActivity(intent)
                            }
                        }
                    }
                }
                else {
                    Toast.makeText(this, "Please enter a FOUR LETTER WORD!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"

            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }


}

