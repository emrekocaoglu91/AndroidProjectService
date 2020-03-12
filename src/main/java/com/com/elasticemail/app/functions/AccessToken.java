package com.com.elasticemail.app.functions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Date;

import java.util.UUID;

import com.elasticemail.app.API;
import com.elasticemail.app.ApiTypes;
import com.elasticemail.app.ApiTypes.*;
import com.elasticemail.app.FileData;
import com.elasticemail.app.APIResponse.VoidApiResponse;

/**
 * Manage your AccessTokens (ApiKeys)
 */
public class AccessToken extends API
{
    /**
     * Add new AccessToken with appropriate AccessLevel (permission).
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param tokenName Name of the AccessToken for ease of reference.
     * @param accessLevel Level of access (permission) to our API.
     * @param restrictAccessToIPRange Comma separated list of CIDR notated IP ranges that this token can connect from.
     * @param type 
     * @return String
     * @throws Exception
     */
    public String add(String tokenName, AccessLevel accessLevel, StringArray restrictAccessToIPRange, AccessTokenType type) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("tokenName", tokenName);
       values.put("accessLevel", String.valueOf(accessLevel));
       if (restrictAccessToIPRange != null) values.put("restrictAccessToIPRange", joinList(restrictAccessToIPRange));
       values.put("type", String.valueOf(type));
       return uploadValues(API_URI + "/accesstoken/add", values, String.class);
   }

    /**
     * Permanently delete AccessToken from your Account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param tokenName Name of the AccessToken for ease of reference.
     * @throws Exception
     */
    public void delete(String tokenName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("tokenName", tokenName);
       uploadValues(API_URI + "/accesstoken/delete", values, VoidApiResponse.class);
   }

    /**
     * List all the AccessToken's in your Account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.AccessTokenArray
     * @throws Exception
     */
    public AccessTokenArray list() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/accesstoken/list", values, AccessTokenArray.class);
   }

    /**
     * Update AccessToken with a new name or AccessLevel.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param tokenName Name of the AccessToken for ease of reference.
     * @param accessLevel Level of access (permission) to our API.
     * @param newTokenName New name of the AccessToken.
     * @param restrictAccessToIPRange Comma separated list of CIDR notated IP ranges that this token can connect from.
     * @throws Exception
     */
    public void update(String tokenName, AccessLevel accessLevel, String newTokenName, StringArray restrictAccessToIPRange) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("tokenName", tokenName);
       values.put("accessLevel", String.valueOf(accessLevel));
       values.put("newTokenName", newTokenName);
       if (restrictAccessToIPRange != null) values.put("restrictAccessToIPRange", joinList(restrictAccessToIPRange));
       uploadValues(API_URI + "/accesstoken/update", values, VoidApiResponse.class);
   }

}

