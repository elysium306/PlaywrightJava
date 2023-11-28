package com.playwright.utilities;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	public static void main(String[] args) {
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("mydb");
		System.out.println("Connected to the database successfully.");
		
		database.createCollection("TestCollection");
	}
}
