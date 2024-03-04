package com.playwright.ui.Tests;

import com.playwright.ui.Base.BaseTest;
import org.testng.annotations.Test;

public class AmazonHomePageTest extends BaseTest {

    @Test
    public void AmazonTitleTest() {
        page.navigate("https://www.amazon.com");
        String title = page.title();
        System.out.println(title);
    }
}
