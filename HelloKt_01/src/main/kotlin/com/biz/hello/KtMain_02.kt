package com.biz.hello

fun main(){
    // Kotlin에서 java로 선언한 클래스 사용하기
    // var, val로 시작하고 생성자를 new 키워드 없이 사용
    // java클래스를 객체로 생성하기
    var c01 = Class_01()
    var ret = c01.sum(100,200)
    println(ret)
}