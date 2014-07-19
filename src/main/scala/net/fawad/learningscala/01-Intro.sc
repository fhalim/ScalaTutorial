1 + 1

val a = 5
// Not allowed
//  a = a + 1
b += 2
b
println("Hello world")
val add3 = (x: Int, y: Int) => x + y
add(1, 2)
val numberAndSquare = square(12)
add2(2, 3)
// Can talk to Java stuff just fine

Math.abs(-12)
import java.util.Date

val endOfYear = new Date(2013 - 1900, 12 - 1, 31)
val (num, squaredValue) = numberAndSquare
// Functions are people too
var b = 5
add3(1, 2)
// Functions can take functions
def add(x: Int, y: Int): Int = {
  return x + y
}
def add2(x: Int, y: Int) = x + y

addToSelf(12)
def addToSelf(value: Int) = applyTwice(value, add3)
def applyTwice(value: Int, func: (Int, Int) => Int) = func(value, value)
// So are tuples
def addToSelf2(value: Int) = applyTwiceGeneric(value, add3)

// Generics are great
def applyTwiceGeneric[T](value: T, func: (T, T) => T) = func(value, value)

def square(x: Int) = (x, x * x)
def sayHello() = println("Hello world")
sayHello

def double(x: Int) = cMul(2)(x)
cMul(2)(5)

// Partial application
def double2 = cMul(2) _
double(5)

// Currying
def cMul(x: Int)(y: Int) = x * y

double2(6)
