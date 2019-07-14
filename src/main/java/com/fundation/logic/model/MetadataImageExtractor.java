/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model;

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

    /**
     * This method returns metadata image height.
     */
    public static String getHeight(File pathFile) {
        String height = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((height = stdInput.readLine()) != null) {
                if ((height.contains("Image Height"))) {
                    int initIndex = height.indexOf(":");
                    int endIndex = height.length();
                    int freeSpace = 2;
                    height = height.substring(initIndex +freeSpace, endIndex);
                    return height;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "There is not image Height";
    }

    /**
     * This method returns metadata image Width.
     */
    public static String getWidth(File pathFile) {
        String width = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((width = stdInput.readLine()) != null) {
                if ((width.contains("Image Width"))) {
                    int initIndex = width.indexOf(":");
                    int endIndex = width.length();
                    int freeSpace = 2;
                    width = width.substring(initIndex + freeSpace, endIndex);
                    return width;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "There is not image Width";
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

    /**
     * This method returns metadata file type.
     */
    public static String getFileType(File pathFile) {
        String imageFileType = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((imageFileType = stdInput.readLine()) != null) {
                if ((imageFileType.contains("File Type"))) {
                    int initIndex = imageFileType.indexOf(":");
                    int endIndex = imageFileType.length();
                    int freeSpace = 2;
                    imageFileType = imageFileType.substring(initIndex + freeSpace, endIndex);
                    return imageFileType;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "There is not file type";
    }
}
