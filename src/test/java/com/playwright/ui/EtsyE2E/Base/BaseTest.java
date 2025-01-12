package com.playwright.ui.EtsyE2E.Base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.playwright.ui.EtsyE2E.Pages.HomePage;
import com.playwright.utilities.PlaywrightFactory;

public class BaseTest {

	protected Page page;

	protected Properties prop;

	protected HomePage homePage;

	@BeforeTest
	public void setup() {
		prop = PlaywrightFactory.initProp();
		System.out.println("Is <prop> null? " + prop.equals(null));
		page = PlaywrightFactory.initPlaywright(prop);
		System.out.println("Is <page> null? " + page.equals(null));
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
