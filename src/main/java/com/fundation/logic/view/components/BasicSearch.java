/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.components;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

/**
 * This class is in charge of displaying Path, filename and type information.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class BasicSearch extends JPanel {
    private JTextField textFieldPath;
    private JTextField textFileName;
    private JTextField textFieldFileType;
    private SettingPanel settingPanel;

    /**
     *  The constructor let it initializer.
     */
    public BasicSearch() {
        basicSearchInitializer();
    }

    /**
     * This method initializes the basic search content and sets the panel.
     */
    public void basicSearchInitializer() {
        settingPanel = new SettingPanel();
        settingPanel.settingPanelAdvanceSearch(this);
        contentBasicSearch();
    }

    /**
     * This method displays Basic Search content on the screen.
     */
    private void contentBasicSearch() {
        JLabel title = new JLabel("File Search");
        title.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_lblVideo = new GridBagConstraints();
        gbc_lblVideo.gridwidth = 3;
        gbc_lblVideo.insets = new Insets(0, 0, 5, 0);
        gbc_lblVideo.gridx = 0;
        gbc_lblVideo.gridy = 0;
        add(title, gbc_lblVideo);

        JLabel lblPath = new JLabel("Path: ");
        GridBagConstraints gbc_lblPath = new GridBagConstraints();
        gbc_lblPath.anchor = GridBagConstraints.EAST;
        gbc_lblPath.insets = new Insets(0, 0, 5, 5);
        gbc_lblPath.gridx = 0;
        gbc_lblPath.gridy = 1;
        add(lblPath, gbc_lblPath);

        textFieldPath = new JTextField();
        GridBagConstraints gbc_textFieldPath = new GridBagConstraints();
        gbc_textFieldPath.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldPath.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldPath.gridx = 1;
        gbc_textFieldPath.gridy = 1;
        add(textFieldPath, gbc_textFieldPath);
        textFieldPath.setColumns(10);

        JButton btnBrowsePath = new JButton("Browse");
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
        gbc_btnBrowsePath.gridx = 2;
        gbc_btnBrowsePath.gridy = 1;
        add(btnBrowsePath, gbc_btnBrowsePath);

        JLabel lblFileName = new JLabel("File Name: ");
        GridBagConstraints gbc_lblTittle = new GridBagConstraints();
        gbc_lblTittle.anchor = GridBagConstraints.EAST;
        gbc_lblTittle.insets = new Insets(0, 0, 5, 5);
        gbc_lblTittle.gridx = 0;
        gbc_lblTittle.gridy = 2;
        add(lblFileName, gbc_lblTittle);

        textFileName = new JTextField();
        GridBagConstraints gbc_textFieldTittle = new GridBagConstraints();
        gbc_textFieldTittle.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldTittle.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTittle.gridx = 1;
        gbc_textFieldTittle.gridy = 2;
        add(textFileName, gbc_textFieldTittle);
        textFileName.setColumns(10);

        JLabel lblExtension = new JLabel("File Extension: ");
        GridBagConstraints gbc_lblFileType = new GridBagConstraints();
        gbc_lblFileType.anchor = GridBagConstraints.EAST;
        gbc_lblFileType.insets = new Insets(0, 0, 5, 5);
        gbc_lblFileType.gridx = 0;
        gbc_lblFileType.gridy = 3;
        add(lblExtension, gbc_lblFileType);

        textFieldFileType = new JTextField();
        GridBagConstraints gbc_textFieldFileExtension = new GridBagConstraints();
        gbc_textFieldFileExtension.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldFileExtension.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldFileExtension.gridx = 1;
        gbc_textFieldFileExtension.gridy = 3;
        add(textFieldFileType, gbc_textFieldFileExtension);
        textFieldFileType.setColumns(10);
    }

    /**
     * This method return Path in TextFieldPath.
     * @return textFieldPath
     */
    public JTextField getTextFieldPath() {
        return textFieldPath;
    }

    /**
     * This method return File Name in TextFileName.
     * @return textFileName
     */
    public JTextField getTextFileName() {
        return textFileName;
    }

    /**
     * This method return File Type in TextFieldFileType.
     * @return textFileType
     */
    public JTextField getTextFieldFileType() {
        return textFieldFileType;
    }
}
