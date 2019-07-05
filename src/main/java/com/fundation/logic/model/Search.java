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

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
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
    public List search() throws Exception {
        if (criteria.getPath() == null) {
            return null;
        }
        List<File> listFileAndDirectory = new ArrayList<File>();
        File file = new File(criteria.getPath());
        String criteriaFileName = criteria.getFileName();
        String criteriaExtension = criteria.getExtension();
        boolean criteriaHidden = criteria.getFileHidden();
        boolean criteriaReadOnly = criteria.getFileReadOnly();
        Float sizeLowerLimit = criteria.getSizeLowerLimit();
        Float sizeUpperLimit = criteria.getSizeUpperLimit();
        Date creationDateLL = criteria.getCreationDateLL();
        Date creationDateUL = criteria.getCreationDateUL();
        Date accessDateLL = criteria.getAccessDateLL();
        Date accessDateUL = criteria.getAccessDateUL();
        Date modificationDateLL = criteria.getModificationDateLL();
        Date modificationDateUL = criteria.getModificationDateUL();
        File[] allSubFiles = file.listFiles();
        for (File fileExtractor : allSubFiles) {
            Path filePath = FileSystems.getDefault().getPath(fileExtractor.getAbsolutePath());
            Float sizeFileExtractor = new Float(Files.size(filePath));
            BasicFileAttributes fileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            Date creationDate = new Date(fileAttributes.creationTime().toMillis());
            Date accessDate = new Date(fileAttributes.lastAccessTime().toMillis());
            Date modificationDate = new Date(fileAttributes.lastModifiedTime().toMillis());
            UserPrincipal fileOwner = Files.getOwner(filePath);
            if (compareFileName(fileExtractor.getName(), criteriaFileName) &&
                    compareExtension(fileExtractor.getName(), criteriaExtension) &&
                    evaluateHidden(fileExtractor.isHidden(), criteriaHidden) &&
                    evaluateReadOnly(fileExtractor.canWrite(), criteriaReadOnly) &&
                    evaluateSizeLimits(sizeFileExtractor, sizeLowerLimit, sizeUpperLimit) &&
                    evaluateDate(creationDate, creationDateLL, creationDateUL) &&
                    evaluateDate(accessDate, accessDateLL, accessDateUL) &&
                    evaluateDate(modificationDate, modificationDateLL, modificationDateUL)) {
                listFileAndDirectory.add(fileExtractor);
            }
        }
        return listFileAndDirectory;
    }

    /**
     * Evaluates fileName field according on criteria.
     *
     * @return Answer after evaluation.
     */
    private boolean compareFileName(String fileExtractorCriteria, String criteria) {
        if (criteria == null || fileExtractorCriteria.contains(criteria)) {
            return true;
        }
        return false;
    }

    /**
     * Evaluates extension field according on criteria.
     *
     * @return Answer after evaluation.
     */
    private boolean compareExtension(String fileExtractorCriteria, String criteria) {
        if (criteria == null) {
            return true;
        }
        return (fileExtractorCriteria.endsWith(criteria));
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
