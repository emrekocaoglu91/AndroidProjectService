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
 * Manage SMTP and HTTP API Channels for grouping email delivery.
 */
public class Channel extends API
{
    /**
     * Manually add a Channel to your Account to group email.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param name Descriptive name of the channel.
     * @return String
     * @throws Exception
     */
    public String add(String name) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("name", name);
       return uploadValues(API_URI + "/channel/add", values, String.class);
   }

    /**
     * Delete the selected Channel.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param name The name of the Channel to delete.
     * @throws Exception
     */
    public void delete(String name) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("name", name);
       uploadValues(API_URI + "/channel/delete", values, VoidApiResponse.class);
   }

    /**
     * Export selected Channels to chosen file format.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param channelNames List of channel names used for processing
     * @param fileFormat Format of the exported file
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file including extension.
     * @return ApiTypes.ExportLink
     * @throws Exception
     */
    public ExportLink export(StringArray channelNames, ExportFileFormats fileFormat, CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (channelNames != null) values.put("channelNames", joinList(channelNames));
       values.put("fileFormat", String.valueOf(fileFormat));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       return uploadValues(API_URI + "/channel/export", values, ExportLink.class);
   }

    /**
     * Returns a list your Channels.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @return ApiTypes.ChannelArray
     * @throws Exception
     */
    public ChannelArray list(int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/channel/list", values, ChannelArray.class);
   }

    /**
     * Rename an existing Channel.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param name The name of the Channel to update.
     * @param newName The new name for the Channel.
     * @return String
     * @throws Exception
     */
    public String update(String name, String newName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("name", name);
       values.put("newName", newName);
       return uploadValues(API_URI + "/channel/update", values, String.class);
   }

}

