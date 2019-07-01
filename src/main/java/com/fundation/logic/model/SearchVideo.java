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
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the model class File and the getter and setter´s methods
 *
 * @author Jesus Menacho
 * @version 1.0 *
 */
public class SearchVideo implements ISearch {
    static private Criteria criteria;
    public SearchVideo(Criteria criteria) {
        this.criteria = criteria;
    }
    public List search() {
        if (criteria.getPath() == null) {
            return null;
        }
        final String FILE_PATH = criteria.getPath();
        List<File> listFileAndDirectory = new ArrayList<File>();
        File file = new File(FILE_PATH);
        File[] allSubFiles = file.listFiles();
        for (File fileExtractor : allSubFiles) {
            if (fileExtractor.isHidden() && criteria.getFileHidden()) {
                if ((!fileExtractor.canWrite()) && criteria.getFileReadOnly()) {
                    if (compareFile(fileExtractor) != null) {
                        listFileAndDirectory.add(compareFile(fileExtractor));
                    }
                }
                if (!criteria.getFileReadOnly()) {
                    if (compareFile(fileExtractor) != null) {
                        listFileAndDirectory.add(compareFile(fileExtractor));
                    }
                }
            } else {
                if (!fileExtractor.isHidden()) {
                    if ((!fileExtractor.canWrite()) && criteria.getFileReadOnly()) {
                        if (compareFile(fileExtractor) != null) {
                            listFileAndDirectory.add(compareFile(fileExtractor));
                        }
                    }
                    if (!criteria.getFileReadOnly()) {
                        if (compareFile(fileExtractor) != null) {
                            listFileAndDirectory.add(compareFile(fileExtractor));
                        }
                    }
                }
            }
        }
        return listFileAndDirectory;
    }

    private File compareFile(File fileExtractor) {
        if (!(criteria.getPath() == null) && (criteria.getFileName() == null) && (criteria.getExtension() == null)) {
            return (new File(fileExtractor.getAbsolutePath()));
        }
        if (!(criteria.getPath() == null) && (!(criteria.getFileName() == null)) && (criteria.getExtension() == null)) {
            if (fileExtractor.getName().contains(criteria.getFileName())) {
                return (new File(fileExtractor.getAbsolutePath()));
            }
        }
        if (!(criteria.getPath() == null) && (!(criteria.getFileName() == null)) && (!(criteria.getExtension() == null))) {
            if (fileExtractor.getName().contains(criteria.getFileName()) && fileExtractor.getName().endsWith(criteria.getExtension())) {
                return (new File(fileExtractor.getAbsolutePath()));
            }
        }
        if (!(criteria.getPath() == (null)) && (criteria.getFileName() == null) && (!(criteria.getExtension() == null))) {
            if (fileExtractor.getName().endsWith(criteria.getExtension())) {
                return (new File(fileExtractor.getAbsolutePath()));
            }
        }
        return null;
    }
}
