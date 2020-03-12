package com.deneme.Korku.Hikayeleri.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "USERSTORY")
public class UserStoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String storyTitle;


    @Column(nullable = false,length = Integer.MAX_VALUE)
    private String storyText;

    public UserStoryEntity() {
    }

    public UserStoryEntity(String userId, String userName, String storyTitle, String storyText) {
        this.userId = userId;
        this.userName = userName;
        this.storyTitle = storyTitle;
        this.storyText = storyText;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
}
