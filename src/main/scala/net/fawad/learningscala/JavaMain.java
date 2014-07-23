package net.fawad.learningscala;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.ILock;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;

public class JavaMain {
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance h = null;
        try{
            h=Hazelcast.newHazelcastInstance();
            final ILock lock = h.getLock("springapp");
            try{
                lock.lock();
                try(ConfigurableApplicationContext ctx = SpringApplication.run(Controllers.class, args)){
                    final IAtomicLong hitCount = h.getAtomicLong("hitcounter");
                    ctx.getBeanFactory().registerSingleton("hitCount", hitCount);
                    new CountDownLatch(1).await();
                }
            }finally{
                lock.unlock();
            }
        } finally {
            if(h!=null){
                h.shutdown();
            }
        }
    }
}
