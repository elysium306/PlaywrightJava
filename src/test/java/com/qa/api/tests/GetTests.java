package com.qa.api.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class GetTests {
	private static Playwright playwright;

	@Test(description = "GET API Test")
	public void getTest() {
		playwright = Playwright.create();
		APIRequestContext request = playwright.request().newContext();
		APIResponse response = request.get("");
		System.out.println(response.body().toString());
	}

	@Test(description = "POST API Test")
	public void postTest() {
		playwright = Playwright.create();
		APIRequestContext request = playwright.request().newContext();

		// Create JSON body
		Map<String, Object> jsonData = new HashMap<>();
		jsonData.put("key", "value");

		RequestOptions options = RequestOptions.create();
		options.setData(new Object[] {});

		APIResponse response = request.post("", options);

		System.out.println(response.body().toString());
	}

	@Test(description = "PUT API Test")
	public void putTest() {
		playwright = Playwright.create();
		APIRequestContext request = playwright.request().newContext();

		Map<String, Object> jsonBody = new HashMap<>();
		jsonBody.put("key", "value");

		RequestOptions options = RequestOptions.create();
		options.setData(new Object[] {});

		APIResponse response = request.put("", options);

		System.out.println(response.body().toString());
	}

	@Test(description = "DELETE API Test")
	public void deleteTest() {
		playwright = Playwright.create();
		APIRequestContext request = playwright.request().newContext();

		RequestOptions options = RequestOptions.create();
		options.setData(new Object[] {});

		APIResponse response = request.delete("", options);

		System.out.println(response.body().toString());
	}

}
