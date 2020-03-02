package de.dimk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
* Initialized with
* ------------- https://start.spring.io/ ----------------
* The generated SpringBootWebApplication  is annotated with @SpringBootApplication.
* It is equivalent to use  @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes.
* We will annotate it with @EnableJpaRepositories. It enables Spring to scan the base package and all its sub-packages
* for any interfaces extending Repository or one of its sub-interfaces. For each interface found, Spring creates the
* appropriate bean to handle invocation of the query methods.
*/

@SpringBootApplication
@EnableJpaRepositories(basePackages = "de.dimk")
public class MySpringBootTutWebAppApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
        return application.sources(SpringApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootTutWebAppApplication.class, args);
	}
}
