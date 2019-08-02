/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.loadSaveCriteria;

import com.fundation.logic.view.customElements.CustomPanel;

import javax.swing.JSplitPane;

/**
 * This class allows you to separate the panels.
 *
 * @author Melissa Romám
 * @version 1.0
 */
public class SplitPanelDate extends CustomPanel {
    private LoadSavePanel loadSavePanel;
    private BasicLoadSavePanel dateSearchPanel;

    /**
     *  The constructor let it initializer.
     */
    public SplitPanelDate() {
        initComponent();
    }

    /**
     *  This method allows initialize the component.
     */
    public void initComponent() {
        contentSplitPanels();
    }

    /**
     *  This method allows to display the content in divided panels.
     */
    public void contentSplitPanels() {
        dateSearchPanel = new BasicLoadSavePanel();
        loadSavePanel = new LoadSavePanel();
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dateSearchPanel, loadSavePanel);
        splitPane.setOneTouchExpandable(false);
        add(splitPane);
    }

    /**
     * Allows to get LoadSavePanel.
     * @return LoadSavePanel.
     */
    public LoadSavePanel getLoadSavePanel() {
        return loadSavePanel;
    }

    /**
     * Allows to get dateSearchPanel.
     * @return DateSearchPanel.
     */
    public BasicLoadSavePanel getDateSearchPanel() {
        return dateSearchPanel;
    }
}
