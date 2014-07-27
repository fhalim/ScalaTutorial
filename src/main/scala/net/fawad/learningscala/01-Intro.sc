// Hello world of scala
println("Hello world")

1 + 1

// Variable declaration
val a = 5
val a2:Int = 5
// Not allowed
//  a = a + 1

var b = 5
b += 2
b

// Function body is expression
def add(x: Int, y: Int): Int = {
  return x + y
}
add(1, 2)


// Can leave off return type and parens
def add2(x: Int, y: Int) = x + y
add2(2, 3)


// Can declare function as a variable
val add3 = (x: Int, y: Int) => x + y
add3(1, 2)




// Can talk to Java stuff just fine

Math.abs(-12)
import java.util.Date
val endOfYear = new Date(2013 - 1900, 12 - 1, 31)
def sayHello() = println("Hello world")
sayHello
