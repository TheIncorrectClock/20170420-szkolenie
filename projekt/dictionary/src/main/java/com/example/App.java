package com.example;

import com.example.dictionary.Controller;
import com.example.dictionary.translation.TranslationService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

	public static void main(String... args) {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfiguration.class);
		Controller c = ctx.getBean(Controller.class);
		c.run();

		ctx.close();
	}

	@Configuration
	@ComponentScan({"com.example.dictionary", "com.example.helloworld"})
	public static class AppConfiguration {

	}

}
