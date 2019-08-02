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

import com.fundation.logic.view.customElements.CustomPanelSecond;
import com.fundation.logic.view.customElements.CustomButton;
import com.fundation.logic.view.PanelSetter;
import com.fundation.logic.view.customElements.CustomLabel;
import com.fundation.logic.view.customElements.CustomTextField;

import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is in charge of displaying Path, filename and type information.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class BasicSearchPanel extends CustomPanelSecond {
    private CustomTextField textFieldPath;
    private CustomTextField textFileName;
    private CustomTextField textFieldFileType;
    private PanelSetter settingPanel;

    /**
     *  The constructor let it initializer.
     */
    public BasicSearchPanel() {
        basicSearchInitializer();
    }

    /**
     * This method initializes the basic search content and sets the panel.
     */
    public void basicSearchInitializer() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        contentBasicSearch();
    }

    /**
     * This method displays Basic search content on the screen.
     */
    private void contentBasicSearch() {
        CustomLabel title = new CustomLabel("Search");
        title.setFont(new Font("Arial", Font.PLAIN, 14));
        GridBagConstraints gbc_lblVideo = new GridBagConstraints();
        gbc_lblVideo.gridwidth = 6;
        gbc_lblVideo.insets = new Insets(5, 5, 5, 5);
        gbc_lblVideo.gridx = 0;
        gbc_lblVideo.gridy = 0;
        add(title, gbc_lblVideo);

        CustomLabel lblPath = new CustomLabel("Path:");
        GridBagConstraints gbc_lblPath = new GridBagConstraints();
        gbc_lblPath.anchor = GridBagConstraints.EAST;
        gbc_lblPath.insets = new Insets(0, 5, 5, 5);
        gbc_lblPath.gridx = 0;
        gbc_lblPath.gridy = 1;
        add(lblPath, gbc_lblPath);

        textFieldPath = new CustomTextField();
        GridBagConstraints gbc_textFieldPath = new GridBagConstraints();
        gbc_textFieldPath.gridwidth = 3;
        gbc_textFieldPath.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldPath.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldPath.gridx = 1;
        gbc_textFieldPath.gridy = 1;
        textFieldPath.setEditable(false);
        add(textFieldPath, gbc_textFieldPath);
        textFieldPath.setColumns(5);

        CustomButton btnBrowsePath = new CustomButton("Browse");
        btnBrowsePath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser folderChooser = new JFileChooser();
                folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = folderChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    textFieldPath.setText(folderChooser.getSelectedFile().getPath());
                }
            }
        });

        GridBagConstraints gbc_btnBrowsePath = new GridBagConstraints();
        gbc_btnBrowsePath.insets = new Insets(0, 0, 5, 0);
        gbc_btnBrowsePath.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnBrowsePath.gridx = 4;
        gbc_btnBrowsePath.gridy = 1;
        add(btnBrowsePath, gbc_btnBrowsePath);

        CustomLabel lblFileName = new CustomLabel("Name:");
        GridBagConstraints gbc_lblTittle = new GridBagConstraints();
        gbc_lblTittle.anchor = GridBagConstraints.EAST;
        gbc_lblTittle.insets = new Insets(0, 5, 5, 5);
        gbc_lblTittle.gridx = 0;
        gbc_lblTittle.gridy = 2;
        add(lblFileName, gbc_lblTittle);

        textFileName = new CustomTextField();
        GridBagConstraints gbc_textFieldTittle = new GridBagConstraints();
        gbc_textFieldTittle.gridwidth = 3;
        gbc_textFieldTittle.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldTittle.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTittle.gridx = 1;
        gbc_textFieldTittle.gridy = 2;
        add(textFileName, gbc_textFieldTittle);
        textFileName.setColumns(5);

        CustomLabel lblExtension = new CustomLabel("Extension:");
        GridBagConstraints gbc_lblFileType = new GridBagConstraints();
        gbc_lblFileType.anchor = GridBagConstraints.EAST;
        gbc_lblFileType.insets = new Insets(0, 10, 5, 5);
        gbc_lblFileType.gridx = 0;
        gbc_lblFileType.gridy = 3;
        add(lblExtension, gbc_lblFileType);

        textFieldFileType = new CustomTextField();
        GridBagConstraints gbc_textFieldFileExtension = new GridBagConstraints();
        gbc_textFieldFileExtension.insets = new Insets(0, 0, 5, 10);
        gbc_textFieldFileExtension.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldFileExtension.gridx = 1;
        gbc_textFieldFileExtension.gridy = 3;
        add(textFieldFileType, gbc_textFieldFileExtension);
        textFieldFileType.setColumns(5);
    }

    /**
     * This method return Path in TextFieldPath.
     * @return textFieldPath
     */
    public CustomTextField getTextFieldPath() {
        return textFieldPath;
    }

    /**
     * This method return File Name in TextFileName.
     * @return textFileName
     */
    public CustomTextField getTextFileName() {
        return textFileName;
    }

    /**
     * This method return File Type in TextFieldFileType.
     * @return textFileType
     */
    public CustomTextField getTextFieldFileType() {
        return textFieldFileType;
    }
}
