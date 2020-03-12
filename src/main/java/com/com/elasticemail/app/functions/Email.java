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
 * Send your emails and see their statuses
 */
public class Email extends API
{
    /**
     * Get email batch status
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param transactionID Transaction identifier
     * @param showFailed Include Bounced email addresses.
     * @param showSent Include Sent email addresses.
     * @param showDelivered Include all delivered email addresses.
     * @param showPending Include Ready to send email addresses.
     * @param showOpened Include Opened email addresses.
     * @param showClicked Include Clicked email addresses.
     * @param showAbuse Include Reported as abuse email addresses.
     * @param showUnsubscribed Include Unsubscribed email addresses.
     * @param showErrors Include error messages for bounced emails.
     * @param showMessageIDs Include all MessageIDs for this transaction
     * @return ApiTypes.EmailJobStatus
     * @throws Exception
     */
    public EmailJobStatus getStatus(String transactionID, Boolean showFailed, Boolean showSent, Boolean showDelivered, Boolean showPending, Boolean showOpened, Boolean showClicked, Boolean showAbuse, Boolean showUnsubscribed, Boolean showErrors, Boolean showMessageIDs) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("transactionID", transactionID);
       values.put("showFailed", String.valueOf(showFailed));
       values.put("showSent", String.valueOf(showSent));
       values.put("showDelivered", String.valueOf(showDelivered));
       values.put("showPending", String.valueOf(showPending));
       values.put("showOpened", String.valueOf(showOpened));
       values.put("showClicked", String.valueOf(showClicked));
       values.put("showAbuse", String.valueOf(showAbuse));
       values.put("showUnsubscribed", String.valueOf(showUnsubscribed));
       values.put("showErrors", String.valueOf(showErrors));
       values.put("showMessageIDs", String.valueOf(showMessageIDs));
       return uploadValues(API_URI + "/email/getstatus", values, EmailJobStatus.class);
   }

    /**
     * Lists the file attachments for the specified email.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param msgID ID number of selected message.
     * @return ApiTypes.FileArray
     * @throws Exception
     */
    public FileArray listAttachments(String msgID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("msgID", msgID);
       return uploadValues(API_URI + "/email/listattachments", values, FileArray.class);
   }

    /**
     * Submit emails. The HTTP POST request is suggested. The default, maximum (accepted by us) size of an email is 10 MB in total, with or without attachments included. For suggested implementations please refer to https://elasticemail.com/support/http-api/
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param subject Email subject
     * @param from From email address
     * @param fromName Display name for from email address
     * @param sender Email address of the sender
     * @param senderName Display name sender
     * @param msgFrom Optional parameter. Sets FROM MIME header.
     * @param msgFromName Optional parameter. Sets FROM name of MIME header.
     * @param replyTo Email address to reply to
     * @param replyToName Display name of the reply to address
     * @param to List of email recipients (each email is treated separately, like a BCC). Separated by comma or semicolon. We suggest using the "msgTo" parameter if backward compatibility with API version 1 is not a must.
     * @param msgTo Optional parameter. Will be ignored if the 'to' parameter is also provided. List of email recipients (visible to all other recipients of the message as TO MIME header). Separated by comma or semicolon.
     * @param msgCC Optional parameter. Will be ignored if the 'to' parameter is also provided. List of email recipients (visible to all other recipients of the message as CC MIME header). Separated by comma or semicolon.
     * @param msgBcc Optional parameter. Will be ignored if the 'to' parameter is also provided. List of email recipients (each email is treated seperately). Separated by comma or semicolon.
     * @param lists The name of a contact list you would like to send to. Separate multiple contact lists by commas or semicolons.
     * @param segments The name of a segment you would like to send to. Separate multiple segments by comma or semicolon. Insert "0" for all Active contacts.
     * @param mergeSourceFilename File name one of attachments which is a CSV list of Recipients.
     * @param dataSource Name or ID of the previously uploaded file (via the File/Upload request) which should be a CSV list of Recipients.
     * @param channel An ID field (max 191 chars) that can be used for reporting [will default to HTTP API or SMTP API]
     * @param bodyHtml Html email body
     * @param bodyText Text email body
     * @param charset Text value of charset encoding for example: iso-8859-1, windows-1251, utf-8, us-ascii, windows-1250 and more…
     * @param charsetBodyHtml Sets charset for body html MIME part (overrides default value from charset parameter)
     * @param charsetBodyText Sets charset for body text MIME part (overrides default value from charset parameter)
     * @param encodingType 0 for None, 1 for Raw7Bit, 2 for Raw8Bit, 3 for QuotedPrintable, 4 for Base64 (Default), 5 for Uue  note that you can also provide the text version such as "Raw7Bit" for value 1.  NOTE: Base64 or QuotedPrintable is recommended if you are validating your domain(s) with DKIM.
     * @param template The ID of an email template you have created in your account.
     * @param attachmentFiles Attachment files. These files should be provided with the POST multipart file upload and not directly in the request's URL. Can also include merge CSV file
     * @param headers Optional Custom Headers. Request parameters prefixed by headers_ like headers_customheader1, headers_customheader2. Note: a space is required after the colon before the custom header value. headers_xmailer=xmailer: header-value1
     * @param postBack Optional header returned in notifications.
     * @param merge Request parameters prefixed by merge_ like merge_firstname, merge_lastname. If sending to a template you can send merge_ fields to merge data with the template. Template fields are entered with {firstname}, {lastname} etc.
     * @param timeOffSetMinutes Number of minutes in the future this email should be sent up to a maximum of 1 year (524160 minutes)
     * @param poolName Name of your custom IP Pool to be used in the sending process
     * @param isTransactional True, if email is transactional (non-bulk, non-marketing, non-commercial). Otherwise, false
     * @param attachments Names or IDs of attachments previously uploaded to your account (via the File/Upload request) that should be sent with this e-mail.
     * @param trackOpens Should the opens be tracked? If no value has been provided, Account's default setting will be used.
     * @param trackClicks Should the clicks be tracked? If no value has been provided, Account's default setting will be used.
     * @param utmSource The utm_source marketing parameter appended to each link in the campaign.
     * @param utmMedium The utm_medium marketing parameter appended to each link in the campaign.
     * @param utmCampaign The utm_campaign marketing parameter appended to each link in the campaign.
     * @param utmContent The utm_content marketing parameter appended to each link in the campaign.
     * @param bodyAmp AMP email body
     * @param charsetBodyAmp Sets charset for body AMP MIME part (overrides default value from charset parameter)
     * @return ApiTypes.EmailSend
     * @throws Exception
     */
    public EmailSend send(String subject, String from, String fromName, String sender, String senderName, String msgFrom, String msgFromName, String replyTo, String replyToName, StringArray to, StringArray msgTo, StringArray msgCC, StringArray msgBcc, StringArray lists, StringArray segments, String mergeSourceFilename, String dataSource, String channel, String bodyHtml, String bodyText, String charset, String charsetBodyHtml, String charsetBodyText, EncodingType encodingType, String template, Iterable<FileData> attachmentFiles, HashMap<String, String> headers, String postBack, HashMap<String, String> merge, String timeOffSetMinutes, String poolName, Boolean isTransactional, StringArray attachments, Boolean trackOpens, Boolean trackClicks, String utmSource, String utmMedium, String utmCampaign, String utmContent, String bodyAmp, String charsetBodyAmp) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("subject", subject);
       values.put("from", from);
       values.put("fromName", fromName);
       values.put("sender", sender);
       values.put("senderName", senderName);
       values.put("msgFrom", msgFrom);
       values.put("msgFromName", msgFromName);
       values.put("replyTo", replyTo);
       values.put("replyToName", replyToName);
       if (to != null) values.put("to", joinList(to));
       if (msgTo != null) values.put("msgTo", joinList(msgTo));
       if (msgCC != null) values.put("msgCC", joinList(msgCC));
       if (msgBcc != null) values.put("msgBcc", joinList(msgBcc));
       if (lists != null) values.put("lists", joinList(lists));
       if (segments != null) values.put("segments", joinList(segments));
       values.put("mergeSourceFilename", mergeSourceFilename);
       values.put("dataSource", dataSource);
       values.put("channel", channel);
       values.put("bodyHtml", bodyHtml);
       values.put("bodyText", bodyText);
       values.put("charset", charset);
       values.put("charsetBodyHtml", charsetBodyHtml);
       values.put("charsetBodyText", charsetBodyText);
       values.put("encodingType", String.valueOf(encodingType));
       values.put("template", template);
       if (headers != null) 
           for (String key : headers.keySet())
              values.put("headers_" + key, key + ": " + headers.get(key));
       values.put("postBack", postBack);
       if (merge != null) 
           for (String key : merge.keySet())
              values.put("merge_" + key, merge.get(key));
       values.put("timeOffSetMinutes", timeOffSetMinutes);
       values.put("poolName", poolName);
       values.put("isTransactional", String.valueOf(isTransactional));
       if (attachments != null) values.put("attachments", joinList(attachments));
       values.put("trackOpens", String.valueOf(trackOpens));
       values.put("trackClicks", String.valueOf(trackClicks));
       values.put("utmSource", utmSource);
       values.put("utmMedium", utmMedium);
       values.put("utmCampaign", utmCampaign);
       values.put("utmContent", utmContent);
       values.put("bodyAmp", bodyAmp);
       values.put("charsetBodyAmp", charsetBodyAmp);
       return httpPostFile(API_URI + "/email/send", attachmentFiles, values, EmailSend.class);
   }

    /**
     * Detailed status of a unique email sent through your account. Returns a 'Email has expired and the status is unknown.' error, if the email has not been fully processed yet.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param messageID Unique identifier for this email.
     * @return ApiTypes.EmailStatus
     * @throws Exception
     */
    public EmailStatus status(String messageID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("messageID", messageID);
       return uploadValues(API_URI + "/email/status", values, EmailStatus.class);
   }

    /**
     * Checks if verification emails is completed.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param txID 
     * @return ApiTypes.Export
     * @throws Exception
     */
    public ApiTypes.Export verificationResult(UUID txID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("txID", String.valueOf(txID));
       return uploadValues(API_URI + "/email/verificationresult", values, ApiTypes.Export.class);
   }

    /**
     * Verify single email address
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param email Proper email address.
     * @param uploadContact 
     * @param updateStatus Should the existing contact's status be changed automatically based on the validation result
     * @return ApiTypes.EmailValidationResult
     * @throws Exception
     */
    public EmailValidationResult verify(String email, Boolean uploadContact, Boolean updateStatus) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("uploadContact", String.valueOf(uploadContact));
       values.put("updateStatus", String.valueOf(updateStatus));
       return uploadValues(API_URI + "/email/verify", values, EmailValidationResult.class);
   }

    /**
     * Verify list of email addresses. Each email in the file (if used) has to be in a new line. This is asynchronous task. To check if task is completed use VerificationResult with returned task ID.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param emails Comma delimited list of contact emails
     * @param rule Query used for filtering.
     * @param listOfEmails 
     * @param uploadContacts 
     * @param updateStatus Should the existing contacts' status be changed automatically based on the validation results
     * @return String
     * @throws Exception
     */
    public String verifyList(FileData emails, String rule, StringArray listOfEmails, Boolean uploadContacts, Boolean updateStatus) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("rule", rule);
       if (listOfEmails != null) values.put("listOfEmails", joinList(listOfEmails));
       values.put("uploadContacts", String.valueOf(uploadContacts));
       values.put("updateStatus", String.valueOf(updateStatus));
       return httpPostFile(API_URI + "/email/verifylist", Arrays.asList(emails), values, String.class);
   }

    /**
     * View email
     * @param messageID Message identifier
     * @param enableTracking 
     * @return ApiTypes.EmailView
     * @throws Exception
     */
    public EmailView view(String messageID, Boolean enableTracking) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("messageID", messageID);
       values.put("enableTracking", String.valueOf(enableTracking));
       return uploadValues(API_URI + "/email/view", values, EmailView.class);
   }

}

