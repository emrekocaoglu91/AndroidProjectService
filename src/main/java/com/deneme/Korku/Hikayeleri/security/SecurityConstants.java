package com.deneme.Korku.Hikayeleri.security;

import com.deneme.Korku.Hikayeleri.SpringApplicationContext;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 172800000; //milisaniye türünden 2 gün
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; //milisaniye türünden 1 saat

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/create";
    public static final String VERIFICATION_EMAIL_URL = "/users/email-verification";
    public static final String PASSWORD_RESET_REQUEST_URL = "/users/password-reset-request";
    public static final String PASSWORD_RESET_URL = "/users/password-reset";



    public static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");

        return appProperties.getTokenSecret();

    }


}
