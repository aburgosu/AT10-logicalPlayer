/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Implements the SearchVideoPanel class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class SearchVideoPanel extends JPanel {

    private JTextField txtFldPath;
    JLabel lblSearch, lblPath;

    public SearchVideoPanel() {
        initComponent();
        initSetting();
    }

    /**
     * This method init all component
     */
    public void initComponent() {

        setLayout(null);

        lblSearch = new JLabel("Search");
        add(lblSearch);

        lblPath = new JLabel("Path");
        add(lblPath);

        txtFldPath = new JTextField();
        add(txtFldPath);
    }

    /**
     * This method init all settings
     */
    public void initSetting() {

        lblSearch.setBounds(24, 23, 62, 27);
        lblPath.setBounds(10, 56, 51, 27);
        lblPath.setBounds(10, 56, 51, 27);
        txtFldPath.setBounds(50, 59, 86, 20);
        txtFldPath.setText("...");

    }
}
