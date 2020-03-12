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
 * Manage all of the exported data from the system.
 */
public class Export extends API
{
    /**
     * Check the current status of the export.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param publicExportID ID of the exported file
     * @return ApiTypes.ExportStatus
     * @throws Exception
     */
    public ExportStatus checkStatus(UUID publicExportID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicExportID", String.valueOf(publicExportID));
       return uploadValues(API_URI + "/export/checkstatus", values, ExportStatus.class);
   }

    /**
     * Delete the specified export.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param publicExportID ID of the exported file
     * @throws Exception
     */
    public void delete(UUID publicExportID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicExportID", String.valueOf(publicExportID));
       uploadValues(API_URI + "/export/delete", values, VoidApiResponse.class);
   }

    /**
     * Download the specified export files in one package
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param publicExportIDs 
     * @return FileData
     * @throws Exception
     */
    public FileData downloadBulk(Iterable<UUID> publicExportIDs) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (publicExportIDs != null) values.put("publicExportIDs", joinList(publicExportIDs));
       return uploadValues(API_URI + "/export/downloadbulk", values, FileData.class);
   }

    /**
     * Returns a list of all exported data.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @return ApiTypes.ExportArray
     * @throws Exception
     */
    public ExportArray list(int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/export/list", values, ExportArray.class);
   }

}

