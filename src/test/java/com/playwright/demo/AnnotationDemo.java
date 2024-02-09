package com.playwright.demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AnnotationDemo {
	// Shared between all tests in this class
	static Playwright playwright;
	static Browser browser;

	// New instance for each test method:
	static BrowserContext context;
	static Page page;

	@BeforeSuite
	static void launchBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page =  browser.newPage();
	}

	@AfterSuite
	static void closeBrowser() {
		playwright.close();
	}

	@BeforeMethod
	void createContextAndPage() {
		context = browser.newContext();
	}

	@AfterMethod
	void closeContext() {
		context.close();
	}

	@Test
	void shouldClickButton() {
		page.navigate("https://playwright.dev/");
		page.locator("[class='getStarted_Sjon']").click();
		String currentURL = page.url();
		System.out.println(currentURL);
		assertEquals("Clicked", page.evaluate("result"));
	}
}
