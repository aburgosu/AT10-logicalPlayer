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

import com.fundation.logic.common.ByteConvert;
import com.fundation.logic.common.Validators;
import com.fundation.logic.model.CustomFile;
import com.fundation.logic.model.search.ISearch;
import com.fundation.logic.model.search.SearchFactory;
import com.fundation.logic.model.searchCriteria.Audio;
import com.fundation.logic.model.searchCriteria.Common;
import com.fundation.logic.model.searchCriteria.Criteria;
import com.fundation.logic.model.searchCriteria.Image;
import com.fundation.logic.model.searchCriteria.Video;
import com.fundation.logic.view.MainFrame;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Implements the SearchController class.
 *
 * @author Melissa Román, John Salazar, Andrés Burgos
 * @version 1.0
 */
public class SearchController {
    private ISearch searchEngine;
    private SearchFactory searchFactory;
    private MainFrame mainFrame;

    private final int COMMON_SEARCH = 0;
    private final int VIDEO_SEARCH = 1;
    private final int AUDIO_SEARCH = 2;
    private final int IMAGE_SEARCH = 3;

    /**
     * Initializes a SearchController instance with a mainFrame and a searchCriteria.
     */
    public SearchController(MainFrame searchFrame) {
        this.mainFrame = searchFrame;
        this.searchFactory = new SearchFactory();
        listenSearchButtons();
    }

    /**
     * Make the searchEngine sending the searchCriteria as parameter.
     */
    public List makeSearch(Criteria criteria) {
        this.searchEngine = searchFactory.createSearch(criteria);
        List<File> foundFiles = searchEngine.search();
        return foundFiles;
    }

