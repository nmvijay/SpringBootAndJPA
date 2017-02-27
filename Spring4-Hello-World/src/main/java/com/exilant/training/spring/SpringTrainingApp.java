package com.exilant.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTrainingApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();

		ApplicationContext context2 = new AnnotationConfigApplicationContext(JavaConfig.class);

		Foo fff = context2.getBean("foo", Foo.class);
		System.out.println(fff.getName());

	}
}
