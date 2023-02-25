package com.inhatc.kotlinpractice

fun main(){

    // 3. String Template

    val name = "Yerin"
    val lastName = "Kim"

    println("My name is ${name + lastName} I'm 25")
    println("is this true? ${1==0}")
    println("this is 2\$a")

    // 부분 주석 commend + /

    checkNum(1)
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

// 4. 조건식
fun maxBy(a : Int, b : Int) : Int {
    if(a > b)
        return a
    else
        return b
}

// 코틀린은 삼항 연산자가 없음
// Expression
fun maxBy2(a : Int, b : Int) = if(a>b) a else b

fun checkNum(score : Int) : Unit{
    // switch 랑 비슷
    // Statement
    when(score){
        0 -> println("this is 0")
        1 ->println("this is 1")
        2,3 ->println("this is 2 or 3")
        /* 생략 가능
        else -> println("I don't know") */
    }

    // Expression
    var b = when(score){
        1-> 1
        2-> 2
        else -> 3 // else 생략 불가능
    }
    println("b : ${b}")

    when(score){
        in 90..100 -> println("You are genius")
        in 10 .. 80 -> println("not bad")
        else -> println("okay") // else 생략 가능
    }
}

/*
Expression VS Statement
    Expression - 값을 반환하는 것
    Statement - 실행을 하도록 명령을 하는 것
    코틀린의 모든 함수는 Expression 리턴 값이 없어도 Unit을 반환
    자바의 void 함수는 Statement

    if문
    자바 - Statement
    코틀린 - Expression 로도 사용 가능
*/

/* 5. Array and List
    Array = 메모리가 할당되어 나옴(처음에 크기 지정 필수)
    List
        1. List - 수정이 불가능, 읽기 전용
        2. MutableList - 수정이 가능, 읽기, 수정 가능
*/

fun array(){
    val array = arrayOf(1,2,3) // 초기화
    val list = listOf(1,2,3)

    val array2 = arrayOf(1, "d", 3.4f)
    val list2 = listOf(1, "d", 11L)

    array[0] = 3
    // list[0] = 2 - 불가능, 읽기 전용
    var result = list.get(0)

    // MutableList 의 대표 ArrayList
    // 주소 값이 바뀌지 않아 val로 선언 가능
    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)

    // arrayList = arrayListOf() - val로 선언되어 불가능
    var arrayList2 = arrayListOf(1,2,3) // var는 가능
}

// 6. for / while
fun forAndWhile(){
    val students = arrayListOf("joyce", "james", "jenny", "jennifer")
    for (name in students){
        println("${name}")
    }

    // index를 포함하여 출력할 때
    for((index, name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")

    }
    var sum : Int = 0
    for(i in 1..10 step 2){
        sum += i
    }
    println(sum) // 25

    sum = 0
    for(i in 10 downTo 1){ // 10, 9, 8...2, 1
        sum += i
    }

    sum = 0
    for(i in 1 until 100) { // 1~99, 100이 포함되지 않음
        sum += i
    }

    var index = 0
    while(index < 10){
        println("current index : ${index}")
        index++
    }
}

// 7. Nullable / NonNull

fun nullCheck(){
    // 자바 NPE : Null Pointer Exception
    // 자바는 컴파일 시점이 아닌 런타임 시점에서만 나타남(실행 시켜야만 나타남)
    // 코틀린은 컴파일 시점에서도 null 관련 오류를 알 수 있음

    var name : String = "yerin"

    // null을 넣고 싶을 때는 타입 뒤에 ? 를 붙임
    // 그래서 타입 생략을 해서는 안됨
    var nullName : String? = null

    var nameInUpperCase = name.uppercase()

    var nullNameInUpperCase = nullName?.uppercase() // nullName이 null이 아니면 실행, 아니면 null을 반환


    // ?: 엘비스 연산자
    val lastName : String? = null
    val fullName = name + " " +(lastName?: "No lastName")

    println(fullName) // yerin No lastName

    // !!
}

// !!
fun ignoreNulls(str : String?){
    val mNotNull : String = str!! // null이 들어올 경우가 없다는 확신?을 나타냄
    val upper = mNotNull.uppercase() // 변수명 뒤에 ? 를 붙이지 않아도 uppercase 등 메소드 사용 가능

    // let 함수를 이용해서 NonNull일 경우에 특정 구문을 이용하는 방법
    // let은 자신의 리시버 객체(email)를 람다식 내부로 옮겨 실행하는 구문
    val email : String? = "yerenkim@gmail.com"
    email?.let{
        println("My email is ${email}") // email 대신 it 사용 가능, null 이면 println은 동작하지 않음
    }
}