package com.playwright.demo;

import java.util.Properties;

import com.playwright.helpers.AppConstants;
import com.playwright.utilities.PlaywrightFactory;

public class MainClass {

    public static void main(String[] args) {

        Properties property = PlaywrightFactory.initProp();

        // retrieve some property
        System.out.println(property.getProperty("usrname"));
        System.out.println(property.getProperty("psword"));

        // How to use AppConstants issue
        System.out.printf("iTunes App ID: %d%n", AppConstants.ITUNES_APP_ID);
        System.out.printf("iTunes HomePage Title: %s%n", AppConstants.ETSY_HOME_PAGE_TITLE);
        System.out.printf("iTunes LoginPage Title: %s%n", AppConstants.ETSY_LOGIN_PAGE_TITLE);
    }

}
