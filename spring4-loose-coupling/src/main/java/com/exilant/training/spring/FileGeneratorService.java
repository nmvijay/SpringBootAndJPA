package com.exilant.training.spring;

import com.exilant.training.spring.beans.FileGenerator;

public class FileGeneratorService {

	private FileGenerator fileGenerator;

	public FileGenerator getFileGenerator() {
		return fileGenerator;
	}

	public void setFileGenerator(FileGenerator fileGenerator) {
		this.fileGenerator = fileGenerator;
	}
	
	public void createFile(String msg1, String msg2) {
		fileGenerator.generateFile(msg1, msg2);
	}

}
