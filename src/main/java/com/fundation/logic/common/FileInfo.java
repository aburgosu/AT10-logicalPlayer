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

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;

/**
 * Implements FileInfo abstract class which is used to get file details.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class FileInfo {
    /**
     * Allows to get file's name or extension depending on option parameter.
     * @param file - File from which the info is get.
     * @param option - Desired file's denomination (name, extension).
     * @return Denomination string.
     */
    public static String getFileDenomination(File file, String option) {
        String complete = file.getName();
        int indexPoint = complete.lastIndexOf(".");
        switch (option) {
            case "name":
                String fileName = complete.substring(0, indexPoint);
                return fileName;
            case "extension":
                String fileExtension = complete.substring(indexPoint + 1);
                return fileExtension;
            default:
                return null;
        }
    }

    /**
     * Allows to get file's size.
     * @param file - File from which the info is get.
     * @return File's size in Float data type.
     */
    public static Float getFileSize(File file) {
        Path filePath = file.toPath();
        try {
            Float fileSize = new Float(Files.size(filePath));
            return fileSize;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Allows to get file's creation, access and modification date depending on option parameter.
     * @param file - File from which the info is get.
     * @param option - Desired file's date (creation, access, modification).
     * @return File's date according on option.
     */
    public static Date getFileDate(File file, String option) {
        Path filePath = file.toPath();
        try {
            BasicFileAttributes fileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            switch (option) {
                case "creation":
                    Date creationDate = new Date(fileAttributes.creationTime().toMillis());
                    return creationDate;
                case "access":
                    Date accessDate = new Date(fileAttributes.lastAccessTime().toMillis());
                    return accessDate;
                case "modification":
                    Date modificationDate = new Date(fileAttributes.lastModifiedTime().toMillis());
                    return modificationDate;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Allows to get file's owner, user or domain, depending on option parameter.
     * @param file - File from which the info is get.
     * @param option - Desired file's owner (user, domain).
     * @return String file's owner according on option.
     */
    public static String getFileOwner(File file, String option) {
        Path filePath = file.toPath();
        try {
            UserPrincipal fileOwner = Files.getOwner(filePath);
            String complete = fileOwner.getName();
            int indexBackSlash = complete.indexOf("\\");
            switch (option) {
                case "domain":
                    String domain = complete.substring(0, indexBackSlash);
                    return domain;
                case "user":
                    String user = complete.substring(indexBackSlash + 1);
                    return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Allows to get file's mimeType.
     * @param file - File from which the info is get.
     * @return File's mimeType.
     */
    public static String getMimeType(File file) {
        Path path = file.toPath();
        try {
            String mimeType = Files.probeContentType(path);
            return mimeType;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
