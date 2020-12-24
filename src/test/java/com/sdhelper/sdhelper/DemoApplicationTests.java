package com.sdhelper.sdhelper;

import com.sdhelper.sdhelper.app.Main;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootTest
@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
