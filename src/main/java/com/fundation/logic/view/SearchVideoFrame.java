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
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

/**
 * Implements the SearchVideoFrame class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class SearchVideoFrame extends JFrame {
    private String pathAddress;
    private SearchVideoPanel mainSearchPanel;

    public SearchVideoFrame() {
        initComponent();
        initSetting();
    }

    /**
     * This method init all component
     */
    public void initComponent() {
        mainSearchPanel = new SearchVideoPanel();
        add(mainSearchPanel);
        setVisible(true);
    }

    /**
     * This method init all setting of the components like the position
     */
    public void initSetting() {
        setBounds(100, 100, 700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getPath() {
        pathAddress = mainSearchPanel.getPath();
        return pathAddress;
    }
}
