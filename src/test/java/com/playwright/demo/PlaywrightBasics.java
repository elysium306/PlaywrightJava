package com.playwright.demo;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class PlaywrightBasics {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private APIRequest request;
    private APIRequestContext requestContext;
    private Page page;

    public static void main(String[] args) {

        System.out.println(Paths.get("chrome.exe"));
    }

    @Test
    public void loginApplication() {
//		String baseURL = PropertyReader.getProperty("baseURL");

        page.navigate("https://www.google.com");
        String title = page.title();
        System.out.println("*** Current title: " + title);
        assertEquals(page.title(), "Google");
    }

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();
        LaunchOptions option = new LaunchOptions();
        option.setHeadless(false);
        option.setExecutablePath(Path.of("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"));
        browser = playwright.chromium().launch(option);
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }

}
