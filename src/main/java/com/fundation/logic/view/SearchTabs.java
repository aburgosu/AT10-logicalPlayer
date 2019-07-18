/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import com.fundation.logic.view.components.SearchSplitPanel;
import com.fundation.logic.view.components.SplitPanelDate;

import javax.swing.*;

/**
 * Implements the tabs of different options.
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class SearchTabs extends JTabbedPane {
    private SearchVideoPanel panelGeneral;
    private GeneralSearchPanel generalSearchPanel;
    private LoadSavePanel loadSavePanel;
    private SearchSplitPanel splitPanelSearch;
    private SplitPanelDate splitPanelSavedCriteria;
    private SplitPanelConvert splitPanelConvert;

    /**
     * Initializes a SearchTabs instance for the search options
     */
    public SearchTabs() {
        generalSearchPanel = new GeneralSearchPanel();
        panelGeneral = new SearchVideoPanel();
        panelGeneral.initComponent();
        splitPanelSearch = new SearchSplitPanel();
        splitPanelSavedCriteria = new SplitPanelDate();
        addTab("Search", null, splitPanelSearch, "Perform general and advance search");

        loadSavePanel = new LoadSavePanel();
        addTab("Saved Criteria", null, splitPanelSavedCriteria, "Save and load criteria");

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

    public SplitPanelDate getSplitPanelSavedCriteria() {
        return splitPanelSavedCriteria;
    }
}
