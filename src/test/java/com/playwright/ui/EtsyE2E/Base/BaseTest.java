package com.playwright.ui.EtsyE2E.Base;

import java.util.Properties;

import com.playwright.utilities.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.playwright.ui.EtsyE2E.Pages.HomePage;

public class BaseTest {

	protected Page page;

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
