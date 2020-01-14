package com.ardelean;

import static com.ardelean.utils.ConfigLoader.getProperty;

import java.io.File;

import com.ardelean.business.OrdersProcessor;

public class App {
	public static void main( String[] args ) {
    String inputDirectoryPath = getProperty("orders.input.path");
	File inputDirectory = new File(inputDirectoryPath);
	if ( !inputDirectory.exists() || !inputDirectory.isDirectory()) {
		System.err.println("Error! Input path doesn't exist or is not a directory. \nProgram exits");
		System.exit(1);
	}
	OrdersProcessor processor = new OrdersProcessor();
	
	// Look for files in input folder indefinitely 
	while (true) {
		for (File file : inputDirectory.listFiles()) {
    		processor.processInputFile(file);
    	}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
}
