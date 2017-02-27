package com.exilant.training.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean(name = "foo")
	public Foo foo() {
		return new Foo("Vijay");
	}
}