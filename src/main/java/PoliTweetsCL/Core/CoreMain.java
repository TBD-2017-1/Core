package PoliTweetsCL.Core;


import PoliTweetsCL.Core.BD.MongoDBController;
import PoliTweetsCL.Core.BD.MySQLController;
import PoliTweetsCL.Core.Model.Tweet;
import org.bson.conversions.Bson;

public class CoreMain {
    public static void main(String[] args) {
        MongoDBController mongo = new MongoDBController();
        MySQLController mysql = new MySQLController();
        Tweet[] tweets = mongo.getTextUnindexedTweets(false);

        System.out.println(tweets[0].toPrettyJSON());

    }
}
