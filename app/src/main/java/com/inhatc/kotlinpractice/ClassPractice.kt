package com.inhatc.kotlinpractice

// 8. Class
// 코틀린은 파일 이름과 클래스 이름이 일치하지 않아도 됨, 여러 클래스도 한 파일 안에 넣을 수 있음
// 'new' 생성자를 사용하지 않아도 됨
// 기본적으로 클래스는 final


open class Human constructor(val name : String = "Anonymous") { // 'constructor' 생략 가능, 주 생성자

//    JAVA 오버 로딩을 사용
/*
    class Person{
        public Person(String name){

        }

        public Person(String name, in age){

        }
    }
*/

    // 부 생성자는 주 생성자의 위임을 받아야 함 = this
    constructor(name : String, age : Int) : this(name){
        println("My name is ${name}, ${age}years old")
    }

    // constructor 로 선언하면 생략 가능
    // val name = name

    // init 처음 인스턴스를 생성할 때 어떤 동작을 하고 싶은지
    init {
        println("New human ha been born!")
    }

    fun eatingCake(){
        println("This is so YUMMY")
    }

    open fun singASong(){
        println("la la la")
    }
}

// 상속, 오버라이딩
// 상속은 하나만 가능
class Korean : Human(){
    override fun singASong(){
        super.singASong()
        println("랄랄라")
        println("My name is ${name}")
    }
}

fun main(){
    val human = Human("Yerin")
    human.eatingCake()

    println("this human's name is ${human.name}") // 프로퍼티 사용, Yerin

    val stranger = Human() // default 값이 있으면 빈 생성자도 생성됨
    println("this human's name is ${stranger.name}") // Anonymous

    val mom = Human("jino", 25)

    val korean = Korean()
    korean.singASong()
}

