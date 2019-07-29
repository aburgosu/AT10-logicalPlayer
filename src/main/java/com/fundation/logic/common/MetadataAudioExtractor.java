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
 * Implements the MetadataAudioExtractor class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataAudioExtractor {
    private static Process extractMetadata;
    private static String searchChannelMode;
    private static String searchAudioCodec;
    private static String searchMimeType;
    private static String searchSampleRate;
    private static List<String> list;
    private static Float searchDuration;

    /**
     * This method read run exiftool.
     */
    public void run(String path) throws IOException {
        searchMimeType = null;
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
                audioChannel(metadata);
                audioCodec(metadata);
                sampleRAte(metadata);
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
        String mimetype2 = mimeType;
        String audioMimeType = mimeType.substring(0, 4);
        if ((audioMimeType.contains("MIME"))) {
            if (mimetype2.contains("audio")) {
                int initIndex = mimetype2.indexOf(":");
                int freeSpace = 2;
                mimeType = mimetype2.substring(initIndex + freeSpace, initIndex + 7);
                searchMimeType = mimeType;
            } else {
                searchMimeType = "All";
            }
        }
    }

    /**
     * This method returns duration of the audio.
     * @param channelMode
     */
    public static void audioChannel(String channelMode) {
        if ((channelMode.contains("Channel"))) {
            if (channelMode.contains("Stereo")) {
                searchChannelMode = "2.0";
            }
            if (channelMode.contains("Mono")) {
                searchChannelMode = "1.0";
            }
            if (channelMode.contains("2.1")) {
                searchChannelMode = "2.1";
            }
            if (channelMode.contains("5")) {
                searchChannelMode = "5.0";
            }
            if (channelMode.contains("5.1")) {
                searchChannelMode = "5.1";
            }
            if (channelMode.contains("6.1")) {
                searchChannelMode = "6.1";
            }
            if (channelMode.contains("7.1")) {
                searchChannelMode = "7.1";
            }
        }
    }

    /**
     * This method find audio codec .
     * @param audioCodec
     */
    public static void audioCodec(String audioCodec) {
        if ((audioCodec.contains("MIME Type"))) {
            if (audioCodec.contains("mpeg")) {
                searchAudioCodec = "MPEG-4 ALS";
            }
            if (audioCodec.contains("wav")) {
                searchAudioCodec = "WAV";
            }
            if (audioCodec.contains("mp3")) {
                searchChannelMode = "MP3";
            }
        }
    }

    /**
     * This method returns audrio codec to AudioSearch.
     * @return searchAudioCodec
     */
    public static String searchAudioCodec() {
        return searchAudioCodec;
    }

    /**
     * This method find metadata sample rate.
     * @param sampleRate
     */
    public static void sampleRAte(String sampleRate) {
        if ((sampleRate.contains("Sample Rate"))) {
            int initIndex = sampleRate.indexOf(":");
            int endIndex = sampleRate.length();
            int freeSpace = 2;
            sampleRate = sampleRate.substring(initIndex + freeSpace, endIndex);
            searchSampleRate = sampleRate+" Hz";
        }
    }

    /**
     * This method returns metadata sample rate.
     * @return searchSampreRate
     */
    public static String getSearchSampleRate() {
        return searchSampleRate;
    }

    /**
     * This method search duration.
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
            Float searchHour = Float.parseFloat(duration.substring(0, 1)) * hourToSeconds;
            Float searchMinute = Float.parseFloat(duration.substring(2, 4)) * minuteToSeconds;
            Float searchSeconds = Float.parseFloat(duration.substring(5, 7));
            searchDuration = (searchHour + searchMinute + searchSeconds) / 3600;
        }
    }

    /**
     * This method returns metadata list.
     * @return list
     */
    public static List<String> getSearchListMetadata() {
        return list;
    }

    /**
     * Return duration from the metadata.
     * @return searchDuration
     */
    public static Float getSearchDuration() {
        return searchDuration;
    }

    /**
     * Return mime type from the metadata.
     * @return searhMimeType
     */
    public static String getSearchMimeType() {
        return searchMimeType;
    }


    /**
     * This method returns audio channel.
     * @return  searchChannelMode
     */
    public static String getAudioChannel() {
        return searchChannelMode;
    }
}
