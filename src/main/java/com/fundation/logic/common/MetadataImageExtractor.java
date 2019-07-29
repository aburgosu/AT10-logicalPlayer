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
public class MetadataImageExtractor {
    static Process extractMetadata;
    static String searchWidth;
    static String searchHeight;
    private static String searchColorSpace;
    private static List<String> list;
    private static String searchMimeType;
    private static final int FREESPACE = 2;

    public void run(String path) throws IOException {
        searchColorSpace = null;
        extractMetadata = Runtime.getRuntime().exec(path);
        readAll();
    }

    /**
     * This method read all metadata.
     */
    public void readAll() {
        String metadata = null;
        list = new ArrayList<>();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
        try {
            while ((metadata = stdInput.readLine()) != null) {
                findColorSpace(metadata);
                findHeight(metadata);
                findWidth(metadata);
                list.add(metadata);
                findMimeType(metadata);
                if ((metadata.contains("Read_All"))) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method read mime type.
     * @param mimeType
     */
    public static void findMimeType(String mimeType) {
        String imageMimeType = mimeType;
        String validatorMimeType = mimeType.substring(0, 4);
        if ((validatorMimeType.contains("MIME"))) {
            if (imageMimeType.contains("image")) {
                int initIndex = imageMimeType.indexOf(":");
                mimeType = imageMimeType.substring(initIndex + FREESPACE, initIndex + 7);
                searchMimeType = mimeType;
            } else {
                searchMimeType = "All";
            }
        }
    }

    /**
     * This method returns metadata image height.
     * @param height
     */
    public static void findHeight(String height) {
        if ((height.contains("Image Height"))) {
            int initIndex = height.indexOf(":");
            int endIndex = height.length();
            searchHeight = height.substring(initIndex + FREESPACE, endIndex);
        }
    }

    /**
     * This method returns metadata image Width.
     * @param width
     */
    public static void findWidth(String width) {
        if ((width.contains("Image Width"))) {
            int initIndex = width.indexOf(":");
            int endIndex = width.length();
            width = width.substring(initIndex + FREESPACE, endIndex);
            searchWidth = width;
        }
    }

    /**
     * This method returns metadata image color space.
     * @param mimeType
     */
    public static void findColorSpace(String mimeType) {
        String mimetype2 = mimeType;
        String audioMimeType = mimeType.substring(0, 5);
        if ((audioMimeType.contains("Color"))) {
            if (mimetype2.contains("RG")) {
                searchColorSpace = "RG";
            }
            if (mimetype2.contains("RGB")) {
                searchColorSpace = "RGB";
            }
            if (mimetype2.contains("sRGB")) {
                searchColorSpace = "sRGB";
            }
            if (mimetype2.contains("MCY")) {
                searchColorSpace = "MCY";
            }
            if (mimetype2.contains("CMYK")) {
                searchColorSpace = "CMYK";
            }
        }
    }

    /**
     * This method returns metadata color space.
     * @return searchColorSpace
     */
    public static String getSearchColorSpace() {
        return searchColorSpace;
    }

    /**
     * This method returns metadata list.
     * @return list
     */
    public static List<String> getSearchListMetadata() {
        return list;
    }

    /**
     * This method return mime type to CommonSearch.
     * @return searchMimeType
     */
    public static String getSearchMimeType() {
        return searchMimeType;
    }

    /**
     * This method returns height image.
     * @return searchHeight
     */
    public static String getHeight() {
        return searchHeight;
    }

    /**
     * This method returns width image.
     * @return searchWidth
     */
    public static String getWidth() {
        return searchWidth;
    }
}
