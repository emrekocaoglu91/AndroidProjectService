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
 * Manage all aspects of your Campaigns.
 */
public class Campaign extends API
{
    /**
     * Adds a Campaign to the queue for processing based on the configuration.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param campaign JSON representation of a campaign
     * @return int
     * @throws Exception
     */
    public int add(ApiTypes.Campaign campaign) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("campaign", String.valueOf(campaign));
       return uploadValues(API_URI + "/campaign/add", values, int.class);
   }

    /**
     * Makes a copy of a campaign configuration and leaves it in draft mode for further editing.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param channelID ID number of selected Channel.
     * @param newCampaignName 
     * @return int
     * @throws Exception
     */
    public int copy(int channelID, String newCampaignName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("channelID", String.valueOf(channelID));
       values.put("newCampaignName", newCampaignName);
       return uploadValues(API_URI + "/campaign/copy", values, int.class);
   }

    /**
     * Deletes the Campaign.  This will not cancel emails that are in progress, see /log/cancelinprogress for this option.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param channelID ID number of selected Channel.
     * @throws Exception
     */
    public void delete(int channelID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("channelID", String.valueOf(channelID));
       uploadValues(API_URI + "/campaign/delete", values, VoidApiResponse.class);
   }

    /**
     * Export Campaign data to the chosen file format.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param channelIDs List of campaign IDs used for processing
     * @param fileFormat Format of the exported file
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file including extension.
     * @return ApiTypes.ExportLink
     * @throws Exception
     */
    public ExportLink export(Iterable<Integer> channelIDs, ExportFileFormats fileFormat, CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       if (channelIDs != null) values.put("channelIDs", joinList(channelIDs));
       values.put("fileFormat", String.valueOf(fileFormat));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       return uploadValues(API_URI + "/campaign/export", values, ExportLink.class);
   }

    /**
     * Returns a list all of your Campaigns.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param search Text fragment used for searching.
     * @param offset How many items should be returned ahead.
     * @param limit Maximum number of returned items.
     * @return ApiTypes.CampaignChannelArray
     * @throws Exception
     */
    public CampaignChannelArray list(String search, int offset, int limit) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("search", search);
       values.put("offset", String.valueOf(offset));
       values.put("limit", String.valueOf(limit));
       return uploadValues(API_URI + "/campaign/list", values, CampaignChannelArray.class);
   }

    /**
     * Updates a previously added Campaign.  Only Active and Paused campaigns can be updated.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param campaign JSON representation of a campaign
     * @return int
     * @throws Exception
     */
    public int update(ApiTypes.Campaign campaign) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("campaign", String.valueOf(campaign));
       return uploadValues(API_URI + "/campaign/update", values, int.class);
   }

}

