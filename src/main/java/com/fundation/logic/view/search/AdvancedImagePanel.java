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

import com.fundation.logic.view.PanelSetter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This class show the Advance image in a panel.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class AdvancedImagePanel extends JPanel {
    private JButton btnSearchAdvanceImage;
    private JTextField textFieldWidth;
    private JTextField textFieldHeight;
    private JComboBox comboBoxColorSpaceData;
    private PanelSetter settingPanel;

    /**
     * This constructor initializer the component.
     */
    public AdvancedImagePanel() {
        initComponent();
    }

    /**
     * This method initializer the set to the panel and content image panel.
     */
    public void initComponent() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        imageContentPanel();
    }

    /**
     * This method show the content panel.
     */
    private void imageContentPanel() {
        JLabel lblWidth = new JLabel("Width: ");
        GridBagConstraints gbc_lblWidth = new GridBagConstraints();
        gbc_lblWidth.anchor = GridBagConstraints.EAST;
        gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
        gbc_lblWidth.gridx = 1;
        gbc_lblWidth.gridy = 4;
        add(lblWidth, gbc_lblWidth);

        textFieldWidth = new JTextField();
        GridBagConstraints gbc_textFieldWith = new GridBagConstraints();
        gbc_textFieldWith.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldWith.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldWith.gridx = 2;
        gbc_textFieldWith.gridy = 4;
        add(textFieldWidth, gbc_textFieldWith);

        JLabel lblHeight = new JLabel("Height: ");
        GridBagConstraints gbc_lblHeight = new GridBagConstraints();
        gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
        gbc_lblHeight.anchor = GridBagConstraints.EAST;
        gbc_lblHeight.gridx = 1;
        gbc_lblHeight.gridy = 5;
        add(lblHeight, gbc_lblHeight);

        textFieldHeight = new JTextField();
        GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
        gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldWidth.gridx = 2;
        gbc_textFieldWidth.gridy = 5;
        add(textFieldHeight, gbc_textFieldWidth);

        JLabel lblColorSpaceData = new JLabel("Color space data: ");
        GridBagConstraints gbc_ColorSpaceData = new GridBagConstraints();
        gbc_ColorSpaceData.anchor = GridBagConstraints.EAST;
        gbc_ColorSpaceData.insets = new Insets(0, 0, 5, 5);
        gbc_ColorSpaceData.gridx = 1;
        gbc_ColorSpaceData.gridy = 6;
        add(lblColorSpaceData, gbc_ColorSpaceData);

        comboBoxColorSpaceData = new JComboBox();
        comboBoxColorSpaceData.setModel(new DefaultComboBoxModel(new String[]{"All", "RGB", "MCY", "RG", "CMYK",}));
        GridBagConstraints gbc_ComboBoxColorSpaceData = new GridBagConstraints();
        gbc_ComboBoxColorSpaceData.insets = new Insets(0, 0, 5, 0);
        gbc_ComboBoxColorSpaceData.fill = GridBagConstraints.HORIZONTAL;
        gbc_ComboBoxColorSpaceData.gridx = 2;
        gbc_ComboBoxColorSpaceData.gridy = 6;
        add(comboBoxColorSpaceData, gbc_ComboBoxColorSpaceData);

        btnSearchAdvanceImage = new JButton("Search");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.CENTER;
        gbc_btnSearch.gridwidth = 6;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 7;
        add(btnSearchAdvanceImage, gbc_btnSearch);
    }

    /**
     * This method return btnSearchAdvanceImage.
     * @return
     */
    public JButton getBtnSearchAdvanceImage() {
        return btnSearchAdvanceImage;
    }

    /**
     * This method return textFieldWidth.
     * @return textFieldWidth
     */
    public JTextField getTextFieldWidth() {
        return textFieldWidth;
    }

    /**
     * This method return textFieldHeight.
     * @return textFieldHeight
     */
    public JTextField getTextFieldHeight() {
        return textFieldHeight;
    }

    /**
     * This method return comboBoxColorSpaceData.
     * @return comboBoxColorSpaceData
     */
    public JComboBox getComboBoxColorSpaceData() {
        return comboBoxColorSpaceData;
    }
}