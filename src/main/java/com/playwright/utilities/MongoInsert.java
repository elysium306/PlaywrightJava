package com.playwright.utilities;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoInsert {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("mydb");
		MongoCollection<Document> collection = database.getCollection("myCollection");

		Document document = new Document("name", "John Doe").append("age", 30).append("email", "johndoe@example.com");

		collection.insertOne(document);
		System.out.println("Document inserted successfully.");
	}
}
