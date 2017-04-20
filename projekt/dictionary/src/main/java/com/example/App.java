package com.example;

import com.example.dictionary.Controller;
import com.example.dictionary.translation.TranslationService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Map;

public class App {

	public static void main(String... args) {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfiguration.class);

		Map<String, Object> ofType = ctx.getBeansOfType(Object.class);
		ofType.entrySet().forEach(System.out::println);

		Controller c = ctx.getBean(Controller.class);
		c.run();

		ctx.close();
	}

	@Configuration
	@ComponentScan({"com.example.dictionary", "com.example.helloworld"})
	@PropertySource("classpath:dict.properties")
	public static class AppConfiguration {

	}

}
