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

import com.fundation.logic.model.CriteriaRecord;
import com.fundation.logic.model.QueryForCriteria;
import com.fundation.logic.model.searchCriteria.*;
import com.fundation.logic.view.MainFrame;
import com.fundation.logic.view.loadSaveCriteria.PopupLoadSave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

/**
 * Implements the LoadSaveController class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class LoadSaveController {
    private MainFrame mainFrame;
    private QueryForCriteria queryCriteria;
    private SearchController searchController;

    public LoadSaveController(MainFrame mainFrame, SearchController searchController) {
        this.mainFrame = mainFrame;
        this.searchController = searchController;
        queryCriteria = new QueryForCriteria();
    }

    /**
     * Shows all criteria saved in database.
     */
    public void showLoadSaveData() {
        List<CriteriaRecord> allRegisters = queryCriteria.getAllCriteriaInDB();
        showLoadSaveList(allRegisters);
    }

    /**
     * Allows to show criteria records in table.
     * @param registers
     */
    public void showLoadSaveList(List<CriteriaRecord> registers) {
        mainFrame.getMainTabs().getSplitPanelSavedCriteria().getLoadSavePanel().clearTableResult();
        for (int index = 0; index < registers.size(); index++) {
            String name = registers.get(index).getName();
            String type = registers.get(index).getType();
            String date = registers.get(index).getDate();
            String id = registers.get(index).getId();
            mainFrame.getMainTabs().getSplitPanelSavedCriteria().getLoadSavePanel().addRegister(name, type, date, id);
        }
    }

    /**
     * Listens to Save buttons in every panel to call the saveCriteria method with appropriate arguments.
     */
    public void listenSaveButtons() {
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getBtnSave().addActionListener(e -> {
            queryCriteria.saveCriteria("criteria name", searchController.getCommonCriteria(), "Common");
            showLoadSaveData();
        });
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getbtnSaveAdvanceVideo().addActionListener(e -> {
            queryCriteria.saveCriteria("criteria name", searchController.getVideoCriteria(), "Video");
            showLoadSaveData();
        });
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getbtnSaveAdvanceAudio().addActionListener(e -> {
            queryCriteria.saveCriteria("criteria name", searchController.getAudioCriteria(), "Audio");
            showLoadSaveData();
        });
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced()
                .getbtnSaveAdvanceImage().addActionListener(e -> {
            queryCriteria.saveCriteria("criteria name", searchController.getImageCriteria(), "Image");
            showLoadSaveData();
        });
    }

    /**
     * Shows filter by date results.
     * @param startDate - Lower limit date.
     * @param endDate - Upper limit date.
     */
    public void showFilterByDate(Date startDate, Date endDate) {
        List<CriteriaRecord> foundCriteria = queryCriteria.findCriteria(startDate, endDate);
        showLoadSaveList(foundCriteria);
    }

    /**
     * Listen to Filter button.
     */
    public void listenFilterButton() {
        mainFrame.getMainTabs().getSplitPanelSavedCriteria().getDateSearchPanel().getBtnFilterByDate()
                .addActionListener(e -> {
                    Date startDate = mainFrame.getMainTabs().getSplitPanelSavedCriteria().getDateSearchPanel()
                            .getFieldDateFirstDate().getDate();
                    Date endDate = mainFrame.getMainTabs().getSplitPanelSavedCriteria().getDateSearchPanel()
                            .getFieldDateSecondDate().getDate();
                    showFilterByDate(startDate, endDate);
                });
    }

    /**
     * Listen to actions on table.
     */
    public void listenTable() {
        final int ID_COLUMN = 3;
        mainFrame.getMainTabs().getSplitPanelSavedCriteria().getLoadSavePanel().getDataTable()
                .addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent me) {
                        if (me.getButton() == MouseEvent.BUTTON3) {
                            PopupLoadSave menu = new PopupLoadSave();
                            menu.show(me.getComponent(), me.getX(), me.getY());
                            menu.setVisible(true);
                            int row = mainFrame.getMainTabs().getSplitPanelSavedCriteria().getLoadSavePanel().getDataTable()
                                    .getSelectedRow();
                            String id = mainFrame.getMainTabs().getSplitPanelSavedCriteria().getLoadSavePanel()
                                    .getDataTable().getValueAt(row, ID_COLUMN).toString();
                            menu.getLoadItem().addMouseListener(new MouseAdapter() {
                                @Override
                                public void mousePressed(MouseEvent event) {
                                    if (event.getButton() == MouseEvent.BUTTON1) {
                                        CriteriaRecord criteriaRecordToLoad = queryCriteria.getCriteriaRecordById(id);
                                        loadCriteria(criteriaRecordToLoad);
                                    }
                                }
                            });
                            menu.getDeleteItem().addMouseListener(new MouseAdapter() {
                                @Override
                                public void mousePressed(MouseEvent event) {
                                    if (event.getButton() == MouseEvent.BUTTON1) {
                                        queryCriteria.deleteById(id);
                                        showLoadSaveData();
                                    }
                                }
                            });
                        }
                    }
                });
    }

    public void loadCriteria(CriteriaRecord criteriaRecord) {
        Criteria criteriaToLoad = criteriaRecord.getCriteria();
        String type = criteriaRecord.getType();
        switch (type) {
            case "Common":
                loadCommonCriteria((Common) criteriaToLoad);
                mainFrame.getMainTabs().setSelectedIndex(0);
                mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().setSelectedIndex(0);
                mainFrame.repaint();
            case "Image":
                loadImageCriteria((Image) criteriaToLoad);
                mainFrame.getMainTabs().setSelectedIndex(0);
                mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().setSelectedIndex(1);
                mainFrame.repaint();
            case "Audio":
                loadAudioCriteria((Audio) criteriaToLoad);
                mainFrame.getMainTabs().setSelectedIndex(0);
                mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().setSelectedIndex(2);
                mainFrame.repaint();
            case "Video":
                loadVideoCriteria((Video) criteriaToLoad);
                mainFrame.getMainTabs().setSelectedIndex(0);
                mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().setSelectedIndex(3);
                mainFrame.repaint();
        }

        System.out.println(criteriaToLoad);
    }

    public void loadBasicSearch(Criteria criteria) {
        //Set path
        mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldPath()
                .setText(criteria.getPath());
        //Set fileName
        mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFileName()
                .setText(criteria.getFileName());
        //Set extension
        mainFrame.getMainTabs().getSplitPanelSearch().getBasicSearchPanel().getTextFieldFileType()
                .setText(criteria.getExtension());
    }

    /**
     * Loads General panel search form according to criteria input.
     * @param criteria - Common criteria to be loaded.
     */
    public void loadCommonCriteria(Common criteria) {
        loadBasicSearch(criteria);
        //Set fromDateCreation
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getTextFieldFromDateCreation().setDate(criteria.getCriteriaCreationDateMin());
        //Set toDateCreation
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getFieldToDateCreation().setDate(criteria.getCriteriaCreationDateMax());
        //Set FromDateModified
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getFieldDateModificationFrom().setDate(criteria.getCriteriaModificationDateMin());
        //Set toDateModified
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getFieldDateModificationTo().setDate(criteria.getCriteriaModificationDateMax());
        //Set toDateAccess
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getFieldDateAccessTo().setDate(criteria.getCriteriaAccessDateMin());
        //Set toDateAccess
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getFieldDateAccessFrom().setDate(criteria.getCriteriaAccessDateMax());
        //Set sizeFrom
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getTextFieldSizeFrom().setText(criteria.getCriteriaSizeMin().toString());
        //Set sizeTo
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getTextFieldSizeTo().setText(criteria.getCriteriaSizeMax().toString());
        //Set units en Bytes
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getComboBoxSizeUnit().setSelectedIndex(0);
        //Set owner
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getTextFieldOwner().setText(criteria.getCriteriaOwner());
        //Set mimeType
        int optionMimeType = 0;
        if (criteria.getCriteriaMimeType().equals("Audio")) {
            optionMimeType = 1;
        }
        if (criteria.getCriteriaMimeType().equals("Video")) {
            optionMimeType = 2;
        }
        if (criteria.getCriteriaMimeType().equals("Image")) {
            optionMimeType = 3;
        }
        if (criteria.getCriteriaMimeType().equals("Text")) {
            optionMimeType = 4;
        }
        if (criteria.getCriteriaMimeType().equals("Application")) {
            optionMimeType = 5;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getComboBoxMimeType().setSelectedIndex(optionMimeType);
        //Set fileHidden
        int optionFileHidden = 0;
        if (criteria.getCriteriaFileHidden().equals("Only hidden")) {
            optionFileHidden = 1;
        }
        if (criteria.getCriteriaFileHidden().equals("All but hidden")) {
            optionFileHidden = 2;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getComboBoxHidden().setSelectedIndex(optionFileHidden);
        //Set readOnly
        int optionReadOnly = 0;
        if (criteria.getCriteriaFileReadOnly().equals("Only read-only")) {
            optionReadOnly = 1;
        }
        if (criteria.getCriteriaFileReadOnly().equals("All but read-only")) {
            optionReadOnly = 2;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getComboBoxReadOnly().setSelectedIndex(optionReadOnly);
    }

    /**
     * Loads Image advance panel search form according to criteria input.
     * @param criteria - Image criteria to be loaded.
     */
    public void loadImageCriteria(Image criteria) {
        loadBasicSearch(criteria);
        //Set width
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced().getTextFieldWidth()
                .setText(criteria.getWidth());
        //Set height
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced().getTextFieldHeight()
                .setText(criteria.getHeight());
        //Set color space data
        int optionColor = 0;
        if (criteria.getColorSpaceData().equals("RGB")) {
            optionColor = 1;
        }
        if (criteria.getColorSpaceData().equals("sRGB")) {
            optionColor = 2;
        }
        if (criteria.getColorSpaceData().equals("MCY")) {
            optionColor = 3;
        }
        if (criteria.getColorSpaceData().equals("RG")) {
            optionColor = 4;
        }
        if (criteria.getColorSpaceData().equals("CMYK")) {
            optionColor = 5;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced()
                .getComboBoxColorSpaceData().setSelectedIndex(optionColor);
    }

    /**
     * Loads Audio advance panel search form according to criteria input.
     * @param criteria - Audio criteria to be loaded.
     */
    public void loadAudioCriteria(Audio criteria) {
        loadBasicSearch(criteria);
        int optionCodec = 0;
        if (criteria.getAudioCodec().equals("MPEG-4 ALS")) {
            optionCodec = 1;
        }
        if (criteria.getAudioCodec().equals("WAV")) {
            optionCodec = 2;
        }
        if (criteria.getAudioCodec().equals("MP3")) {
            optionCodec = 3;
        }
        if (criteria.getAudioCodec().equals("RTA")) {
            optionCodec = 4;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getComboBoxAudioCodecName().setSelectedIndex(optionCodec);
        //Set channel
        int optionChannel = 0;
        if (criteria.getChannel().equals("0")) {
            optionChannel = 1;
        }
        if (criteria.getChannel().equals("1.0")) {
            optionChannel = 2;
        }
        if (criteria.getChannel().equals("2.0")) {
            optionChannel = 3;
        }
        if (criteria.getChannel().equals("2.1")) {
            optionChannel = 4;
        }
        if (criteria.getChannel().equals("5.1")) {
            optionChannel = 5;
        }
        if (criteria.getChannel().equals("6.1")) {
            optionChannel = 6;
        }
        if (criteria.getChannel().equals("7.1")) {
            optionChannel = 7;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getComboBoxAudioChannel().setSelectedIndex(optionChannel);
        int optionSampleRate = 0;
        if (criteria.getSampleRate().equals("8000 Hz")) {
            optionSampleRate = 1;
        }
        if (criteria.getSampleRate().equals("11025 Hz")) {
            optionSampleRate = 2;
        }
        if (criteria.getSampleRate().equals("16000 Hz")) {
            optionSampleRate = 3;
        }
        if (criteria.getSampleRate().equals("22050 Hz")) {
            optionSampleRate = 4;
        }
        if (criteria.getSampleRate().equals("32000 Hz")) {
            optionSampleRate = 5;
        }
        if (criteria.getSampleRate().equals("37800 Hz")) {
            optionSampleRate = 6;
        }
        if (criteria.getSampleRate().equals("44100 Hz")) {
            optionSampleRate = 7;
        }
        if (criteria.getSampleRate().equals("47250 Hz")) {
            optionSampleRate = 8;
        }
        if (criteria.getSampleRate().equals("48000 Hz")) {
            optionSampleRate = 9;
        }
        if (criteria.getSampleRate().equals("50000 Hz")) {
            optionSampleRate = 10;
        }
        if (criteria.getSampleRate().equals("50400 Hz")) {
            optionSampleRate = 11;
        }
        if (criteria.getSampleRate().equals("64000 Hz")) {
            optionSampleRate = 12;
        }
        if (criteria.getSampleRate().equals("88200 Hz")) {
            optionSampleRate = 13;
        }
        if (criteria.getSampleRate().equals("96000 Hz")) {
            optionSampleRate = 14;
        }
        if (criteria.getSampleRate().equals("176400 Hz")) {
            optionSampleRate = 15;
        }
        if (criteria.getSampleRate().equals("192000 Hz")) {
            optionSampleRate = 16;
        }
        if (criteria.getSampleRate().equals("352800 Hz")) {
            optionSampleRate = 17;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getComboBoxAudioSampleRate().setSelectedIndex(optionSampleRate);
        //Set durationEnd
        /*
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getMinuteSpinnerTo().
        String endDuration = (mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getPanelAudioAdvanced().getMinuteSpinnerTo());
        String initDuration = (mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab()
                .getPanelAudioAdvanced().getMinuteSpinner());
                */
    }

    public void loadVideoCriteria(Video criteria) {
        loadBasicSearch(criteria);
        //Set video codec
        int optionVideoCodec = 0;
        if (criteria.getVideoCodec().equals("MPEG-4")) {
            optionVideoCodec = 1;
        }
        if (criteria.getVideoCodec().equals("WMV")) {
            optionVideoCodec = 2;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getComboBoxVideoCodec().setSelectedIndex(optionVideoCodec);
        //Set audio codec
        int optionAudioCodec = 0;
        if (criteria.getAudioCodec().equals("MPEG")) {
            optionAudioCodec = 1;
        }
        if (criteria.getAudioCodec().equals("WMA")) {
            optionAudioCodec = 2;
        }
        if (criteria.getAudioCodec().equals("AAC")) {
            optionAudioCodec = 3;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getComboBoxAudioCodecName().setSelectedIndex(optionAudioCodec);
        //Set framerate
        int optionFrameRate = 0;
        if (criteria.getFrameRate().equals("21")) {
            optionFrameRate = 1;
        }
        if (criteria.getFrameRate().equals("24")) {
            optionFrameRate = 2;
        }
        if (criteria.getFrameRate().equals("30")) {
            optionFrameRate = 3;
        }
        if (criteria.getFrameRate().equals("60")) {
            optionFrameRate = 4;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getComboBoxVideoFrameRate().setSelectedIndex(optionFrameRate);
        //Set resolution
        int optionResolution = 0;
        if (criteria.getHeight().equals("144")) {
            optionResolution = 1;
        }
        if (criteria.getHeight().equals("360")) {
            optionResolution = 2;
        }
        if (criteria.getHeight().equals("480")) {
            optionResolution = 3;
        }
        if (criteria.getHeight().equals("720")) {
            optionResolution = 4;
        }
        if (criteria.getHeight().equals("1080")) {
            optionResolution = 5;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getComboBoxResolution().setSelectedIndex(optionResolution);
        /*
        String endDuration = (mainFrame.getMainTabs().getSplitPanelSearch()
                .getSearchAdvanceTab().getPanelVideoAdvanced().getMinuteSpinnerTo());
        String initDuration = (mainFrame.getMainTabs().getSplitPanelSearch()
                .getSearchAdvanceTab().getPanelVideoAdvanced().getMinuteSpinner());

         */
    }
}

