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
 * Managing and editing templates of your emails
 */
public class Template extends API
{
    /**
     * Create new Template. Needs to be sent using POST method
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param name Filename
     * @param subject Default subject of email.
     * @param fromEmail Default From: email address.
     * @param fromName Default From: name.
     * @param templateScope Enum: 0 - private, 1 - public, 2 - mockup
     * @param bodyHtml HTML code of email (needs escaping).
     * @param bodyText Text body of email.
     * @param css CSS style
     * @param originalTemplateID ID number of original template.
     * @param tags 
     * @param bodyAmp AMP code of email (needs escaping).
     * @return int
     * @throws Exception
     */
    public int add(String name, String subject, String fromEmail, String fromName, TemplateScope templateScope, String bodyHtml, String bodyText, String css, int originalTemplateID, StringArray tags, String bodyAmp) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("name", name);
       values.put("subject", subject);
       values.put("fromEmail", fromEmail);
       values.put("fromName", fromName);
       values.put("templateScope", String.valueOf(templateScope));
       values.put("bodyHtml", bodyHtml);
       values.put("bodyText", bodyText);
       values.put("css", css);
       values.put("originalTemplateID", String.valueOf(originalTemplateID));
       if (tags != null) values.put("tags", joinList(tags));
       values.put("bodyAmp", bodyAmp);
       return uploadValues(API_URI + "/template/add", values, int.class);
   }

    /**
     * Create a new Tag to be used in your Templates
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param tag Tag's value
     * @return ApiTypes.TemplateTag
     * @throws Exception
     */
    public TemplateTag addTag(String tag) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("tag", tag);
       return uploadValues(API_URI + "/template/addtag", values, TemplateTag.class);
   }

    /**
     * Copy Selected Template
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param templateID ID number of template.
     * @param name Filename
     * @param subject Default subject of email.
     * @param fromEmail Default From: email address.
     * @param fromName Default From: name.
     * @return ApiTypes.Template
     * @throws Exception
     */
    public ApiTypes.Template copy(int templateID, String name, String subject, String fromEmail, String fromName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       values.put("name", name);
       values.put("subject", subject);
       values.put("fromEmail", fromEmail);
       values.put("fromName", fromName);
       return uploadValues(API_URI + "/template/copy", values, ApiTypes.Template.class);
   }

    /**
     * Delete template with the specified ID
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param templateID ID number of template.
     * @throws Exception
     */
    public void delete(int templateID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       uploadValues(API_URI + "/template/delete", values, VoidApiResponse.class);
   }

    /**
     * Delete templates with the specified ID
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param templateIDs 
     * @throws Exception
     */
    public void deleteBulk(Iterable<Integer> templateIDs) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (templateIDs != null) values.put("templateIDs", joinList(templateIDs));
       uploadValues(API_URI + "/template/deletebulk", values, VoidApiResponse.class);
   }

    /**
     * Delete a tag, removing it from all Templates
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param tag 
     * @throws Exception
     */
    public void deleteTag(String tag) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("tag", tag);
       uploadValues(API_URI + "/template/deletetag", values, VoidApiResponse.class);
   }

    /**
     * Lists your templates, optionally searching by Tags
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param tags 
     * @param templateTypes 
     * @param limit If provided, returns templates with these tags
     * @param offset Filters on template type
     * @return ApiTypes.TemplateList
     * @throws Exception
     */
    public TemplateList getList(StringArray tags, TemplateTypeArray templateTypes, int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (tags != null) values.put("tags", joinList(tags));
       if (templateTypes != null) if (templateTypes != null) values.put("templateTypes", joinList(templateTypes));
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/template/getlist", values, TemplateList.class);
   }

    /**
     * Retrieve a list of your Tags
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.TemplateTagList
     * @throws Exception
     */
    public TemplateTagList getTagList() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/template/gettaglist", values, TemplateTagList.class);
   }

    /**
     * Check if template is used by campaign.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param templateID ID number of template.
     * @return Boolean
     * @throws Exception
     */
    public Boolean isUsedByCampaign(int templateID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       return uploadValues(API_URI + "/template/isusedbycampaign", values, Boolean.class);
   }

    /**
     * Load template with content
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param templateID ID number of template.
     * @return ApiTypes.Template
     * @throws Exception
     */
    public ApiTypes.Template loadTemplate(int templateID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       return uploadValues(API_URI + "/template/loadtemplate", values, ApiTypes.Template.class);
   }

    /**
     * Read Rss feed
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param url Rss feed url.
     * @param count Number of item tags to read.
     * @return String
     * @throws Exception
     */
    public String readRssFeed(String url, int count) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("url", url);
       values.put("count", String.valueOf(count));
       return uploadValues(API_URI + "/template/readrssfeed", values, String.class);
   }

    /**
     * Update existing template, overwriting existing data. Needs to be sent using POST method.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param templateID ID number of template.
     * @param templateScope Enum: 0 - private, 1 - public, 2 - mockup
     * @param name Filename
     * @param subject Default subject of email.
     * @param fromEmail Default From: email address.
     * @param fromName Default From: name.
     * @param bodyHtml HTML code of email (needs escaping).
     * @param bodyText Text body of email.
     * @param css CSS style
     * @param removeScreenshot 
     * @param tags 
     * @param bodyAmp AMP code of email (needs escaping).
     * @throws Exception
     */
    public void update(int templateID, TemplateScope templateScope, String name, String subject, String fromEmail, String fromName, String bodyHtml, String bodyText, String css, Boolean removeScreenshot, StringArray tags, String bodyAmp) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       values.put("templateScope", String.valueOf(templateScope));
       values.put("name", name);
       values.put("subject", subject);
       values.put("fromEmail", fromEmail);
       values.put("fromName", fromName);
       values.put("bodyHtml", bodyHtml);
       values.put("bodyText", bodyText);
       values.put("css", css);
       values.put("removeScreenshot", String.valueOf(removeScreenshot));
       if (tags != null) values.put("tags", joinList(tags));
       values.put("bodyAmp", bodyAmp);
       uploadValues(API_URI + "/template/update", values, VoidApiResponse.class);
   }

    /**
     * Bulk change default options and the scope of your templates
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param templateIDs 
     * @param subject Default subject of email.
     * @param fromEmail Default From: email address.
     * @param fromName Default From: name.
     * @param templateScope Enum: 0 - private, 1 - public, 2 - mockup
     * @throws Exception
     */
    public void updateDefaultOptions(Iterable<Integer> templateIDs, String subject, String fromEmail, String fromName, TemplateScope templateScope) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (templateIDs != null) values.put("templateIDs", joinList(templateIDs));
       values.put("subject", subject);
       values.put("fromEmail", fromEmail);
       values.put("fromName", fromName);
       values.put("templateScope", String.valueOf(templateScope));
       uploadValues(API_URI + "/template/updatedefaultoptions", values, VoidApiResponse.class);
   }

}

