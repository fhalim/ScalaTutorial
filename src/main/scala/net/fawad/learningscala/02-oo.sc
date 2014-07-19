import java.beans.BeanInfo

val bob = new Person
val jack = new Person2("Jack", "1231231234")
bob.setName("Bob")
bob.getName

// Phone number is unset
bob.phone
val bob2 = new Person3("bob", "123")
val pete = new Person4("pete", "543")
jack.name
jack.phone = "abc"
// Can't do
//    jack.name = "pete"

// Also can't do jack.setPhone("12")

import scala.beans.BeanProperty

val bob3 = new Person3("bob", "123")
val bob4 = new Person3("bob", "123")

bob2.getName
bob2.setPhone("1234")
bob2.phone

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

class Person2(val name: String, var phone: String) {

}

pete.set

class Person3(@BeanProperty val name: String, @BeanProperty var phone: String)

@BeanInfo class Person4(val name: String, var phone: String)

bob3 == bob4 // Denied!

