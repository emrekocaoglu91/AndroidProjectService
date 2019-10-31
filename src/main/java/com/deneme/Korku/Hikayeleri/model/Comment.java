package com.deneme.Korku.Hikayeleri.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity(name = "COMMENT")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FK_USER_ID")
    private long fkUserId;

    @Column(name = "FK_STORY_ID")
    private long fkStoryId;

    @Column(name = "COMMENT_DATE")
    private Date commentDate;

    @Column(name = "CONTEXT")
    private String contextData;

    @Column(name = "IS_ACTIVE")
    private char isActive;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(long fkUserId) {
        this.fkUserId = fkUserId;
    }

    public long getFkStoryId() {
        return fkStoryId;
    }

    public void setFkStoryId(long fkStoryId) {
        this.fkStoryId = fkStoryId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getContextData() {
        return contextData;
    }

    public void setContextData(String contextData) {
        this.contextData = contextData;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }
}
