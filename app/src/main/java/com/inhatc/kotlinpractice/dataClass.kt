package com.inhatc.kotlinpractice

// 2. Data 클래스
// pojo - 모델이 되는 클래스

data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// toString(), hashCode(), equlas(), copy() 가 자동으로 만들어짐

class TicketNomal(val companyName : String, val name : String, var date : String, var seatNumber : Int)

fun main(){
    val ticketA = Ticket("koreanAir", "yerin", "2023-02-08", 20)
    val ticketB = TicketNomal("koreanAir", "yerin", "2023-02-08", 20)

    println(ticketA) // 객체의 내용이 나옴
    println(ticketB) // 메모리 주소 값이 나옴
}