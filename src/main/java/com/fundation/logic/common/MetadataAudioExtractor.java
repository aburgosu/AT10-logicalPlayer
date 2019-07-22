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
import java.io.File;
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
                audioChannel(metadata);
                audioCodec(metadata);
                mimeType(metadata);
                sampleRAte(metadata);
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
     * This method returns duration of the audio.
     */
    public static void audioChannel(String channelMode) {
        if ((channelMode.contains("Channel"))) {
            if (channelMode.contains("Stereo")){
                searchChannelMode = "2";
            }
            if (channelMode.contains("Mono")){
                searchChannelMode = "1";
            }
        }
    }
    /**
     * This method returns audio channel.
     */
    public static String getAudioChannel(){
        return searchChannelMode;
    }

    /**
     * This method find audio codec .
     */
    public static void audioCodec(String audioCodec) {
        if ((audioCodec.contains("MIME Type"))) {
            if (audioCodec.contains("mpeg")){
                searchAudioCodec = "MPEG-4 ALS";
            }
            if (audioCodec.contains("wav")){
                searchAudioCodec = "WAV";
            }
            if (audioCodec.contains("mp3")){
                searchChannelMode = "MP3";
            }
        }
    }

    /**
     * This method returns audrio codec to AudioSearch.
     */
    public static String searchAudioCodec(){
        return searchAudioCodec;
    }

    /**
     * This method find mime type of the audio.
     */
    public static void mimeType(String mimeType) {
        if ((mimeType.contains("MIME Type"))) {
            if (mimeType.contains("audio")) {
                searchMimeType = "audio";
            }
        }
    }

    /**
     * This method returns mime type to AudioSearch.
     */
    public static String searchMimeType(){
        return searchMimeType;
    }

    /**
     * This method find metadata sample rate.
     */
    public static void sampleRAte(String sampleRate) {
        if ((sampleRate.contains("Sample Rate"))) {
            int initIndex = sampleRate.indexOf(":");
            int endIndex = sampleRate.length();
            int freeSpace = 2;
            sampleRate = sampleRate.substring(initIndex + freeSpace, endIndex);
            searchSampleRate = sampleRate;
        }
    }

    /**
     * This method returns metadata sample rate.
     */
    public static String getSearchSampleRate(){
        return searchSampleRate;
    }

    /**
     * This method returns duration of the audio.
     */
    public static String getDuration(File pathFile) {
        String duration = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((duration = stdInput.readLine()) != null) {
                if ((duration.contains("Duration"))) {
                    int initIndex = duration.indexOf(":");
                    int endIndex = duration.length();
                    int freeSpace = 2;
                    int unnecesaryWords = 9;
                    duration = duration.substring(initIndex + freeSpace, endIndex - unnecesaryWords);
                    return duration;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return "There is not duration";
    }

    /**
     * This method returns metadata list.
     */
    public List<String> getSearchListMetadata() {
        return list;
    }
}
