package com.biz.hello

fun main(){
    
    // kt에서는 자료형이 지정되지 않은 변수에 null값을 저장하면 안된다
    // 반드시 자료형을 지정하고 자료형 뒤에 ? 첨가해야 한다
    var anyVar : Int? = null
    println(anyVar)

    //
    //
    var anyVar1 : Any = 123
    anyVar1 = "Korea"
    anyVar1 = 30.2F

    // any type 저장된 값의 자료형이 무엇이냐?
    when(anyVar1){
        is String -> println("문자열형")
        is Int -> println("int 형")
        is Float -> println("float 형")
        is Double -> println("double 형")
        else -> println("모르겠는데요??")
    }
}