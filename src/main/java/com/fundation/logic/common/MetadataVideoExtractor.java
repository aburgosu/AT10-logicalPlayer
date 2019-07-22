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
                frameRate(metadata);
                getVideoCodec(metadata);
                getHeight(metadata);
                getVideoAudioCodec(metadata);
                list.add(metadata);
                if ((metadata.contains("Read_All"))) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "Metadata No available";
    }

    /**
     * This method search metadata frame rate.
     *
     * @return
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
     * This method search video codec.
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
     * This method seach video audio codec.
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
     * This method return frame rate.
     * @return
     */
    public static String getSearchFrameRate() {
        return searchFrameRate;
    }

    /**
     * This method return audio codec.
     * @return
     */
    public static String getSearchAudioCodec() {
        return searchAudioCodec;
    }

    /**
     * This method return video codec.
     * @return
     */
    public static String getSearchVideoCodec() {
        return searchVideoCodec;
    }

    /**
     * This method return image size.
     * @return
     */
    public static String getSearchHeight() {
        return searchHeight;
    }

    /**
     * This method return metadata list.
     * @return
     */
    public List<String> getSearchListMetadata() {
        return list;
    }

}
