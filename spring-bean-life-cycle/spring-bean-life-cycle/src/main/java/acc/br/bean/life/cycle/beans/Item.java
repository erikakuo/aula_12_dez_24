package acc.br.bean.life.cycle.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Item implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private String beanName;
    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public Item(String name) {
        System.out.println("1. Instantiation: Novo item criado.");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. BeanNameAware: Config nome: " + name);
        this.beanName = name;
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. BeanFactoryAware: Config aplicacao " + getName());
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. ApplicationContextAware: Config applicantionContext.");
        this.applicationContext = applicationContext;
    }  
    
    @PostConstruct
    public void init() {
        System.out.println("6. @PostConstruct: " + getName() + " Preparado para agir.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. Initialization: " + getName() + " tratando.");
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Executando a inicializacao " + getName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy: " + getName() + " Indo para destruicao.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: " + getName() + " em espera.");
        restAndRecover();
    }

    private void restAndRecover() {
        System.out.println("12. DisposableBean: " + getName() + " Recuperando.");
    }    

    public void customDestroy() {
        System.out.println("13. Custom Destruction: " + getName() + " Finalizando.");

    }

}