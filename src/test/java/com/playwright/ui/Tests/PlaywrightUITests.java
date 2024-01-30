package com.playwright.ui.Tests;

import static org.testng.Assert.assertNotNull;

import java.util.Properties;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.playwright.ui.Base.PlaywrightFactory;
import com.playwright.utilities.PropertyReader;

public class PlaywrightUITests {

	private Properties prop;

	@Test
	public void test1() {
		Page page = PlaywrightFactory.initPlaywright(prop);

		// navigate to etsy.com
//		page.navigate("https://www.etsy.com");
		page.navigate(PropertyReader.getProperty("playwright_home"));
		System.out.println(page.title());
		assertNotNull(page.title(), "Assert Title Is Not Null");
	}

}
