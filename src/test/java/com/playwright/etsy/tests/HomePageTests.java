package com.playwright.etsy.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.playwright.etsy.pages.HomePage;
import com.playwright.helpers.AppConstants;
import com.playwright.helpers.BaseTest;

public class HomePageTests extends BaseTest {

	private Page page;

	@Test
	public void login_test() {
		homePage = new HomePage(page);
		homePage.login();
		String actualHomePageTitle = homePage.getHomePageTitle();
		assertEquals(actualHomePageTitle, AppConstants.LANDING_PAGE_TITLE);
	}

	@Test(dataProvider = "productList")
	public void search_test(String productName) {
		homePage = new HomePage(page);
		System.out.println(String.format("Searching for Product: %s", productName));
		homePage.searchForProduct(productName);
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
