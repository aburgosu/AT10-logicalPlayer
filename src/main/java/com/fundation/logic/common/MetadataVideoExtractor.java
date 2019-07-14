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
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
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
        return "No file name";
    }

    /**
     * This method returns metadata frame rate.
     */
    public static String getFrameRate(File pathFile) {
        String frameRate = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
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
        return "No Frame rate";
    }

    /**
     * This method returns metadata file type.
     */
    public static String getFileType(File pathFile) {
        String videoFileType = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile);
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
        return "No file type";
    }

    /**
     * This method returns metadata image height.
     */
    public static String getHeight(File pathFile) {
        String height = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((height = stdInput.readLine()) != null) {
                if ((height.contains("Image Height"))) {
                    int initIndex = height.indexOf(":");
                    int endIndex = height.length();
                    int freeSpace = 2;
                    height = height.substring(initIndex + freeSpace, endIndex);
                    return height;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "No resolution";
    }

    /**
     * This method returns metadata image width.
     */
    public static String getWidth(File pathFile) {
        String width = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
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
        return "No resolution";
    }

    /**
     * This method returns duration of the video.
     */
    public static String getDuration(File pathFile) {
        String duration = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
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
        return "No Duration";
    }

    /**
     * This method returns duration of the video.
     */
    public static String getTitle(File pathFile) {
        String title = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
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
        return "No title";
    }

    /**
     * This method returns video codec.
     */
    public static String getVideoCodec(File pathFile) {
        String videoCodec = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
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
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "No video codec";
    }

    /**
     * This method returns video audio codec.
     */
    public static String getVideoAudioCodec(File pathFile) {
        String videoAudioCodec = null;
        try {
            Process extractMetadata = Runtime.getRuntime().exec("resources/exiftool.exe " + pathFile.toString());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(extractMetadata.getInputStream()));
            while ((videoAudioCodec = stdInput.readLine()) != null) {
                if (videoAudioCodec.contains("Video Codec")) {
                    int initIndex = videoAudioCodec.indexOf(":");
                    int endIndex = videoAudioCodec.length();
                    int freeSpace = 2;
                    videoAudioCodec = videoAudioCodec.substring(initIndex + freeSpace, endIndex);
                    if (videoAudioCodec.contains("Windows")) {
                        videoAudioCodec = "WMV";
                        return videoAudioCodec;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "No video codec";
    }
}
