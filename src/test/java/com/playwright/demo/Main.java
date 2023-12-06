package com.playwright.demo;

import com.playwright.helpers.AppConstants;

public class Main {

	public static void main(String[] args) {

		System.out.println(String.format("iTunes App ID: %d", AppConstants.ITUNES_APP_ID));
		System.out.println(String.format("iTunes HomePage Title: %s", AppConstants.ETSY_HOME_PAGE_TITLE));
		System.out.println(String.format("iTunes LoginPage Title: %s", AppConstants.ETSY_LOGIN_PAGE_TITLE));
	}

}
