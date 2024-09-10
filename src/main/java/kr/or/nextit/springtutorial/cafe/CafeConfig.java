package kr.or.nextit.springtutorial.cafe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CafeConfig {

    @Bean
    public CoffeeMachine espressoCoffeeMachin(){
        return new EspressoCoffeeMachin();
    }

    @Bean
    public Barista barista(){
        return new Barista(espressoCoffeeMachin());
    }

    @Bean
    public Cafe cafe() {
        return new Cafe(barista());
    }
}
