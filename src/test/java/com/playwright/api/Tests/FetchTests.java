package com.playwright.api.Tests;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;

public class FetchTests extends BaseAPITest {
	APIRequest request;
	APIRequestContext requestContext;
	
		@Test
		public void fetchRequest1() {
			requestContext = BaseAPITest.getRequest();
			APIResponse getResponse = requestContext.get("https://www.google.com");
			assertThat(getResponse).isOK();
		}
		
		@Test
		public void fetRequest2() {
			requestContext = BaseAPITest.getRequest();
			APIResponse response = requestContext.get("https://www.yahoo.com");
			assertThat(response).isOK();
		}

}
