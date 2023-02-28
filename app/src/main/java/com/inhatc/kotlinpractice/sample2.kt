package com.inhatc.kotlinpractice

// 1. lambda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명 함수
// 1) 메소드의 파라미터로 넘겨 줄 수가 있다. fun maxBy(a : Int)
// 2) return 값으로 사용할 수가 있다.

// 람다의 기본 정의
// val lambdaName : Type = {argumentList -> codeBody}

// Int 를 넣어 Int 를 반환, 타입 추론이 가능
val square : (Int) -> (Int) = {number -> number*number}
// val square = {number : Int -> number*number}

val nameAge = {name : String, age : Int ->
    "My name is ${name} I'm ${age}"
}

fun main(){
    println(square(12))
    println(nameAge("Yerin", 25))

    val a = "yerin said "
    val b = "mac said "
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(extendString("Yerin", 25))

    println(calculateGrade(97))
    println(calculateGrade(971))


    val lambda = {number : Double ->
        number == 4.3213
    }
    println(invokeLambda(lambda))

    // 람다 리터럴 - 중괄호 바로 삽입
    println(invokeLambda({true}))
    println(invokeLambda({it > 3.22}))

    // fun의 마지막 파라미터가 람다식일 경우 소괄호 생략 가능
    println(invokeLambda { it > 3.22 })

    // 1-5. 익명 내부 함수
    // 1. Kotlin Interface 가 아닌 Java Interface 이어야 함
    // 2. 그 Interface 는 단 하나의 메소드만 가져아 함

}

// 1-2. 확장 함수
// 클래스를 확장 - 있는 클래스에 추가하기 위해 사용
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

// this - 확장 함수를 call 하는 object
// it - 들어가는 파라미터가 1개일 경우에 it 으로 생략 가능
fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = {
        "I am ${this} and ${it} years old"
    }
    return name.introduceMyself(age)
}

// 1-3. 람다의 리턴
// 람다는 리턴을 할 때, 마지막 표현식이 리턴의 벨류 타입을 지정함
// input 파라미터는 여러 개일 수 있기 때문에 소괄호를 써줘야 함 - (Int)
// return 값은 타입이 하나라서 소괄호를 써주지 않아도 됨
val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 1-4. 람다를 표현하는 여러가지 방법
// input, output 타입을 알려줘야 함

fun invokeLambda(lambda : (Double) -> Boolean) : Boolean {
    return lambda(5.2343)
}