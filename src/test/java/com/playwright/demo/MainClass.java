package com.playwright.demo;

import java.util.Properties;

import com.playwright.utilities.PlaywrightFactory;

public class MainClass {

	public static void main(String[] args) {
		
		Properties property = PlaywrightFactory.initProp();
		
		// retrieve some property
		System.out.println(property.getProperty("usrname"));
		System.out.println(property.getProperty("psword"));
	}

}
