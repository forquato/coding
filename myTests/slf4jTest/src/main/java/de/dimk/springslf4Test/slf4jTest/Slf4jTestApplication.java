package de.dimk.springslf4Test.slf4jTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.*;


@SpringBootApplication
@Slf4j
public class Slf4jTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Slf4jTestApplication.class, args);
		log.info("testing logging with lombok");
	}
}
