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

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implements new Search class with improvements in searching algorithm.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class Search implements ISearch {
    static private Criteria criteria;

    /**
     * Initializes a Search instance which requires a criteria as parameter.
     */
    public Search(Criteria criteria) {
        this.criteria = criteria;
    }

    /**
     * Main search method.
     *
     * @return List of found items according on criteria.
     */
    public List search() {
        if (criteria.getCriteriaPath() == null) {
            return null;
        }
        List<File> listFileAndDirectory = new ArrayList<File>();
        File file = new File(criteria.getCriteriaPath());
        String criteriaFileName = criteria.getCriteriaFileName();
        String criteriaExtension = criteria.getCriteriaExtension();
        boolean criteriaHidden = criteria.getCriteriaFileHidden();
        boolean criteriaReadOnly = criteria.getCriteriaFileReadOnly();
        Float sizeLowerLimit = criteria.getCriteriaSizeMin();
        Float sizeUpperLimit = criteria.getCriteriaSizeMax();
        Date creationDateLL = criteria.getCriteriaCreationDateMin();
        Date creationDateUL = criteria.getCriteriaCreationDateMax();
        Date accessDateLL = criteria.getCriteriaAccessDateMin();
        Date accessDateUL = criteria.getCriteriaAccessDateMax();
        Date modificationDateLL = criteria.getCriteriaModificationDateMin();
        Date modificationDateUL = criteria.getCriteriaModificationDateMax();
        String criteriaOwner = criteria.getCriteriaOwner();
        File[] allSubFiles = file.listFiles();
        for (File fileExtractor : allSubFiles) {
            String fileName = FileInfo.getFileDenomination(fileExtractor, "name");
            String fileExtension = FileInfo.getFileDenomination(fileExtractor, "extension");
            Float sizeFileExtractor = FileInfo.getFileSize(fileExtractor);
            Date creationDate = FileInfo.getFileDate(fileExtractor, "creation");
            Date accessDate = FileInfo.getFileDate(fileExtractor, "access");
            Date modificationDate = FileInfo.getFileDate(fileExtractor, "modification");
            String owner = FileInfo.getFileOwner(fileExtractor, "user");
            if (evaluateString(fileName, criteriaFileName) &&
                    evaluateString(fileExtension, criteriaExtension) &&
                    evaluateHidden(fileExtractor.isHidden(), criteriaHidden) &&
                    evaluateReadOnly(fileExtractor.canWrite(), criteriaReadOnly) &&
                    evaluateSizeLimits(sizeFileExtractor, sizeLowerLimit, sizeUpperLimit) &&
                    evaluateDate(creationDate, creationDateLL, creationDateUL) &&
                    evaluateDate(accessDate, accessDateLL, accessDateUL) &&
                    evaluateDate(modificationDate, modificationDateLL, modificationDateUL) &&
                    evaluateString(owner, criteriaOwner)) {
                listFileAndDirectory.add(fileExtractor);
            }
        }
        return listFileAndDirectory;
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

    /**
     * Evaluates hidden status according on if Hidden option is checked.
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateHidden(boolean fileExtractorHidden, boolean criteria) {
        return !(fileExtractorHidden) || criteria; //((~p)vq)
    }

    /**
     * Evaluates readOnly status according on if ReadOnly option is checked.
     *
     * @return Answer after evaluation.
     */
    private boolean evaluateReadOnly(boolean fileExtractorCanWrite, boolean criteria) {
        return !(criteria) || !(fileExtractorCanWrite); //((~q)v(~p))
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
            return sizeFileExtractor > lowerLimit;
        }
        if (lowerLimit == null && upperLimit != null) {
            return sizeFileExtractor < upperLimit;
        }
        return (sizeFileExtractor > lowerLimit && sizeFileExtractor < upperLimit);
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
            return fileExtractorDate.after(lowerLimit);
        }
        if (lowerLimit == null && upperLimit != null) {
            return fileExtractorDate.before(upperLimit);
        }
        return (fileExtractorDate.after(lowerLimit) && fileExtractorDate.before(upperLimit));
    }
}
