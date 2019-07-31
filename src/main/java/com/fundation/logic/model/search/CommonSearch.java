/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.search;

import com.fundation.logic.common.DateSetter;
import com.fundation.logic.common.FileInfo;
import com.fundation.logic.common.MetadataCommonExtractor;
import com.fundation.logic.model.CustomFile;
import com.fundation.logic.model.searchCriteria.Common;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implements new CommonSearch class with improvements in searching algorithm.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CommonSearch implements ISearch {
    static private Common criteria;

    /**
     * Initializes a CommonSearch instance which requires a searchCriteria as parameter.
     */
    public CommonSearch(Common criteria) {
        this.criteria = criteria;
    }

    /**
     * Main search method.
     *
     * @return List of found items if searchCriteria's path is not null.
     */
    public List search() {
        if (criteria.getPath() == null) {
            return null;
        }
        return searchInPath(criteria.getPath());
    }

    /**
     * @param path
     * @return Complete list of found items according on searchCriteria's path.
     */
    public List searchInPath(String path) {
        List<CustomFile> searchResult = new ArrayList<>();
        File file = new File(path);
        String criteriaFileName = criteria.getFileName();
        String criteriaExtension = criteria.getExtension();
        String criteriaHidden = criteria.getCriteriaFileHidden();
        String criteriaReadOnly = criteria.getCriteriaFileReadOnly();
        Float sizeLowerLimit = criteria.getCriteriaSizeMin();
        Float sizeUpperLimit = criteria.getCriteriaSizeMax();
        Date creationDateLL = criteria.getCriteriaCreationDateMin();
        Date creationDateUL = criteria.getCriteriaCreationDateMax();
        Date accessDateLL = criteria.getCriteriaAccessDateMin();
        Date accessDateUL = criteria.getCriteriaAccessDateMax();
        Date modificationDateLL = criteria.getCriteriaModificationDateMin();
        Date modificationDateUL = criteria.getCriteriaModificationDateMax();
        String criteriaOwner = criteria.getCriteriaOwner();
        String criteriaMimeType = criteria.getCriteriaMimeType();

        File[] allSubFiles = file.listFiles();
        for (File fileExtractor : allSubFiles) {
            try {
                if (fileExtractor.isDirectory()) {
                    searchResult.addAll(searchInPath(fileExtractor.getAbsolutePath()));
                } else {
                    String exiftool = "thirdParty/exiftool.exe "; //Tool used for extract metadata
                    String pathd = exiftool + "\"" + fileExtractor + "\"";
                    String fileName = FileInfo.getFileDenomination(fileExtractor, "name");
                    String fileExtension = FileInfo.getFileDenomination(fileExtractor, "extension");
                    boolean fileHiddenStatus = fileExtractor.isHidden();
                    boolean fileCanWrite = fileExtractor.canWrite();
                    Float fileSize = FileInfo.getFileSize(fileExtractor);
                    Date creationDate = FileInfo.getFileDate(fileExtractor, "creation");
                    Date accessDate = FileInfo.getFileDate(fileExtractor, "access");
                    Date modificationDate = FileInfo.getFileDate(fileExtractor, "modification");
                    String owner = FileInfo.getFileOwner(fileExtractor, "user");
                    MetadataCommonExtractor metadataCommonExtractor = new MetadataCommonExtractor();
                    metadataCommonExtractor.run(pathd);
                    String mimeType = MetadataCommonExtractor.getSearchMimeType();
                    if (evaluateString(fileName, criteriaFileName) &&
                            evaluateString(fileExtension, criteriaExtension) &&
                            evaluateHidden(fileHiddenStatus, criteriaHidden) &&
                            evaluateReadOnly(fileCanWrite, criteriaReadOnly) &&
                            evaluateSizeLimits(fileSize, sizeLowerLimit, sizeUpperLimit) &&
                            evaluateDate(creationDate, creationDateLL, creationDateUL) &&
                            evaluateDate(accessDate, accessDateLL, accessDateUL) &&
                            evaluateDate(modificationDate, modificationDateLL, modificationDateUL) &&
                            evaluateString(owner, criteriaOwner) &&
                            evaluateString(mimeType, criteriaMimeType)) {
                        List<String> metadata = MetadataCommonExtractor.getSearchListMetadata();
                        CustomFile matchingFile = new CustomFile(fileExtractor.getAbsolutePath(), fileName,
                                fileExtension, fileHiddenStatus, !fileCanWrite, fileSize, creationDate, accessDate,
                                modificationDate, owner, mimeType, metadata);
                        searchResult.add(matchingFile);
                    }
                }
            } catch (Exception exc) {
                exc.getMessage();
            }
        }
        return searchResult;
    }

    /**
     * Evaluates specific string field according on searchCriteria.
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateString(String fileExtractorCriteria, String criteria) {
        if (criteria == null || fileExtractorCriteria.equalsIgnoreCase(criteria)) {
            return true;
        }
        return false;
    }

    /**
     * Evaluates hidden status according to selected Hidden option .
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateHidden(boolean fileExtractorHidden, String criteria) {
        if("All".equals(criteria) || ("Only hidden".equals((criteria)) && fileExtractorHidden)
                || ("All but hidden".equals(criteria) && !fileExtractorHidden)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Evaluates readOnly status according to selected Read-only option.
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateReadOnly(boolean fileExtractorCanWrite, String criteria) {
        if("All".equals(criteria) || ("Only read-only".equals((criteria)) && !fileExtractorCanWrite)
                || ("All but read-only".equals(criteria) && fileExtractorCanWrite)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Evaluates if the file size is between set limits.
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateSizeLimits(Float sizeFileExtractor, Float lowerLimit, Float upperLimit) {
        if (lowerLimit == null && upperLimit == null) {
            return true;
        }
        if (lowerLimit != null && upperLimit == null) {
            return sizeFileExtractor >= lowerLimit;
        }
        if (lowerLimit == null && upperLimit != null) {
            return sizeFileExtractor <= upperLimit;
        }
        return (sizeFileExtractor >= lowerLimit && sizeFileExtractor <= upperLimit);
    }

    /**
     * Evaluates if the date is between set limits.
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateDate(Date fileExtractorDate, Date lowerLimit, Date upperLimit) {
        if (lowerLimit == null && upperLimit == null) {
            return true;
        }
        if (lowerLimit != null && upperLimit == null) {
            return fileExtractorDate.after(DateSetter.setStartOfDay(lowerLimit));
        }
        if (lowerLimit == null && upperLimit != null) {
            return fileExtractorDate.before(DateSetter.setEndOfDay(upperLimit));
        }
        return (fileExtractorDate.after(DateSetter.setStartOfDay(lowerLimit)) &&
                fileExtractorDate.before(DateSetter.setEndOfDay(upperLimit)));
    }
}
