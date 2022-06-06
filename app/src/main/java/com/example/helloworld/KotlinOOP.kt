package com.example.helloworld

import java.lang.IllegalArgumentException
import kotlin.math.floor

fun classTesting(){

    // An object (or instance) of the Person Class.
    Person()
    Person("Timmy", "Turner")

    // I can save that object to a variable. Defining the type (: Person) is optional but is done so to be explicit here.
    var whoAmI : Person = Person("Jonathan", "Cornet")

    // If default values are assigned in the constructor, not all variables are needed.
    Person(firstName = "Jane")
}

// An example of a Class (blueprint) with a constructor. The constructor line word is optional. The class below has the same constructor.
class PersonLong constructor(firstName: String, lastName: String){

}

// Less verbose Class definition. Default values are assigned in the primary constructor.
class Person (firstName: String = "John", lastName: String = "Doe"){

    // Member Variables - Properties
    var age : Int? = null
    var hobby: String = "hanging out"

    // To get around scope issues of methods, we need to save the parameter of the name into a variable.
    var personFirstName : String? = null

    // The Initializer Block. Called when an object is created.
    init{
        println("A person was created. Their name is $firstName $lastName.")

        // assign the parameter to the member variable inside the initializer to pass the variable to a method.
        this.personFirstName = firstName
    }

    // Member functions - Methods
    fun stateHobby(){
        // Note: the $firstname can ONLY be used correctly if the parameter is stored as a member variable.
        println("$personFirstName\' hobby is $hobby")
    }

    // Member secondary Constructor
    constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName){
        this.age = age
    }
}

class Car(){

    // "lateinit" allows a variable to be created without initializing it. However, if it is not initialized, it will cause an error.
    lateinit var owner: String

    // Without this code block, the "lateinit" line above would cause an error.
    init {
        this.owner = "Frank"
    }

    // Getters and Setters
    // When you create a variable and assign it a value, a getter and setter are generated in the background.
    // For example, the code below is created when the variable maxSpeed is defined (here, it is explicitly shown).
    var maxSpeed: Int = 250
        get() = field
        set(value){
            field = value
        }

    // We can also customize the getters and setters.
    // "getters" will return the variable value (also known as accessors)
    // "setters" will set or update the value (also known as mutators)
    val myBrand: String = "BMW"

        // Custom getter.
        get() {
            return field.toLowerCase()
        }

    var minSpeed: Int = 1

        // Custom setter.
        set(value){
            field = if(value > 0) value else throw IllegalArgumentException("Cars can't have negative speed.")
        }

    // Setting the "set" to private makes the variable only changeable within the class.
    var myModel : String = "M5"
        private set
}

// Data class are classes whose main purpose is to hold data.
// These classes have some standard functionality and utility functions are often mechanically derivable from the data.
// Data class constructors must have at least 1 parameter.
// Data class parameters must be either "val" or "var".
// Data class cannot be abstract, open, sealed, or inner classes.
data class User(val id: Long, var name: String)

// Inheritance
// The class that inherits the features of another class is called the Sub, Child, or Derived class.
// The class whose features are inherited is called the Super, Parent, or Base class.
// In order to inherit from a class, the class must be "open".
// In order to prevent a class from being inherited from, the class must be "sealed" (a sealed class is the opposite of an open class).

// NOTE: any/all classes inherit from the "Any" Class, which is the root of the Kotlin class hierarchy.
// In other words, every Kotlin class has Any as a superclass.

// The Super Class, Parent Class, Base Class of this example (and of ModernVehicles and ElectricVehicles).
open class Vehicle{
    // Assume this class has lots of the following:
    // Properties
    // Methods
}

// The Sub Class, Child Class, Derived Class of Vehicle.
// The Super Class, Parent Class, Base Class of ElectricVehicles.
open class ModernVehicles(val name: String, val brand: String) : Vehicle(){
    // New properties
    // New methods
    open var range: Double = 0.0

    fun extendRange(amount: Double){
        if(amount > 0)
            range += amount
    }

    open fun drive(distance: Double){
        println("Drove for $distance miles.")
    }
}

// The Sub Class, Child Class, Derived Class of this example (and of Vehicle and ModernVehicles).
// This sub class needs the constructor from the parent class included (first 2 parameters).
class ElectricVehicles(name: String, brand: String, batteryLife: Double) : ModernVehicles(name, brand){
    // Specific properties
    // Specific methods

    // In order to change aspects of a parent class, the "override" keyword must be used and the aspect must be open in the parent class.
    override var range = batteryLife * 6
    override fun drive(distance: Double){
        println("Drove for $distance miles using the battery.")
    }

