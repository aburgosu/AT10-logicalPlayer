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
 * Implements the MetadataVideoExtractor class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataVideoExtractor {


    /**
     * This method returns metadata frame rate.
     */
    public static String getFileName(File pathFile) {
        String fileName = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((fileName = stdInput.readLine()) != null) {
                if ((fileName.contains("File Name"))) {
                    int initIndex = fileName.indexOf(":");
                    int endIndex = fileName.length();
                    int freeSpace = 2;
                    fileName = fileName.substring(initIndex + freeSpace, endIndex);
                    return fileName;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "All";
    }

    /**
     * This method returns metadata frame rate.
     */
    public static String getFrameRate(File pathFile) {
        String frameRate = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((frameRate = stdInput.readLine()) != null) {
                if ((frameRate.contains("Video Frame Rate"))) {
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
        }
        return "All";
    }

    /**
     * This method returns metadata file type.
     */
    public static String getFileType(File pathFile) {
        String videoFileType = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((videoFileType = stdInput.readLine()) != null) {
                if ((videoFileType.contains("File Type"))) {
                    int initIndex = videoFileType.indexOf(":");
                    int endIndex = videoFileType.length();
                    int freeSpace = 2;
                    videoFileType = videoFileType.substring(initIndex + freeSpace, endIndex);
                    return videoFileType;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "All";
    }

    /**
     * This method returns metadata resolution.
     */
    public static String getResolution(File pathFile) {
        String resolution = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((resolution = stdInput.readLine()) != null) {
                if ((resolution.contains("Image Height"))) {
                    int initIndex = resolution.indexOf(":");
                    int endIndex = resolution.length();
                    int freeSpace = 2;
                    resolution = resolution.substring(initIndex + freeSpace, endIndex);
                    return resolution;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "All";
    }

    /**
     * This method returns duration of the video.
     */
    public static String getDuration(File pathFile) {
        String duration = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((stdInput.readLine()) != null) {
                duration = stdInput.readLine();
                if ((duration.contains("Duration"))) {
                    int freeSpace = 2;
                    int initIndex = duration.indexOf(":") + freeSpace;
                    int endIndex = duration.length();
                    duration = duration.substring(initIndex, endIndex);
                    return duration;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return "All";
    }

    /**
     * This method returns duration of the video.
     */
    public static String getTitle(File pathFile) {
        String title = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((title = stdInput.readLine()) != null) {
                if (title.contains("Title")) {
                    int initIndex = title.indexOf(":");
                    int endIndex = title.length();
                    int freeSpace = 2;
                    title = title.substring(initIndex + freeSpace, endIndex);
                    return title;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "All";
    }

    /**
     * This method returns video codec.
     */
    public static String getVideoCodec(File pathFile) {
        String videoCodec = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((videoCodec = stdInput.readLine()) != null) {
                if (videoCodec.contains("Video Codec")) {
                    int initIndex = videoCodec.indexOf(":");
                    int endIndex = videoCodec.length();
                    int freeSpace = 2;
                    videoCodec = videoCodec.substring(initIndex + freeSpace, endIndex);
                    if (videoCodec.contains("Windows")) {
                        videoCodec = "WMV";
                        return videoCodec;
                    }
                    if (videoCodec.contains("MP")) {
                        videoCodec = "MPEG-4";
                        return videoCodec;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "All";
    }

    /**
     * This method returns video audio codec.
     */
    public static String getVideoAudioCodec(File pathFile) {
        String videoAudioCodec = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("thirdParty/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((videoAudioCodec = stdInput.readLine()) != null) {
                if (videoAudioCodec.contains("Audio Codec")) {
                    int initIndex = videoAudioCodec.indexOf(":");
                    int endIndex = videoAudioCodec.length();
                    int freeSpace = 2;
                    videoAudioCodec = videoAudioCodec.substring(initIndex + freeSpace, endIndex);
                    if (videoAudioCodec.contains("Windows")) {
                        videoAudioCodec = "WMA";
                        return videoAudioCodec;
                    }
                    if (videoAudioCodec.contains("AAC")) {
                        videoAudioCodec = "AAC";
                        return videoAudioCodec;
                    }
                    if (videoAudioCodec.contains("MPEG")) {
                        videoAudioCodec = "MPEG";
                        return videoAudioCodec;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "All";
    }
}
