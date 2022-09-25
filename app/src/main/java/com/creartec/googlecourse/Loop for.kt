package com.creartec.googlecourse

fun main(){
    val names= listOf("gisvelita","jhordan","randall","marco")
    for (name in names){
        print(name+"----")
        println("tiene ${name.length} letras")
    }
    for (item in 1..10){
        print("$item,")
    }
    println()
    for (letter in 'a'..'z'){
        print(letter + ",")
    }
    println()
    for (item in 10 downTo 1){
        print("$item,")
    }
    println()
    for (item in 10 downTo 0 step 2){
        print("$item,")
    }


}