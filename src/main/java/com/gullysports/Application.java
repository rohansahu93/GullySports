
package com.gullysports;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * Application class.
 */
@SpringBootApplication
@EnableMongoAuditing
public class Application {

    /**
     * Main class.
     *
     * @param args Arguments
     */
    public static void main(final String[] args) {

        SpringApplication.run(Application.class, args);
    }

    /**
     * The bean method that lists all the registered beans. uncomment Bean
     * annotation if you want to list the registered beans.
     * 
     * @param ctx Spring Application Context
     * @return Instance of CommandLineRunner bean
     */
    // @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {

        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
