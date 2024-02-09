package com.playwright.ui.DemoBlaze.Pages;

import com.microsoft.playwright.Page;
import com.playwright.ui.DemoBlaze.Base.BasePage;
import com.playwright.utilities.PropertyReader;

public class LoginPage extends BasePage {
    private Page page;

    public LoginPage(Page page){
        super();
        this.page = page;
        page.navigate(PropertyReader.getProperty("demoblazeurl"));
    }

    public void login(String username, String password){
        HomePage homePage = new HomePage(page);
    }

}
