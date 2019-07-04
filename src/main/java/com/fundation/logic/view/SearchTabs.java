package com.fundation.logic.view;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class SearchTabs extends JTabbedPane {
    /**
     * Initializes a SearchTabs instance for the search options
     */
    public SearchTabs() {
        SearchVideoPanel panelGeneral = new SearchVideoPanel();
        panelGeneral.initComponent();
        addTab("General", null, panelGeneral, "Perform a general search");

        JPanel panelAdvanced = new JPanel();
        addTab("Advanced", null, panelAdvanced, "Perform an advanced search");

        JPanel panelLoadSave = new JPanel();
        addTab("Load/Save", null, panelLoadSave, "Load/Save searches");
    }
}
