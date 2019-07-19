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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Implements the SearchVideoFrame class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class SearchVideoFrame extends JFrame {
    JPanel mainContentPanel;
    private SearchTabs searchTabs;
    private TableResult tableResult;

    public SearchVideoFrame() {
        initSetting();
    }

    /**
     * This method init all component
     */
    public void initComponent() {
        Color newColor = new Color(81, 209, 246);
        this.setBackground( newColor );
        mainContentPanel = new JPanel();
        mainContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainContentPanel.setLayout(new BorderLayout(0, 0));

        JSplitPane mainSplitPanel = new JSplitPane();
        mainSplitPanel.setDividerLocation(getWidth()/2);
        mainSplitPanel.setEnabled(false);
        mainContentPanel.add(mainSplitPanel, BorderLayout.CENTER);

        tableResult = new TableResult();
        JScrollPane tableScrollPanel = new JScrollPane();
        tableScrollPanel.add(tableResult);
        mainSplitPanel.setRightComponent(tableResult);

        searchTabs = new SearchTabs();
        mainSplitPanel.setLeftComponent(searchTabs);
    }

    /**
     * This method init all setting of the components like the position
     */
    public void initSetting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 870, 400);
        setTitle("J2AM Player");
        initComponent();
        setContentPane(mainContentPanel);
        setVisible(true);
    }

    /**
     * This method return the TableResult
     */
    public TableResult getTableResult() {
        return tableResult;
    }

    /**
     * This method return the SearchTabs
     */
    public SearchTabs getSearchTabs() {
        return searchTabs;
    }
}
