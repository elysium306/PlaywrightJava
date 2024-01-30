package com.playwright.api.Base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.playwright.helpers.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseAPITest {
	protected APIRequestContext requestContext;
    protected APIResponse response;

    protected static ObjectMapper objectMapper;
    protected JsonNode jsonResponse;

    @BeforeTest
    public void setup(){
        requestContext = PlaywrightFactory.getRequest();
    }


	@AfterTest
    public void teardown(){
        requestContext.dispose();
    }

    public static ObjectMapper getMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }
}
