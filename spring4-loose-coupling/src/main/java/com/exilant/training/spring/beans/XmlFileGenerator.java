package com.exilant.training.spring.beans;

public class XmlFileGenerator implements FileGenerator {

	public void generateFile(String msg1, String msg2) {
		System.out.println("I am generating XML file");
		System.out.println(String.format("<xml><message1>%s</message1><message2>%s</message2></xml>", msg1, msg2));
	}

}
