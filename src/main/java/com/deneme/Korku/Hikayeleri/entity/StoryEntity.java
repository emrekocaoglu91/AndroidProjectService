package com.deneme.Korku.Hikayeleri.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "STORY")

public class StoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTEXT")
    private String contextData;

    @Column(name = "IS_ACTIVE")
    private char isActive;

    @Column(name = "PIC_URL")
    private String pictureURL;


    public StoryEntity() {
        this.isActive = 'N';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
