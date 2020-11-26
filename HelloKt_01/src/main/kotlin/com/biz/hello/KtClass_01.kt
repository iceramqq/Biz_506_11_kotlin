package com.biz.hello


class Standard(data : Int) {}
class Standard1 private constructor(data : Int) {}

class Empty
class Empty1 private constructor() {}

class PropertyClass(val firName : String, val lastName : String) {}

fun main(){
    // 생성자 var, val  키워드를 사용하지 않으면
    // 변수에 접근할 수 없다.
    var st = Standard(20)
    // println(st.data)

    var em = Empty()
    var pc = PropertyClass("홍","길동")
    println("${pc.firName + pc.lastName}")
}