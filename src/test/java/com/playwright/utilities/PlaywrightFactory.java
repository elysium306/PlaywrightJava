package com.playwright.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	private static final Playwright playwright;

	// Initiate UI Component
	private static Browser browser;
	private static BrowserContext browserContext;
	private static Page page;

	// Initiate API Component
	private static final APIRequest request;
	private static final APIRequestContext requestContext;

	private static Properties prop;

	// JSON Parser Initiation
	protected static ObjectMapper objectMapper;

	static {
		playwright = Playwright.create();
		request = playwright.request();
		requestContext = request.newContext();
	}

	public static Page initPlaywright(Properties prop) {

		prop = initProp();

		String browserName = prop.getProperty("browser").trim();
		System.out.printf("Browser Name: %s%n", prop.getProperty("browser"));

		switch (browserName) {
		case "chromium" -> browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setArgs(List.of("--start-maximized")).setHeadless(false));
		case "firefox" -> browser = playwright.firefox()
				.launch(new BrowserType.LaunchOptions().setArgs(List.of("--start-maximized")).setHeadless(false));
		case "safari" -> browser = playwright.webkit()
				.launch(new BrowserType.LaunchOptions().setArgs(List.of("--start-maximized")).setHeadless(false));
		case "chrome" -> browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome")
				.setArgs(List.of("--start-maximized")).setHeadless(false));
		default -> System.out.println("Please Provide A Valid Browser Name ...");
		}

		browserContext = browser.newContext();
		page = browserContext.newPage();

		return page;
	}

	public static Properties initProp() {
		prop = new Properties();
//        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\configuration.properties";
		Path path = Path.of(System.getProperty("user.dir", "/src/main/resources/properties/config.properties"));
		File file = new File(path.toUri());
		try {
			InputStream inputStream = new FileInputStream(file);
			prop.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.printf("** FileNotFoundException: %n", e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.printf("** IOException: %n", e);
			e.printStackTrace();
		}
		return prop;
	}

	public static APIRequestContext getRequest() {
		return requestContext;
	}

	public static ObjectMapper getMapper() {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return objectMapper;
	}
	
	public static void main(String[] args) {
		Path path = Path.of(System.getProperty("user.dir", "/src/main/resources/properties/config.properties"));
		System.out.println(path.toString());
	}
}
