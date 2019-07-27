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

import java.util.List;

/**
 * Implements the LoadSaveController class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class LoadSaveController {
    private MainFrame searchFrame;
    private QueryForCriteria queryCriteria;

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
    /*
    public void saveCriteria() {
        searchFrame.get
    }*/
}
