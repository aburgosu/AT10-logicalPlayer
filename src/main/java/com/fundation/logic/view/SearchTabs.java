/**
 * Copyright (c) 2019 Jalasoft.
 * <p>
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
 * Implements the tabs of different .
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class SearchTabs extends JTabbedPane {
    private JPanel panelAdvanced;
    private JPanel panelLoadSave;
    private SearchVideoPanel panelGeneral;
    private GeneralSearchPanel generalSearchPanel;
    /**
     * Initializes a SearchTabs instance for the search options
     */
    public SearchTabs() {

        generalSearchPanel = new GeneralSearchPanel();
        panelGeneral = new SearchVideoPanel();
        panelGeneral.initComponent();
        addTab("General", null, generalSearchPanel, "Perform a general search");

        panelAdvanced = new JPanel();
        addTab("Advanced", null, panelAdvanced, "Perform an advanced search");

        panelLoadSave = new JPanel();
        addTab("Load/Save", null, panelLoadSave, "Load/Save searches");
    }
}
