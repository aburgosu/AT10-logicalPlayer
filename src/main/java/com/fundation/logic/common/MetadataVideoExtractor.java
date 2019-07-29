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
 * Implements the MetadataVideoExtractor class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataVideoExtractor {
    static Process extractMetadata;
    static String searchFrameRate;
    static String searchAudioCodec;
    static String searchVideoCodec;
    static String searchHeight;
    private static List<String> list;
    private Float searchHour;
    private Float searchMinute;
    private Float searchSeconds;
    private static Float searchDuration;
    static String searchMimeType;

    public void run(String path) throws IOException {
        searchMimeType = null;
        extractMetadata = Runtime.getRuntime().exec(path);
        readAll();
    }

    /**
     * This method get all metadata and set in each method for get a specific metadata.
     */
    public void readAll() {
        String metadata = null;
        list = new ArrayList<>();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
        try {
            while ((metadata = stdInput.readLine()) != null) {
                frameRate(metadata);
                getVideoCodec(metadata);
                getHeight(metadata);
                getVideoAudioCodec(metadata);
                list.add(metadata);
                duration(metadata);
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
     * @param mimeType
     */
    public static void mimeType(String mimeType) {
        String validatorMimeType = mimeType;
        String videoMimeType = mimeType.substring(0, 4);
        if ((videoMimeType.contains("MIME"))) {
            if (validatorMimeType.contains("video")) {
                int initIndex = validatorMimeType.indexOf(":");
                int freeSpace = 2;
                mimeType = validatorMimeType.substring(initIndex + freeSpace, initIndex + 7);
                searchMimeType = mimeType;
            }
        }
    }

    /**
     * This method search metadata frame rate.
     * @param frameRate
     */
    public void frameRate(String frameRate) {
        if ((frameRate.contains("Frame Rate"))) {
            int initIndex = frameRate.indexOf(":");
            int endIndex = frameRate.length();
            int freeSpace = 2;
            frameRate = frameRate.substring(initIndex + freeSpace, endIndex);
            frameRate = Float.toString(Math.round(Float.parseFloat(frameRate)));
            int start = 0;
            int deleteDat0 = 2;
            frameRate = frameRate.substring(start, deleteDat0);
            this.searchFrameRate = frameRate;
        }
    }

    /**
     * This method search metadata resolution.
     * @param height
     */
    public void getHeight(String height) {
        if ((height.contains("Image Height"))) {
            int initIndex = height.indexOf(":");
            int endIndex = height.length();
            int freeSpace = 2;
            height = height.substring(initIndex + freeSpace, endIndex);
            searchHeight = height;
        }
    }

    /**
     * This method search metadata video codec.
     * @param videoCodec
     */
    public void getVideoCodec(String videoCodec) {
        if (videoCodec.contains("Video Codec")) {
            int initIndex = videoCodec.indexOf(":");
            int endIndex = videoCodec.length();
            int freeSpace = 2;
            videoCodec = videoCodec.substring(initIndex + freeSpace, endIndex);
            if (videoCodec.contains("Windows")) {
                videoCodec = "WMV";
                searchVideoCodec = videoCodec;
            }
            if (videoCodec.contains("MP")) {
                videoCodec = "MPEG-4";
                searchVideoCodec = videoCodec;
            }
        }
    }

    /**
     * This method search metadata audio codec.
     * @param videoAudioCodec
     */
    public void getVideoAudioCodec(String videoAudioCodec) {
        if (videoAudioCodec.contains("Audio Codec")) {
            int initIndex = videoAudioCodec.indexOf(":");
            int endIndex = videoAudioCodec.length();
            int freeSpace = 2;
            videoAudioCodec = videoAudioCodec.substring(initIndex + freeSpace, endIndex);
            if (videoAudioCodec.contains("Windows")) {
                videoAudioCodec = "WMA";
                searchAudioCodec = videoAudioCodec;
            }
            if (videoAudioCodec.contains("AAC")) {
                videoAudioCodec = "AAC";
                searchAudioCodec = videoAudioCodec;
            }
            if (videoAudioCodec.contains("MPEG")) {
                videoAudioCodec = "MPEG";
                searchAudioCodec = videoAudioCodec;
            }
        }
    }

    /**
     * This method search metadata duration.
     * @param duration
     */
    public void duration(String duration) {
        String validatorDuration = duration.substring(0, 8);
        if (validatorDuration.contains("Duration")) {
            int initIndex = duration.indexOf(":");
            int endIndex = duration.length();
            int freeSpace = 2;
            Float hourToSeconds = new Float(3600);
            Float minuteToSeconds = new Float(60);
            duration = duration.substring(initIndex + freeSpace, endIndex);
            searchHour = Float.parseFloat(duration.substring(0, 1)) * hourToSeconds;
            searchMinute = Float.parseFloat(duration.substring(2, 4)) * minuteToSeconds;
            searchSeconds = Float.parseFloat(duration.substring(5, 7));
            searchDuration = (searchHour + searchMinute + searchSeconds) / 3600;
        }
    }

    /**
     * This method return frame rate.
     * @return searchFrameRate
     */
    public static String getSearchFrameRate() {
        return searchFrameRate;
    }

    /**
     * This method return audio codec.
     * @return searchAudioCodec
     */
    public static String getSearchAudioCodec() {
        return searchAudioCodec;
    }

    /**
     * This method return video codec.
     * @return searchVideoCodec
     */
    public static String getSearchVideoCodec() {
        return searchVideoCodec;
    }

    /**
     * This method return image size.
     * @return searchHeight
     */
    public static String getSearchHeight() {
        return searchHeight;
    }

    /**
     * This method return metadata list.
     * @return list
     */
    public static List<String> getSearchListMetadata() {
        return list;
    }

    /**
     * This method return duration in decimal.
     * @return searchDuration
     */
    public static Float getSearchDuration() {
        return searchDuration;
    }

    /**
     * This method return mime type to CommonSearch.
     * @return searchMimeType
     */
    public static String getSearchMimeType() {
        return searchMimeType;
    }
}
