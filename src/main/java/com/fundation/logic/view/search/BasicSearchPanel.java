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

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is in charge of displaying Path, filename and type information.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class BasicSearchPanel extends JPanel {
    private JTextField textFieldPath;
    private JTextField textFileName;
    private JTextField textFieldFileType;
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
        JLabel title = new JLabel("Search");
        title.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_lblVideo = new GridBagConstraints();
        gbc_lblVideo.gridwidth = 6;
        gbc_lblVideo.insets = new Insets(5, 5, 5, 5);
        gbc_lblVideo.gridx = 0;//3
        gbc_lblVideo.gridy = 0;
        add(title, gbc_lblVideo);

        JLabel lblPath = new JLabel("Path: ");
        GridBagConstraints gbc_lblPath = new GridBagConstraints();
        gbc_lblPath.anchor = GridBagConstraints.EAST;
        gbc_lblPath.insets = new Insets(0, 5, 5, 5);
        gbc_lblPath.gridx = 1;//0
        gbc_lblPath.gridy = 1;
        add(lblPath, gbc_lblPath);

        textFieldPath = new JTextField();
        GridBagConstraints gbc_textFieldPath = new GridBagConstraints();
        gbc_textFieldPath.gridwidth = 2;
        gbc_textFieldPath.insets = new Insets(0, 0, 5, 10);
        gbc_textFieldPath.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldPath.gridx = 2;//1
        gbc_textFieldPath.gridy = 1;
        //textFieldPath.setEditable(false);
        add(textFieldPath, gbc_textFieldPath);
        textFieldPath.setColumns(5);

        JButton btnBrowsePath = new JButton("Browse");
        Color newColor = new Color(81, 209, 246);
        btnBrowsePath.setBackground(newColor);
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
        gbc_btnBrowsePath.insets = new Insets(0, 0, 5, 10);
        gbc_btnBrowsePath.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnBrowsePath.gridx = 4;//2
        gbc_btnBrowsePath.gridy = 1;
        add(btnBrowsePath, gbc_btnBrowsePath);

        JLabel lblFileName = new JLabel("Name: ");
        GridBagConstraints gbc_lblTittle = new GridBagConstraints();
        gbc_lblTittle.anchor = GridBagConstraints.EAST;
        gbc_lblTittle.insets = new Insets(0, 5, 5, 5);
        gbc_lblTittle.gridx = 1; //0
        gbc_lblTittle.gridy = 2;
        add(lblFileName, gbc_lblTittle);

        textFileName = new JTextField();
        GridBagConstraints gbc_textFieldTittle = new GridBagConstraints();
        gbc_textFieldTittle.gridwidth = 2;
        gbc_textFieldTittle.insets = new Insets(0, 0, 5, 10);
        gbc_textFieldTittle.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTittle.gridx = 2; //1
        gbc_textFieldTittle.gridy = 2;
        add(textFileName, gbc_textFieldTittle);
        textFileName.setColumns(5);

        JLabel lblExtension = new JLabel("Extension: ");
        GridBagConstraints gbc_lblFileType = new GridBagConstraints();
        gbc_lblFileType.anchor = GridBagConstraints.EAST;
        gbc_lblFileType.insets = new Insets(0, 10, 5, 5);
        gbc_lblFileType.gridx = 1; //0
        gbc_lblFileType.gridy = 3;
        add(lblExtension, gbc_lblFileType);

        textFieldFileType = new JTextField();
        GridBagConstraints gbc_textFieldFileExtension = new GridBagConstraints();
        gbc_textFieldFileExtension.insets = new Insets(0, 0, 5, 10);
        gbc_textFieldFileExtension.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldFileExtension.gridx = 2;//1
        gbc_textFieldFileExtension.gridy = 3;
        add(textFieldFileType, gbc_textFieldFileExtension);
        textFieldFileType.setColumns(5);
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
