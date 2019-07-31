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

import com.fundation.logic.common.StringToHour;
import com.fundation.logic.model.CriteriaRecord;
import com.fundation.logic.model.QueryForCriteria;
import com.fundation.logic.model.searchCriteria.Audio;
import com.fundation.logic.model.searchCriteria.Common;
import com.fundation.logic.model.searchCriteria.Criteria;
import com.fundation.logic.model.searchCriteria.Image;
import com.fundation.logic.model.searchCriteria.Video;
import com.fundation.logic.view.MainFrame;
import com.fundation.logic.view.PopUpMessage;
import com.fundation.logic.view.loadSaveCriteria.NameFrame;
import com.fundation.logic.view.loadSaveCriteria.PopupLoadSave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
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
    private NameFrame nameFrame;

    public LoadSaveController(MainFrame mainFrame, SearchController searchController) {
        this.mainFrame = mainFrame;
        this.searchController = searchController;
        queryCriteria = new QueryForCriteria();
        showLoadSaveData();
        listenFilterButton();
        listenSaveButtons();
        listenTable();
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
            nameFrame = new NameFrame();
            nameFrame.setVisible(true);
            nameFrame.getBtnSave().addActionListener(f -> {
                queryCriteria.saveCriteria(this.nameFrame.getTextFieldName().getText(),
                        searchController.getCommonCriteria(), "Common");
                showLoadSaveData();
                nameFrame.setVisible(false);
            });
        });
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getbtnSaveAdvanceVideo().addActionListener(e -> {
            nameFrame = new NameFrame();
            nameFrame.setVisible(true);
            nameFrame.getBtnSave().addActionListener(f -> {
                queryCriteria.saveCriteria(this.nameFrame.getTextFieldName().getText(),
                        searchController.getVideoCriteria(), "Video");
                showLoadSaveData();
                nameFrame.setVisible(false);
            });
        });
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getbtnSaveAdvanceAudio().addActionListener(e -> {
            nameFrame = new NameFrame();
            nameFrame.setVisible(true);
            nameFrame.getBtnSave().addActionListener(f -> {
                queryCriteria.saveCriteria(this.nameFrame.getTextFieldName().getText(),
                        searchController.getAudioCriteria(), "Audio");
                showLoadSaveData();
                nameFrame.setVisible(false);
            });
        });
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced()
                .getbtnSaveAdvanceImage().addActionListener(e -> {
            nameFrame = new NameFrame();
            nameFrame.setVisible(true);
            nameFrame.getBtnSave().addActionListener(f -> {
                queryCriteria.saveCriteria(this.nameFrame.getTextFieldName().getText(),
                        searchController.getImageCriteria(), "Image");
                showLoadSaveData();
                nameFrame.setVisible(false);
            });
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
            if (startDate == null) {
                startDate = null;
            }

            if (endDate == null) {
                endDate = null;
            }

            if (startDate != null && endDate != null) {
                if (endDate.before(startDate)) {
                PopUpMessage.showPopupMessage("Invalid Date",
                    "The date on the left must be less than the date on the right.");
                }
            }
            showFilterByDate(startDate, endDate);
        });
    }

    /**
     * Listen to actions on table.
     */
    public void listenTable() {
        final int ID_COLUMN = 3;
        try {
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
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    /**
     * Loads search form according to criteria record.
     * @param criteriaRecord - Criteria record to be loaded.
     */
    public void loadCriteria(CriteriaRecord criteriaRecord) {
        Criteria criteriaToLoad = criteriaRecord.getCriteria();
        String type = criteriaRecord.getType();
        switch (type) {
            case "Common":
                loadCommonCriteria((Common) criteriaToLoad);
                mainFrame.getMainTabs().setSelectedIndex(0);
                mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().setSelectedIndex(0);
                mainFrame.repaint();
                break;
            case "Image":
                loadImageCriteria((Image) criteriaToLoad);
                mainFrame.getMainTabs().setSelectedIndex(0);
                mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().setSelectedIndex(1);
                mainFrame.repaint();
                break;
            case "Audio":
                loadAudioCriteria((Audio) criteriaToLoad);
                mainFrame.getMainTabs().setSelectedIndex(0);
                mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().setSelectedIndex(2);
                mainFrame.repaint();
                break;
            case "Video":
                loadVideoCriteria((Video) criteriaToLoad);
                mainFrame.getMainTabs().setSelectedIndex(0);
                mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().setSelectedIndex(3);
                mainFrame.repaint();
                break;
        }
    }

    /**
     * Loads search form basic fields according to criteria.
     * @param criteria - Criteria to be loaded.
     */
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
        try {
            //Set sizeFrom
            mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                    .getTextFieldSizeFrom().setText(criteria.getCriteriaSizeMin().toString());
            //Set sizeTo
            mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                    .getTextFieldSizeTo().setText(criteria.getCriteriaSizeMax().toString());
        } catch (Exception exception) {
            exception.getMessage();
        }
        //Set units en Bytes
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getComboBoxSizeUnit().setSelectedIndex(0);
        //Set owner
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getTextFieldOwner().setText(criteria.getCriteriaOwner());
        //Set mimeType
        int optionMimeType = 0;
        if ("Audio".equals(criteria.getCriteriaMimeType())) {
            optionMimeType = 1;
        }
        if ("Video".equals(criteria.getCriteriaMimeType())) {
            optionMimeType = 2;
        }
        if ("Image".equals(criteria.getCriteriaMimeType())) {
            optionMimeType = 3;
        }
        if ("Application".equals(criteria.getCriteriaMimeType())) {
            optionMimeType = 4;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getComboBoxMimeType().setSelectedIndex(optionMimeType);
        //Set fileHidden
        int optionFileHidden = 0;
        if ("Only hidden".equals(criteria.getCriteriaFileHidden())) {
            optionFileHidden = 1;
        }
        if ("All but hidden".equals(criteria.getCriteriaFileHidden())) {
            optionFileHidden = 2;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getComboBoxHidden().setSelectedIndex(optionFileHidden);
        //Set readOnly
        int optionReadOnly = 0;
        if ("Only read-only".equals(criteria.getCriteriaFileReadOnly())) {
            optionReadOnly = 1;
        }
        if ("All but read-only".equals(criteria.getCriteriaFileReadOnly())) {
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
        if ("RGB".equals(criteria.getColorSpaceData())) {
            optionColor = 1;
        }
        if ("sRGB".equals(criteria.getColorSpaceData())) {
            optionColor = 2;
        }
        if ("MCY".equals(criteria.getColorSpaceData())) {
            optionColor = 3;
        }
        if ("RG".equals(criteria.getColorSpaceData())) {
            optionColor = 4;
        }
        if ("CMYK".equals(criteria.getColorSpaceData())) {
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
        if ("MPEG-4 ALS".equals(criteria.getAudioCodec())) {
            optionCodec = 1;
        }
        if ("WAV".equals(criteria.getAudioCodec())) {
            optionCodec = 2;
        }
        if ("MP3".equals(criteria.getAudioCodec())) {
            optionCodec = 3;
        }
        if ("RTA".equals(criteria.getAudioCodec())) {
            optionCodec = 4;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getComboBoxAudioCodecName().setSelectedIndex(optionCodec);
        //Set channel
        int optionChannel = 0;
        if ("0".equals(criteria.getChannel())) {
            optionChannel = 1;
        }
        if ("1.0".equals(criteria.getChannel())) {
            optionChannel = 2;
        }
        if ("2.0".equals(criteria.getChannel())) {
            optionChannel = 3;
        }
        if ("2.1".equals(criteria.getChannel())) {
            optionChannel = 4;
        }
        if ("5.1".equals(criteria.getChannel())) {
            optionChannel = 5;
        }
        if ("6.1".equals(criteria.getChannel())) {
            optionChannel = 6;
        }
        if ("7.1".equals(criteria.getChannel())) {
            optionChannel = 7;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getComboBoxAudioChannel().setSelectedIndex(optionChannel);
        int optionSampleRate = 0;
        if ("8000 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 1;
        }
        if ("11025 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 2;
        }
        if ("16000 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 3;
        }
        if ("22050 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 4;
        }
        if ("32000 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 5;
        }
        if ("32000 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 6;
        }
        if ("44100 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 7;
        }
        if ("47250 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 8;
        }
        if ("48000 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 9;
        }
        if ("50000 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 10;
        }
        if ("50400 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 11;
        }
        if ("64000 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 12;
        }
        if ("88200 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 13;
        }
        if ("96000 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 14;
        }
        if ("176400 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 15;
        }
        if ("192000 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 16;
        }
        if ("352800 Hz".equals(criteria.getSampleRate())) {
            optionSampleRate = 17;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getComboBoxAudioSampleRate().setSelectedIndex(optionSampleRate);
        //Set durationFrom
        String durationFrom = criteria.getDurationfrom();
        Calendar calendar = Calendar.getInstance();
        if(StringToHour.getHours(durationFrom) == 0) {
            calendar.set(Calendar.HOUR, 24);
        } else {
            calendar.set(Calendar.HOUR, StringToHour.getHours(durationFrom));
        }
        calendar.set(Calendar.MINUTE, StringToHour.getMinutes(durationFrom));
        calendar.set(Calendar.SECOND, StringToHour.getSeconds(durationFrom));
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced().getMinuteSpinner()
                .setValue(calendar.getTime());
        //Set durationTo
        String durationTo = criteria.getDurationTo();
        Calendar calendarTo = Calendar.getInstance();
        if(StringToHour.getHours(durationTo) == 0) {
            calendarTo.set(Calendar.HOUR, 24);
        } else {
            calendarTo.set(Calendar.HOUR, StringToHour.getHours(durationTo));
        }
        calendarTo.set(Calendar.MINUTE, StringToHour.getMinutes(durationTo));
        calendarTo.set(Calendar.SECOND, StringToHour.getSeconds(durationTo));
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced().getMinuteSpinnerTo()
                .setValue(calendarTo.getTime());
    }

    /**
     * Loads Video advance panel search form according to criteria input.
     * @param criteria - Video criteria to be loaded.
     */
    public void loadVideoCriteria(Video criteria) {
        loadBasicSearch(criteria);
        //Set video codec
        int optionVideoCodec = 0;
        if ("MPEG-4".equals(criteria.getVideoCodec())) {
            optionVideoCodec = 1;
        }
        if ("WMV".equals(criteria.getVideoCodec())) {
            optionVideoCodec = 2;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getComboBoxVideoCodec().setSelectedIndex(optionVideoCodec);
        //Set audio codec
        int optionAudioCodec = 0;
        if ("MPEG".equals(criteria.getAudioCodec())) {
            optionAudioCodec = 1;
        }
        if ("WMA".equals(criteria.getAudioCodec())) {
            optionAudioCodec = 2;
        }
        if ("AAC".equals(criteria.getAudioCodec())) {
            optionAudioCodec = 3;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getComboBoxAudioCodecName().setSelectedIndex(optionAudioCodec);
        //Set framerate
        int optionFrameRate = 0;
        if ("21".equals(criteria.getFrameRate())) {
            optionFrameRate = 1;
        }
        if ("24".equals(criteria.getFrameRate())) {
            optionFrameRate = 2;
        }
        if ("30".equals(criteria.getFrameRate())) {
            optionFrameRate = 3;
        }
        if ("60".equals(criteria.getFrameRate())) {
            optionFrameRate = 4;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getComboBoxVideoFrameRate().setSelectedIndex(optionFrameRate);
        //Set resolution
        int optionResolution = 0;
        if ("144".equals(criteria.getHeight())) {
            optionResolution = 1;
        }
        if ("360".equals(criteria.getHeight())) {
            optionResolution = 2;
        }
        if ("480".equals(criteria.getHeight())) {
            optionResolution = 3;
        }
        if ("720".equals(criteria.getHeight())) {
            optionResolution = 4;
        }
        if ("1080".equals(criteria.getHeight())) {
            optionResolution = 5;
        }
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getComboBoxResolution().setSelectedIndex(optionResolution);
        //Set durationFrom
        String durationFrom = criteria.getDurationfrom();
        Calendar calendarFrom = Calendar.getInstance();
        if(StringToHour.getHours(durationFrom) == 0) {
            calendarFrom.set(Calendar.HOUR, 24);
        } else {
            calendarFrom.set(Calendar.HOUR, StringToHour.getHours(durationFrom));
        }
        calendarFrom.set(Calendar.MINUTE, StringToHour.getMinutes(durationFrom));
        calendarFrom.set(Calendar.SECOND, StringToHour.getSeconds(durationFrom));
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced().getMinuteSpinner()
                .setValue(calendarFrom.getTime());
        //Set durationTo
        String durationTo= criteria.getDurationTo();
        Calendar calendarTo = Calendar.getInstance();
        if(StringToHour.getHours(durationTo) == 0) {
            calendarTo.set(Calendar.HOUR, 24);
        } else {
            calendarTo.set(Calendar.HOUR, StringToHour.getHours(durationTo));
        }
        calendarTo.set(Calendar.MINUTE, StringToHour.getMinutes(durationTo));
        calendarTo.set(Calendar.SECOND, StringToHour.getSeconds(durationTo));
        mainFrame.getMainTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced().getMinuteSpinnerTo()
                .setValue(calendarTo.getTime());
    }
}

