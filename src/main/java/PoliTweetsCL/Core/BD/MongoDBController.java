package PoliTweetsCL.Core.BD;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import PoliTweetsCL.Core.Model.*;
import org.bson.Document;

import java.util.Arrays;

public class MongoDBController {
	private MongoClient mongoClient;
	private MongoDatabase db;
	private MongoCollection<Document> tweetsCollection;

	/* CONSTRUCTORES */

	// Para conectar con el servidor remoto
	public MongoDBController(boolean remoto) {
		// credencial
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("admin", "admin","DigitalOceanServer".toCharArray());
		// cliente
		mongoClient = new MongoClient(new ServerAddress("107.170.99.162", 27017), Arrays.asList(mongoCredential));

		// conectar a bd
		db = mongoClient.getDatabase("politweets");
		tweetsCollection = db.getCollection("tweets");
	}

	// Para conectar al servidor local
	public MongoDBController(){
		mongoClient = new MongoClient("localhost", 27017);
		db = mongoClient.getDatabase("politweets");
		tweetsCollection = db.getCollection("tweets");
	}

	// Para conectar con el servidor local con credenciales
	public MongoDBController(String username, String pass){
		// credencial
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(username, "admin",pass.toCharArray());
		// cliente
		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(mongoCredential));
		db = mongoClient.getDatabase("politweets");
		tweetsCollection = db.getCollection("tweets");
	}


	/* METODOS */

	public void saveTweet(Tweet tweet){
		// create document
		Document doc = Document.parse( tweet.toJSON() );

		// Insert
		tweetsCollection.insertOne(doc);
	}


}
