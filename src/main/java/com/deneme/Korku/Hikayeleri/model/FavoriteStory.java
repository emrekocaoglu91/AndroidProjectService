package com.deneme.Korku.Hikayeleri.model;




import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "FAVORITE_STORY")

public class FavoriteStory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FK_USER_ID")
    private long fkUserId;

    @Column(name = "FK_STORY_ID")
    private long fkStoryId;

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
}
