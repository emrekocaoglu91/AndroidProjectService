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
 * Manage the files on your account
 */
public class File extends API
{
    /**
     * Permanently deletes the file from your Account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param fileID Unique identifier for the file stored in your Account.
     * @param filename Name of your file including extension.
     * @throws Exception
     */
    public void delete(int fileID, String filename) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("fileID", String.valueOf(fileID));
       values.put("filename", filename);
       uploadValues(API_URI + "/file/delete", values, VoidApiResponse.class);
   }

    /**
     * Downloads the file to your local device.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param filename Name of your file including extension.
     * @param fileID Unique identifier for the file stored in your Account.
     * @return FileData
     * @throws Exception
     */
    public FileData download(String filename, int fileID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("filename", filename);
       values.put("fileID", String.valueOf(fileID));
       return uploadValues(API_URI + "/file/download", values, FileData.class);
   }

    /**
     * Lists all your available files.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.FileArray
     * @throws Exception
     */
    public FileArray listAll() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/file/listall", values, FileArray.class);
   }

    /**
     * Returns detailed file information for the given file.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param filename Name of your file including extension.
     * @return ApiTypes.File
     * @throws Exception
     */
    public ApiTypes.File load(String filename) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("filename", filename);
       return uploadValues(API_URI + "/file/load", values, ApiTypes.File.class);
   }

    /**
     * Uploads selected file to your Account using http form upload format (MIME multipart/form-data) or PUT method.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param file 
     * @param name Filename
     * @param expiresAfterDays Number of days the file should be stored for.
     * @param enforceUniqueFileName If a file exists with the same name do not upload and override the file.
     * @return ApiTypes.File
     * @throws Exception
     */
    public ApiTypes.File upload(FileData file, String name, int expiresAfterDays, Boolean enforceUniqueFileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("name", name);
       values.put("expiresAfterDays", String.valueOf(expiresAfterDays));
       values.put("enforceUniqueFileName", String.valueOf(enforceUniqueFileName));
       return httpPostFile(API_URI + "/file/upload", Arrays.asList(file), values, ApiTypes.File.class);
   }

}

