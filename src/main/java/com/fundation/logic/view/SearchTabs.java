/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import com.fundation.logic.view.components.BasicSearch;
import com.fundation.logic.view.components.SplitPanelSearch;
import com.fundation.logic.view.components.SplitPanelDate;

import javax.swing.*;

/**
 * Implements the tabs of different options.
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class SearchTabs extends JTabbedPane {
    private AdvancedSearchPanel panelAdvanced;
    private SearchVideoPanel panelGeneral;
    private GeneralSearchPanel generalSearchPanel;
    private LoadSavePanel loadSavePanel;
    private final ConverterPanel panelConvert;
    private BasicSearch basicSearch;
    private SplitPanelSearch splitPanelSearch;
    private SplitPanelDate splitPanelDate;

    /**
     * Initializes a SearchTabs instance for the search options
     */
    public SearchTabs() {

        generalSearchPanel = new GeneralSearchPanel();
        panelGeneral = new SearchVideoPanel();
        panelGeneral.initComponent();
        basicSearch = new BasicSearch();
        splitPanelSearch = new SplitPanelSearch();
        splitPanelDate = new SplitPanelDate();
        addTab("Search", null, splitPanelSearch, "Perform a general search");

        loadSavePanel = new LoadSavePanel();
        addTab("Load/Save", null, splitPanelDate, "Load/Save searches");

        panelConvert = new ConverterPanel();
        addTab("Converter", null, panelConvert, "Perform a video/audio convertion");
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
    public SplitPanelSearch getSplitPanelSearch() {
        return splitPanelSearch;
    }
}
