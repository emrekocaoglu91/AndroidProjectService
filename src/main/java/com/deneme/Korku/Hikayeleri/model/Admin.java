package com.deneme.Korku.Hikayeleri.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "ADMIN")
public class Admin implements Serializable {
    @Id
    private Long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
