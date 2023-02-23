package com.inhatc.kotlinpractice

fun main(){

    // 3. String Template

    val name = "Yerin"
    val lastName = "Kim"

    println("My name is ${name + lastName} I'm 25")
    println("is this true? ${1==0}")
    println("this is 2\$a")

    // 부분 주석 commend + /
}

// 1. 함수
// return 이 없을 때 Unit = Redundant 'Unit' return type

fun helloWorld() {
    println("Hello World!")
}

// return 타입이 있을 때는 지정 필요
fun add(a : Int, b : Int) : Int {
    return a+b
}

// 2. val VS var
// val = value 값 변경 불가
// var = variable 값 변경 가능

fun hi(){
    val a : Int = 10
    var b : Int = 9

    b = 100

    // 자동 추론 - 변수 타입 생갹 가능
    val c = 100
    var d = 100
    var name = "Yerin"

    // 값을 바로 할당하지 않을 경우는 타입 지정 필수
    var e : String
}