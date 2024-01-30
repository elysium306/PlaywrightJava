package com.playwright.helpers;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class PlaywrightFactory {

	private static final Playwright playwright;

	// Initiate UI Component
	private static Browser browser;

    // Initiate API Component
	private static final APIRequest request;
	private static final APIRequestContext requestContext;

    private static Properties prop;

	static {
		// Playwright initialize
		playwright = Playwright.create();
		request = playwright.request();
		requestContext = request.newContext();
	}

	public static Page initPlaywright(Properties prop) {

		prop = initProp();

		String browserName = prop.getProperty("browser").trim();
		System.out.printf("Browser Name: %s%n", prop.getProperty("browser"));

		switch (browserName) {
		case "chromium":
			browser = playwright.chromium().launch(
					new BrowserType.LaunchOptions().setArgs(List.of("--start-maximized")).setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(
					new BrowserType.LaunchOptions().setArgs(List.of("--start-maximized")).setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(
					new BrowserType.LaunchOptions().setArgs(List.of("--start-maximized")).setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome")
					.setArgs(List.of("--start-maximized")).setHeadless(false));
			break;
		default:
			System.out.println("Please Provide A Valid Browser Name ...");
			break;
		}

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

		System.out.printf("** Opening Website: %s%n", prop.getProperty("etsy_home").trim());
		page.navigate(prop.getProperty("etsy_home"));

		return page;
	}



	public static Properties initProp() {
		String filePath = System.getProperty("user.dir")
				+ "/src/main/resources/properties/configuration.properties";
		try {
            InputStream inputStream = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(inputStream);
		} catch (IOException e) {
			System.out.printf("** IOException: %n", e);
			e.printStackTrace();
		}
		return prop;
	}

	public static APIRequestContext getRequest() {
		return requestContext;
	}

}
