/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model;

import com.fundation.logic.common.FileInfo;
import com.fundation.logic.common.MetadataVideoExtractor;
import com.fundation.logic.model.criteria.Video;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implements new Video Search class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class VideoSearch {
    static private Video videoCriteria;

    /**
     * Initializes a Search instance which requires a criteria as parameter.
     */
    public VideoSearch(Video videoCriteria) {
        this.videoCriteria = videoCriteria;
    }

    /**
     * Main search method.
     *
     * @return List of found items if criteria's path is not null.
     */
    public List search() {
        if (videoCriteria.getPath() == null) {
            return null;
        }
        return searchInPath(videoCriteria.getPath());
    }

    /**
     * @param path
     * @return Complete list of found items according on criteria's path.
     */
    public List searchInPath(String path) {
        List<CustomizedFile> searchResult = new ArrayList<>();
        File file = new File(path);
        String criteriaFileName = videoCriteria.getFileName();
        String criteriaExtension = videoCriteria.getExtension();
        String criteriVideoCodec = videoCriteria.getVideoCodec();
        String criteriaFrameRate = videoCriteria.getFrameRate();
        String criteriaHeight = Integer.toString(videoCriteria.getHeight());
        String criteriaWidth = Integer.toString(videoCriteria.getWidth());
        File[] allSubFiles = file.listFiles();

        for (File fileExtractor : allSubFiles) {
            if (fileExtractor.isDirectory()) {
                searchResult.addAll(searchInPath(fileExtractor.getAbsolutePath()));
            } else {
                String fileName = FileInfo.getFileDenomination(fileExtractor, "name");
                String fileExtension = FileInfo.getFileDenomination(fileExtractor, "extension");
                String fileVideoCodec = MetadataVideoExtractor.getVideoCodec(fileExtractor);
                String fileHeight = MetadataVideoExtractor.getResolution(fileExtractor);
                String fileWidth = MetadataVideoExtractor.getResolution(fileExtractor);
                String videoCodec = MetadataVideoExtractor.getVideoCodec(fileExtractor);
                String frameRate = MetadataVideoExtractor.getFrameRate(fileExtractor);
                Date creationDate = FileInfo.getFileDate(fileExtractor, "creation");
                Date accessDate = FileInfo.getFileDate(fileExtractor, "access");
                Date modificationDate = FileInfo.getFileDate(fileExtractor, "modification");
                Float fileSize = FileInfo.getFileSize(fileExtractor);

                if (evaluateString(frameRate, criteriaFrameRate)
                        && evaluateString(fileName, criteriaFileName)
                        && evaluateString(fileExtension, criteriaExtension)
                ) {
                    CustomizedFile matchingFile = new CustomizedFile(fileExtractor.getAbsolutePath(), fileName,
                            fileExtension, false, false,
                            fileSize, creationDate, accessDate,
                            modificationDate, "MimeType", "video");
                    searchResult.add(matchingFile);
                }
            }
        }
        return searchResult;
    }

    /**
     * Evaluates specific string field according on criteria.
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateString(String fileExtractorCriteria, String criteria) {
        if (criteria == null || fileExtractorCriteria.equalsIgnoreCase(criteria)) {
            return true;
        }
        return false;
    }
}
