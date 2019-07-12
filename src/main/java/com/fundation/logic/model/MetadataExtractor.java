/**
 * Copyright (c) 2019 Jalasoft.
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
 * Implements the MetadataExtractor class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataExtractor {

    /**
     * This method returns metadata frame rate.
     */
    public String getFrameRate(File path) {
        String frameRate = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + path.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((frameRate = stdInput.readLine()) != null) {
                if ((frameRate.contains("Video Frame Rate"))) {
                    int initIndex = frameRate.indexOf(":");
                    int endIndex = frameRate.length();
                    frameRate = frameRate.substring(initIndex + 2, endIndex);
                    frameRate = Float.toString(Math.round(Float.parseFloat(frameRate)));
                    frameRate = frameRate.substring(0, 2);
                    return frameRate;
                }
            }
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    /**
     * This method returns metadata file type.
     */
    public String getFileType(File path) {
        String videoFileType = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + path.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((videoFileType = stdInput.readLine()) != null) {
                if ((videoFileType.contains("File Type"))) {
                    int initIndex = videoFileType.indexOf(":");
                    int endIndex = videoFileType.length();
                    videoFileType = videoFileType.substring(initIndex + 2, endIndex);
                    System.out.println(videoFileType);
                    return videoFileType;
                }
            }
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
