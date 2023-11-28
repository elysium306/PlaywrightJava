package com.playwright.etsy.pages;

import java.util.Properties;

import com.microsoft.playwright.Page;
import com.playwright.utilities.PlaywrightFactory;

public class HomePage {

	protected Page page;

	protected Properties prop = PlaywrightFactory.initProp();

	// 1. Login locators - OR
	private String login_button = "//button[normalize-space()='Sign in']";
	private String email_box = "//input[@id='join_neu_email_field']";
	private String password = "//input[@id='join_neu_password_field']";
	private String stay_signed_in = "//label[normalize-space()='Stay signed in']";
	private String submit_button = "//button[@name='submit_attempt']";

	// Search Related
	private String search_box = "#global-enhancements-search-query";
	private String search_icon = "//button[@value='Search']";

	// 2. page constructor:
	public HomePage(Page page) {
		this.page = page;
	}

	// 3. page methods/actions
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println(String.format("Page Title: %s", title));
		return title;
	}

	public String getHomePageURL() {
		String url = page.url();
		System.out.println(String.format("Page URL: %s", url));
		return url;
	}

	public String searchForProduct(String productName) {
		System.out.println(String.format("** Searching for product: %s", productName));
		page.fill(search_box, productName);
		page.click(search_icon);
		String searchPageTitle = page.title();
		return searchPageTitle;
	}

	public LoginPage login() {
		page.click(login_button);
		page.fill(email_box, prop.getProperty("usrname"));
		page.fill(password, prop.getProperty("psword"));
		page.click(submit_button);
		if (!page.isChecked(stay_signed_in)) {
			System.out.println("'Stay Signed In' is NOT checked");
			page.click(stay_signed_in);
		}
		return new LoginPage(page);
	}

}
