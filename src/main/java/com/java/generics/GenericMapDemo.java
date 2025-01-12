package com.java.generics;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GenericMapDemo {

	public static void main(String[] args) {

		Map<String, Double> map1 = getConcurrentMap();
		map1.put("one", 1d);
		map1.putIfAbsent("two", 2d);
		map1.computeIfAbsent("three", v -> 3d);
		map1.computeIfPresent("three", (k, v) -> 3.1d);

		System.out.println(map1.toString());

		System.out.println("------------------------");

		Map<Integer, String> map2 = getConcurrentMap();
		map2.put(1, "One");
		map2.putIfAbsent(2, "Two");
		map2.computeIfAbsent(3, v -> "Three");
		map2.computeIfPresent(3, (k, v) -> "THREE");

		System.out.println(map2.toString());

	}

	public static <K, V> Map<K, V> getConcurrentMap() {
		return new ConcurrentHashMap<K, V>();
	}

}
