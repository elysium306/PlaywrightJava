package com.playwright.utilities;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBExample {

	private static final String db_name = "mydb";

	public static void main(String[] args) {

//		// Create single document
		Document doc = new Document("name", "John Doe").append("age", 30).append("email", "john.doe@example.com");
		insertSingleDocument("single_collection", doc);

//		// Create bulk documents
		List<Document> docs = List.of(
				new Document("name", "Jane Doe").append("age", 28).append("email", "jane.doe@example.com"),
				new Document("name", "Richard Roe").append("age", 31).append("email", "richard.roe@example.com"));
		insertBulkDocuments("bulk_collection", docs);

//		// How to delete a document
		deleteDocument("", "name", "John Doe");

		// How to drop a collection
		dropCollection("first_test");
		dropCollection("myCollection");

	}

	/**
	 * @apiNote Insert single document to the database
	 * @param collectionName
	 * @param doc
	 */
	public static void insertSingleDocument(String collectionName, Document doc) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase(db_name);
		MongoCollection<Document> collection = database.getCollection(collectionName);

		collection.insertOne(doc);
		System.out.println("Document <" + doc + "> inserted successfully.");
	}

	/**
	 * 
	 * PS: List<Document> docs
	 */
	public static void insertBulkDocuments(String collectionName, List<Document> docs) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase(db_name);
		MongoCollection<Document> collection = database.getCollection(collectionName);

		collection.insertMany(docs);
		System.out.println("Document <" + docs + "> inserted successfully.");
	}

	/**
	 * @apiNote This method deletes the collection using collection name, key, and
	 *          value.
	 * @param collectionName
	 * @param key
	 * @param value
	 */
	public static void deleteDocument(String collectionName, String key, String value) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase(db_name);
		MongoCollection<Document> collection = database.getCollection(collectionName);

		Document filter = new Document(key, value);
		collection.deleteOne(filter);
		System.out.println("Document <" + collectionName + "> deleted successfully.");
	}

	/**
	 * @apiNote This method drops the collection from the database
	 * @param collectionName
	 */
	public static void dropCollection(String collectionName) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase(db_name);

		Document command = new Document("drop", collectionName);
		if (isCollectionExist(collectionName)) {
			database.runCommand(command);
			System.out.println("Collection <" + collectionName + "> dropped successfully.");
		} else {
			System.out.println("The Collection <" + collectionName + "> you are trying to delete does not exist");
		}
	}

	/**
	 * @apiNote This method checks if the given collection is present or not
	 * @param collectionName
	 * @return primitive boolean value; true if the collection present, false if
	 *         does not.
	 */
	public static boolean isCollectionExist(String collectionName) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase(collectionName);
		boolean collectionExists = db.listCollectionNames().into(new ArrayList<>()).contains(collectionName);
		System.out
				.println("Collection Name " + collectionName + " " + (collectionExists ? "exists" : "does not exist"));
		return collectionExists;
	}
}
