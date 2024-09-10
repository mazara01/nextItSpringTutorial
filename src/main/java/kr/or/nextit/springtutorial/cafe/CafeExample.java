package kr.or.nextit.springtutorial.cafe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CafeExample {
    public static void main(String[] args) {
       /* EspressoCoffeeMachin espressoCoffeeMachin = new EspressoCoffeeMachin();
        Barista barista = new Barista(espressoCoffeMachine);

        Cafe cafe=new Cafe(barista);
        Coffee  coffee = cafe.orderCoffee(4000);
        System.out.println(coffee);
*/
//        ApplicationContext context = new ClassPathXmlApplicationContext("cafe-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(CafeConfig.class);

        Cafe cafe = context.getBean("cafe",Cafe.class);
        Coffee coffee = cafe.orderCoffee(4000);
        System.out.println(coffee);
    }
}
