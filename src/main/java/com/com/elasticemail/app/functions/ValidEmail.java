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
 * Managing sender emails.
 */
public class ValidEmail extends API
{
    /**
     * Add new email to account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param emailAddress 
     * @param returnUrl URL to navigate to after Account creation
     * @return ApiTypes.ValidEmail
     * @throws Exception
     */
    public ApiTypes.ValidEmail add(String emailAddress, String returnUrl) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("emailAddress", emailAddress);
       values.put("returnUrl", returnUrl);
       return uploadValues(API_URI + "/validemail/add", values, ApiTypes.ValidEmail.class);
   }

    /**
     * Get list of all valid emails of account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.ValidEmailArray
     * @throws Exception
     */
    public ValidEmailArray list() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/validemail/list", values, ValidEmailArray.class);
   }

    /**
     * Delete valid email from account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param validEmailID 
     * @throws Exception
     */
    public void remove(int validEmailID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("validEmailID", String.valueOf(validEmailID));
       uploadValues(API_URI + "/validemail/remove", values, VoidApiResponse.class);
   }

    /**
     * Resends email verification.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param emailAddress 
     * @param returnUrl URL to navigate to after Account creation
     * @throws Exception
     */
    public void resendEmailVerification(String emailAddress, String returnUrl) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("emailAddress", emailAddress);
       values.put("returnUrl", returnUrl);
       uploadValues(API_URI + "/validemail/resendemailverification", values, VoidApiResponse.class);
   }

}

