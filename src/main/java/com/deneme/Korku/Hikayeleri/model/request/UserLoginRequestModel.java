package com.deneme.Korku.Hikayeleri.model.request;

import java.io.Serializable;

public class UserLoginRequestModel implements Serializable {

    private String email;
    private String password;
    private String userName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
