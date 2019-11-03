package com.softsquared.softsquared_as1.Model;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class StoryIcon {
    private String userId;
    private Drawable profile;
    private boolean isStory;

    public StoryIcon(String userId, Drawable profile, boolean isStory) {
        this.userId = userId;
        this.profile = profile;
        this.isStory = isStory;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Drawable getProfile() {
        return profile;
    }

    public void setProfile(Drawable profile) {
        this.profile = profile;
    }

    public boolean isStory() {
        return isStory;
    }

    public void setStory(boolean story) {
        isStory = story;
    }
}
