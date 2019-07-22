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

    public void run(String path) throws IOException {
        extractMetadata = Runtime.getRuntime().exec(path);
        readAll();
    }

//    public static String isVideo() {
//        String fileName = null;
//        try {
//            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
//            while ((fileName = stdInput.readLine()) != null) {
//                if ((fileName.contains("MIME Type"))) {
//                    System.out.println(fileName);
//                    if (fileName.contains("video")){
//                        System.out.println(fileName);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
//        return "All";
//    }

    /**
     * This method returns metadata frame rate.
     */
//    public static String getFileName() {
//        String fileName = null;
//        try {
//            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
//            while ((fileName = stdInput.readLine()) != null) {
//                if ((fileName.contains("File Name"))) {
//                    int initIndex = fileName.indexOf(":");
//                    int endIndex = fileName.length();
//                    int freeSpace = 2;
//                    fileName = fileName.substring(initIndex + freeSpace, endIndex);
//                    return fileName;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
//        return "All";
//    }

    /**
     * This method returns metadata frame rate.
     *
     * @return
     */
    public String readAll() {
        String frameRate = null;
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
        try {
            while ((frameRate = stdInput.readLine()) != null) {
                String s = frameRate;
                frameRate(s);
                getVideoCodec(s);
                getHeight(s);
                getVideoAudioCodec(s);
                if ((frameRate.contains("Read_All"))) {
                    int initIndex = frameRate.indexOf(":");
                    int endIndex = frameRate.length();
                    int freeSpace = 2;
                    frameRate = frameRate.substring(initIndex + freeSpace, endIndex);
                    frameRate = Float.toString(Math.round(Float.parseFloat(frameRate)));
                    int start = 0;
                    int deleteDat0 = 2;
                    frameRate = frameRate.substring(start, deleteDat0);
                    this.searchFrameRate = frameRate;
                    System.out.println(frameRate);
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

    public void mimeType(String mimeType) {
        frameRate(mimeType);
        getVideoCodec(mimeType);
        getHeight(mimeType);
        getVideoAudioCodec(mimeType);
        if ((mimeType.contains("Frame Rate"))) {
            int initIndex = mimeType.indexOf(":");
            int endIndex = mimeType.length();
            int freeSpace = 2;
            mimeType = mimeType.substring(initIndex + freeSpace, endIndex);
            mimeType = Float.toString(Math.round(Float.parseFloat(mimeType)));
            int start = 0;
            int deleteDat0 = 2;
            mimeType = mimeType.substring(start, deleteDat0);
            this.searchFrameRate = mimeType;
        }
    }

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
     * This method returns metadata file type.
     */
//    public static String getFileType() {
//        String videoFileType = null;
//        try {
//            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
//            while ((videoFileType = stdInput.readLine()) != null) {
//                if ((videoFileType.contains("File Type"))) {
//                    int initIndex = videoFileType.indexOf(":");
//                    int endIndex = videoFileType.length();
//                    int freeSpace = 2;
//                    videoFileType = videoFileType.substring(initIndex + freeSpace, endIndex);
//                    return videoFileType;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
//        return "All";
//    }

    /**
     * This method returns metadata resolution.
     */
    public void getHeight(String resolution) {
        //BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
        // String resolution = stdInput.readLine();
        //while ((resolution) != null) {
        //      System.out.println(resolution);
        if ((resolution.contains("Image Height"))) {
            int initIndex = resolution.indexOf(":");
            int endIndex = resolution.length();
            int freeSpace = 2;
            resolution = resolution.substring(initIndex + freeSpace, endIndex);
            searchHeight = resolution;
        }
    }
    //}

    /**
     * This method returns duration of the video.
     */
//    public static String getDuration(File pathFile) {
//        String duration = null;
//        try {
//            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
//            while ((stdInput.readLine()) != null) {
//                duration = stdInput.readLine();
//                if ((duration.contains("Duration"))) {
//                    int freeSpace = 2;
//                    int initIndex = duration.indexOf(":") + freeSpace;
//                    int endIndex = duration.length();
//                    duration = duration.substring(initIndex, endIndex);
//                    return duration;
//                }
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            System.exit(-1);
//        }
//        return "All";
//    }

    /**
     * This method returns duration of the video.
     */
//    public static String getTitle(File pathFile) {
//        String title = null;
//        try {
//            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
//            while ((title = stdInput.readLine()) != null) {
//                if (title.contains("Title")) {
//                    int initIndex = title.indexOf(":");
//                    int endIndex = title.length();
//                    int freeSpace = 2;
//                    title = title.substring(initIndex + freeSpace, endIndex);
//                    return title;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
//        return "All";
//    }

    /**
     * This method returns video codec.
     */
    public void getVideoCodec(String videoCodec) {
        //String videoCodec = null;
        //try {
        //  BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
        //  while ((videoCodec) != null) {
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
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
    }

    /**
     * This method returns video audio codec.
     */
    public void getVideoAudioCodec(String videoAudioCodec) {
        //     String videoAudioCodec = null;
        //   System.out.println(videoAudioCodec+"hhhhhhhhhhh");
        //BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
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

    public static String getSearchFrameRate() {
        return searchFrameRate;
    }

    public static String getACodec() {
        return searchAudioCodec;
    }

    public static String getSearchVideoCodec() {
        return searchVideoCodec;
    }

    public static String getSearchHeight() {
        return searchHeight;
    }
}
