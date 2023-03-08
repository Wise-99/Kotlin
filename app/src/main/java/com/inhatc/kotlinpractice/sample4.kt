package com.inhatc.kotlinpractice

// 4. object
// 앱을 실행할 때 한번만 생성 됨 - SingleTon Pattern

object CarFactory {
    val cars = mutableListOf<Car>()

    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car (val horsePower : Int)

fun main(){
    val car1 = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(CarFactory.cars.size)
    println(car1) // 객체의 내용 10
    println(car2) // 객체의 내용 200
}