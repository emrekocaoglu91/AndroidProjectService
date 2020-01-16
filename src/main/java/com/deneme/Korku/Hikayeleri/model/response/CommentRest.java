package com.deneme.Korku.Hikayeleri.model.response;

import com.deneme.Korku.Hikayeleri.entity.CommentEntity;

public class CommentRest extends CommentEntity {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
