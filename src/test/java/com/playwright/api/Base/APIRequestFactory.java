package com.playwright.api.Base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

public class APIRequestFactory {
	
	private static final Playwright playwright;
	private static final APIRequest request;
	private static final APIRequestContext requestContext;
	protected static ObjectMapper objectMapper;
	
	static {
		playwright = Playwright.create();
		request = playwright.request();
		requestContext = request.newContext();
	}

	public static APIRequestContext getRequest() {
		return requestContext;
	}
	
	public static ObjectMapper getMapper() {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return objectMapper;
	}
}
