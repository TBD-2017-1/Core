package BD;

import Model.Tweet;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import com.mongodb.util.JSON;
import org.bson.Document;

import com.google.gson.Gson;

import twitter4j.Status;
import twitter4j.json.DataObjectFactory;

public class MongoDBController {
	MongoClient mongoClient;
	MongoDatabase db;
	MongoCollection<Document> tweetsCollection;

	public MongoDBController() {
		mongoClient = new MongoClient("localhost", 27017);
		db = mongoClient.getDatabase("politweets");
		tweetsCollection = db.getCollection("tweets");
	}


/*
	public void saveTweet(Tweet tweet){

	}



	public static DBObject tweetToDoc(Object obj){
		Gson gson = new Gson();
		// Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(obj);

		BasicDBObject doc = (BasicDBObject) JSON.parse(json);

		return doc;
	}

	public static Object docToDoc(DBObject doc, Object objClass){

	}
*/
}
