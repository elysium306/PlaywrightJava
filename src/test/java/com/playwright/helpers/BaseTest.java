package com.playwright.helpers;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.playwright.ui.pages.HomePage;
import com.playwright.utilities.PlaywrightFactory;

public class BaseTest {

	Page page;

	protected Properties prop;

	protected HomePage homePage;

	@BeforeTest
	public void setup() {
		prop = PlaywrightFactory.initProp();
		page = PlaywrightFactory.initPlaywright(prop);
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
