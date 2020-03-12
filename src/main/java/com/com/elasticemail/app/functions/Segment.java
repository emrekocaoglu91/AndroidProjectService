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
 * Manages your segments - dynamically created lists of contacts
 */
public class Segment extends API
{
    /**
     * Create new segment, based on specified RULE.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param segmentName Name of your segment.
     * @param rule Query used for filtering.
     * @return ApiTypes.Segment
     * @throws Exception
     */
    public ApiTypes.Segment add(String segmentName, String rule) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("segmentName", segmentName);
       values.put("rule", rule);
       return uploadValues(API_URI + "/segment/add", values, ApiTypes.Segment.class);
   }

    /**
     * Copy your existing Segment with the optional new rule and custom name
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param sourceSegmentName The name of the segment you want to copy
     * @param newSegmentName New name of your segment if you want to change it.
     * @param rule Query used for filtering.
     * @return ApiTypes.Segment
     * @throws Exception
     */
    public ApiTypes.Segment copy(String sourceSegmentName, String newSegmentName, String rule) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("sourceSegmentName", sourceSegmentName);
       values.put("newSegmentName", newSegmentName);
       values.put("rule", rule);
       return uploadValues(API_URI + "/segment/copy", values, ApiTypes.Segment.class);
   }

    /**
     * Delete existing segment.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param segmentName Name of your segment.
     * @throws Exception
     */
    public void delete(String segmentName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("segmentName", segmentName);
       uploadValues(API_URI + "/segment/delete", values, VoidApiResponse.class);
   }

    /**
     * Exports all the contacts from the provided segment
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param segmentName Name of your segment.
     * @param fileFormat Format of the exported file
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file including extension.
     * @return ApiTypes.ExportLink
     * @throws Exception
     */
    public ExportLink export(String segmentName, ExportFileFormats fileFormat, CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("segmentName", segmentName);
       values.put("fileFormat", String.valueOf(fileFormat));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       return uploadValues(API_URI + "/segment/export", values, ExportLink.class);
   }

    /**
     * Lists all your available Segments
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param includeHistory True: Include history of last 30 days. Otherwise, false.
     * @param from From what date should the segment history be shown. In YYYY-MM-DDThh:mm:ss format.
     * @param to To what date should the segment history be shown. In YYYY-MM-DDThh:mm:ss format.
     * @return ApiTypes.SegmentArray
     * @throws Exception
     */
    public SegmentArray list(Boolean includeHistory, Date from, Date to) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("includeHistory", String.valueOf(includeHistory));
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       return uploadValues(API_URI + "/segment/list", values, SegmentArray.class);
   }

    /**
     * Lists your available Segments using the provided names
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param segmentNames Names of segments you want to load. Will load all contacts if left empty or the 'All Contacts' name has been provided
     * @param includeHistory True: Include history of last 30 days. Otherwise, false.
     * @param from From what date should the segment history be shown. In YYYY-MM-DDThh:mm:ss format.
     * @param to To what date should the segment history be shown. In YYYY-MM-DDThh:mm:ss format.
     * @return ApiTypes.SegmentArray
     * @throws Exception
     */
    public SegmentArray loadByName(StringArray segmentNames, Boolean includeHistory, Date from, Date to) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (segmentNames != null) values.put("segmentNames", joinList(segmentNames));
       values.put("includeHistory", String.valueOf(includeHistory));
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       return uploadValues(API_URI + "/segment/loadbyname", values, SegmentArray.class);
   }

    /**
     * Lists your available Segments with tracked history option on
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param includeHistory True: Include history of last 30 days. Otherwise, false.
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @return ApiTypes.SegmentArray
     * @throws Exception
     */
    public SegmentArray loadTrackedHistory(Boolean includeHistory, Date from, Date to) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("includeHistory", String.valueOf(includeHistory));
       if (from != null) values.put("from", String.valueOf(from));
       if (to != null) values.put("to", String.valueOf(to));
       return uploadValues(API_URI + "/segment/loadtrackedhistory", values, SegmentArray.class);
   }

    /**
     * Rename or change RULE for your segment
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param segmentName Name of your segment.
     * @param newSegmentName New name of your segment if you want to change it.
     * @param rule Query used for filtering.
     * @param trackHistory 
     * @return ApiTypes.Segment
     * @throws Exception
     */
    public ApiTypes.Segment update(String segmentName, String newSegmentName, String rule, Boolean trackHistory) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("segmentName", segmentName);
       values.put("newSegmentName", newSegmentName);
       values.put("rule", rule);
       values.put("trackHistory", String.valueOf(trackHistory));
       return uploadValues(API_URI + "/segment/update", values, ApiTypes.Segment.class);
   }

}

