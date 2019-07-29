/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the MetadataImageExtractor class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataCommonExtractor {

    static Process extractMetadata;
    static String searchMimeType;
    static List<String> list;

    public void run(String path) throws IOException {
        extractMetadata = Runtime.getRuntime().exec(path);
        readAll();
    }

    /**
     * This method read all metadata.
     * @return void
     */
    public void readAll() {
        String metadata = null;
        list = new ArrayList<>();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
        try {
            while ((metadata = stdInput.readLine()) != null) {
                list.add(metadata);
                mimeType(metadata);
                if ((metadata.contains("Read_All"))) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method read mime type.
     * @return void
     */
    public static void mimeType(String mimeType) {
        String audioMimeType = mimeType.substring(0, 9);
        if ((audioMimeType.contains("MIME Type"))) {
            if (mimeType.contains("audio")) {
                searchMimeType = "Audio";
            }
            if (mimeType.contains("video")) {
                searchMimeType = "Video";
            }
            if (mimeType.contains("txt")) {
                searchMimeType = "Text";
            }
            if (mimeType.contains("image")) {
                searchMimeType = "Image";
            }
            if (mimeType.contains("application")) {
                searchMimeType = "Application";
            }
        }
    }

    /**
     * This method return mime type to CommonSearch.
     * @return searchMimeType
     */
    public static String getSearchMimeType() {
        return searchMimeType;
    }

    /**
     * This method return metadata list to CommonSearch.
     * @return list
     */
    public static List<String> getSearchListMetadata() {
        return list;
    }
}
