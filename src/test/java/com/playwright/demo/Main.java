package com.playwright.demo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        LaunchBrowserAndGetTitle();
        PageWindowMaximize();
    }

    public static void LaunchBrowserAndGetTitle() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("msedge")
                        // // this is just a workaround may not work well all the scenarios
                        .setArgs(Arrays.asList("--start-maximized")
                        )
        );
        Page page = browser.newPage();

        // go to the test site
        page.navigate("https://www.yahoo.com");
        System.out.println("*** Current Title: [" + page.title() + "]");

        // closing the instances
        page.close();
        browser.close();
        playwright.close();
    }

    public static void PageWindowMaximize() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setChannel("msedge")
            );
            Page page = browser.newPage(new Browser.NewPageOptions().setViewportSize(1080, 1920));

            // Your code here...
            page.navigate("https://www.yahoo.com");
            System.out.println("*** Current Title: [" + page.title() + "]");

            // closing the instances
            page.close();
            browser.close();
        }
    }

}
