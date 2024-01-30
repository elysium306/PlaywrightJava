package com.playwright.api.Tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;

public class PostTests extends BaseAPITest{
	
	APIRequestContext requestContext;
	APIResponse postResponse;

	@Test
	public void deleteUserTest() {
		requestContext = getRequest();
		postResponse = requestContext.post("");
		
		// Assert
		assertThat(postResponse).isOK();
	}

}
