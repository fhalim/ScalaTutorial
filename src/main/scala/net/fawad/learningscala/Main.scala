package net.fawad.learningscala

import java.util.concurrent.CountDownLatch

import com.hazelcast.config.Config
import com.hazelcast.core.{Hazelcast, IAtomicLong}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}
import resource.managed

import scala.annotation.meta.setter

object Main {
  def main(args: Array[String]) {
    import net.fawad.learningscala.Disposal._
    val cfg = new Config
    for (h <- managed(Hazelcast.newHazelcastInstance());
         lock <- managed(h.getLock("springapp"));
         ctx <- managed(SpringApplication.run(classOf[Controllers], args: _*))) {
      val hitCount = h.getAtomicLong("hitcounter")
      ctx.getBeanFactory.registerSingleton("hitCount", hitCount)
      new CountDownLatch(1).await()
    }
  }
}

@Controller
@EnableAutoConfiguration
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequestMapping(Array("/api"))
class Controllers {
  @(Autowired @setter)
  var hitCounter:IAtomicLong = _
  @RequestMapping(Array("/hello"))
  @ResponseBody def sayHello = "Hello world " + hitCounter.addAndGet(1)
}