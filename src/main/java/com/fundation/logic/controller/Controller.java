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

import com.fundation.logic.model.AudioSearch;
import com.fundation.logic.model.CommonSearch;
import com.fundation.logic.model.CriteriaRecord;
import com.fundation.logic.model.CustomizedFile;
import com.fundation.logic.model.ISearch;
import com.fundation.logic.model.ImageSearch;
import com.fundation.logic.model.QueryForCriteria;
import com.fundation.logic.model.VideoSearch;
import com.fundation.logic.model.criteria.Audio;
import com.fundation.logic.model.criteria.Common;
import com.fundation.logic.model.criteria.Criteria;
import com.fundation.logic.model.criteria.Image;
import com.fundation.logic.model.criteria.Video;
import com.fundation.logic.view.MainFrame;

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
    private MainFrame searchFrame;
    private QueryForCriteria queryCriteria;

    private final int COMMON_SEARCH = 0;
    private final int VIDEO_SEARCH = 1;
    private final int AUDIO_SEARCH = 2;
    private final int IMAGE_SEARCH = 3;

    /**
     * Initializes a Controller instance with a searchFrame and a criteria
     */
    public Controller(MainFrame searchFrame) {
        this.searchFrame = searchFrame;
        queryCriteria = new QueryForCriteria();
    }

    /**
     * Make the search sending the criteria as parameter
     */
    public List makeSearch(Criteria criteria) {
        if (criteria instanceof Common) {
            search = new CommonSearch((Common) criteria);
        }
        if (criteria instanceof Video) {
            search = new VideoSearch((Video) criteria);
        }
        if (criteria instanceof Audio) {
            search = new AudioSearch((Audio) criteria);
        }
        if (criteria instanceof Image) {
            search = new ImageSearch((Image) criteria);
        }
        List<File> foundFiles = search.search();
        return foundFiles;
    }

    /**
     * Shows the result in the table
     */
    public void showSearchResult(int searchType) {
        List<CustomizedFile> foundFiles = null;
        if (searchType == COMMON_SEARCH) {
            foundFiles = makeSearch(getCommonCriteria());
        }
        if (searchType == VIDEO_SEARCH) {
            foundFiles = makeSearch(getVideoCriteria());
        }
        if (searchType == AUDIO_SEARCH) {
            foundFiles = makeSearch(getAudioCriteria());
        }
        if (searchType == IMAGE_SEARCH) {
            foundFiles = makeSearch(getImageCriteria());
        }

        if (foundFiles != null) {
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
    }

    /**
     * Get Common criteria
     * @return Common criteria
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
        String sizeFrom = (searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getTextFieldSizeFrom().getText());
        Float sizeFromF = null;
        if (sizeFrom.length() != 0) {
            sizeFromF = new Float(sizeFrom);
        }
        String sizeTo = (searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getTextFieldSizeTo().getText());
        Float sizeToF = null;
        if (sizeTo.length() != 0) {
            sizeToF = new Float(sizeTo);
        }
        Date fromDateCreation = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getTextFieldFromDateCreation().getDate();
        if (fromDateCreation == null) {
            fromDateCreation = null;
        }
        Date toDateCreation = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getFieldToDateCreation().getDate();
        if (toDateCreation == null) {
            toDateCreation = null;
        }
        Date dateAccessFrom = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getFieldDateAccessFrom().getDate();
        if (dateAccessFrom == null) {
            dateAccessFrom = null;
        }
        Date dateAccessTo = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getFieldDateAccessTo().getDate();
        if (dateAccessTo == null) {
            dateAccessTo = null;
        }
        Date dateModificationFrom = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getFieldDateModificationFrom().getDate();
        if (dateModificationFrom == null) {
            dateModificationFrom = null;
        }
        Date dateModificationTo = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getFieldDateModificationTo().getDate();
        if (dateModificationTo == null) {
            dateModificationTo = null;
        }
        String owner = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getTextFieldOwner().getText();
        if (owner.length() == 0) {
            owner = null;
        }
        String mimeType = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getComboBoxMimeType().getSelectedItem().toString();
        if(mimeType == "All") {
            mimeType = null;
        }
        boolean fileHidden = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getCheckBoxHidden().isSelected();
        boolean readOnly = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getCheckBoxReadOnly().isSelected();

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
     * Get Image criteria
     * @return Image criteria
     */
    private Criteria getImageCriteria() {
        Image criteria = new Image();
        String path = searchFrame.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath().getText();
        String fileName = searchFrame.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFileName().getText();
        if (fileName.length() == 0) {
            fileName = null;
        }
        String extensionName = searchFrame.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldFileType().getText();
        if (extensionName.length() == 0) {
            extensionName = null;
        }
        String width = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced().getTextFieldWidth().getText();
        if (width.length() == 0) {
            width = "0";
        }
        String height = searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced().getTextFieldHeight().getText();
        if (height.length() == 0) {
            height= "0";
        }
        criteria.setPath(path);
        criteria.setWidth(Integer.parseInt(width));
        criteria.setHeight(Integer.parseInt(height));
        return criteria;
    }

    /**
     * Get Audio criteria
     * @return Audio criteria
     */
    private Criteria getAudioCriteria() {
        return null;
    }

    /**
     * Get Video criteria
     * @return Video criteria
     */
    private Criteria getVideoCriteria() {
        Video criteria = new Video();

        String path = searchFrame.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath().getText();
        String fileName = searchFrame.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFileName().getText();
        if (fileName.length() == 0) {
            fileName = null;
        }
        String extensionName = searchFrame.getSearchTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldFileType().getText();
        if (extensionName.length() == 0) {
            extensionName = null;
        }
        String videoCodec = (searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced().getComboBoxVideoCodec().getSelectedItem().toString());
        if (videoCodec.length() == 0) {
            videoCodec = null;
        }
        String audioCodec = (searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced().getComboBoxAudioCodecName().getSelectedItem().toString());
        if (audioCodec.length() == 0) {
            audioCodec = null;
        }
        String framerate = (searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced().getComboBoxVideoFrameRate().getSelectedItem().toString());
        if (framerate.length() == 0) {
            framerate = null;
        }
        String resolution = (searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced().getComboBoxResolution().getSelectedItem().toString());
        if (resolution.length() == 0) {
            resolution = null;
        }
        criteria.setPath(path);
        criteria.setFileName(fileName);
        criteria.setExtension(extensionName);
        criteria.setVideoCodec(videoCodec);
        criteria.setAudioCodec(audioCodec);
        criteria.setFrameRate(framerate);
        criteria.setHeight(Integer.parseInt(resolution.substring(resolution.indexOf("x")+1)));
        return criteria;
    }

    /**
     * send the search by clicking on search
     */
    public void setEvents() {
        searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel().getSearchButton().addActionListener(e -> {
            searchFrame.getTableResult().clearTableResult();
            showSearchResult(COMMON_SEARCH);
        });
        searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced().getBtnSearchAdvanceVideoPanel().addActionListener(e -> {
            searchFrame.getTableResult().clearTableResult();
            showSearchResult(VIDEO_SEARCH);
        });
        searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced().getBtnSearchAdvanceAudio().addActionListener(e -> {
            searchFrame.getTableResult().clearTableResult();
            showSearchResult(AUDIO_SEARCH);
        });
        searchFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced().getBtnSearchAdvanceImage().addActionListener(e -> {
            searchFrame.getTableResult().clearTableResult();
            showSearchResult(IMAGE_SEARCH);
        });
    }

    public void showLoadSaveData() {
        searchFrame.getSearchTabs().getSplitPanelSavedCriteria().getLoadSavePanel().clearTableResult();
        List<CriteriaRecord> registers = queryCriteria.getAllCriteriaInDB();
        for (int index = 0; index < registers.size(); index++) {
            String name = registers.get(index).getName();
            String type = registers.get(index).getType();
            String date = registers.get(index).getDate();
            searchFrame.getSearchTabs().getSplitPanelSavedCriteria().getLoadSavePanel().addRegister(name, type, date);
        }
    }
}
