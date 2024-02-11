package com.playwright.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.playwright.utilities.PropertyReader;

public class PlaywrightBasic {

	private static Playwright playwright;

	private static Browser browser;

	private static final Map<String, String> site_info = new HashMap<>();

	public static void main(String[] args) {

		// Create Playwright object
		playwright = Playwright.create();

		// Setup LaunchOptions
		LaunchOptions options = new LaunchOptions();
		options.setChannel("chromium");
//		options.setChannel("chrome-beta");
//		options.setChannel("msedge");
//		options.setChannel("msedge-beta");
//		options.setChannel("msedge-dev");
		options.setHeadless(false);

		// Create Browser object
		browser = playwright.chromium().launch(options);
//		browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
//		browser = playwright.webkit().launch();

		// Create Page Object
		Page page = browser.newPage();
		page.navigate(PropertyReader.getProperty("amazon_home"));

		String title = page.title();
		assertNotNull(title);
		System.out.println(title);

		String url = page.url();
		site_info.put(title, url);
		assertEquals(url, PropertyReader.getProperty("amazon_home"));
		System.out.println(url);

		browser.close();
		playwright.close();

	}

	@BeforeTest
	public void setup() {
		// Create Playwright object
		playwright = Playwright.create();

		// Create Browser object
		browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("msedge"));
	}

	@Test(description = "Validate Playwright Home Page is Displaying the Title Properly")
	public void playwrightHomeTest() {
		Page page1 = browser.newPage();

		// Go to Playwright home page and get the title
		page1.navigate(PropertyReader.getProperty("playwright_home"));
		String page1_title = page1.title();
		assertNotNull(page1_title);
		System.out.println(page1_title);
		System.out.println(page1.url());
		assertEquals(page1.url(), "https://playwright.dev/");
		site_info.put("test1", page1_title);
		site_info.put("test2", page1_title);
		page1.close();
	}

	@Test(description = "Verify That Etsy Homepage is Displaying Title Properly")
	public void etsyHomeTest() {
		Page page2 = browser.newPage();

		// Go to Etsy eCommerse website and get the title
		page2.navigate(PropertyReader.getProperty("etsy_home"));
		String page2_title = page2.title();
		assertNotNull(page2_title);

		System.out.println(page2_title);
		System.out.println(page2.url());
		site_info.put("test3", page2_title);
		assertEquals(page2.url(), "https://www.etsy.com/");

		page2.close();
	}

	@AfterTest
	public void tearDown() {
		browser.close();
		playwright.close();
		site_info.forEach((key, value) -> System.out.println(key + " :: " + value));
	}
	/**
	 * Playwright hierarchy: create Playwright object --> Browser object --> Page
	 * object -->
	 */

}
