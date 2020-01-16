package com.deneme.Korku.Hikayeleri.model.request;

import java.io.Serializable;

public class CommentRequestModel implements Serializable {

    private String commentText;

    private Long storyID;

    private String userID;


    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Long getStoryID() {
        return storyID;
    }

    public void setStoryID(Long storyID) {
        this.storyID = storyID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
