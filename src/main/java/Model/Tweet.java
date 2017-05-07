package Model;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.UserMentionEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tweet{
    // Twitter Status
    private long _id;
    private Date createdAt;
    private String text;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private Tweet retweetedStatus;
    private Tweet quotedStatus;
    private User[] userMentions;
    private String[] hashtags;
    private  User user;

    // Politweets
    private String sentimiento = null;
    private boolean textIndexed = false;
    private boolean userIndexed = false;
    private boolean geoIndexed = false;

     Tweet(Status s){
        _id = s.getId();
        createdAt = s.getCreatedAt();
        text = s.getText();
        inReplyToStatusId = s.getInReplyToStatusId();
        inReplyToUserId = s.getInReplyToUserId();
        retweetedStatus = new Tweet(s.getRetweetedStatus());
        quotedStatus = new Tweet(s.getQuotedStatus());
        user = new User(s.getUser());

        UserMentionEntity[] menciones = s.getUserMentionEntities();
        userMentions = new User[menciones.length];
        for (int i=0;i<menciones.length;i++) {
            userMentions[i] = new User(menciones[i]);
        }

        HashtagEntity[] statusHashtags = s.getHashtagEntities();
        hashtags = new String[statusHashtags.length];
        for (int i=0;i<statusHashtags.length;i++) {
            hashtags[i] = statusHashtags[i].getText();
        }
    }

    // GETTERS
    public long getId() { return _id;}
    public String getText() {return text;}
    public Date getCreatedAt() {return createdAt;}
    public User getUser() {return user;}
    public User[] getUserMentions() {return userMentions;}
    public String[] getHashtags() {return hashtags;}
    public long getInReplyToStatusId() { return inReplyToStatusId;}
    public long getInReplyToUserId() {return inReplyToUserId;}
    public Tweet getQuotedStatus() {return quotedStatus;}
    public Tweet getRetweetedStatus() {return retweetedStatus;}
    public String getSentimiento() {return sentimiento;}
    public boolean isGeoIndexed() {return geoIndexed;}
    public boolean isTextIndexed() {return textIndexed;}
    public boolean isUserIndexed() {return userIndexed;}

    // SETTERS
    public void setSentimiento(String sentimiento) {this.sentimiento = sentimiento;}
    public void setTextIndexed(boolean textIndexed) {this.textIndexed = textIndexed;}
    public void setUserIndexed(boolean userIndexed) {this.userIndexed = userIndexed;}
    public void setGeoIndexed(boolean geoIndexed) {this.geoIndexed = geoIndexed;}


}
