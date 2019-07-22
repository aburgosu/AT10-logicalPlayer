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
    static String searchColorSpace;
    private List<String> list;


    public void run(String path) throws IOException {
        extractMetadata = Runtime.getRuntime().exec(path);
        readAll();
    }

    /**
     * This method read all metadata.
     *
     * @return
     */
    public String readAll() {
        String metadata = null;
        list = new ArrayList<>();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
        try {
            while ((metadata = stdInput.readLine()) != null) {
                height(metadata);
                width(metadata);
                list.add(metadata);
                if ((metadata.contains("Read_All"))) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
            System.out.println("No paso frame rate");
        }
        return "NO hay";
    }

    /**
     * This method returns metadata image height.
     */
    public static void height(String height) {
        if ((height.contains("Image Height"))) {
            int initIndex = height.indexOf(":");
            int endIndex = height.length();
            int freeSpace = 2;
            searchHeight = height.substring(initIndex + freeSpace, endIndex);
        }
    }

    /**
     * This method returns height image.
     */
    public static String getHeight() {
        return searchHeight;
    }

    /**
     * This method returns metadata image Width.
     */
    public static void width(String width) {
        if ((width.contains("Image Width"))) {
            int initIndex = width.indexOf(":");
            int endIndex = width.length();
            int freeSpace = 2;
            width = width.substring(initIndex + freeSpace, endIndex);
            searchWidth = width;
        }
    }

    /**
     * This method returns width image.
     */
    public static String getWidth() {
        return searchWidth;
    }


    /**
     * This method returns metadata image color space.
     */
    public static void getColorSpace(String colorSpace) {
        if ((colorSpace.contains("Color Space"))) {
            int initIndex = colorSpace.indexOf(":");
            int endIndex = colorSpace.length();
            int freeSpace = 2;
            colorSpace = colorSpace.substring(initIndex + freeSpace, endIndex);
            searchColorSpace = colorSpace;
        }
    }

    /**
     * This method returns metadata list.
     */
    public List<String> getSearchListMetadata() {
        return list;
    }
}
