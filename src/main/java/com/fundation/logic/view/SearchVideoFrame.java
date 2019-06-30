/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

/**
 * Implements the SearchVideoFrame class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class SearchVideoFrame extends JFrame {
    private JPanel contentSearchVideoPane;
    public SearchVideoFrame() {
        initComponent();
        initSetting();
    }

    /**
     * This method init all component
     */
    public void initComponent() {
        contentSearchVideoPane = new JPanel();
        SearchVideoPanel mainSearchPanel = new SearchVideoPanel();
        mainSearchPanel.setVisible(true);
        add(mainSearchPanel);
        SearchVideoPanel initSearchPanel = new SearchVideoPanel();
        contentSearchVideoPane.add(initSearchPanel);
    }

    /**
     * This method init all setting of the components like the position
     */
    public void initSetting() {
        setBounds(100, 100, 700, 700);
        contentSearchVideoPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentSearchVideoPane.setLayout(new BorderLayout(0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
