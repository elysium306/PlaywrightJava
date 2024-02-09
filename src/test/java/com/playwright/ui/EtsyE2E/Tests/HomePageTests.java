package com.playwright.ui.EtsyE2E.Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.playwright.ui.EtsyE2E.Base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.playwright.helpers.AppConstants;

public class HomePageTests extends BaseTest {

	@Test(priority = 1)
	public void login_test() {
		
		homePage.login();
		String actualHomePageTitle = homePage.getHomePageTitle();
		assertEquals(actualHomePageTitle, AppConstants.ETSY_LOGIN_PAGE_TITLE);
	}

	@Test(dataProvider = "productList", priority = 2, dependsOnMethods = "login_test")
	public void search_test(String productName) {
		System.out.printf("Searching for Product: %s%n", productName);
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
