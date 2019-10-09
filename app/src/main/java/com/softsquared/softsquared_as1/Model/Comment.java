package com.softsquared.softsquared_as1.Model;

import java.util.ArrayList;

public class Comment {
    private String userId;
    private String comments;
    private boolean isFavorited;
    private ArrayList<String> peopleFavorites;

    public Comment(String userId, String comments, boolean isFavorited, ArrayList<String> peopleFavorites) {
        this.userId = userId;
        this.comments = comments;
        this.isFavorited = isFavorited;
        this.peopleFavorites = peopleFavorites;
    }

    public Comment() {

    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    public boolean isFavorited() { return isFavorited; }
    public void setFavorited(boolean favorited) { isFavorited = favorited; }
    public ArrayList<String> getPeopleFavorites() { return peopleFavorites; }
    public void setPeopleFavorites(ArrayList<String> peopleFavorites) { this.peopleFavorites = peopleFavorites; }
}
