package com.collections_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.testng.annotations.Test;

import static com.primitive.miscelleneous.StringUtils.*;

public class MapDemo {
	static Map<String, String> myMap;
	static String text = "collections";
	
	@Test
	public void myHashMap() {
		myMap = new HashMap<>();
		myMap.put("Father", "Mamatweli");
		myMap.put("Mother", "Gulyar");
		myMap.put("Daughter", "Merhaba");
		myMap.put("Son", "Alishir");
		
		boolean isContained = myMap.containsKey(capitalize("father"));
		System.out.println(String.format("*** Does the HashMap contain the key '%s': %b", capitalize("father"), isContained));
		System.out.println();
	}
	
	@Test
	public static void myTreeMap() {
		myMap = new TreeMap<>();
		myMap.put("Father", "Mamatweli");
		myMap.put("Mother", "Gulyar");
		myMap.put("Daughter", "Merhaba");
		myMap.put("Son", "Alishir");
		
		boolean isContained = myMap.containsKey(capitalize("father"));
		System.out.println(String.format("*** Does the HashMap contain the key '%s': %b", capitalize("father"), isContained));
		System.out.println();
	}
	
	@Test
	public void testStringBuffer() {
		StringBuffer stringBuffer = new StringBuffer(text);
		System.out.println(stringBuffer.capacity());
	}

}
