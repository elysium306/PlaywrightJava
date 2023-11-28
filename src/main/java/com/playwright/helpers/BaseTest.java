package com.playwright.helpers;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.playwright.etsy.pages.HomePage;
import com.playwright.utilities.PlaywrightFactory;

public class BaseTest {

	protected Page page;

	protected HomePage homePage;

	@BeforeTest
	public void setup() {
		page = PlaywrightFactory.initPlaywright("chrome");
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
