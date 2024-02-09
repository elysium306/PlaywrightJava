package com.playwright.demo.Day2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.omutwar.Base.BaseClass;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DemoTest extends BaseClass {

    String testSite = "http://playwright.dev";
//	public static void main(String[] args) {
//		try (Playwright playwright = Playwright.create()) {
//			Browser browser = playwright.chromium().launch();
//			Page page = browser.newPage();
//			page.navigate("http://playwright.dev");
//			System.out.println(page.title());
//		}
//	}

    @Test
    public void test1() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            );
            Page page = browser.newPage();
            page.navigate(testSite);
            System.out.println("*** Current Web Title: [%-8s]".formatted(page.title()));
        }
    }

    @Test
    public void test2() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));

            // create a locator
            Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));

            // Expect an attribute "to be strictly equal" to the value.
            assertThat(getStarted).hasAttribute("href", "/docs/intro");

            // Click the get started link.
            getStarted.click();

            // Expects page to have a heading with the name of Installation.
            assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Installation"))).isVisible();
        }
    }

    @Test(description = "This is test3:: without using 'try' block")
    public void test3() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://playwright.dev");

        // Expect a title "to contain" a substring.
        assertThat(page).hasTitle(Pattern.compile("Playwright"));

        // create a locator
        Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));

        // Expect an attribute "to be strictly equal" to the value.
        assertThat(getStarted).hasAttribute("href", "/docs/intro");

        // Click the get started link.
        getStarted.click();

        // Expects page to have a heading with the name of Installation.
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Installation"))).isVisible();
    }
}
