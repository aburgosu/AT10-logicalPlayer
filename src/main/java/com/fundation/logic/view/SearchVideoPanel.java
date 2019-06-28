/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Implements the SearchVideoPanel class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class SearchVideoPanel extends JPanel {

    private JTextField txtFldPath, txtFldFileName, txtFldSize, txtFldCreationDate, txtFldModificationDate;
    private JLabel lblSearch, lblPath, lblFileName, lblSize, lblCreationDate, lblModificationDate;
    private JComboBox comboSize;
    private Integer positionOneX,positionTwoX,positionThreeX;//position x default

    public SearchVideoPanel() {
        initComponent();
        initSetting();
    }

    /**
     * This method init all component
     */
    public void initComponent() {

        setLayout(null);

        //Init and adds Labels
        lblSearch = new JLabel("Search");
        add(lblSearch);
        lblPath = new JLabel("Path");
        add(lblPath);
        lblFileName = new JLabel("File Name");
        add(lblFileName);
        lblSize = new JLabel("Size");
        add(lblSize);
        lblCreationDate = new JLabel("Creation Date");
        add(lblCreationDate);
        lblModificationDate = new JLabel("Modification Date");
        add(lblModificationDate);
        //LabelsVideo search options


        //Init and adds Texts Fields
        txtFldPath = new JTextField();
        add(txtFldPath);
        txtFldFileName = new JTextField();
        add(txtFldFileName);
        txtFldSize = new JTextField();
        add(txtFldSize);
        txtFldCreationDate = new JTextField();
        add(txtFldCreationDate);
        txtFldModificationDate = new JTextField();
        add(txtFldModificationDate);

        //Init and adds combo box
        comboSize = new JComboBox();
        add(comboSize);

    }

    /**
     * This method init all settings
     */
    public void initSetting() {

        positionOneX = 10;
        positionTwoX = 180;
        positionThreeX = 300;

        lblSearch.setBounds(positionOneX, 23, 62, 27);
        lblPath.setBounds(positionOneX, 56, 51, 27);
        lblFileName.setBounds(positionOneX, 86, 90, 27);
        lblSize.setBounds(positionOneX, 120, 40, 20);
        lblCreationDate.setBounds(positionOneX, 150, 160, 20);
        lblModificationDate.setBounds(10, 180, 160, 20);

        txtFldPath.setBounds(positionTwoX, 59, 86, 20);
        txtFldFileName.setBounds(positionTwoX, 90, 86, 20);
        txtFldSize.setBounds(positionTwoX, 120, 86, 20);
        comboSize.setBounds(positionThreeX, 120, 45, 20);
        txtFldCreationDate.setBounds(positionTwoX,150,60,20);
        txtFldModificationDate.setBounds(positionTwoX,180,60,20);

        txtFldPath.setText("...");
        txtFldFileName.setText("...");
        txtFldSize.setText("...");
        txtFldCreationDate.setText("...");
        txtFldModificationDate.setText("...");

        //Video search options




    }
}
