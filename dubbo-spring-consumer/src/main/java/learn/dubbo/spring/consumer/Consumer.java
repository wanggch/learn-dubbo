package learn.dubbo.spring.consumer;

import learn.dubbo.spring.api.GreetingsService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Objects;

public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();
        GreetingsService greetingsService = (GreetingsService) context.getBean("greetingsService");
        if (Objects.isNull(greetingsService)) {
            System.out.println("Cannot find service.");
        }
        String msg = greetingsService.sayHi("Jenny");
        System.out.println(msg);
    }
}
