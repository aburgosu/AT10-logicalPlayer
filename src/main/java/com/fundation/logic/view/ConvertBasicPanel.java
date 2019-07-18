/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import com.fundation.logic.view.components.SettingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is in charge of displaying Path, filename and type information.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class ConvertBasicPanel extends JPanel {
    private JTextField textFieldSourcePath;
    private JTextField textFieldDestinationPath;
    private JTextField textFieldNewName;
    private SettingPanel settingPanel;

    /**
     *  The constructor let it initializer.
     */
    public ConvertBasicPanel() {
        basicConvertInitializer();
    }

    /**
     * This method initializes the basic search content and sets the panel.
     */
    public void basicConvertInitializer() {
        settingPanel = new SettingPanel();
        settingPanel.setPanel(this);
        contentBasicConvert();
    }

    /**
     * This method displays Basic Search content on the screen.
     */
    private void contentBasicConvert() {
        JLabel title = new JLabel("Convert");
        title.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_lblTittle = new GridBagConstraints();
        gbc_lblTittle.gridwidth = 3;
        gbc_lblTittle.insets = new Insets(5, 5, 5, 5);
        gbc_lblTittle.gridx = 0;
        gbc_lblTittle.gridy = 0;
        add(title, gbc_lblTittle);

        JLabel lblSourcePath = new JLabel("Source path: ");
        GridBagConstraints gbc_lblSourcePath = new GridBagConstraints();
        gbc_lblSourcePath.anchor = GridBagConstraints.EAST;
        gbc_lblSourcePath.insets = new Insets(0, 5, 5, 5);
        gbc_lblSourcePath.gridx = 0;
        gbc_lblSourcePath.gridy = 1;
        add(lblSourcePath, gbc_lblSourcePath);

        textFieldSourcePath = new JTextField();
        GridBagConstraints gbc_textFieldSourcePath = new GridBagConstraints();
        gbc_textFieldSourcePath.insets = new Insets(0, 0, 5, 10);
        gbc_textFieldSourcePath.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSourcePath.gridx = 1;
        gbc_textFieldSourcePath.gridy = 1;
        //textFieldSourcePath.setEditable(false);
        add(textFieldSourcePath, gbc_textFieldSourcePath);
        textFieldSourcePath.setColumns(5);

        JButton btnBrowseSourcePath = new JButton("Browse");
        btnBrowseSourcePath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser folderChooser = new JFileChooser();
                folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = folderChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    textFieldSourcePath.setText(folderChooser.getSelectedFile().getPath());
                }
            }
        });

        GridBagConstraints gbc_btnBrowseSourcePath = new GridBagConstraints();
        gbc_btnBrowseSourcePath.insets = new Insets(0, 0, 5, 10);
        gbc_btnBrowseSourcePath.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnBrowseSourcePath.gridx = 2;
        gbc_btnBrowseSourcePath.gridy = 1;
        add(btnBrowseSourcePath, gbc_btnBrowseSourcePath);

        JLabel lblDestinationPath = new JLabel("Destination path: ");
        GridBagConstraints gbc_lblDestinationPath = new GridBagConstraints();
        gbc_lblDestinationPath.anchor = GridBagConstraints.EAST;
        gbc_lblDestinationPath.insets = new Insets(0, 5, 5, 5);
        gbc_lblDestinationPath.gridx = 0;
        gbc_lblDestinationPath.gridy = 2;
        add(lblDestinationPath, gbc_lblDestinationPath);

        textFieldDestinationPath = new JTextField();
        GridBagConstraints gbc_textFieldDestinationPath = new GridBagConstraints();
        gbc_textFieldDestinationPath.insets = new Insets(0, 0, 5, 10);
        gbc_textFieldDestinationPath.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDestinationPath.gridx = 1;
        gbc_textFieldDestinationPath.gridy = 2;
        //textFieldSourcePath.setEditable(false);
        add(textFieldDestinationPath, gbc_textFieldDestinationPath);
        textFieldDestinationPath.setColumns(5);

        JButton btnBrowseDestinationPath = new JButton("Browse");
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
        gbc_btnBrowseDestinationPath.insets = new Insets(0, 0, 5, 10);
        gbc_btnBrowseDestinationPath.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnBrowseDestinationPath.gridx = 2;
        gbc_btnBrowseDestinationPath.gridy = 2;
        add(btnBrowseDestinationPath, gbc_btnBrowseDestinationPath);

        JLabel lblNewName = new JLabel("New name: ");
        GridBagConstraints gbc_lblNewName = new GridBagConstraints();
        gbc_lblNewName.anchor = GridBagConstraints.EAST;
        gbc_lblNewName.insets = new Insets(0, 10, 5, 5);
        gbc_lblNewName.gridx = 0;
        gbc_lblNewName.gridy = 3;
        add(lblNewName, gbc_lblNewName);

        textFieldNewName = new JTextField();
        GridBagConstraints gbc_textFieldNewName = new GridBagConstraints();
        gbc_textFieldNewName.insets = new Insets(0, 0, 5, 10);
        gbc_textFieldNewName.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNewName.gridx = 1;
        gbc_textFieldNewName.gridy = 3;
        add(textFieldNewName, gbc_textFieldNewName);
        textFieldNewName.setColumns(5);
    }
}
