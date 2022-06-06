package com.example.helloworld

import android.view.Display

/*      KOTLIN BASICS
    In order to develop android apps, I have decided to watch a youtube tutorial that explains all of the Kotlin basics.
    I can find this amazing tutorial at the following URL: https://www.youtube.com/watch?v=uRyvNKRkwbs
    I hope to create several apps using the information I learn here, and I will keep this page as a reference page.
    This will be a quick and useful guide to Kotlin 101.
*/

fun main(){

    // Variable
    var myMood = "happy"

    // Immutable Variable
    val myName = "Jon"
    val myAge = 28

    // String Concatenation (Can use "word" + var too, but this method is preferred.)
    print("Hello, my name is $myName. Today, I am feeling $myMood.")

    // -------------- Variable Types --------------
    // Kotlin uses type inference, which means a variables type is determined by context.
    // However, type can be specified, as shown in the examples below.

    // Integer TYPES: Byte (8 bit), Short (16 bit), Int (32 bit), Long (64 bit)
    val myByte: Byte = 13
    val myShort: Short = 420
    val myInt: Int = 123123123
    val myLong: Long = 107_000_000_000_000_000 // underscore does not affect value, only for readability.

    // Floating Point Number TYPES: Float (32 bit), Double (64 bit)
    val myFloat: Float = 12.34F
    val myDouble: Double = 3.14159265358979323846

    // Boolean Logical (true or false)
    var isProgramWorking: Boolean = true

    // Characters
    val firstLetter: Char = 'a'
    val firstNumber: Char = '1'
    val randomChar : Char = '$'

    // Strings and Basic String Operations
    val myStr: String = "Hello World!"

    var firstCharInStr = myStr[0]
    var lastCharInStr = myStr[myStr.length - 1]

    print("\n$myStr")
    print("\nFirst and last characters in my string: $firstCharInStr and $lastCharInStr \n")

    // -------------- Arithmetic Operators --------------
    // Kotlin makes use of the following operators: +, -, *, /, %.

    // Basic Arithmetic Operator Examples
    val addition       = 5 + 3 // addition will be set to 8
    val subtraction    = 5 - 3 // subtraction will be set to 2
    val multiplication = 5 * 3 // multiplication will be set to 15
    val division       = 5 / 3 // division will be set to 1, because we are dividing Int
    val modulo         = 5 % 3 // modulo will be set to 2, because 5 / 3 has a reminder of 2

    var testValue      = 10
    testValue          /= 2 // testValue will be set to 5, because 10 / 2 is 5
    testValue          += 5 // testValue will be set to 10, because 5 + 5 is 10
    // This can be done with +=, -=, *=, /=

    // Watch out for type mismatch, typecast as needed.
    val firstMismatch    = 5.0
    val secondMismatch   = 3
    var testTypeMismatch = (firstMismatch / secondMismatch).toFloat() // need to typecast to see decimals

    println(testTypeMismatch)

    // -------------- Comparison Operators --------------
    // Kotlin makes use of the following operators: ==, !=, <, >, <=, >=.

    val isEqual    = 5==3  // Boolean with value of false
    val isNotEqual = 5!=3  // Boolean with value of true

    // Kotlin can run calculations in curly braces and print directly.
    println("is5GreaterThan3 is equal to ${5 > 3}")

    // -------------- Assignment Operators --------------
    // Kotlin makes use of the following operators: +=, -=, *=, /=, %=
    var myCount = 3
    myCount     += 3  // The value is now 6 because we have incremented by 3

    // Increment and Decrement Operators (++ and --) can also be used.
    myCount++  // Now, the value is 7 because we incremented by 1.

    // Increment and Decrement Operators can be placed before or after the value.
    // If placed before, it will be changed on that line of code be evaluating.
    // If placed after, it will be changed after evaluating.

    println("myCount is  $myCount")      // The value printed is 7
    println("myCount is  ${myCount++}")  // The value printed is 7, then it is incremented to 8
    println("myCount is  ${++myCount}")  // The value printed is 9, because the value was incremented before the value was evaluated.

    // -------------- Conditional Statements --------------
    // Kotlin takes advantage of several different conditional statements to determine program flow.

    // If...Else Statements
    var heightPerson1 = 170
    var heightPerson2 = 189

    if(heightPerson1 > heightPerson2) {
        println("Person 1 should use raw force to beat his opponent.")
    }else if(heightPerson1 == heightPerson2){
        println("Person 1 should use a special height move to beat his opponent.")
    }else {
        println("Person 1 should use technique to beat his opponent.")
    }

    // When Statements -- Kotlin's version of a Switch Statement.
    var currentSeason = 3
    when (currentSeason){
        1 -> println("It is Spring.")
        2 -> println("It is Summer.")
        3 -> println("It is Fall.")
        4 -> println("It is Winter.")
        5 -> {
            println("It is Spring again!")
            println("A whole year has passed.")
        }
        else -> println("You've seen many seasons.")
    }

    // When Statements need the keyword "in" when defining a range
    var month = 1
    when(month){
        in 1..3 -> println("This month is during Spring.")
        in 4..6 -> println("This month is during Summer.")
        in 7..9 -> println("This month is during Fall.")
        in 10..12 -> println("This month is during Winter.")
        in 24 downTo 13 -> println("A whole year has passed.")
        88, 39, 46 -> println("An example of just listing switch cases when they are not ordered..")
        !in 0..100 -> println("An example of using not in, this will activate if the number is below 0 or above 100.")
    }

    // When Statements can also be used to check variable types. The statements need the keyword "is" when defining a type.
    var unknown : Any = 13.37  // This has been typecast to be any type and Kotlin will figure out what type to assign the variable.
    when(unknown){
        is Int    -> println("The unknown variable is an Int")
        is Double -> println("The unknown variable is an Double")
        else      -> println("The unknown variable is not an Int or a Double.")
    }
    // Note: both in and is can be negated with !in and !is.

    // While Loops
    // The while loop executes a block of code repeatedly as long as a given condition is true.
    var whileCondition = 1
    while(whileCondition <= 10){
        println("$whileCondition")
        whileCondition++
    }
    println("While loop completed.")

    // Another while loop example that uses a boolean condition.
    var feltTemp = "cold"
    var roomTemp = 10
    while(feltTemp == "cold"){
        roomTemp++
        if (roomTemp >= 20){
            feltTemp = "comfy"
            println("Now it's comfy!")
        }
    }

    // Another type of while loop is the "do while" loop.
    // A do while loop will execute once before checking the while condition, even if the condition is not met.
    whileCondition = 100
    do{
        println("$whileCondition")
        whileCondition++
    }while(whileCondition <= 10)
    println("Do while loop completed.")

    // For loops
    // Two acceptable ways of writing a for loop in Kotlin.

    // The first loop will print 10, because it is using the .. notation.
    for(num in 1..10){
        println("$num")
    }

    // The second loop will not print 10, because it is using the 'until' notation.
    for(i in 1 until 10){
        println("$i")
    }
    println("For loops completed.")

    // The step size can also be specified in a for loop.
    for(j in 10 downTo 1 step 2){
        print("$j ")
    }
    println("")

    // This same example can also be written the following way.
    for(j in 10.downTo(1).step(2)){
        print("$j ")
    }
    println("")

    // -------------- Nullables --------------
    // Kotlin allows for nullables values if specified.

    var someName : String      = "Joe"
    // someName                = null --> COMPILATION ERROR.
    var nullableName : String? = "Bobby"
    nullableName               = null

    // However, certain operations can't be performed on null. Note the syntax ? for a possible null value.
    var someNameLength         = someName.length
    // var nullableNameLength  = nullableName.length --> CAN"T PERFORM ON NULL.
    var nullableNameLength     = nullableName?.length // If the variable is not null, the length will be returned. Otherwise, null will be returned.

    // If an action should only be taken if the variable is NOT null, the safe call operator "?" can be used.
    nullableName               = "Jim"
    println("$nullableName")
    nullableName?.let{println("The name above has a length of ${it.length}")}

    nullableName               = null
    // nullableName?.let{println(it.length)} // This is suppose to be skipped due to the null values but is crashing the program instead...

    // The safe call operator can be used in a chain.
    // val friendAge: String? = me?.friend?.age ?: 0

    // Elvis operator (?:)
    // This operator is used when assigning a potentially nullable variable to a non-nullable variable.
    var newName = nullableName ?: "Stranger"
    println("This is $newName")

    // -------------- Functions --------------
    // Calling a simple function with no arguments.
    myFunction()

    // Calling a function with arguments. (a and b).
    var result = addUp(2,4)
    println("The result of addUp is $result")

    // Note: a Method is a Function within a Class.
    // Functions, Methods, and Procedures are all similar but do have differences. Be mindful of the terminology used.

    // -------------- Classes --------------
    // The code for the following can be found in KotlinOOP where object-oriented programming is explored.

    // Person class examples.
    classTesting()

    var theDude = Person("The", "Dude", 35)
    theDude.stateHobby()

    theDude.hobby = "bowling"
    theDude.age = 36
    theDude.stateHobby()
    println("The dude is now ${theDude.age} years old.")

    // Car class examples.
    var myCar = Car()
    println("The car brand is ${myCar.myBrand}")

    // User data class examples.
    val user1 = User(1, "Joe")
    user1.name = "Khan"
    val user2 = User(1,"Khan")

    // Comparing data classes.
    println(user1 == user2) // This is true because all fields are the same.

    // Copying data classes.
    val newUser = user1.copy(name = "New Guy") // newUser has a new name, but the same ID while user1 has not changed.

    println(newUser)

    // Grabbing data class components.
    println(newUser.component1()) // This will print the first component, in this case the ID value of 1.

    // Deconstruction of data class.
    val (id, name) = newUser

    // The line above is equivalent to the lines below (different variable names are chosen to avoid confusion).
    val idOfUser   = newUser.id
    val nameOfUser = newUser.name

    // Vehicle and Sub class examples.
    var myModernCar   = ModernVehicles("A3", "Audi")
    var myElectricCar = ElectricVehicles("Model-S", "Tesla", 85.0)

    // Both these objects can use the method from "ModernVehicles".
    // This is an aspect of Polymorphism - The ability to treat objects with similar traits in a common way.
    myModernCar.drive(200.0)
    myElectricCar.drive(250.0)
    myElectricCar.driveRange()

    // Interface examples.
    var myGoKart  = GoKart(60.0, "Thunder")
    var myEGoKart = ElectricGoKart(60.0, "Lightning")

    // NOTE: myEGoKart will call both the interface function (due to the super.brake call) and the override function.
    myGoKart.brake()
    myEGoKart.brake()

    // Abstract class examples.
    // These objects are created from classes that inherit most of their properties/functionality from an abstract class.
    val aHuman     = Human("Adam", "Africa", 160.0, 20.0)
    val anElephant = Elephant("Rosy", "India", 8000.0, 25.0)

    aHuman.run()
    anElephant.run()

    aHuman.breath()
    anElephant.breath()

    // NOTE: you cannot create a mammal object.
    // val myMammal = Mammal("It","Earth", 5.0, 5.0) - Not allowed, Mammal is an abstract class.

    // DIFFERENCES BETWEEN CLASSES AND INTERFACES:
    // * A class can implement multiple interfaces, but can only inherit from 1 class.
    // * An interface does not need a constructor. A class always does.
    // * Interfaces cannot hold fields (a value held in memory by a variable).
    // * An interface cannot hold state, a class holds state (this means variable values can be stored and manipulated within a class).

    // Typecasting examples.
    typecastTesting()
}

// A simple function
fun myFunction(){
    println("Called from myFunction")
}

// A function with 2 parameters (type Int) that returns a value (type Int).
fun addUp(a: Int, b: Int): Int{
    return a + b
}