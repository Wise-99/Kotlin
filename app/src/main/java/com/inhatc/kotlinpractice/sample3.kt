package com.inhatc.kotlinpractice

// 3. Companion object
// 정적 변수나 정적 메소드를 선언할 때 자바의 static 대신 사용 됨

// private constructor - 다른 곳에서는 객체를 생성할 수 없음
// interface를 통해 상속 가능
class Book private constructor(val id : Int, val name : String){

    // private 프로퍼티나 메소드를 읽어올 수 있게 함
    companion object BookFactory : IdProvider {

        override fun getId(): Int {
            return 444
        }

        val myBook = "new book"
        fun create() = Book(getId(), myBook)

    }

}

interface IdProvider {
    fun getId() : Int
}

fun main(){
    // val book = Book.Companion.create()
    val book = Book.create()

    val bookId = Book.BookFactory.getId()
    println("${book.id} ${book.name}")
}

