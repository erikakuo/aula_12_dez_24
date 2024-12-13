package acc.br.bean.life.cycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import acc.br.bean.life.cycle.beans.Item;

@Configuration
public class ItemConfig {

    @Bean
    public Item potion() {
        return new Item("Pocao");
    }
}