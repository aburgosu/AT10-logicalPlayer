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

import com.fundation.logic.model.CommonSearch;
import com.fundation.logic.model.criteria.Common;
import com.fundation.logic.model.ISearch;
import com.fundation.logic.model.criteria.Criteria;
import com.fundation.logic.view.SearchVideoFrame;
import com.fundation.logic.model.CustomizedFile;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Implements the Controller class
 *
 * @author Melissa Román, John Salazar, Andrés Burgos
 * @version 1.0
 */
public class Controller {
    private ISearch search;
    private SearchVideoFrame searchFrame;

    /**
     * Initializes a Controller instance with a searchFrame and a criteria
     */
    public Controller(SearchVideoFrame searchFrame) {
        this.searchFrame = searchFrame;
    }

    /**
     * Sets criteria according on input parameters
     * @return
     */
    public Common getCommonCriteria() {
        Common criteria = new Common();

        String path = searchFrame.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath().getText();

        String fileName = searchFrame.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFileName().getText();
        if (fileName.length() == 0) {
            fileName = null;
        }
        String extensionName = searchFrame.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldFileType().getText();
        if (extensionName.length() == 0) {
            extensionName = null;
        }
        String sizeFrom = (searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldSizeFrom().getText());
        Float sizeFromF = null;
        if (sizeFrom.length() != 0) {
            sizeFromF = new Float(sizeFrom);
        }
        String sizeTo = (searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldSizeTo().getText());
        Float sizeToF = null;
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
        if (dateModificationTo == null) {
            dateModificationTo = null;
        }
        String owner = searchFrame.getSearchTabs().getGeneralSearchPanel().getTextFieldOwner().getText();
        if (owner.length() == 0) {
            owner = null;
        }
        String mimeType = searchFrame.getSearchTabs().getGeneralSearchPanel().getComboBoxMimetype().getSelectedItem().toString();
        boolean fileHidden = searchFrame.getSearchTabs().getGeneralSearchPanel().getCheckBoxHidden().isSelected();
        boolean readOnly = searchFrame.getSearchTabs().getGeneralSearchPanel().getCheckBoxReadOnly().isSelected();

        criteria.setPath(path);
        criteria.setFileName(fileName);
        criteria.setExtension(extensionName);
        criteria.setCriteriaFileHidden(fileHidden);
        criteria.setCriteriaFileReadOnly(readOnly);
        criteria.setCriteriaSizeMin(sizeFromF);
        criteria.setCriteriaSizeMax(sizeToF);
        criteria.setCriteriaCreationDateMin(fromDateCreation);
        criteria.setCriteriaCreationDateMax(toDateCreation);
        criteria.setCriteriaAccessDateMin(dateAccessFrom);
        criteria.setCriteriaAccessDateMax(dateAccessTo);
        criteria.setCriteriaModificationDateMin(dateModificationFrom);
        criteria.setCriteriaModificationDateMax(dateModificationTo);
        criteria.setCriteriaOwner(owner);
        criteria.setCriteriaMimeType(mimeType);
        return criteria;
    }

    /**
     * Make the search sending the criteria as parameter
     */
    public List makeSearch(Criteria criteria) {
        search = new CommonSearch((Common) criteria);
        List<File> foundFiles = search.search();
        return foundFiles;
    }

    /**
     * show the result in the table
     */
    public void showSearchResult() {
        List<CustomizedFile> foundFiles;
        foundFiles = makeSearch(getCommonCriteria());
        for (int index = 0; index < foundFiles.size(); index++) {
            String path = foundFiles.get(index).getPath();
            String name = foundFiles.get(index).getName();
            String extension = foundFiles.get(index).getExtension();
            Float size = foundFiles.get(index).getSize();
            Date creationDate = foundFiles.get(index).getCreationDate();
            Date modificationDate = foundFiles.get(index).getModificationDate();
            Date lastAccessDate = foundFiles.get(index).getAccessDate();
            this.searchFrame.getTableResult().addResult(path, name, extension, size, creationDate,
                modificationDate, lastAccessDate, "---");
        }
    }

    /**
     * send the search by clicking on search
     */
    public void setEvents() {
        searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getSearchButton().addActionListener(e -> {
            searchFrame.getTableResult().clearTableResult();
            showSearchResult();
        });
    }
}
