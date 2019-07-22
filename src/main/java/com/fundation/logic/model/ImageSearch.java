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
import com.fundation.logic.common.MetadataImageExtractor;
import com.fundation.logic.model.criteria.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implements new Image search class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ImageSearch implements ISearch {
    static private Image imageCriteria;

    /**
     * Initializes a search instance which requires a criteria as parameter.
     */
    public ImageSearch(Image audioCriteria) {
        this.imageCriteria = audioCriteria;
    }

    /**
     * Main search method.
     *
     * @return List of found items if criteria's path is not null.
     */
    public List search() {
        if (imageCriteria.getPath() == null) {
            return null;
        }
        return searchInPath(imageCriteria.getPath());
    }

    /**
     * @param path
     * @return Complete list of found items according on criteria's path.
     */
    public List searchInPath(String path) {
        List<CustomizedFile> searchResult = new ArrayList<>();
        File file = new File(path);
        String criteriaFileName = imageCriteria.getFileName();
        String criteriaExtension = imageCriteria.getExtension();
        String criteriaWidth = imageCriteria.getWidth();
        String criteriaHeight = imageCriteria.getHeight();
        File[] allSubFiles = file.listFiles();
        for (File fileExtractor : allSubFiles) {
            try {
                if (fileExtractor.isDirectory()) {
                    searchResult.addAll(searchInPath(fileExtractor.getAbsolutePath()));
                } else {
                    String fileName = FileInfo.getFileDenomination(fileExtractor, "name");
                    String fileExtension = FileInfo.getFileDenomination(fileExtractor, "extension");
                    MetadataImageExtractor metadataImageExtractor = new MetadataImageExtractor();
                    String exiftool = "thirdParty/exiftool.exe "; //Tool used for extract metadata
                    String pathd = exiftool + "\"" + fileExtractor + "\"";
                    metadataImageExtractor.run(pathd);
                    String width = "0";
                    if (criteriaWidth.length() != 1) {
                        width = MetadataImageExtractor.getWidth();
                    }
                    String height = "0";
                    if (criteriaHeight.length() != 1) {
                        height = MetadataImageExtractor.getHeight();
                    }
                    Date creationDate = FileInfo.getFileDate(fileExtractor, "creation");
                    Date accessDate = FileInfo.getFileDate(fileExtractor, "access");
                    Date modificationDate = FileInfo.getFileDate(fileExtractor, "modification");
                    Float fileSize = FileInfo.getFileSize(fileExtractor);
                    if (evaluateString(fileName, criteriaFileName)
                            && evaluateString(fileExtension, criteriaExtension)
                            && evaluateString(width, criteriaWidth)
                            && evaluateString(height, criteriaHeight)
                    ) {
                        CustomizedFile matchingFile = new CustomizedFile(fileExtractor.getAbsolutePath(),
                                fileName, fileExtension, false, false,
                                fileSize, creationDate, accessDate,
                                modificationDate, "MimeType", "video");
                        searchResult.add(matchingFile);
                    }
                }
            } catch (Exception e) {
                System.out.println("The file  :" + FileInfo.getFileDenomination(fileExtractor, "name") + " -  Has not been added ");
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
