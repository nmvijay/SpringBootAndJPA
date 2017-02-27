package com.exilant.training.spring.beans;

public class CsvFileGenerator implements FileGenerator {

	public void generateFile(String msg1, String msg2) {
		System.out.println("I am generating CSV file");
		System.out.println(String.format("%s, %s", msg1, msg2));
	}
}