    /**
     * Shows the result in the table.
     */
    public void showSearchResult(int searchType) {
        List<CustomFile> foundFiles = null;
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
                String sizeUnit = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                        .getGeneralSearchPanel().getComboBoxSizeUnit().getSelectedItem().toString();
                size = ByteConvert.bytesConvert(size.toString(), sizeUnit);
                Date creationDate = foundFiles.get(index).getCreationDate();
                Date modificationDate = foundFiles.get(index).getModificationDate();
                Date lastAccessDate = foundFiles.get(index).getAccessDate();
                List<String> detailsList = foundFiles.get(index).getMetadata();
                this.mainFrame.getTableResult().addResult(path, name, extension, size + " " + sizeUnit,
                        creationDate, modificationDate, lastAccessDate, detailsList);
            }
        }
    }

    /**
     * Allows to get common search criteria.
     * @return Common searchCriteria
     */
    public Common getCommonCriteria() {
        Common criteria = new Common();
        String path = mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath()
                .getText();
        String fileName = mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFileName()
                .getText();
        if (fileName.length() == 0) {
            fileName = null;
        }
        String extensionName = mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel()
                .getTextFieldFileType().getText();
        if (extensionName.length() == 0) {
            extensionName = null;
        }
        String sizeUnit = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getComboBoxSizeUnit().getSelectedItem().toString();
        String sizeFrom = (mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getTextFieldSizeFrom().getText());
        Float sizeFromF = null;
        if (sizeFrom.length() != 0) {
            sizeFromF = ByteConvert.anyConvertBytes(sizeUnit, sizeFrom);
        }
        String sizeTo = (mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getTextFieldSizeTo().getText());
        Float sizeToF = null;
        if (sizeTo.length() != 0) {
            sizeToF = ByteConvert.anyConvertBytes(sizeUnit, sizeTo);
        }
        Date fromDateCreation = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getTextFieldFromDateCreation().getDate();
        if (fromDateCreation == null) {
            fromDateCreation = null;
        }
        Date toDateCreation = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getFieldToDateCreation().getDate();
        if (toDateCreation == null) {
            toDateCreation = null;
        }
        Date dateAccessFrom = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getFieldDateAccessFrom().getDate();
        if (dateAccessFrom == null) {
            dateAccessFrom = null;
        }
        Date dateAccessTo = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getFieldDateAccessTo().getDate();
        if (dateAccessTo == null) {
            dateAccessTo = null;
        }
        Date dateModificationFrom = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getFieldDateModificationFrom().getDate();
        if (dateModificationFrom == null) {
            dateModificationFrom = null;
        }
        Date dateModificationTo = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getFieldDateModificationTo().getDate();
        if (dateModificationTo == null) {
            dateModificationTo = null;
        }
        String owner = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getTextFieldOwner().getText();
        if (owner.length() == 0) {
            owner = null;
        }
        String mimeType = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getComboBoxMimeType().getSelectedItem().toString();
        if (mimeType == "All") {
            mimeType = null;
        }
        String fileHidden = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getComboBoxHidden().getSelectedItem().toString();
        String readOnly = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getGeneralSearchPanel().getComboBoxReadOnly().getSelectedItem().toString();

        /**
         * Validates entered data ans shows a message. according to error.
         */
        if (!Validators.isValidPath(path)) {
            mainFrame.showPopupMessage("Information Message",
                    "The path is not correct or does not exist.");
        }

        if (fromDateCreation != null && toDateCreation != null) {
            if (toDateCreation.before(fromDateCreation)) {
                mainFrame.showPopupMessage("Invalid Created Date",
                        "The date on the left must be less than the date on the right.");
            }
        }
        if (dateModificationFrom != null && dateModificationTo != null) {
            if (dateModificationTo.before(dateModificationFrom)) {
                mainFrame.showPopupMessage("Invalid Modified Date",
                        "The date on the left must be less than the date on the right.");
            }
        }
        if (dateAccessFrom != null && dateAccessTo != null) {
            if (dateAccessTo.before(dateAccessFrom)) {
                mainFrame.showPopupMessage("Invalid Accessed Date",
                        "The date on the left must be less than the date on the right.");
            }
        }
        if (sizeFrom != null && sizeTo != null) {
            if (sizeTo.compareTo(sizeFrom) < 0) {
                mainFrame.showPopupMessage("Error Message",
                        "The size of the left must be smaller than the size of the right");
            }
        }
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
     * Allows to get image criteria.
     * @return Image search criteria.
     */
    public Criteria getImageCriteria() {
        Image criteria = new Image();
        String path = mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath()
                .getText();
        String fileName = mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFileName()
                .getText();
        if (fileName.length() == 0) {
            fileName = null;
        }
        String extensionName = mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel()
                .getTextFieldFileType().getText();
        if (extensionName.length() == 0) {
            extensionName = null;
        }
        String width = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced()
                .getTextFieldWidth().getText();
        if (width.length() == 0) {
            width = "0";
        }
        String height = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced()
                .getTextFieldHeight().getText();
        if (height.length() == 0) {
            height = "0";
        }
        String colorSpaceData = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getPanelImageAdvanced().getComboBoxColorSpaceData().getSelectedItem().toString();
        criteria.setPath(path);
        criteria.setFileName(fileName);
        criteria.setExtension(extensionName);
        criteria.setWidth(Integer.parseInt(width));
        criteria.setHeight(Integer.parseInt(height));
        criteria.setColorSpaceData(colorSpaceData);
        return criteria;
    }

    /**
     * Allows to get Audio criteria.
     * @return Audio criteria.
     */
    public Criteria getAudioCriteria() {
        Audio criteria = new Audio();
        String path = mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath()
                .getText();
        String fileName = mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFileName()
                .getText();
        if (fileName.length() == 0) {
            fileName = null;
        }
        String extensionName = mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel()
                .getTextFieldFileType().getText();
        if (extensionName.length() == 0) {
            extensionName = null;
        }
        String channel = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getPanelAudioAdvanced().getComboBoxAudioChannel().getSelectedItem().toString();
        if (channel.length() == 0) {
            channel = null;
        }
        String audioCodec = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getPanelAudioAdvanced().getComboBoxAudioCodecName().getSelectedItem().toString();
        if (audioCodec.length() == 0) {
            audioCodec = null;
        }
        String sampleRate = mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getPanelAudioAdvanced().getComboBoxAudioSampleRate().getSelectedItem().toString();
        if (sampleRate.length() == 0) {
            sampleRate = null;
        }
        String endDuration = (mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getPanelAudioAdvanced().getMinuteSpinnerTo());
        String initDuration = (mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getPanelAudioAdvanced().getMinuteSpinner());
        int subStringFromEnd = 17;
        int subStringFromInit = 9;
        int init = endDuration.length() - subStringFromEnd;
        int end = initDuration.length() - subStringFromInit;
        endDuration = endDuration.substring(init, end);
        initDuration = initDuration.substring(init, end);
        criteria.setDurationTo(endDuration);
        criteria.setDurationFrom(initDuration);
        criteria.setPath(path);
        criteria.setFileName(fileName);
        criteria.setExtension(extensionName);
        criteria.setChannel(channel);
        criteria.setAudioCodec(audioCodec);
        criteria.setSampleRate(sampleRate);
        return criteria;
    }

    /**
     * Allows to get video criteria.
     * @return Video criteria.
     */
    public Criteria getVideoCriteria() {
        Video criteria = new Video();
        String path = mainFrame.getMainTabs().getSplitPanelSearch()
                .getBasicSearchPanel().getTextFieldPath().getText();
        String fileName = mainFrame.getMainTabs().getSplitPanelSearch()
                .getBasicSearchPanel().getTextFileName().getText();
        if (fileName.length() == 0) {
            fileName = null;
        }
        String extensionName = mainFrame.getMainTabs().getSplitPanelSearch()
                .getBasicSearchPanel().getTextFieldFileType().getText();
        if (extensionName.length() == 0) {
            extensionName = null;
        }
        String videoCodec = (mainFrame.getMainTabs().getSplitPanelSearch()
                .getSearchAdvanceTab().getPanelVideoAdvanced().getComboBoxVideoCodec().getSelectedItem().toString());
        if (videoCodec.length() == 0) {
            videoCodec = null;
        }
        String audioCodec = (mainFrame.getMainTabs().getSplitPanelSearch()
                .getSearchAdvanceTab().getPanelVideoAdvanced().getComboBoxAudioCodecName()
                .getSelectedItem().toString());
        if (audioCodec.length() == 0) {
            audioCodec = null;
        }
        String framerate = (mainFrame.getMainTabs().getSplitPanelSearch()
                .getSearchAdvanceTab().getPanelVideoAdvanced().getComboBoxVideoFrameRate()
                .getSelectedItem().toString());
        if (framerate.length() == 0) {
            framerate = null;
        }
        String resolution = (mainFrame.getMainTabs().getSplitPanelSearch()
                .getSearchAdvanceTab().getPanelVideoAdvanced().getComboBoxResolution()
                .getSelectedItem().toString());
        if (resolution.length() == 0) {
            resolution = null;
        }
        String endDuration = (mainFrame.getMainTabs().getSplitPanelSearch()
                .getSearchAdvanceTab().getPanelVideoAdvanced().getMinuteSpinnerTo());
        String initDuration = (mainFrame.getMainTabs().getSplitPanelSearch()
                .getSearchAdvanceTab().getPanelVideoAdvanced().getMinuteSpinner());
        int subStringFromEnd = 17;
        int subStringFromInit = 9;
        int init = endDuration.length() - subStringFromEnd;
        int end = endDuration.length() - subStringFromInit;
        endDuration = endDuration.substring(init, end);
        initDuration = initDuration.substring(init, end);
        criteria.setDurationTo(endDuration);
        criteria.setDurationFrom(initDuration);
        criteria.setPath(path);
        criteria.setFileName(fileName);
        criteria.setExtension(extensionName);
        criteria.setVideoCodec(videoCodec);
        criteria.setAudioCodec(audioCodec);
        criteria.setFrameRate(framerate);
        criteria.setHeight(resolution);
        return criteria;
    }

    /**
     * Listens to Search buttons in every panel to call the search methods with appropriate argument.
     */
    public void listenSearchButtons() {
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getSearchButton().addActionListener(e -> {
            mainFrame.getTableResult().clearTableResult();
            showSearchResult(COMMON_SEARCH);
        });
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getBtnSearchAdvanceVideoPanel().addActionListener(e -> {
            mainFrame.getTableResult().clearTableResult();
            showSearchResult(VIDEO_SEARCH);
        });
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getBtnSearchAdvanceAudio().addActionListener(e -> {
            mainFrame.getTableResult().clearTableResult();
            showSearchResult(AUDIO_SEARCH);
        });
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced()
                .getBtnSearchAdvanceImage().addActionListener(e -> {
            mainFrame.getTableResult().clearTableResult();
            showSearchResult(IMAGE_SEARCH);
        });
    }
}
