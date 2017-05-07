package Model;

import twitter4j.Status;

import java.util.List;

public class Tweet{
    // Twitter Status
    int _id;
    String createdAt;
    String text;
    int inReplyToStatusId;
    int inReplyToUserId;
    Tweet retweetedStatus;
    Tweet QuotedStatus;
    List<User> userMentions;
    List<String> hashtags;
    User user;

    // Politweets
    String sentimiento;
    boolean textIndexed;
    boolean userIndexed;
    boolean geoIndexed;

    public Tweet(Status status){

    }

}
