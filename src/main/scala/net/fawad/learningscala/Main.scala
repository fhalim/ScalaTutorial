package net.fawad.learningscala

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

object Main {
  def main(args:Array[String]) {
    SpringApplication.run(classOf[Controllers], args:_*)
  }
}


@Controller
@EnableAutoConfiguration
@RequestMapping(Array("/api")) class Controllers {
  @RequestMapping(Array("/hello")) def sayHello = "Hello world"
}

