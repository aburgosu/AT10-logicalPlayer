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

import com.fundation.logic.view.CustomPanelSecond;
import com.fundation.logic.view.CustomButton;
import com.fundation.logic.view.PanelSetter;
import com.fundation.logic.view.CustomLabel;
import com.fundation.logic.view.CustomComboBox;
import com.fundation.logic.view.CustomTextField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implements basic convert panel.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertBasicPanel extends CustomPanelSecond {
    private CustomTextField textFieldSourcePath;
    private CustomTextField textFieldDestinationPath;
    private CustomTextField textFieldNewName;
    private CustomComboBox comboBoxMetadataFormat;
    private PanelSetter settingPanel;

    /**
     * The constructor let it initialize.
     */
    public ConvertBasicPanel() {
        basicConvertInitializer();
    }

    /**
     * This method initializes the basic convert searchCriteria fields panel.
     */
    public void basicConvertInitializer() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        showBasicConvertForm();
    }

    /**
     * This method displays basic convert searchCriteria form.
     */
    private void showBasicConvertForm() {
        CustomLabel title = new CustomLabel("Convert");
        title.setFont(new Font("Arial", Font.PLAIN, 14));
        GridBagConstraints gbc_lblTittle = new GridBagConstraints();
        gbc_lblTittle.gridwidth = 6;
        gbc_lblTittle.insets = new Insets(5, 5, 5, 5);
        gbc_lblTittle.gridx = 0;
        gbc_lblTittle.gridy = 0;
        add(title, gbc_lblTittle);

        CustomLabel lblSourcePath = new CustomLabel("Source path:");
        GridBagConstraints gbc_lblSourcePath = new GridBagConstraints();
        gbc_lblSourcePath.anchor = GridBagConstraints.EAST;
        gbc_lblSourcePath.insets = new Insets(0, 5, 5, 5);
        gbc_lblSourcePath.gridx = 0;
        gbc_lblSourcePath.gridy = 1;
        add(lblSourcePath, gbc_lblSourcePath);

        textFieldSourcePath = new CustomTextField();
        GridBagConstraints gbc_textFieldSourcePath = new GridBagConstraints();
        gbc_textFieldSourcePath.insets = new Insets(0, 0, 5, 5);
        textFieldSourcePath.setEditable(false);
        gbc_textFieldSourcePath.gridwidth = 3;
        gbc_textFieldSourcePath.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSourcePath.gridx = 1;
        gbc_textFieldSourcePath.gridy = 1;
        add(textFieldSourcePath, gbc_textFieldSourcePath);
        textFieldSourcePath.setColumns(5);

        CustomButton btnBrowseSourcePath = new CustomButton("Browse");
        btnBrowseSourcePath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser folderChooser = new JFileChooser();
                //folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = folderChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    textFieldSourcePath.setText(folderChooser.getSelectedFile().getPath());
                }
            }
        });

        GridBagConstraints gbc_btnBrowseSourcePath = new GridBagConstraints();
        gbc_btnBrowseSourcePath.insets = new Insets(0, 0, 5, 0);
        gbc_btnBrowseSourcePath.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnBrowseSourcePath.gridx = 4;
        gbc_btnBrowseSourcePath.gridy = 1;
        add(btnBrowseSourcePath, gbc_btnBrowseSourcePath);

        CustomLabel lblDestinationPath = new CustomLabel("Destination path:");
        GridBagConstraints gbc_lblDestinationPath = new GridBagConstraints();
        gbc_lblDestinationPath.anchor = GridBagConstraints.EAST;
        gbc_lblDestinationPath.insets = new Insets(0, 5, 5, 5);
        gbc_lblDestinationPath.gridx = 0;
        gbc_lblDestinationPath.gridy = 2;
        add(lblDestinationPath, gbc_lblDestinationPath);

        textFieldDestinationPath = new CustomTextField();
        GridBagConstraints gbc_textFieldDestinationPath = new GridBagConstraints();
        textFieldDestinationPath.setEditable(false);
        gbc_textFieldDestinationPath.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldDestinationPath.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDestinationPath.gridwidth = 3;
        gbc_textFieldDestinationPath.gridx = 1;
        gbc_textFieldDestinationPath.gridy = 2;
        add(textFieldDestinationPath, gbc_textFieldDestinationPath);
        textFieldDestinationPath.setColumns(5);

        CustomButton btnBrowseDestinationPath = new CustomButton("Browse");
        btnBrowseDestinationPath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser folderChooser = new JFileChooser();
                folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = folderChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    textFieldDestinationPath.setText(folderChooser.getSelectedFile().getPath());
                }
            }
        });

        GridBagConstraints gbc_btnBrowseDestinationPath = new GridBagConstraints();
        gbc_btnBrowseDestinationPath.insets = new Insets(0, 0, 5, 0);
        gbc_btnBrowseDestinationPath.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnBrowseDestinationPath.gridx = 4;
        gbc_btnBrowseDestinationPath.gridy = 2;
        add(btnBrowseDestinationPath, gbc_btnBrowseDestinationPath);

        CustomLabel lblNewName = new CustomLabel("New name:");
        GridBagConstraints gbc_lblNewName = new GridBagConstraints();
        gbc_lblNewName.anchor = GridBagConstraints.EAST;
        gbc_lblNewName.insets = new Insets(0, 10, 5, 5);
        gbc_lblNewName.gridx = 0;
        gbc_lblNewName.gridy = 3;
        add(lblNewName, gbc_lblNewName);

        textFieldNewName = new CustomTextField();
        GridBagConstraints gbc_textFieldNewName = new GridBagConstraints();
        gbc_textFieldNewName.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldNewName.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNewName.gridwidth = 3;
        gbc_textFieldNewName.gridx = 1;
        gbc_textFieldNewName.gridy = 3;
        add(textFieldNewName, gbc_textFieldNewName);
        textFieldNewName.setColumns(5);

        CustomLabel lblMetadataFormat = new CustomLabel("Metadata format:");
        GridBagConstraints gbc_lblMetadataFormat = new GridBagConstraints();
        gbc_lblMetadataFormat.anchor = GridBagConstraints.EAST;
        gbc_lblMetadataFormat.insets = new Insets(0, 0, 5, 5);
        gbc_lblMetadataFormat.gridx = 0;
        gbc_lblMetadataFormat.gridy = 4;
        add(lblMetadataFormat, gbc_lblMetadataFormat);

        comboBoxMetadataFormat = new CustomComboBox();
        comboBoxMetadataFormat.setModel(new DefaultComboBoxModel(new String[]{"None", "xmp", "json"}));
        GridBagConstraints gbc_comboBoxMetadataFormat = new GridBagConstraints();
        gbc_comboBoxMetadataFormat.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxMetadataFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxMetadataFormat.gridx = 1;
        gbc_comboBoxMetadataFormat.gridy = 4;
        add(comboBoxMetadataFormat, gbc_comboBoxMetadataFormat);
    }

    /**
     * Allows to get textFieldSourcePath.
     * @return textFieldSourcePath
     */
    public CustomTextField getTextFieldSourcePath() {
        return textFieldSourcePath;
    }

    /**
     * Allows to get textFieldDestinationPath.
     * @return textFieldDestinationPath
     */
    public CustomTextField getTextFieldDestinationPath() {
        return textFieldDestinationPath;
    }

    /**
     * Allows to get textFieldNewName.
     * @return textFieldNewName
     */
    public CustomTextField getTextFieldNewName() {
        return textFieldNewName;
    }

    /**
     * Allows to get textFieldMetadataFormat.
     * @return comboBoxMetadataFormat
     */
    public CustomComboBox getComboBoxMetadataFormat() {
        return comboBoxMetadataFormat;
    }
}
