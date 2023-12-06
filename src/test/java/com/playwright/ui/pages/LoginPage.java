package com.playwright.ui.pages;

import java.util.Properties;

import com.microsoft.playwright.Page;
import com.playwright.utilities.PlaywrightFactory;

public class LoginPage {

	Page page;
	Properties prop = PlaywrightFactory.initProp();

	// 1. String locators - OR
	

	// 2. Page Constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	// 3. Page Actions/Methods


	public String getLoginPageTitle() {
		return page.title();
	}

	public String getLoginPageURL() {
		return page.url();
	}


}
