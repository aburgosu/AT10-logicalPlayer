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

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;

/**
 * Implements the MainFrame class
 *
 * @author John Salazar Pinto, Melissa Román
 * @version 1.0
 */
public class MainFrame extends JFrame {
    JPanel mainContentPanel;
    private MainTabs searchTabs;
    private TableResult tableResult;

    public MainFrame() {
        initSetting();
    }

    /**
     * This method init all component
     */
    public void initComponent() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            e.printStackTrace();
        }
        mainContentPanel = new JPanel();
        mainContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainContentPanel.setLayout(new BorderLayout(0, 0));
        mainContentPanel.setBackground(new Color(42, 135, 77));

        JSplitPane mainSplitPanel = new JSplitPane();
        mainSplitPanel.setDividerLocation(getWidth()/2);
        mainSplitPanel.setEnabled(false);
        mainContentPanel.add(mainSplitPanel, BorderLayout.CENTER);

        tableResult = new TableResult();
        JScrollPane tableScrollPanel = new JScrollPane();
        tableScrollPanel.add(tableResult);
        mainSplitPanel.setRightComponent(tableResult);

        searchTabs = new MainTabs();
        mainSplitPanel.setLeftComponent(searchTabs);
    }

    /**
     * This method init all setting of the components like the position
     */
    public void initSetting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 870, 400);
        setForeground(Color.orange);
        setBackground(Color.BLUE);
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
     * This method return the MainTabs
     */
    public MainTabs getSearchTabs() {
        return searchTabs;
    }

    /**
     * Shows a popup message
     * @param messageTittle - Tittle of the message
     * @param messageText - Text of the message
     */
    public void showPopupMessage(String messageTittle, String messageText) {
        JDialog message = new JDialog(this, messageTittle);
        message.setBounds(50, 200, 350, 150);
        message.setSize(350, 120);
        JPanel messageTextPanel = new JPanel();
        JLabel text = new JLabel(messageText);
        text.setFont(new Font("Tahoma", Font.PLAIN, 12));
        text.setForeground(Color.red);
        messageTextPanel.add(text, SwingConstants.CENTER);
        message.add(messageTextPanel, BorderLayout.CENTER);
        message.setVisible(true);
    }
}
