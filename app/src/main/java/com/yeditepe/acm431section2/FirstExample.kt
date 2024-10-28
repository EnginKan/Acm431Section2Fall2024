package com.yeditepe.acm431section2

fun main(){

    val myList = listOf(20,30,40,"ACM431")
    val myList2 = mutableListOf<String>("ACM321","ACM431","ACM222")
    val myArray = arrayOf("ACM321", 12, true)
    var code : Int = 321
    code = 40

    myList2.add("COMP301")
    val course: String = myList2.get(2)
    println(myList[0])
    println(myArray[2])
    //When-Expression
    var whichClass : String =when{
          course.substring(3).startsWith("4") -> "SeniorYear"
          course.substring(3).startsWith("3") -> "ThirdYear"
          course.substring(3).startsWith("2") -> "SecondYear"
          else-> "NotKnown"
            }

    println("You are in class ${whichClass.uppercase()}")


    var content: String? ="Message"
    var result = content?.uppercase()?:"There is an exception"

    var number : Int? = null
    number = number?.dec()?: 0

    println(number)

    println("$result")
    content = "bla bla bla"

    println(sum(3,4))
    substruction(10,2)
    println(power(2,3))
    println(sum(argument2 = 4, argument1 = 1))
    println(power(3))



}
//a function with named arguments where arguments are argument1 and argument2
fun sum(argument1: Int, argument2: Int): Int{
    return argument1+argument2
}

fun substruction(argument1: Int,argument2: Int): Unit{

    println("${argument1-argument2}")
}
//This function includes both named(base) and default arguments(pow)
fun power(base: Int, pow: Int = 2): Int{
    var result =1

    repeat(pow){
        result*=base
    }
    return result
}

fun addition(a: Int, b: Int): Int= a+b