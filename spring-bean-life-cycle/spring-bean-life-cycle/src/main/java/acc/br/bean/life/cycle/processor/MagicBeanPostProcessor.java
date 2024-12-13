package acc.br.bean.life.cycle.processor;

import org.springframework.beans.factory.config.BeanPostProcessor;

import acc.br.bean.life.cycle.beans.Character;
import acc.br.bean.life.cycle.beans.Item;
import acc.br.bean.life.cycle.beans.Weapon;

public class MagicBeanPostProcessor implements BeanPostProcessor {
	
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
    	
        if (bean instanceof Character) {
            System.out.println("5. BeanPostProcessor: Adicionando um efeito" + ((Character) bean).getName());
        } else if (bean instanceof Weapon) {
            System.out.println("5. BeanPostProcessor: Modificando a weapon: " + ((Weapon) bean).getName());
        } else if (bean instanceof Item) {
            System.out.println("5. BeanPostProcessor: Efeito criado: " + ((Item) bean).getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
    	
        if (bean instanceof Character) {
            System.out.println("9. BeanPostProcessor: Continuacao " + ((Character) bean).getName());
        } else if (bean instanceof Weapon) {
            System.out.println("9. BeanPostProcessor: Weapon " + ((Weapon) bean).getName() + " com efeito.");
        } else if (bean instanceof Item) {
            System.out.println("9. BeanPostProcessor: Item " + ((Item) bean).getName() + " com poder.");
        }
        return bean;
    }
}