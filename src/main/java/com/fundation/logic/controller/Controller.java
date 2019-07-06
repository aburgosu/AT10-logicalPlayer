/**
 * Copyright (c) 2019 Jalasoft.
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
import com.fundation.logic.model.CustomizedFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;

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
        setEvents();
    }

    /**
     * Sets criteria according on input parameters
     */
    public void setCriteria(String path, String fileName, String extension, Boolean fileHidden, Boolean fileReadOnly,
                            Float minSize, Float maxSize, Date minCreationDate, Date maxCreationDate, Date minAccessDate,
                            Date maxAccessDate, Date minModificationDate, Date maxModificationDate, String owner) {
        criteria.setCriteriaPath(path);
        criteria.setCriteriaFileName(fileName);
        criteria.setCriteriaExtension(extension);
        criteria.setCriteriaFileHidden(fileHidden);
        criteria.setCriteriaFileReadOnly(fileReadOnly);
        criteria.setCriteriaSizeMin(minSize);
        criteria.setCriteriaSizeMax(maxSize);
        criteria.setCriteriaCreationDateMin(minCreationDate);
        criteria.setCriteriaCreationDateMax(maxCreationDate);
        criteria.setCriteriaAccessDateMin(minAccessDate);
        criteria.setCriteriaAccessDateMax(maxAccessDate);
        criteria.setCriteriaModificationDateMin(minModificationDate);
        criteria.setCriteriaModificationDateMax(maxModificationDate);
        criteria.setCriteriaOwner(owner);
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
                null, "docx", true, false, null, null,
                null, null, null, null, null,
                null, null);
        List<CustomizedFile> foundFiles;
        foundFiles = makeSearch(criteria);
        for (int index = 0; index < foundFiles.size(); index++) {
            String path = foundFiles.get(index).getName();
            String extension = foundFiles.get(index).getExtension();
            Float size = foundFiles.get(index).getSize();
            Date creationDate = foundFiles.get(index).getCreationDate();
            this.searchFrame.getTableResult().addResult(path, extension, size, creationDate, "---");
        }
    }

    /**
     * send the search by clicking on search
     */
    public void setEvents() {
        JButton btnSearch = searchFrame.getSearchTabs().getGeneralSearchPanel().getSearchButton();
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                searchFrame.getTableResult().clearTableResult();
                printSearchResult();
            }
        });
    }
}
