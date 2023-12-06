package com.playwright.ui.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.playwright.helpers.AppConstants;
import com.playwright.helpers.BaseTest;

public class HomePageTests extends BaseTest {

	@Test(priority = 1)
	public void login_test() {
		
		homePage.login();
		String actualHomePageTitle = homePage.getHomePageTitle();
		assertEquals(actualHomePageTitle, AppConstants.ETSY_LOGIN_PAGE_TITLE);
	}

	@Test(dataProvider = "productList", priority = 2, dependsOnMethods = "login_test")
	public void search_test(String productName) {
		System.out.println(String.format("Searching for Product: %s", productName));
		homePage.searchForProduct(productName);
		String actualTitle = homePage.getHomePageTitle();
		assertTrue(actualTitle.toLowerCase().contains(productName.toLowerCase()), "Assert that the search web title contains product name");
	}
	
	@DataProvider
	public Object[][] productList(){
		return new Object[][] {
//			{"cute mug"},
			{"ugly mug"},
//			{"pretty mug"}
		};
	}

}
