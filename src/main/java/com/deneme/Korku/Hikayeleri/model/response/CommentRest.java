package com.deneme.Korku.Hikayeleri.model.response;

import com.deneme.Korku.Hikayeleri.entity.CommentEntity;

import java.io.Serializable;
import java.util.Date;

public class CommentRest extends CommentEntity implements Serializable {

    private Long id;

    private String userName;

    private String commentText;

    private Long storyID;

    private String date;
    private String commentDate;



    public CommentRest() {
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCommentText() {
        return commentText;
    }

    @Override
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public Long getStoryID() {
        return storyID;
    }

    @Override
    public void setStoryID(Long storyID) {
        this.storyID = storyID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
}
