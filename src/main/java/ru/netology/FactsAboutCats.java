package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FactsAboutCats {
    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final int upvotes;
    //private final String userUpvoted;

    public FactsAboutCats(
            @JsonProperty("_id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") int upvotes
            //@JsonProperty("userUproved") String userUpvoted
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
       // this.userUpvoted = userUpvoted;
    }



    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public int getUpvotes() {
       return upvotes;
    }

    //public String getUserUpvoted() {
      //  return userUpvoted;
    //}

    @Override
    public String toString() {
        return "FactsAboutCats{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user=" + user +
                ", upvotes=" + upvotes +
                //", userUpvoted='" + userUpvoted + '\'' +
                '}';
    }


}
