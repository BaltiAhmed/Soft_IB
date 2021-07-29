package tn.elif.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages={ "tn.elif.spring.controllers"})
public class SoftIbApplication {


	public static void main(String[] args) {
		SpringApplication.run(SoftIbApplication.class, args);

		System.out.printf("hi");
		System.out.printf("Test Younes");
		System.out.printf("Test Ahmed");

	}

}
