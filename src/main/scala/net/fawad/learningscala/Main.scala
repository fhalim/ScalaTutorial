package net.fawad.learningscala

import java.util.concurrent.CountDownLatch

import com.hazelcast.core.Hazelcast
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}
import resource.managed

object Main {
  def main(args: Array[String]) {
    import net.fawad.learningscala.Disposal._

    for (h <- managed(Hazelcast.newHazelcastInstance());
         lock <- managed(h.getLock("springapp"));
         ctx <- managed(SpringApplication.run(classOf[Controllers], args: _*))) {
      new CountDownLatch(1).await()
    }
  }
}

@Controller
@EnableAutoConfiguration
@RequestMapping(Array("/api")) class Controllers {
  @RequestMapping(Array("/hello"))
  @ResponseBody def sayHello = "Hello world"
}

