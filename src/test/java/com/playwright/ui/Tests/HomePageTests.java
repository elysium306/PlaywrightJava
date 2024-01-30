package com.playwright.ui.Tests;

import com.playwright.helpers.AppConstants;
import com.playwright.ui.Base.BaseUITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTests extends BaseUITest {

	@Test(priority = 1)
	public void login_test() {
		homePage.login();
		String actualHomePageTitle = homePage.getHomePageTitle();
		assertEquals(actualHomePageTitle, AppConstants.ETSY_LOGIN_PAGE_TITLE);
	}

	@Test(dataProvider = "productList", priority = 2)
	public void search_test(String productName) {
		System.out.printf("Searching for Product: %s%n", productName);
		homePage.searchForProduct(productName);
		String actualTitle = homePage.getHomePageTitle();
		assertTrue(actualTitle.toLowerCase().contains(productName.toLowerCase()), "Assert that the search web title contains product name");
	}
	
	@DataProvider
	public Object[][] productList(){
		return new Object[][] {
			{"cute mug"},
			{"ugly mug"},
			{"pretty mug"}
		};
	}

}
