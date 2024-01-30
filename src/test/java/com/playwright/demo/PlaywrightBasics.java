package com.playwright.demo;

import static org.testng.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightBasics {

	private Playwright playwright;

	private Browser browser;

	private BrowserContext browserContext;

	private APIRequest request;

	private APIRequestContext requestContext;

	private Page page;

	public static void main(String[] args) {
		
		System.out.println(Paths.get("chrome.exe"));
	}

	@BeforeMethod
	public void setup() {
		playwright = Playwright.create();
		LaunchOptions option = new LaunchOptions();
		option.setHeadless(false);
		option.setExecutablePath(Path.of("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"));
		browser = playwright.chromium().launch(option);
		browserContext = browser.newContext();
		page = browserContext.newPage();
	}

	@Test
	public void loginApplication() {
//		String baseURL = PropertyReader.getProperty("baseURL");

		page.navigate("https://www.google.com");
		assertEquals(page.title(), "Google");
	}

	@AfterMethod
	public void tearDown() {
		page.close();
		browserContext.close();
		browser.close();
		playwright.close();
	}

}
