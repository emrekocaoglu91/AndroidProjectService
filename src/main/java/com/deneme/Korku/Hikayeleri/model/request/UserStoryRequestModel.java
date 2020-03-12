package com.deneme.Korku.Hikayeleri.model.request;

import java.io.Serializable;

public class UserStoryRequestModel implements Serializable {

    private String userName;
    private String storyTitle;
    private String storyText;
    private String userId;

    public UserStoryRequestModel() {
    }

    public UserStoryRequestModel(String userName, String storyTitle, String storyText, String userId) {
        this.userName = userName;
        this.storyTitle = storyTitle;
        this.storyText = storyText;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
