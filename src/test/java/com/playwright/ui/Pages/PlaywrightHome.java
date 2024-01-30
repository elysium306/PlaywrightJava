package com.playwright.ui.Pages;

import java.util.Properties;

import com.microsoft.playwright.Page;
import com.playwright.ui.Base.PlaywrightFactory;

public class PlaywrightHome {

	protected Page page;
	protected Properties prop;

	// 1. String locators _
	private final String get_Started = "getStarted_Sjon";
	private final String docs = "header div div a[href='/docs/intro']:first-child";

	// 2. Need to create constructor
	public PlaywrightHome(String browserName) {
		this.page = PlaywrightFactory.initPlaywright(prop);
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
