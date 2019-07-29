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
import com.fundation.logic.view.MainFrame;
import com.fundation.logic.view.loadSaveCriteria.PopupLoadSave;
import com.fundation.logic.view.resultTable.PopupMenu;

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
        mainFrame.getSearchTabs().getSplitPanelSavedCriteria().getLoadSavePanel().clearTableResult();
        for (int index = 0; index < registers.size(); index++) {
            String name = registers.get(index).getName();
            String type = registers.get(index).getType();
            String date = registers.get(index).getDate();
            int id = registers.get(index).getId();
            mainFrame.getSearchTabs().getSplitPanelSavedCriteria().getLoadSavePanel().addRegister(name, type, date, id);
        }
    }

    /**
     * Listens to Save buttons in every panel to call the saveCriteria method with appropriate arguments.
     */
    public void listenSaveButtons() {
        mainFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getGeneralSearchPanel()
                .getBtnSave().addActionListener(e -> {
            queryCriteria.saveCriteria("criteria name", searchController.getCommonCriteria(), "Common");
        });
        mainFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelVideoAdvanced()
                .getbtnSaveAdvanceVideo().addActionListener(e -> {
            queryCriteria.saveCriteria("criteria name", searchController.getVideoCriteria(), "Video");
        });
        mainFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelAudioAdvanced()
                .getbtnSaveAdvanceAudio().addActionListener(e -> {
            queryCriteria.saveCriteria("criteria name", searchController.getAudioCriteria(), "Audio");
        });
        mainFrame.getSearchTabs().getSplitPanelSearch().getSearchAdvanceTab().getPanelImageAdvanced()
                .getbtnSaveAdvanceImage().addActionListener(e -> {
            queryCriteria.saveCriteria("criteria name", searchController.getImageCriteria(), "Image");
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
        mainFrame.getSearchTabs().getSplitPanelSavedCriteria().getDateSearchPanel().getBtnFilterByDate()
                .addActionListener(e -> {
                    Date startDate =  mainFrame.getSearchTabs().getSplitPanelSavedCriteria().getDateSearchPanel()
                            .getFieldDateFirstDate().getDate();
                    Date endDate = mainFrame.getSearchTabs().getSplitPanelSavedCriteria().getDateSearchPanel()
                            .getFieldDateSecondDate().getDate();
                    showFilterByDate(startDate, endDate);
                });
    }

    /**
     * Listen to actions on table.
     */
    public void listenTable() {
        final int ID_COLUMN = 3;
        mainFrame.getSearchTabs().getSplitPanelSavedCriteria().getLoadSavePanel().getDataTable()
                .addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON3) {
                    PopupLoadSave menu = new PopupLoadSave();
                    menu.show(me.getComponent(), me.getX(), me.getY());
                    menu.setVisible(true);
                    int row = mainFrame.getSearchTabs().getSplitPanelSavedCriteria().getLoadSavePanel().getDataTable()
                            .getSelectedRow();
                    String id = mainFrame.getSearchTabs().getSplitPanelSavedCriteria().getLoadSavePanel()
                            .getDataTable().getValueAt(row, ID_COLUMN).toString();
                    menu.getLoadItem().addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent event) {
                            if (event.getButton() == MouseEvent.BUTTON1) {
                                System.out.println("Carga el criterio");
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


}
