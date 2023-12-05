package com.playwright.api.tests;


import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class FetchTests extends BaseAPITest {
	
		@Test
		public void fetchRequest1() {
			APIRequestContext request = BaseAPITest.getRequest();
			APIResponse getResponse = request.get("https://www.google.com");
			assertThat(getResponse).isOK();
		}
		
		@Test
		public void fetRequest2() {
			APIRequestContext request = BaseAPITest.getRequest();
			APIResponse response = request.get("https://www.yahoo.com");
			assertThat(response).isOK();
		}

}
