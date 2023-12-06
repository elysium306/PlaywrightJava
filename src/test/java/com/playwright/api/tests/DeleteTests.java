package com.playwright.api.tests;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.playwright.utilities.BaseAPITest;

public class DeleteTests extends BaseAPITest {
	APIRequestContext requestContext;
	APIResponse response;

	@Test
	public void deleteUserTest() {
		requestContext = getRequest();
		response = requestContext.delete("");
		assertThat(response).isOK();
		
		
	}
}
