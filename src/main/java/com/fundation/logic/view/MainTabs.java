/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import com.fundation.logic.view.loadSaveCriteria.LoadSavePanel;
import com.fundation.logic.view.convert.SplitPanelConvert;
import com.fundation.logic.view.loadSaveCriteria.SplitPanelDate;
import com.fundation.logic.view.search.GeneralSearchPanel;
import com.fundation.logic.view.search.SearchSplitPanel;

import javax.swing.JTabbedPane;

/**
 * Implements the tabs of different options.
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class MainTabs extends JTabbedPane {
    private GeneralSearchPanel generalSearchPanel;
    private LoadSavePanel loadSavePanel;
    private SearchSplitPanel splitPanelSearch;
    private SplitPanelDate splitPanelSavedCriteria;
    private SplitPanelConvert splitPanelConvert;

    /**
     * Initializes a MainTabs instance for the search options
     */
    public MainTabs() {
        generalSearchPanel = new GeneralSearchPanel();
        splitPanelSearch = new SearchSplitPanel();
        splitPanelSavedCriteria = new SplitPanelDate();
        addTab("Search", null, splitPanelSearch, "Perform general and advance search");

        loadSavePanel = new LoadSavePanel();
        addTab("Save/Load", null, splitPanelSavedCriteria, "Save and load searchCriteria");

        splitPanelConvert = new SplitPanelConvert();
        addTab("Convert", null, splitPanelConvert, "Perform video/audio converts");
    }

    /**
     * This method return GeneralSearchTab Panel
     */
    public GeneralSearchPanel getGeneralSearchPanel() {
        return generalSearchPanel;
    }

    /**
     * This method return LoadSavePanel
     */
    public LoadSavePanel getLoadSavePanel() {
        return loadSavePanel;
    }

    /**
     * This method return the content splitPanelSearch.
     * @return splitPanelSearch.
     */
    public SearchSplitPanel getSplitPanelSearch() {
        return splitPanelSearch;
    }

    /**
     * This method return the content splitPanelSavedSearch.
     * @return splitPanelSavedCriteria.
     */
    public SplitPanelDate getSplitPanelSavedCriteria() {
        return splitPanelSavedCriteria;
    }

    /**
     * This method return the content splitPanelConvert.
     * @return splitPanelConvert.
     */
    public SplitPanelConvert getSplitPanelConvert() { return splitPanelConvert; }
}
