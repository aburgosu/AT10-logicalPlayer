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
import com.fundation.logic.model.SearchVideo;
import com.fundation.logic.view.SearchVideoFrame;

import java.io.File;
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
    public Criteria setCriteria(String path, String fileName, String extension, Boolean fileHidden,
            Boolean fileReadOnly) {
        criteria.setPath(path);
        criteria.setFileName(fileName);
        criteria.setExtension(extension);
        criteria.setFileHidden(fileHidden);
        criteria.setFileReadOnly(fileReadOnly);
        return criteria;
    }

    /**
     * Make the search sending the criteria as parameter
     */
    public List makeSearch(Criteria criteria) {
        search = new SearchVideo(criteria);
        List<File> foundFiles = search.search();
        return foundFiles;
    }
}
