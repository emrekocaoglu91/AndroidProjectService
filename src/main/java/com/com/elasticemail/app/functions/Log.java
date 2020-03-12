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
 * Methods to check logs of your campaigns
 */
public class Log extends API
{
    /**
     * Cancels emails that are waiting to be sent.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param channelName Name of selected channel.
     * @param transactionID ID number of transaction
     * @throws Exception
     */
    public void cancelInProgress(String channelName, String transactionID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("channelName", channelName);
       values.put("transactionID", transactionID);
       uploadValues(API_URI + "/log/cancelinprogress", values, VoidApiResponse.class);
   }

    /**
     * Returns log of delivery events filtered by specified parameters.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param statuses List of comma separated message statuses: 0 for all, 1 for ReadyToSend, 2 for InProgress, 4 for Bounced, 5 for Sent, 6 for Opened, 7 for Clicked, 8 for Unsubscribed, 9 for Abuse Report
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param channelName Name of selected channel.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @return ApiTypes.EventLog
     * @throws Exception
     */
    public EventLog events(LogEventStatusArray statuses, Date from, Date to, String channelName, int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (statuses != null) if (statuses != null) values.put("statuses", joinList(statuses));
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       values.put("channelName", channelName);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/log/events", values, EventLog.class);
   }

    /**
     * Export email log information to the specified file format.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param statuses List of comma separated message statuses: 0 for all, 1 for ReadyToSend, 2 for InProgress, 4 for Bounced, 5 for Sent, 6 for Opened, 7 for Clicked, 8 for Unsubscribed, 9 for Abuse Report
     * @param fileFormat Format of the exported file
     * @param from Start date.
     * @param to End date.
     * @param channelName Name of selected channel.
     * @param includeEmail True: Search includes emails. Otherwise, false.
     * @param includeSms True: Search includes SMS. Otherwise, false.
     * @param messageCategory ID of message category
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file including extension.
     * @param email Proper email address.
     * @return ApiTypes.ExportLink
     * @throws Exception
     */
    public ExportLink export(LogJobStatusArray statuses, ExportFileFormats fileFormat, Date from, Date to, String channelName, Boolean includeEmail, Boolean includeSms, MessageCategoryArray messageCategory, CompressionFormat compressionFormat, String fileName, String email) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (statuses != null) values.put("statuses", joinList(statuses));
       values.put("fileFormat", String.valueOf(fileFormat));
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       values.put("channelName", channelName);
       values.put("includeEmail", String.valueOf(includeEmail));
       values.put("includeSms", String.valueOf(includeSms));
       if (messageCategory != null) if (messageCategory != null) values.put("messageCategory", joinList(messageCategory));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       values.put("email", email);
       return uploadValues(API_URI + "/log/export", values, ExportLink.class);
   }

    /**
     * Export delivery events log information to the specified file format.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param statuses List of comma separated message statuses: 0 for all, 1 for ReadyToSend, 2 for InProgress, 4 for Bounced, 5 for Sent, 6 for Opened, 7 for Clicked, 8 for Unsubscribed, 9 for Abuse Report
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param channelName Name of selected channel.
     * @param fileFormat Format of the exported file
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file including extension.
     * @return ApiTypes.ExportLink
     * @throws Exception
     */
    public ExportLink exportEvents(LogEventStatusArray statuses, Date from, Date to, String channelName, ExportFileFormats fileFormat, CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (statuses != null) if (statuses != null) values.put("statuses", joinList(statuses));
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       values.put("channelName", channelName);
       values.put("fileFormat", String.valueOf(fileFormat));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       return uploadValues(API_URI + "/log/exportevents", values, ExportLink.class);
   }

    /**
     * Export detailed link tracking information to the specified file format.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param channelName Name of selected channel.
     * @param fileFormat Format of the exported file
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file including extension.
     * @return ApiTypes.ExportLink
     * @throws Exception
     */
    public ExportLink exportLinkTracking(Date from, Date to, String channelName, ExportFileFormats fileFormat, int limit, int offset, CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       values.put("channelName", channelName);
       values.put("fileFormat", String.valueOf(fileFormat));
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       return uploadValues(API_URI + "/log/exportlinktracking", values, ExportLink.class);
   }

    /**
     * Track link clicks
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @param channelName Name of selected channel.
     * @return ApiTypes.LinkTrackingDetails
     * @throws Exception
     */
    public LinkTrackingDetails linkTracking(Date from, Date to, int limit, int offset, String channelName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       values.put("channelName", channelName);
       return uploadValues(API_URI + "/log/linktracking", values, LinkTrackingDetails.class);
   }

    /**
     * Returns logs filtered by specified parameters.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param statuses List of comma separated message statuses: 0 for all, 1 for ReadyToSend, 2 for InProgress, 4 for Bounced, 5 for Sent, 6 for Opened, 7 for Clicked, 8 for Unsubscribed, 9 for Abuse Report
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param channelName Name of selected channel.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @param includeEmail True: Search includes emails. Otherwise, false.
     * @param includeSms True: Search includes SMS. Otherwise, false.
     * @param messageCategory ID of message category
     * @param email Proper email address.
     * @param ipaddress Search for recipients that we sent through this IP address
     * @return ApiTypes.Log
     * @throws Exception
     */
    public ApiTypes.Log load(LogJobStatusArray statuses, Date from, Date to, String channelName, int limit, int offset, Boolean includeEmail, Boolean includeSms, MessageCategoryArray messageCategory, String email, String ipaddress) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (statuses != null) values.put("statuses", joinList(statuses));
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       values.put("channelName", channelName);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       values.put("includeEmail", String.valueOf(includeEmail));
       values.put("includeSms", String.valueOf(includeSms));
       if (messageCategory != null) if (messageCategory != null) values.put("messageCategory", joinList(messageCategory));
       values.put("email", email);
       values.put("ipaddress", ipaddress);
       return uploadValues(API_URI + "/log/load", values, ApiTypes.Log.class);
   }

    /**
     * Returns notification logs filtered by specified parameters.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param statuses List of comma separated message statuses: 0 for all, 1 for ReadyToSend, 2 for InProgress, 4 for Bounced, 5 for Sent, 6 for Opened, 7 for Clicked, 8 for Unsubscribed, 9 for Abuse Report
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @param messageCategory ID of message category
     * @param useStatusChangeDate True, if 'from' and 'to' parameters should resolve to the Status Change date. To resolve to the creation date - false
     * @param notificationType 
     * @return ApiTypes.Log
     * @throws Exception
     */
    public ApiTypes.Log loadNotifications(LogJobStatusArray statuses, Date from, Date to, int limit, int offset, MessageCategoryArray messageCategory, Boolean useStatusChangeDate, NotificationType notificationType) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (statuses != null) values.put("statuses", joinList(statuses));
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       if (messageCategory != null) if (messageCategory != null) values.put("messageCategory", joinList(messageCategory));
       values.put("useStatusChangeDate", String.valueOf(useStatusChangeDate));
       values.put("notificationType", String.valueOf(notificationType));
       return uploadValues(API_URI + "/log/loadnotifications", values, ApiTypes.Log.class);
   }

    /**
     * Loads summary information about activity in chosen date range.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param channelName Name of selected channel.
     * @param interval 'Hourly' for detailed information, 'summary' for daily overview
     * @param transactionID ID number of transaction
     * @return ApiTypes.LogSummary
     * @throws Exception
     */
    public LogSummary summary(Date from, Date to, String channelName, IntervalType interval, String transactionID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("from", String.valueOf(from));
       values.put("to", String.valueOf(to));
       values.put("channelName", channelName);
       values.put("interval", String.valueOf(interval));
       values.put("transactionID", transactionID);
       return uploadValues(API_URI + "/log/summary", values, LogSummary.class);
   }

}

