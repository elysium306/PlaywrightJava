package com.playwright.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private static File config;

	private static Properties properties = new Properties();

	private static FileInputStream fis;

	private static String filePath;

	public static String getProperty(String key) {
		filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\configuration.properties";
		System.out.println("*** configuration.properties: " + filePath);
		String value = "";

		try {
			config = new File(filePath);
			fis = new FileInputStream(config);
			properties.load(fis);
			value = properties.getProperty(key);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return value;
	}
	
	public static String getLocator(String key) {
		// /PlaywrightDemo/src/main/resources/properties/locators.properties
		filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\locators.properties";
		System.out.println("*** locator.properties: " + filePath);
		String value = "";

		try {
			config = new File(filePath);
			fis = new FileInputStream(config);
			properties.load(fis);
			value = properties.getProperty(key);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return value;
	}

	public static void main(String[] args) {

		System.out.println("## Getting property: " + getProperty("playwright_home"));
		System.out.println("** Getting locator: " + getLocator("username"));
	}
}
