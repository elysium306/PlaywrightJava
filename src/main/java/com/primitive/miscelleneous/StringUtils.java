package com.primitive.miscelleneous;

import java.util.Arrays;

public abstract class StringUtils implements CharSequence, Cloneable {

	public static void main(String[] args) {
		String capitalize = capitalize("father");
		System.out.println(capitalize);
		String reverse = reverse("selenium");
		System.out.println(reverse);
		
		System.out.println("---- Reverse the String ----");
		System.out.println(reverseSentence("Selenium Java Automation"));
	}

	/**
	 * @apiNote This method takes a String variable, returns capitalized value
	 * @param string
	 * @return String
	 */
	public static String capitalize(String string) {
		System.out.println("--- Capitalized version of the given String ----");
		return string.substring(0, 1).toUpperCase() + string.substring(1, string.length());
	}

	public static String reverse(String string) {
		System.out.println("--- Reverse of the given String ----");
		StringBuilder sb = new StringBuilder(string);
		return sb.reverse().toString();
	}

	public static String reverseSentence(String string) {
		String[] given = string.split(" ");
		System.out.println(Arrays.toString(given));
		String result = "";
		for (int i = 0; i < given.length; i++) {
			result = reverse(given[i]) + " ";
			System.out.println(String.format("'result' after index %d is: %s",  i, result));
		}
		return result.trim();
	}
}
