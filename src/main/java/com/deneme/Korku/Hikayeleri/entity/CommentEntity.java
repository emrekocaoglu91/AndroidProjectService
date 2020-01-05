package com.deneme.Korku.Hikayeleri.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "COMMENTS")
public class CommentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200,name = "COMMENT_TEXT")
    private String commentText;

    @Column(name = "USER_ID",nullable = false)
    private String userID;

    @Column(name = "STORY_ID",nullable = false)
    private Long storyID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Long getStoryID() {
        return storyID;
    }

    public void setStoryID(Long storyID) {
        this.storyID = storyID;
    }
}
