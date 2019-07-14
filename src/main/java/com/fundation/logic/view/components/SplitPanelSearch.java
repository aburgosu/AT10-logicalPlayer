/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.components;

import com.fundation.logic.view.SearchAdvanceTab;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

/**
 * This class allows you to separate the panels.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class SplitPanelSearch extends JPanel {
    /**
     * The constructor allows components to be initialized.
     */
    public SplitPanelSearch() {
        initComponent();
    }

    /**
     * This method initializes the component.
     */
    public void initComponent() {
        ContentsplitPanel();
    }

    /**
     * This method shows the content of the division of panels in a splitPane.
     */
    public void ContentsplitPanel() {
        JPanel basicSearch = new BasicSearch();
        JTabbedPane a = new SearchAdvanceTab();
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, basicSearch, a);
        splitPane.setOneTouchExpandable(true);
        add(splitPane);
    }
}
