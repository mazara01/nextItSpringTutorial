package kr.or.nextit.springtutorial.aop;

import kr.or.nextit.springtutorial.SpringTutorialApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AOPExample {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AOPExample.class, args);
        AOPMethod aopMethod = context.getBean("aopMethod", AOPMethod.class);
        //name의 이름은 빈에서 설정한 이름임
        aopMethod.method3();

    }
}
