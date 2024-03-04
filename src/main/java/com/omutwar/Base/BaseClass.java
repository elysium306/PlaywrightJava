package com.omutwar.Base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass {

    protected Playwright playwright = Playwright.create();
    protected Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
    protected Page page;

//	public BaseClass(Page page, String browserType) {
//		this.page = page;
//		
//	}

    void openApplication(Page page, String url) {
        page = browser.newPage();
        page.navigate(url);
    }

}