    fun driveRange(){
        println("Has a range of $range miles.")
    }
}

// Interfaces
// An interface is a contract that a class may choose to sign. If the class does, it is obliged to provide implementation of the properties and functions of the interface.
// In other words, it is a collection of things that can all be quickly and optionally added to a class.
// Note: a sub class that inherits from a class that inherits an interface also inherits that interface.
// Note: an interface can inherit from another interface.
// Note: a class can implement multiple interfaces.
interface Drivable{
    val maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("The drivable is braking.")
    }
}

open class GoKart(override val maxSpeed: Double, val name: String): Drivable{
    override fun drive(): String {
        return "Driving the interface drive."
    }
    // Shorter version of above block: override fun drive():String = "Driving the interface drive."
}

class ElectricGoKart(maxSpeed: Double, name: String): GoKart(maxSpeed, name){
    override fun brake(){
        // The super keyword is calling the interface's definition of the brake function.
        super.brake()
        // The new functionality to brake is added here.
        println("Electric brakes applied.")
        // NOTE: If the original function call isn't needed, don't use the super.brake call. Just override the function.
    }
}

// Abstract Class
// An abstract class cannot be instantiated (you cannot create an object of an abstract class).
// However, you can inherit subclasses from an abstract class.
// The members (properties and methods) of an abstract class are non-abstract (unless explicitly set to abstract with the keyword abstract).
abstract class Mammal(private val name: String, private val origin: String, private val weight: Double){
    // Note, this abstract class has concrete, non-abstract properties defined in the constructor.

    // However, this property IS abstract (must be overridden by subclass).
    abstract var maxRunSpeed: Double

    // Abstract methods (must be implemented by subclass).
    abstract fun run()
    abstract fun breath()

    // Concrete (non-abstract) method.
    fun displayDetails(){
        println("Name: $name, Origin: $origin, Weight: $weight, Max Running Speed: $maxRunSpeed")
    }
}

// These two classes will inherit most of their properties/functions from the abstract class, but will change certain aspects.
class Human(name: String, origin: String, weight: Double, override var maxRunSpeed: Double): Mammal(name, origin, weight){

    override fun run(){
        println("Runs on two legs.")
    }

    override fun breath(){
        println("Breaths through mouth and nose.")
    }
    // NOTE: these 3 overrides are needed to construct a class inheriting from an abstract class because they were not implemented in the parent class.
}

class Elephant(name: String, origin: String, weight: Double, override var maxRunSpeed: Double): Mammal(name, origin, weight){

    override fun run(){
        println("Runs on four legs.")
    }

    override fun breath(){
        println("Breaths through trunk.")
    }
    // NOTE: these 3 overrides are needed to construct a class inheriting from an abstract class because they were not implemented in the parent class.
}

// Typecasting
fun typecastTesting(){
    val stringList: List<String> = listOf(
        "Michael", "Jim", "Pam", "Dwight")
    val mixedTypeList: List<Any> = listOf(
        "Guy", 30, 10, "June", 70.5, "Beer")

    // Older if statement way to execute logic.
    /*
    for(value in mixedTypeList){
        if(value is Int){
            println("Integer: '$value'")
        } else if (value is Double){
            println("Double: '$value' with Floor value of ${floor(value)}")
        } else if (value is String){
            println("String: '$value' of length ${value.length}")
        } else{
            println("Unknown type.")
        }
    }
     */

    // Alternative way to write the above code block. Preferred by Kotlin.
    for(value in mixedTypeList){
        when(value){
            is Int    -> println("Integer: '$value'")
            is Double -> println("Double: '$value' with Floor value of ${floor(value)}")
            is String -> println("String: '$value' of length ${value.length}")
            else      -> println("Unknown type.")
        }
    }

    // Smart casting
    val obj1: Any = "I have a dream."
    if(obj1 !is String){
        println("Not a string")
    } else {
        // Object is automatically cast to a String in this scope. Hence, the length function is avaiable.
        println("String with length of ${obj1.length}")
    }

    // Explicit casting using the "as" keyword - this can go wrong and lead to an error.
    val str1: String = obj1 as String
    println(str1.length)

    // Example of it going wrong... Also called Unsafe casting.
    // val obj2: Any = 1337
    // val str2: String = obj2 as String
    // println(str2)

    // Explicit casting using the "as?" keyword - the safe version of what was done before.
    // Also called Safe casting.
    val obj3: Any = 1337
    val str3: String? = obj3 as? String // Works, but sets value to "null"
    println(str3) // Prints "null" since this variable is not a string.
}
