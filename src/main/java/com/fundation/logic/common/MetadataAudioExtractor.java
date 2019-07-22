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
                audioChannel(s);
                audioCodec(s);
                mimeType(s);
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

    public static String getAudioChannel(){
        return searchChannelMode;
    }

    /**
     * This method returns duration of the audio.
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

    public static String searchAudioCodec(){
        return searchAudioCodec;
    }

    public static void mimeType(String mimeType) {
        if ((mimeType.contains("MIME Type"))) {
            if (mimeType.contains("audio")) {
                searchMimeType = "audio";
            }
        }
    }

    public static String searchMimeType(){
        return searchMimeType;
    }

    /**
     * This method returns metadata sample rate.
     */
    public static String getSampleRate(File pathFile) {
        String sampleRate = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
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
