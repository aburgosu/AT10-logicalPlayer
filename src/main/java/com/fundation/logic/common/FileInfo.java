package com.fundation.logic.common;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserPrincipal;

public class FileInfo {
    public static String getFileName(File file) {
        String complete = file.getName();
        String fileName = complete.substring(0, complete.length() - 4);
        return fileName;
    }

    public static String getFileExtension(File file) {
        String complete = file.getName();
        String fileExtension = complete.substring(complete.length() - 3);
        return fileExtension;
    }

    public static String getFileOwnerDomain(File file) {
        Path filePath = FileSystems.getDefault().getPath(file.getAbsolutePath());
        try {
            UserPrincipal fileOwner = Files.getOwner(filePath);
            String complete = fileOwner.getName();
            int indexBackSlash = complete.indexOf("/");
            String domain = complete.substring(0, indexBackSlash - 1);
            return domain;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFileOwnerUser(File file) {
        Path filePath = FileSystems.getDefault().getPath(file.getAbsolutePath());
        try {
            UserPrincipal fileOwner = Files.getOwner(filePath);
            String complete = fileOwner.getName();
            int indexBackSlash = complete.indexOf("/");
            String user = complete.substring(indexBackSlash);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
