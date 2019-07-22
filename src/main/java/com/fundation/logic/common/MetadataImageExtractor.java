/**
 * Copyright (c) 2019 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String frameRate = null;
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
        try {
            while ((frameRate = stdInput.readLine()) != null) {
                String s = frameRate;
                height(s);
                width(s);
                if ((frameRate.contains("Read_All"))) {
                    int initIndex = frameRate.indexOf(":");
                    int endIndex = frameRate.length();
                    int freeSpace = 2;
                    frameRate = frameRate.substring(initIndex + freeSpace, endIndex);
                    frameRate = Float.toString(Math.round(Float.parseFloat(frameRate)));
                    int start = 0;
                    int deleteDat0 = 2;
                    frameRate = frameRate.substring(start, deleteDat0);
                    return frameRate;
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

    public static String getHeight() {
        return searchHeight;
    }

    /**
     * This method returns metadata image Width.
     */
    public static void width(String width) {
        System.out.println(width+"asdfasdfadsf");
        if ((width.contains("Image Width"))) {
            int initIndex = width.indexOf(":");
            int endIndex = width.length();
            int freeSpace = 2;
            width = width.substring(initIndex + freeSpace, endIndex);
            searchWidth = width;
        }
    }

    public static String getWidth() {
        return searchWidth;
    }


    /**
     * This method returns metadata image color space.
     */
    public static String getColorSpace(File pathFile) {
        String colorSpace = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((colorSpace = stdInput.readLine()) != null) {
                if ((colorSpace.contains("Color Space"))) {
                    int initIndex = colorSpace.indexOf(":");
                    int endIndex = colorSpace.length();
                    int freeSpace = 2;
                    colorSpace = colorSpace.substring(initIndex + freeSpace, endIndex);
                    return colorSpace;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "There is not color space";
    }
}
