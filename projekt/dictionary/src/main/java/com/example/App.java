package com.example;

import com.example.dictionary.Controller;
import com.example.dictionary.translation.TranslationService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Map;

public class App {

	public static void main(String... args) {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfiguration.class);

//		Map<String, Object> ofType = ctx.getBeansOfType(Object.class);
//		ofType.entrySet().forEach(System.out::println);

		Controller c = ctx.getBean(Controller.class);
		c.run();

		ctx.close();
	}

	@Configuration
	@EnableAspectJAutoProxy
	@ComponentScan({"com.example.dictionary", "com.example.helloworld"})
	@PropertySource("classpath:dict.properties")
	public static class AppConfiguration {

		@Bean
		Validator validator() {
			return new LocalValidatorFactoryBean();
//			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//			return factory.getValidator();
		}

	}

}
