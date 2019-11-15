package com.deneme.Korku.Hikayeleri.security;

import com.deneme.Korku.Hikayeleri.SpringApplicationContext;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 172800000; //milisaniye türünden 2 gün
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";

    public static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");

        return appProperties.getTokenSecret();

    }


}
