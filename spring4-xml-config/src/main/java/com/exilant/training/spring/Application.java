package com.exilant.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exilant.training.spring.beans.HelloWorld;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		helloWorld.printMessage("Vijay");
	}
}
