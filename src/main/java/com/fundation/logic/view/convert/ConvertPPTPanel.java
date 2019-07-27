/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.convert;

import com.fundation.logic.view.*;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Implements convert PPT panel.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertPPTPanel extends CustomPanel2 {
    private JComboBox comboBoxNewFormat;
    private PanelSetter settingPanel;
    private CustomButton btnConvertAudio;

    /**
     * This constructor initializes the component.
     */
    public ConvertPPTPanel() {
        initComponent();
    }

    /**
     * This method initializes the panel with the form.
     */
    public void initComponent() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        showPPTConvertCriteriaForm();
    }

    /**
     * This method show convert PPT form.
     */
    private void showPPTConvertCriteriaForm() {
        JLabel lblNewFormat = new CustomLabel("New format:");
        GridBagConstraints gbc_lblNewFormat = new GridBagConstraints();
        gbc_lblNewFormat.anchor = GridBagConstraints.EAST;
        gbc_lblNewFormat.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewFormat.gridx = 1;
        gbc_lblNewFormat.gridy = 4;
        add(lblNewFormat, gbc_lblNewFormat);

        comboBoxNewFormat = new CustomComboBox();
        comboBoxNewFormat.setModel(new DefaultComboBoxModel(new String[]{"PNG", "JPG", "BMP", "GIF", "TIF"}));
        GridBagConstraints gbc_comboBoxNewFormat = new GridBagConstraints();
        gbc_comboBoxNewFormat.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxNewFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxNewFormat.gridx = 2;
        gbc_comboBoxNewFormat.gridy = 4;
        add(comboBoxNewFormat, gbc_comboBoxNewFormat);

        btnConvertAudio = new CustomButton("Convert");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.CENTER;
        gbc_btnSearch.insets = new Insets(0, 0, 10, 0);
        gbc_btnSearch.gridwidth = 6;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 17;
        add(btnConvertAudio, gbc_btnSearch);
    }


    /**
     * Allows to get comboBoxNewFormat.
     * @return
     */
    public JComboBox getComboBoxNewFormat() {
        return comboBoxNewFormat;
    }

    /**
     * Allows to get comboBoxNewFormat.
     * @return btnConvertAudio
     */
    public JButton getBtnConvertAudio() {
        return btnConvertAudio;
    }
}
