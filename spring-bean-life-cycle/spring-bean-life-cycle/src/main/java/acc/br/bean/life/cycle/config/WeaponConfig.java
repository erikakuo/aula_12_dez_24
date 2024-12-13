package acc.br.bean.life.cycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import acc.br.bean.life.cycle.beans.Weapon;

@Configuration
public class WeaponConfig {

    @Bean
    public Weapon sword() {
        return new Weapon("Arma");
    }
}