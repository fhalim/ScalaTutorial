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

// So are tuples
def addToSelf2(value: Int) = applyTwiceGeneric(value, add)

// Currying
def cMul(x: Int)(y: Int) = x * y
cMul(2)(5)

def double(x: Int) = cMul(2)(x)
double(5)

// Partial application
def double2 = cMul(2) _
double2(6)

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


