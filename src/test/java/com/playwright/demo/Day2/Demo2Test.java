package com.playwright.demo.Day2;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;

@UsePlaywright
public class Demo2Test {
	private static final Logger log = LoggerFactory.getLogger(Demo2Test.class);
	private static final String URL = "https://playwright.dev";

	@Test
	public void getTitleTest(Page page) {
		log.info("### Openign the application");
		page.navigate(URL);
		String title = page.title();
		System.out.println(title);
	}
}
