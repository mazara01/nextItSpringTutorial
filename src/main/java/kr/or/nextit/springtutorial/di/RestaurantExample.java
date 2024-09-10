package kr.or.nextit.springtutorial.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class RestaurantExample {
    public static void main(String[] args) {
        /*Restaurant restaurant = new Restaurant("아웃백", "대전 중구 계룔로 824", "042-718-5567");//instance라고함
        System.out.println(restaurant);
        Chef chef1 = new Chef("미소", "20");
        Chef chef2 = new Chef("쵸파", "25");
        List<Chef> chefs=new ArrayList<>();
        chefs.add(chef1);
        chefs.add(chef2);
        restaurant.setChefs(chefs);
        System.out.println(restaurant);*/

        //상속에서 is a, has a?
        /*
        * is a: 부모 자식, 사람 학생, 학생 대학생, 동물(animal), 강아지(dog)
        * has a(포함관계): 은행 고객, 고객통장, 음식점 요리사, 자동타 타이어
        * class Bank {
        *   Customer[] customers;
        * }
        * 스프링도 컨테이너가 있다. =>톰캣이 서블릿 컨테이너 역할을 하는 것과 같음
        * 스프링이 관리하는 객체를 스프링 빈(bean)이라고 한다.
        * 스프링 컨테이너에 빈을 등록해야하는에 이떄 xml방식과 annotaion방식이 있다.
        * */

        //Xml 방식으로 가져올 떄
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("restaurant-context.xml");
//        Restaurant restaurant = context.getBean("restaurant", Restaurant.class);
//        System.out.println(restaurant);
        //Annotaion 방식으로 가져올 때
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RestaurantConfig.class);
        Restaurant restaurant = context.getBean("restaurant",Restaurant.class);
        System.out.println(restaurant);
    }
}
