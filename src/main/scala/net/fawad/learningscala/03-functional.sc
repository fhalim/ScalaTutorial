var lastValue = 0
def setValue(value:Int) = {
  lastValue = value
  value
}

setValue(12)
lastValue
setValue(3)
lastValue

def square(x: Int) = (x, x * x)     // Functions can return multiple values
val numberAndSquare = square(12)
val (num, squaredValue) = numberAndSquare   // Can destructure return value



def add(x:Int, y:Int) = x + y
// Functions can take functions
def applyTwice(value: Int, func: (Int, Int) => Int) = func(value, value)

def addToSelf(value: Int) = applyTwice(value, add)
addToSelf(12)

// Generics are great
def applyTwiceGeneric[T](value: T, func: (T, T) => T) = func(value, value)


def addToSelf2(value: Int) = applyTwiceGeneric(value, add)

// Currying
def cMul(x: Int)(y: Int) = x * y
cMul(2)(5)

def double(x: Int) = cMul(2)(x)
double(5)

// Partial application
def double2 = cMul(2) _
double2(6)

// Recursion

import scala.math.BigInt


def fac(number:BigInt):BigInt =
  if (number == 0) BigInt(1)
  else number * fac(number - 1)
fac(30)

import scala.annotation.tailrec
def fac2(number:BigInt):BigInt = {
  @tailrec def facInner(accumulator:BigInt, value:BigInt):BigInt =
    if(value == 0) accumulator
    else facInner(value * accumulator, value - 1)
  facInner(1, number)
}
fac2(10000)
//fac(10000)
// Pattern matching
abstract class Node
case class Tree(left:Node, right:Node) extends Node
case class Leaf(value:Int) extends Node
def repr(n:Node):String = n match {
  case Leaf(v) => s"{Leaf: $v}}"
  case Tree(left, right) => s"{Left: ${repr(left)}, right: ${repr{right}})"
}

println(repr(Tree(Leaf(12), Tree(Leaf(14), Leaf(22)))))

case class EmptyableLeaf(value:Option[Int]) extends Node
def repr2(n:Node):String = n match {
  case EmptyableLeaf(Some(v)) => s"{Leaf: $v}}"
  case EmptyableLeaf(None) => s"{Leaf: Empty}}"
  case Tree(left, right) => s"{Left: ${repr2(left)}, right: ${repr2{right}})"
}

println(repr2(Tree(EmptyableLeaf(Some(12)), Tree(EmptyableLeaf(None), EmptyableLeaf(Some(22))))))

// For comprehension
for(num <- 0 until 5; denom <- 0 until 3; result <- safeDivide(num, denom)) {
  println(result)
}

def safeDivide(num: Double, denom:Double) = if(denom == 0) None else Some(num /denom)
safeDivide(15, 3)
safeDivide(3, 0)
for(num <- 0 until 5; denom <- 0 until 3) {
  println(num /denom)
}
// Unification

def triple(value:Int) = value * 3
triple(4)
import scala.beans.BeanProperty
object mytriple {
  @BeanProperty var counter = 0
  def apply(value:Int) = {
    counter = counter + 1
    value * 3
  }
}
mytriple(4)
mytriple(3)
mytriple.getCounter