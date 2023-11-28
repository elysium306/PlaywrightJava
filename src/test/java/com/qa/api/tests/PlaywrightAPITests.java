package com.qa.api.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class PlaywrightAPITests {

	private Playwright playwright;
	private APIRequest request;
	private APIRequestContext requestContext;

	@BeforeTest
	public void setup() {
		playwright = Playwright.create();
		request = playwright.request();
		requestContext = request.newContext();
	}

	@AfterTest
	public void tearDown() {
		requestContext.dispose();
		playwright.close();
	}

	@Test(dataProvider = "testData", alwaysRun = false)
	public void getUsersAPI(int userID) throws IOException {
		try (Playwright playwright = Playwright.create()) {
			APIRequest getRequest = playwright.request();
			APIRequestContext requestContext = getRequest.newContext();
			APIResponse getResponse = requestContext.get("https://gorest.co.in/public/v2/users/" + userID);
			int getStatusCode = getResponse.status();
			String getStatusMessage = getResponse.statusText();
			byte[] resBody = getResponse.body();
			ObjectMapper objMapper = new ObjectMapper();
			JsonNode responseBody = objMapper.readTree(resBody);
			System.out.println(String.format("Status Code: %d :: Status Message %s", getStatusCode, getStatusMessage));
			System.out.println("### Display Each User Info: " + responseBody.toPrettyString());
			getResponse.dispose(); // If not disposed, the response will stay in the memory, memory pollution
		}
	}

	@Test(description = "This is GET users request", alwaysRun = false)
	public void getUsers() throws IOException {
		try (Playwright playwright = Playwright.create()) {
			APIRequest getRequest = playwright.request();
			APIRequestContext requestContext = getRequest.newContext();
			APIResponse getResponse = requestContext.get("https://gorest.co.in/public/v2/users");
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode responseBody = objectMapper.readTree(getResponse.body());
			System.out.println("*** Printing GET Response: " + responseBody.toPrettyString());
			getResponse.dispose(); // If not disposed, the response will stay in the memory, memory pollution
		}
	}

	@Test(description = "getUsersAPI()")
	public void getUsersAPI() {
		try (Playwright playwright = Playwright.create()) {
			APIRequest request = playwright.request();
			APIRequestContext reqContext = request.newContext();
			APIResponse response = reqContext.get("https://reqres.in/api/users?page=2");
			System.out.println("API Response: " + response.text());

			byte[] responseBody = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				System.out.println(objectMapper.readTree(response.body()).textValue());
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

			Map<String, String> responseHeaders = response.headers();
			responseHeaders.forEach((k, v) -> System.out.println(k + " : " + v));

			assertEquals(responseHeaders.get("content-type"), "application/json; charset=utf-8", "Assert Content Type");
			assertEquals(response.ok(), true, "Assert that the response status should be 'Ok'");

			response.dispose();
			playwright.close();
		}
	}

	@Test
	public void getUser() {
		APIResponse response = requestContext.get("https://reqres.in/",
				RequestOptions.create()
					.setQueryParam("page", 2)
					.setQueryParam("id", 8)
		);
		System.out.println(requestContext.toString());
		System.out.println(response.text());
		assertEquals(response.ok(), true);
		assertThat(response).isOK();
		response.dispose();
		try {
			System.out.println("### RESPONSE.TEXT(): >>> " + response.text());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@DataProvider(name = "testData")
	public Integer[] userData() {
		return new Integer[] { 5746768, 5746765, 5746773, 5746762 };
	}

}
