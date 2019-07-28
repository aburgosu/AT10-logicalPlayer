/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic;

import com.fundation.logic.controller.ConvertController;
import com.fundation.logic.controller.LoadSaveController;
import com.fundation.logic.view.MainFrame;
import com.fundation.logic.controller.SearchController;

/**
 * Implements the main class
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class main {

    public static void main(String[] arg) {
        MainFrame mainFrame = new MainFrame();
        SearchController searchController = new SearchController(mainFrame);
        ConvertController convertController = new ConvertController(mainFrame);
        LoadSaveController loadSaveController = new LoadSaveController(mainFrame, searchController);
        searchController.listenSearchButtons();
        loadSaveController.showLoadSaveData();
        loadSaveController.listenFilterButton();
        loadSaveController.listenSaveButtons();
        convertController.listenConvertButtons();
    }
}
