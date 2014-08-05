// Defaults to immutable collections
val myNumbers = Vector(1, 2, 3)
myNumbers.head
myNumbers.tail
myNumbers.reverse

myNumbers.apply(1)
myNumbers(1)




// Factories at all levels
val moreNumbers = Seq(2, 3, 4)
val moreNumbers2 = Iterable(2, 3, 4)





// Pattern matching on collections
def snd[T](coll:Seq[T]) = coll match {
  case _ +: v +: tail => Some(v)
  case _ => None
}

snd(myNumbers)




// Constructing more collections
val myNumbers2 = 1 :: 2 :: 3 :: Nil
myNumbers2 ++ Vector(4, 5, 6)
1 +: myNumbers2
myNumbers :+ 1


// Folding (accumulation)
myNumbers.foldLeft(0)((x, y) => x + y)

(0 /: myNumbers) (_ + _)


// Mapping
def double(x: Int) = x * 2
myNumbers.map(double)

myNumbers.filter(x => x % 2 != 0)


def odd(x: Int) = x % 2 == 1

myNumbers filter odd


// Partition
myNumbers.partition(odd)





// Maps
val ages = Map("Tom" -> 21, "Dick" -> 15, "Harry" -> 3, "Bob" -> 45)
ages.filter { case (k, v) => v >= 21}





// Parallel collections
def slowDoubler = (x:Int) => {
  Thread.sleep(500)
  x * 2
}

myNumbers map slowDoubler
myNumbers.par.map(slowDoubler)




// Can use for comprehensions to compose collections

val products = for(x <- myNumbers; y <- myNumbers if y < x) yield (x, y, x * y)




// Implicit conversion to java types
import java.util.Collections

import scala.collection.JavaConversions._
Collections.binarySearch(List("Bob", "Ted", "Charlie"), "Ted")




// Streams
val ints:Stream[Int] = Stream.from(0)

ints.take(5).toArray

val fibs:Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map{case(x,y) => x + y}
fibs.take(20).toArray