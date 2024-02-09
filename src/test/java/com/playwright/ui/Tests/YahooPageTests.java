package com.playwright.ui.Tests;

import com.playwright.ui.Base.BaseTest;
import org.testng.annotations.Test;

public class YahooPageTests extends BaseTest {
    String yahooURL = "https://www.yahoo.com";
    @Test
    public void YahooTitleTest(){
        page.navigate(yahooURL);
        String title = page.title();
        System.out.println(title);
    }
}
