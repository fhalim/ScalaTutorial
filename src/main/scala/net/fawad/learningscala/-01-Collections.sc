// Defaults to immutable collections
val myNumbers = Vector(1, 2, 3)
myNumbers.head
myNumbers.tail
myNumbers.reverse

myNumbers.apply(1)
myNumbers(1)
val ages = Map("Tom" -> 21, "Dick" -> 15, "Harry" -> 3, "Bob" -> 45)

myNumbers.map(double)

myNumbers.filter(x => x % 2 != 0)

def double(x: Int) = x * 2
myNumbers filter odd

def odd(x: Int) = x % 2 == 1

ages.filter { case (k, v) => v >= 21}