package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application  {


    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    MessageService mockMessageService() {
        return () -> "Hello World!";
    }

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    Object indep() {
        return new Object();
    }

    public static void main(String[] args) {
       ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Application.class);
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        MessagePrinter printer = applicationContext.getBean(MessagePrinter.class);
        printer.printMessage();
    }

}


