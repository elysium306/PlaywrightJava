package com.playwright.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;


public class PlaywrightFactory {

    private static final Playwright playwright;

    // Initiate UI Component
    private static Browser browser;

    // Initiate API Component
    private static final APIRequest request;
    private static final APIRequestContext requestContext;

    private static Properties prop;

    // JSON Parser Initiation
    protected static ObjectMapper objectMapper;

    static {
        playwright = Playwright.create();
        request = playwright.request();
        requestContext = request.newContext();
    }

    public static Page initPlaywright(Properties prop) {

        prop = initProp();

        String browserName = prop.getProperty("browser").trim();
        System.out.printf("Browser Name: %s%n", prop.getProperty("browser"));

        switch (browserName) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setArgs(List.of("--start-maximized")).setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setArgs(List.of("--start-maximized")).setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setArgs(List.of("--start-maximized")).setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setArgs(List.of("--start-maximized")).setHeadless(false));
                break;
            default:
                System.out.println("Please Provide A Valid Browser Name ...");
                break;
        }

        BrowserContext browserContext = browser.newContext();

        return browserContext.newPage();
    }

    public static Properties initProp() {
        Path filePath = Paths.get(System.getProperty("user.dir"), "/src/main/resources/properties/configuration.properties");
        try {
            InputStream inputStream = new FileInputStream(filePath.toString());
            prop = new Properties();
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.printf("** FileNotFoundException: %n", e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.printf("** IOException: %n", e);
            e.printStackTrace();
        }
        return prop;
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
