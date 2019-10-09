package com.softsquared.softsquared_as1.Model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Article {
    private String userId;
    private String place;
    private Drawable profile;
    private ArrayList<Drawable> imgs;
    private boolean isFavorited;
    private ArrayList<String> peopleFavorites;
    private String description;
    private ArrayList<Comment> comments;
    private String date;

    public Article() {

    }

    public Article(String userId, String place, Drawable profile, ArrayList<Drawable> imgs, boolean isFavorited, ArrayList<String> peopleFavorites, String description, ArrayList<Comment> comments, String date) {
        this.userId = userId;
        this.place = place;
        this.profile = profile;
        this.imgs = imgs;
        this.isFavorited = isFavorited;
        this.peopleFavorites = peopleFavorites;
        this.description = description;
        this.comments = comments;
        this.date = date;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }
    public Drawable getProfile() { return profile; }
    public void setProfile(Drawable profile) { this.profile = profile; }
    public ArrayList<Drawable> getImgs() { return imgs; }
    public void setImgs(ArrayList<Drawable> imgs) { this.imgs = imgs; }
    public boolean isFavorited() { return isFavorited; }
    public void setFavorited(boolean favorited) { isFavorited = favorited; }
    public ArrayList<String> getPeopleFavorites() { return peopleFavorites; }
    public void setPeopleFavorites(ArrayList<String> peopleFavorites) { this.peopleFavorites = peopleFavorites; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public ArrayList<Comment> getComments() { return comments; }
    public void setComments(ArrayList<Comment> comments) { this.comments = comments; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
