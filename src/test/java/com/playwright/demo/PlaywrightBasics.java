package com.playwright.demo;

import static org.testng.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

	private Playwright playwright;

	private Browser browser;

	private BrowserContext context;

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
		context = browser.newContext();
		page = context.newPage();
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
		context.close();
		browser.close();
		playwright.close();
	}

}
