package com.exilant.training.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.exilant.training.spring.beans.HelloWorld;
import com.exilant.training.spring.beans.HelloWorldImpl;

@Configuration
public class JavaConfig {

	@Bean(name = "helloWorld")
	public HelloWorld helloWorld() {
		return new HelloWorldImpl();
	}
}
