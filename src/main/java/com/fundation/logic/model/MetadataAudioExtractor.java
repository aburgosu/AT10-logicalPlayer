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
 * Implements the MetadataAudioExtractor class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataAudioExtractor {

    /**
     * This method returns duration of the audio.
     */
    public String getAudioChannel(File pathFile) {
        String channelMode = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((stdInput.readLine()) != null) {
                channelMode = stdInput.readLine();
                if ((channelMode.contains("Lame Stereo Mode"))) {
                    int initIndex = channelMode.indexOf(":");
                    int endIndex = channelMode.length();
                    int freeSpace = 2;
                    channelMode = channelMode.substring(initIndex + freeSpace, endIndex);
                    return channelMode;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return "there is not audio channel";
    }

    /**
     * This method returns metadata sample rate.
     */
    public String getSampleRate(File pathFile) {
        String sampleRate = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((sampleRate = stdInput.readLine()) != null) {
                if ((sampleRate.contains("Sample Rate"))) {
                    int initIndex = sampleRate.indexOf(":");
                    int endIndex = sampleRate.length();
                    int freeSpace = 2;
                    sampleRate = sampleRate.substring(initIndex + freeSpace, endIndex);
                    return sampleRate;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "There is not sample rate";
    }

    /**
     * This method returns duration of the audio.
     */
    public String getDuration(File pathFile) {
        String duration = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((duration = stdInput.readLine()) != null) {
                if ((duration.contains("Duration"))) {
                    int initIndex = duration.indexOf(":");
                    int endIndex = duration.length();
                    int freeSpace = 2;
                    int unnecesaryWords = 9;
                    duration = duration.substring(initIndex + freeSpace, endIndex - unnecesaryWords);
                    System.out.println("test" + duration);
                    return duration;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return "There is not duration";
    }
}
