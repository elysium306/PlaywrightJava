package com.playwright.ui.DemoBlaze.Pages;

import com.microsoft.playwright.Page;
import com.playwright.ui.DemoBlaze.Base.BasePage;

public class HomePage extends BasePage {
    private Page page;
    public HomePage(Page page) {
        super();
        this.page = page;
    }
}
