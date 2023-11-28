package com.playwright.demo;

import static org.testng.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

//import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo2 {
	// Shared between all tests in this class
	static Playwright playwright;
	static Browser browser;

	// New instance for each test method:
	BrowserContext context;
	Page page;

	@BeforeAll
	static void launchBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	}

	@AfterAll
	static void closeBrowser() {
		playwright.close();
	}

	@BeforeEach
	void createContextAndPage() {
		context = browser.newContext();
	}

	@AfterEach
	void closeContext() {
		context.close();
	}

	@Test
	void shouldClickButton() {
		page.navigate("http://www.playwright.dev");
		page.locator("[class='getStarted_Sjon']").click();
		assertEquals("Clicked", page.evaluate("result"));
	}
}
