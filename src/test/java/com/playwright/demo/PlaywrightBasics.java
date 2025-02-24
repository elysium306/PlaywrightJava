package com.playwright.demo;

import static org.testng.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

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

	@Test
	public void loginApplication() {
//		String baseURL = PropertyReader.getProperty("baseURL");

		page.navigate("https://www.google.com");
		String title = page.title();
		System.out.println("*** Current title: " + title);
		assertEquals(page.title(), "Google");
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

	@AfterMethod
	public void tearDown() {
		page.close();
		browserContext.close();
		browser.close();
		playwright.close();
	}

}
