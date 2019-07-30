/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.search;

import com.fundation.logic.view.customElements.CustomPanel;

import javax.swing.JSplitPane;

/**
 * This class allows you to separate the panels.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class SearchSplitPanel extends CustomPanel {
    private BasicSearchPanel basicSearch;
    private SearchAdvanceTab searchOptionTabs;
    /**
     * The constructor allows components to be initialized.
     */
    public SearchSplitPanel() {
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
        basicSearch = new BasicSearchPanel();
        searchOptionTabs = new SearchAdvanceTab();
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, basicSearch, searchOptionTabs);
        splitPane.setOneTouchExpandable(false);
        add(splitPane);
    }

    /**
     * This method return the basicSearch content.
     * @return basicSearch
     */
    public BasicSearchPanel getBasicSearchPanel() {
        return basicSearch;
    }

    /**
     * This method return the searchOptionTabs content.
     * @return searchOptionTabs.
     */
    public SearchAdvanceTab getSearchAdvanceTab() {
        return searchOptionTabs;
    }
}
