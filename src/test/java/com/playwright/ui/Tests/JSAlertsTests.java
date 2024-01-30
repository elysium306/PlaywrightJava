package com.playwright.ui.Tests;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class JSAlertsTests {

	private Playwright playwright;
	private Browser browser;
	private BrowserContext context;
	private Page page;

	@BeforeMethod
	public void setup() {
		playwright = Playwright.create();
		browser = playwright.chromium()
				.launch(new LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
		context = browser.newContext();
		page = context.newPage();
	}

//	@Test(description = "Verify Click for JS Confirm", alwaysRun = true)
//	public void confirmAlert() {
//		page.navigate("https://the-internet.herokuapp.com/");
//		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JavaScript Alerts")).click();
//		page.onceDialog(dialog -> {
//			System.out.println(String.format("Dialog message: %s", dialog.message()));
//			dialog.dismiss();
//		});
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Alert")).click();
//		String confirm_message = page.getByText("You successfully clicked an alert").textContent();
//		assertEquals(confirm_message, "You successfully clicked an alert");
//	}

//	@Test(description = "Verify Click for JS Confirm")
//	public void acceptAlert() {
//		page.navigate("https://the-internet.herokuapp.com");
//		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JavaScript Alerts")).click();
//		page.onceDialog(dialog -> {
//			System.out.println(String.format("Dialog message: %s", dialog.message()));
//			dialog.dismiss();
//		});
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
//		String confirm_message = page.getByText("You clicked: Ok").textContent();
//		assertEquals(confirm_message, "You clicked: ok");
//	}

	@Test(description = "Verify JavaScript Alerts")
	public void promptAlert() {
		page.navigate("https://the-internet.herokuapp.com");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JavaScript Alerts")).click();
		page.onceDialog(dialog -> {
			System.out.println(String.format("Dialog message: %s", dialog.message()));
			dialog.dismiss();
		});
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Prompt")).click();

		page.onDialog(dialog -> {
			System.out.println(String.format("Dialog message: %s", dialog.message()));
			dialog.accept("test text");
		});

//		page.onceDialog(dialog -> {
//			
//			System.out.println(String.format("Dialog message: %s", dialog.message()));
//			dialog.accept("playwright");
//		});
		page.getByText("You entered: playwright").click();
		String confirm_message = page.getByText("You entered: playwright").textContent();
		assertEquals(confirm_message, "You entered: playwright");
	}

	@AfterMethod
	public void tearDown() {
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}
}