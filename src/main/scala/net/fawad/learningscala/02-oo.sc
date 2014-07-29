// Java style class
class Person {
  var name: String = ""
  var phone: String = ""

  def getName() = name

  def setName(value: String) {
    name = value
  }

  def getPhone() = phone

  def setPhone(value: String) {
    phone = value
  }
}
val bob = new Person
bob.setName("Bob")
bob.getName
bob.phone

class Person2(val name: String, var phone: String) {

}
val jack = new Person2("Jack", "1231231234")
jack.name
jack.phone = "abc"
// Can't do
//    jack.name = "pete"

// Also can't do jack.setPhone("12")



import scala.beans.BeanProperty

class Person3(@BeanProperty val name: String, @BeanProperty var phone: String)

val bob2 = new Person3("bob", "123")
bob2.getName
bob2.setPhone("1234")
bob2.phone

val bob3 = new Person3("bob", "123")
val bob4 = new Person3("bob", "123")

bob3 == bob4

case class Person4(@BeanProperty val name: String, @BeanProperty var phone: String)
val bob5 = new Person4("bob", "123")
val bob6 = new Person4("bob", "123")

bob5 == bob6

object HitCounter {
  var value = 0
  println("I just got created")
  def incrementAndGet = {
    value = value + 1
    println(s"Logged: Incremented to ${value}")
    value
  }
}
println(s"Current value ${HitCounter.incrementAndGet}")
println(s"Current value ${HitCounter.incrementAndGet}")


trait Counter {
  var value = 0
  def increment() = value = value + 1
  def get = value
}


trait Loggable {
  def log(message:String) = println(s"Logged: ${message}")
}

object NewHitCounter extends Counter with Loggable {
  def incrementAndGet = {
    increment()
    log(s"Updated to value ${value}")
    get
  }
}

NewHitCounter.incrementAndGet
NewHitCounter.incrementAndGet





// Implicit conversions

import java.text.SimpleDateFormat

val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
val startDate = dateFormat.parse("2012-01-01")
val endDate = dateFormat.parse("2013-01-01")
println((endDate.getTime - startDate.getTime) / (60 * 60 * 1000))







import java.util.Date
class MathableDate(val date:Date) {
  def -(otherDate:MathableDate) = (date.getTime - otherDate.date.getTime) / (60 * 60 * 1000)
}

println(new MathableDate(endDate) - new MathableDate(startDate))






implicit def toMathable(value:String) = new MathableDate(dateFormat.parse(value))
println("2013-01-01" - "2012-01-01")




// Specialization
class MyContainer[@specialized T](value:T){

}