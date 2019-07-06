/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.controller;

import com.fundation.logic.model.Criteria;
import com.fundation.logic.model.ISearch;
import com.fundation.logic.model.Search;
import com.fundation.logic.view.SearchVideoFrame;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Implements the Controller class
 *
 * @author Melissa Román
 * @version 1.0
 */
public class Controller {
    ISearch search;
    Criteria criteria;
    SearchVideoFrame searchFrame;

    /**
     * Initializes a Controller instance with a searchFrame and a criteria
     */
    public Controller(SearchVideoFrame searchFrame) {
        criteria = new Criteria();
        this.searchFrame = searchFrame;
    }

    /**
     * Sets criteria according on input parameters
     */
    public void setCriteria(String path, String fileName, String extension,
                            Boolean fileHidden, Boolean fileReadOnly,
                            Float lowerLimit, Float upperLimit, Date creDLL,
                            Date creDUL, Date accDLL, Date accDUL, Date modDLL, Date modDUL) {
        criteria.setPath(path);
        criteria.setFileName(fileName);
        criteria.setExtension(extension);
        criteria.setFileHidden(fileHidden);
        criteria.setFileReadOnly(fileReadOnly);
        criteria.setSizeLowerLimit(lowerLimit);
        criteria.setSizeUpperLimit(upperLimit);
        criteria.setCreationDateLL(creDLL);
        criteria.setCreationDateUL(creDUL);
        criteria.setAccessDateLL(accDLL);
        criteria.setAccessDateUL(accDUL);
        criteria.setModificationDateLL(modDLL);
        criteria.setModificationDateUL(modDUL);
    }

    /**
     * Make the search sending the criteria as parameter
     */
    public List makeSearch(Criteria criteria) {
        search = new Search(criteria);
        try {
            List<File> foundFiles = search.search();
            return foundFiles;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * print the result in the table
     */
    public void printSearchResult() {
        setCriteria("resources/",
                null, null, false, false, null, null,
                null, null, null, null, null, null);
        List<File> foundFiles;
        foundFiles = makeSearch(criteria);
        for (int index = 0; index < foundFiles.size(); index++) {
            this.searchFrame.getTableResult().addResult(foundFiles.get(index).getName(),
                    foundFiles.get(index).getName().substring(foundFiles.get(index).getName().length() - 3),
                    new Float(foundFiles.get(index).length()),
                    new Date(System.currentTimeMillis()), "--x");
        }
    }
}
