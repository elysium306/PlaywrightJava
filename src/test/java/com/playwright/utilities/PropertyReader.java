package com.playwright.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private static File config;

	private static final Properties properties = new Properties();

	private static FileInputStream inputStream;

	private static String filePath;

	public static String getProperty(String key) {
		filePath = System.getProperty("user.dir") + "/src/main/resources/properties/configuration.properties";
		System.out.println("*** configuration.properties: " + filePath);

		try {
			config = new File(filePath);
			inputStream = new FileInputStream(config);
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
	
	public static String getLocator(String key) {
		// src/main/resources/properties/locators.properties
		filePath = System.getProperty("user.dir") + "/src/main/resources/properties/locators.properties";
		System.out.println("*** locator.properties: " + filePath);

		try {
			config = new File(filePath);
			inputStream = new FileInputStream(config);
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	public static void main(String[] args) {

		System.out.println("## Getting property: " + getProperty("playwright_home"));
		System.out.println("** Getting locator: " + getLocator("username"));
	}
}
