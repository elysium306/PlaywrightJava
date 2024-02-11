package com.playwright.ui.Tests;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class LoginTest {

	@Test
	public void loginTest() {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://the-internet.herokuapp.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Basic Auth")).click();
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		String text = page.getByText("Congratulations! You must have the proper credentials.").textContent();
		assertNotNull(page.title());
		assertNotNull(text);
	}

}
