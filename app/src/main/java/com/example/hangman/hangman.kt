package com.example.hangman

import kotlin.random.Random

val words= listOf("apple","ball","cat","dog","egg","fool","gun","hen","italy","jack")
var word=""
val guess= arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main(){
    setUpGame()
}

fun setUpGame(){
   val wordIndex= Random.nextInt(words.size)
    word =words[wordIndex]
    println(word)
    for(i in word.indices){
        guess.add('_')
    }

    var gameOver=false
    do{
        printGameStatus()
        println("Please enter a letter")
        var input= readLine()?:""

        if(input.isEmpty()){
            println("That's not a valid input. Please try again")
        }else{
            val letter:Char=input[0]
            if(word.contains(letter)){
                for(i in word.indices){
                    if(word[i]==letter)
                        guess[i]=letter
                }
                if(!guess.contains('_'))
                    gameOver=true
            }else{
                println("Sorry, that's not part of the word")
                remainingGuesses--
                mistakes++
                if(mistakes==6)
                    gameOver=true
            }
        }
    }while(!gameOver)

    if(mistakes==6){
        printGameStatus()
        println("Sorry, you lost. The word was\n$word")
    }else{
        println("\nCongratulations, you won!")
        println("The word was \n$word")
    }
}

fun printGameStatus(){
    when(mistakes){
        0-> print0Mistakes()
        1-> print1Mistakes()
        2-> print2Mistakes()
        3-> print3Mistakes()
        4-> print4Mistakes()
        5-> print5Mistakes()
        6-> print6Mistakes()
    }

    print("Word: ")
    for(element in guess)
        print("$element ")
    println("\nYou have $remainingGuesses guess(es) left")
}

fun print0Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print1Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print2Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print3Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print4Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print5Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     /  ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print6Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     / \\")
    println(" /|\\      ")
    println("/ | \\     ")
}