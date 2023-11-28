package com.playwright.pages;

import com.microsoft.playwright.Page;
import com.playwright.utilities.PlaywrightFactory;

public class PlaywrightHome {

	private Page page;

	// 1. String locators _
	private String get_Started = "getStarted_Sjon";

	private String playwright_title = "a b.navbar__title";

	private String docs = "header div div a[href='/docs/intro']:first-child";

	// 2. Need to create constructor
	public PlaywrightHome(String browserName) {
		this.page = PlaywrightFactory.initPlaywright(browserName);
	}
	
	// 3. Page actions/methods
	public String getHomePageTitle() {
		return page.title();
	}
	
	public String getHomePageURL() {
		return page.url();
	}
	
	public void search(String productName) {
		page.fill(docs, productName);
		page.click(get_Started);
	}

}
