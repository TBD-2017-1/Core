package Model;

import twitter4j.UserMentionEntity;

public class User {
    // Twitter
    private long _id;
    private String name;
    private String screenName;
    private int followersCount;
    private int friendsCount;
    private String location;

    User(twitter4j.User u){
        _id = u.getId();
        name = u.getName();
        screenName = u.getScreenName();
        followersCount = u.getFollowersCount();
        friendsCount = u.getFriendsCount();
        location = u.getLocation();
    }

    User(UserMentionEntity m){
        _id = m.getId();
        name = m.getName();
        screenName = m.getScreenName();
    }

    // GETTERS
    public long get_id() {return _id;}
    public String getName() {return name;}
    public String getScreenName() {return screenName;}
    public int getFollowersCount() {return followersCount;}
    public int getFriendsCount() {return friendsCount;}
    public String getLocation() {return location;}

}
