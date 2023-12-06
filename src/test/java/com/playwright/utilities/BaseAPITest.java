package com.playwright.utilities;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
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
		if(requestContext == null) {
			requestContext = request.newContext();
		}
		return request.newContext();
	}
	
	public static JsonNode getJsonNode(APIResponse response) {
		ObjectMapper om = new ObjectMapper();
		JsonNode jsonNode = null;
		try {
			jsonNode = om.readTree(response.body());
			System.out.println(jsonNode.toPrettyString());
		} catch (IOException e) {
			System.out.println(String.format("*** Initializing JsonNode Object Failed: ", e));
			e.printStackTrace();
		}
		return jsonNode;
	}

	public static int getJsonResponseBodysize(APIResponse response) {
		return getJsonNode(response).size();
	}
}
