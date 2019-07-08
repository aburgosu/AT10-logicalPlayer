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
import com.fundation.logic.view.GeneralSearchPanel;
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
    public void setCriteria(String path, String fileName, String extension, boolean fileHiddenStatus, boolean fileReadOnlyStatus,
                            Float minSize, Float maxSize, Date minCreationDate, Date maxCreationDate, Date minAccessDate,
                            Date maxAccessDate, Date minModificationDate,
                            Date maxModificationDate, String owner, String mimeType) {
        criteria.setCriteriaPath(path);
        criteria.setCriteriaFileName(fileName);
        criteria.setCriteriaExtension(extension);
        criteria.setCriteriaFileHidden(fileHiddenStatus);
        criteria.setCriteriaFileReadOnly(fileReadOnlyStatus);
        criteria.setCriteriaSizeMin(minSize);
        criteria.setCriteriaSizeMax(maxSize);
        criteria.setCriteriaCreationDateMin(minCreationDate);
        criteria.setCriteriaCreationDateMax(maxCreationDate);
        criteria.setCriteriaAccessDateMin(minAccessDate);
        criteria.setCriteriaAccessDateMax(maxAccessDate);
        criteria.setCriteriaModificationDateMin(minModificationDate);
        criteria.setCriteriaModificationDateMax(maxModificationDate);
        criteria.setCriteriaOwner(owner);
        criteria.setCriteriaMimeType(mimeType);
    }

    /**
     * Make the search sending the criteria as parameter
     */
    public List makeSearch(Criteria criteria) {
        search = new Search(criteria);
        List<File> foundFiles = search.search();
        return foundFiles;
    }

    /**
     * show the result in the table
     */
    public void showSearchResult() {
        String fileName = searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldFilename().getText();
        if (fileName.length() == 0) {
            fileName = null;
        }
        String extensionName = searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldExtension().getText();
        if (extensionName.length() == 0) {
            extensionName = null;
        }

        String sizeFrom =(searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldSizeFrom().getText());
        Float sizeFromF = null;
        if (sizeFrom.length() != 0) {
            sizeFromF = new Float(sizeFrom);
        }

        String sizeTo =(searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldSizeTo().getText());
        Float sizeToF = null;
        System.out.println("hsad"+sizeTo+"hsad");
        if (sizeTo.length() != 0) {
            sizeToF = new Float(sizeTo);
        }
        Date fromDateCreation = searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldFromDateCreation().getDate();
        if (fromDateCreation == null) {
            fromDateCreation = null;
        }
        Date toDateCreation = searchFrame.getSearchTabs().getGeneralSearchPanel().getFieldToDateCreation().getDate();
        if (toDateCreation == null) {
            toDateCreation = null;
        }
        Date dateAccessFrom = searchFrame.getSearchTabs().getGeneralSearchPanel().getFieldDateAccessFrom().getDate();
        if (dateAccessFrom == null) {
            dateAccessFrom = null;
        }
        Date dateAccessTo = searchFrame.getSearchTabs().getGeneralSearchPanel().getFieldDateAccessTo().getDate();
        if (dateAccessTo == null) {
            dateAccessTo = null;
        }

        Date dateModificationFrom = searchFrame.getSearchTabs().getGeneralSearchPanel().getFieldDateModificationFrom().getDate();
        if (dateModificationFrom == null) {
            dateModificationFrom = null;
        }
        Date dateModificationTo = searchFrame.getSearchTabs().getGeneralSearchPanel().getFieldDateModificationTo().getDate();
        if (dateModificationTo == null ) {
            dateModificationTo = null;
        }

        String owner = searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldOwner().getText();
        if (owner.length() == 0) {
            owner = null;
        }
        String mimeType = searchFrame.getSearchTabs().getGeneralSearchPanel().getComboBoxMimetype().getSelectedItem().toString();

        System.out.println(mimeType);
        boolean fileHidden = searchFrame.getSearchTabs().getGeneralSearchPanel().getCheckBoxHidden().isSelected();
        boolean readOnly = searchFrame.getSearchTabs().getGeneralSearchPanel().getCheckBoxReadOnly().isSelected();
        String testPath = searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldPath().getText().replace("\\","/");
        System.out.println(testPath);
        setCriteria(testPath,
                fileName,
                extensionName,
                fileHidden, readOnly ,
                sizeFromF,
                sizeToF,
                fromDateCreation, toDateCreation, dateAccessFrom,
                dateAccessTo, dateModificationFrom,
                dateModificationTo, owner,null);
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
        btnSearch.addActionListener(e -> {
            searchFrame.getTableResult().clearTableResult();
            showSearchResult();
        });
    }
}
