package com.exilant.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exilant.training.spring.beans.HelloWorld;
import com.exilant.training.spring.config.JavaConfig;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		helloWorld.printMessage("Vijay");
	}

}
