

// Defaults to immutable collections
val myNumbers = Vector(1, 2, 3)
myNumbers.head
myNumbers.tail
myNumbers.reverse

myNumbers.apply(1)
myNumbers(1)

val myNumbers2 = 1 :: 2 :: 3 :: Nil
myNumbers2 ++ Vector(4, 5, 6)
1 +: myNumbers2
myNumbers :+ 1

myNumbers.foldLeft(0)((x, y) => x + y)

(0 /: myNumbers) (_ + _)

val ages = Map("Tom" -> 21, "Dick" -> 15, "Harry" -> 3, "Bob" -> 45)

def double(x: Int) = x * 2
myNumbers.map(double)

myNumbers.filter(x => x % 2 != 0)


def odd(x: Int) = x % 2 == 1

myNumbers filter odd
ages.filter { case (k, v) => v >= 21}