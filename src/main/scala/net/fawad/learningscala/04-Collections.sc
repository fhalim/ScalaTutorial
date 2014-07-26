// Defaults to immutable collections
val myNumbers = Vector(1, 2, 3)
myNumbers.head
myNumbers.tail
myNumbers.reverse

myNumbers.apply(1)
myNumbers(1)

val moreNumbers = Seq(2, 3, 4)
val moreNumbers2 = Iterable(2, 3, 4)


val myNumbers2 = 1 :: 2 :: 3 :: Nil
myNumbers2 ++ Vector(4, 5, 6)
1 +: myNumbers2
myNumbers :+ 1

myNumbers.foldLeft(0)((x, y) => x + y)

(0 /: myNumbers) (_ + _)


def double(x: Int) = x * 2
myNumbers.map(double)

myNumbers.filter(x => x % 2 != 0)


def odd(x: Int) = x % 2 == 1

myNumbers filter odd

myNumbers.partition(odd)

val ages = Map("Tom" -> 21, "Dick" -> 15, "Harry" -> 3, "Bob" -> 45)
ages.filter { case (k, v) => v >= 21}

def slowDoubler = (x:Int) => {
  Thread.sleep(500)
  x * 2
}

myNumbers map slowDoubler
myNumbers.par.map(slowDoubler)

val timesTable = for(x <- myNumbers; y <- myNumbers) yield (x, y, x * y)




// Implicit conversion to java types
import java.util.Collections

import scala.collection.JavaConversions._
Collections.binarySearch(List("Bob", "Ted", "Charlie"), "Ted")




// Streams
val ints:Stream[Int] = Stream.from(0)

ints.take(5).toArray

val fibs:Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map{case(x,y) => x + y}
fibs.take(20).toArray