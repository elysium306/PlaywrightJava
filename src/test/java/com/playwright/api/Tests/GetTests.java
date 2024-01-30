package com.playwright.api.Tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.HttpHeader;
import com.microsoft.playwright.options.RequestOptions;
import com.playwright.helpers.AppConstants;
import com.playwright.api.Base.APIRequestFactory;
import com.playwright.ui.Base.PlaywrightFactory;

public class GetTests extends BaseAPITest {
	private static Map<String, String> headersMap;

	APIRequestContext requestContext;
	APIResponse response;
	ObjectMapper objectMapper;
	JsonNode jsonResponse;

	@Test(description = "GET API Test")
	public void getTest() {
		APIRequestContext request = PlaywrightFactory.getRequest();
		APIResponse response = request.get("https://reqres.in/api/users?page=2");
		System.out.println(response.body().toString());

		// Parse API JSON Response:
		JsonNode jsonResponse = getJsonNode(response);
		System.out.println("----Printing JSON Body As Pretty Json Response----");
		System.out.println(jsonResponse.toPrettyString());
		System.out.println("----Printing JSON Response Size----");
		System.out.println(getJsonResponseBodysize(response));
	}

	@Test(description = "POST API Test")
	public void postTest() {
		APIRequestContext request = PlaywrightFactory.getRequest();

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
		requestContext = PlaywrightFactory.getRequest();
		Map<String, Object> jsonBody = new HashMap<>();
		jsonBody.put("key", "value");

		RequestOptions options = RequestOptions.create();
		options.setData(new Object[] {});

		APIResponse response = requestContext.put("", options);

		System.out.println(response.body().toString());
	}

	@Test(description = "DELETE API Test")
	public void deleteTest() {
		APIRequestContext requestContext = PlaywrightFactory.getRequest();

		RequestOptions options = RequestOptions.create();
		options.setData(new Object[] {});

		APIResponse response = requestContext.delete("", options);

		System.out.println(response.body().toString());
	}

	@Test
	public void getAllUsers() throws IOException {
		requestContext = APIRequestFactory.getRequest();
		response = requestContext.get("https://reqres.in/api/users?page=2");

		// Create ObjectMapper instance
		objectMapper = APIRequestFactory.getMapper();
		jsonResponse = objectMapper.readTree(response.body());

		System.out.println("----Printing GET Response Body----");
		System.out.println(jsonResponse.toPrettyString());

		System.out.println("----Printing GET Response Status Message----");
//		System.out.println("** Response Body: " + response.statusText());
		assertEquals(response.statusText(), AppConstants.GET_STATUS_CODE, "Verify GET Call Status Message");
		assertThat(response).isOK();

		System.out.println("----Printing GET API Call Endpoint URL----");
		System.out.println(response.url());

		// Get the response headers in Map format
		System.out.println("----Print key and value of the Headers Map----");
		headersMap = response.headers();
		System.out.printf("Size of the header: %d\nContent-type: %s\nserver: %s\n=====================\n",
				headersMap.size(), headersMap.get("content-type"), headersMap.get("server"));
		headersMap.forEach((k, v) -> System.out.println(k + " :: " + v));
		assertEquals(headersMap.get("content-type"), AppConstants.CONTENT_TYPE, "Verify the content-type");
		assertEquals(headersMap.get("x-powered-by"), AppConstants.X_POWERED_BY, "Verify x-powered-by Value");
		assertEquals(headersMap.get("server"), AppConstants.SERVER, "Assert that the server type is cloudflare");

		System.out.println("----Print each value of the headers list----");
		List<HttpHeader> headerList = response.headersArray();
		headerList.forEach(s -> System.out.println(s.name));
		System.out.println("----Getting each value using key of the headersMap");
		for (String key : headersMap.keySet()) {
			System.out.println(key + " : " + headersMap.get(key));
		}
	}

}
