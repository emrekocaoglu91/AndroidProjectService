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
 * Manage sending domains and verify DNS configurations.
 */
public class Domain extends API
{
    /**
     * Add a new domain to be registered and secured to an Account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param domain Name of selected domain.
     * @param trackingType 
     * @param setAsDefault Set this domain as the default domain for the Account.
     * @throws Exception
     */
    public void add(String domain, TrackingType trackingType, Boolean setAsDefault) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       values.put("trackingType", String.valueOf(trackingType));
       values.put("setAsDefault", String.valueOf(setAsDefault));
       uploadValues(API_URI + "/domain/add", values, VoidApiResponse.class);
   }

    /**
     * Deletes a domain from the Account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param domain Name of selected domain.
     * @throws Exception
     */
    public void delete(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       uploadValues(API_URI + "/domain/delete", values, VoidApiResponse.class);
   }

    /**
     * Lists all the domains configured for this Account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.DomainDetailArray
     * @throws Exception
     */
    public DomainDetailArray list() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/domain/list", values, DomainDetailArray.class);
   }

    /**
     * Sets the default sender for the Account as an email address from a verified domain.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param email Email address of a verified domain to be used as default when sending from non-verified domains.
     * @throws Exception
     */
    public void setDefault(String email) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       uploadValues(API_URI + "/domain/setdefault", values, VoidApiResponse.class);
   }

    /**
     * Allow to use VERP on given domain and specify custom bounces domain.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param domain Name of selected domain.
     * @param isVerp 
     * @param customBouncesDomain 
     * @param isCustomBouncesDomainDefault 
     * @throws Exception
     */
    public void setVerp(String domain, Boolean isVerp, String customBouncesDomain, Boolean isCustomBouncesDomainDefault) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       values.put("isVerp", String.valueOf(isVerp));
       values.put("customBouncesDomain", customBouncesDomain);
       values.put("isCustomBouncesDomainDefault", String.valueOf(isCustomBouncesDomainDefault));
       uploadValues(API_URI + "/domain/setverp", values, VoidApiResponse.class);
   }

    /**
     * Verifies proper DKIM DNS configuration for the domain.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param domain Domain name to verify.
     * @return String
     * @throws Exception
     */
    public String verifyDkim(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       return uploadValues(API_URI + "/domain/verifydkim", values, String.class);
   }

    /**
     * Verifies proper MX DNS configuration for the domain.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param domain Domain name to verify.
     * @return String
     * @throws Exception
     */
    public String verifyMX(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       return uploadValues(API_URI + "/domain/verifymx", values, String.class);
   }

    /**
     * Verifies proper SPF DNS configuration for the domain.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param domain Domain name to verifiy.
     * @return ApiTypes.ValidationStatus
     * @throws Exception
     */
    public ValidationStatus verifySpf(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       return uploadValues(API_URI + "/domain/verifyspf", values, ValidationStatus.class);
   }

    /**
     * Verifies proper CNAME DNS configuration for the tracking domain.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param domain Domain name to verify.
     * @param trackingType 
     * @return String
     * @throws Exception
     */
    public String verifyTracking(String domain, TrackingType trackingType) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       values.put("trackingType", String.valueOf(trackingType));
       return uploadValues(API_URI + "/domain/verifytracking", values, String.class);
   }

}

