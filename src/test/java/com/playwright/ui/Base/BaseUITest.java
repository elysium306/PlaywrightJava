package com.playwright.ui.Base;

import com.microsoft.playwright.Page;
import com.playwright.helpers.PlaywrightFactory;
import com.playwright.ui.Pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseUITest {

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
