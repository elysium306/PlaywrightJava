package com.qa.api.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

public class BaseAPITest {
	
	private static Playwright playwright;
	private static APIRequest request;
	private static APIRequestContext requestContext;
	
	@BeforeTest
	public void setup() {
		playwright = Playwright.create();
		request = playwright.request();
	}
	
	@AfterTest
	public void tearDown() {
		requestContext.dispose();
		playwright.close();
	}

	public static APIRequestContext getRequest() {
		return request.newContext();
	}

}
