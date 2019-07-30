/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import com.fundation.logic.view.resultTable.TableResult;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * Implements the MainFrame class
 *
 * @author John Salazar Pinto, Melissa Román
 * @version 1.0
 */
public class MainFrame extends CustomJFrame {
    JPanel mainContentPanel;
    private MainTabs searchTabs;
    private TableResult tableResult;
    private HeaderPanel header;
    private FooterPanel footer;

    public MainFrame() {
        initSetting();
    }

    /**
     * This method init all component
     */
    public void initComponent() {
        mainContentPanel = new CustomPanelSecond();
        mainContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainContentPanel.setLayout(new BorderLayout(0, 0));

        header = new HeaderPanel();
        mainContentPanel.add(header, BorderLayout.NORTH);

        CustomSplitPanel mainSplitPanel = new CustomSplitPanel();
        mainSplitPanel.setDividerLocation(getWidth()/2);
        mainSplitPanel.setEnabled(false);
        mainSplitPanel.setBackground(new Color(60,63,65));
        mainContentPanel.add(mainSplitPanel, BorderLayout.CENTER);

        searchTabs = new MainTabs();
        mainSplitPanel.setLeftComponent(searchTabs);

        tableResult = new TableResult();
        JScrollPane tableScrollPanel = new JScrollPane(add(tableResult));
        tableScrollPanel.getViewport().setBackground(new Color(43,43,43));
        mainSplitPanel.setRightComponent(add(tableScrollPanel));

        footer = new FooterPanel();
        mainContentPanel.add(footer, BorderLayout.SOUTH);
    }

    /**
     * This method init all setting of the components like the position
     */
    public void initSetting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 400);
        setIconImage(new ImageIcon("resources/Images/icon.png").getImage());
        setTitle("J2AM2 Player");
        initComponent();
        setContentPane(mainContentPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    /**
     * This method return the TableResult
     */
    public TableResult getTableResult() {
        return tableResult;
    }

    /**
     * This method return the MainTabs
     */
    public MainTabs getSearchTabs() {
        return searchTabs;
    }
}
