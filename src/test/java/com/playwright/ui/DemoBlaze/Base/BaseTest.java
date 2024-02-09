package com.playwright.ui.DemoBlaze.Base;

import com.microsoft.playwright.Page;
import com.playwright.utilities.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    protected Properties prop;
    protected Page page;

    @BeforeTest
    public void setup(){
        prop = PlaywrightFactory.initProp();
        page = PlaywrightFactory.initPlaywright(prop);
    }

    @AfterTest
    public void teardown(){
        page.close();
    }
}
