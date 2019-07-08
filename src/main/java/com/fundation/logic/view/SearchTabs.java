/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

/**
 * Implements the tabs of different options.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class SearchTabs extends JTabbedPane {
    private AdvancedSearchPanel panelAdvanced;
    private SearchVideoPanel panelGeneral;
    private GeneralSearchPanel generalSearchPanel;
    private LoadSavePanel loadSavePanel;
    private final JPanel panelConvert;

    /**
     * Initializes a SearchTabs instance for the search options
     */
    public SearchTabs() {

        generalSearchPanel = new GeneralSearchPanel();
        panelGeneral = new SearchVideoPanel();
        panelGeneral.initComponent();
        addTab("General", null, generalSearchPanel, "Perform a general search");

        panelAdvanced = new AdvancedSearchPanel();
        addTab("Advanced", null, panelAdvanced, "Perform an advanced search");

        loadSavePanel = new LoadSavePanel();
        addTab("Load/Save", null, loadSavePanel, "Load/Save searches");

        panelConvert = new JPanel();
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
}
