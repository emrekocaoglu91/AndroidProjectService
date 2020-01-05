package com.deneme.Korku.Hikayeleri.model.response;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "STORY")

//TODO : Story request nesnesi oluştur.ContextData'sını içermemeli. BaseStoryOluştur ! Inherit edip context ekle .



public class StoryRest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTEXT")
    private String contextData;

    @Column(name = "IS_ACTIVE")
    private char isActive;

    //tag ve kategori eklenebilir.


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
