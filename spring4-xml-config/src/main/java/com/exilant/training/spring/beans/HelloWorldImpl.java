package com.exilant.training.spring.beans;

public class HelloWorldImpl implements HelloWorld {

	public void printMessage(String msg) {
		System.out.println("Hello : " + msg);
	}

}
