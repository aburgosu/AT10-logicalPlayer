package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdvancedImagePanel extends JPanel {
private JTextField textFieldPath;
private JTextField textFileName;
private JTextField textFieldFileType;
private JTextField textFieldWidth;
private JTextField textFieldHeight;
private JTextField textFieldColorSpaceData;
    public AdvancedImagePanel(){

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

        setLayout(gridBagLayout);

        JLabel lblImage = new JLabel("Image Advanced Search");
        lblImage.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_lblImage = new GridBagConstraints();
        gbc_lblImage.gridwidth = 2;
        gbc_lblImage.insets = new Insets(0, 0, 5, 0);
        gbc_lblImage.gridx = 0;
        gbc_lblImage.gridy = 3;
        add(lblImage, gbc_lblImage);

        JLabel lblPath = new JLabel("Path: ");
        GridBagConstraints gbc_lblPath = new GridBagConstraints();
        gbc_lblPath.anchor = GridBagConstraints.EAST;
        gbc_lblPath.insets = new Insets(0, 0, 5, 5);
        gbc_lblPath.gridx = 0;
        gbc_lblPath.gridy = 4;
        add(lblPath, gbc_lblPath);

        textFieldPath = new JTextField();
        GridBagConstraints gbc_textFieldPath = new GridBagConstraints();
        gbc_textFieldPath.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldPath.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldPath.gridx = 1;
        gbc_textFieldPath.gridy = 4;
        add(textFieldPath, gbc_textFieldPath);
        textFieldPath.setColumns(10);

        JButton btnBrowsePath = new JButton("Browse");
        btnBrowsePath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser folderChooser = new JFileChooser();
                folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = folderChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    textFieldPath.setText(folderChooser.getSelectedFile().getPath());
                }
            }
        });

//        GridBagConstraints cgbc_btnSearch = new GridBagConstraints();
//        cgbc_btnSearch.gridwidth = 2;
//        cgbc_btnSearch.gridx = 2;
//        cgbc_btnSearch.gridy = 4;
//        add(btnBrowsePath, cgbc_btnSearch);

        JLabel lblFileName = new JLabel("File Name: ");
        GridBagConstraints gbc_lblTittle = new GridBagConstraints();
        gbc_lblTittle.anchor = GridBagConstraints.EAST;
        gbc_lblTittle.insets = new Insets(0, 0, 5, 5);
        gbc_lblTittle.gridx = 0;
        gbc_lblTittle.gridy = 5;
        add(lblFileName, gbc_lblTittle);

        textFileName = new JTextField();
        GridBagConstraints gbc_textFieldTittle = new GridBagConstraints();
        gbc_textFieldTittle.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldTittle.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTittle.gridx = 1;
        gbc_textFieldTittle.gridy = 5;
        add(textFileName, gbc_textFieldTittle);
        textFileName.setColumns(10);


        JLabel lblFileType = new JLabel("Extension: ");
        GridBagConstraints gbc_lblFileType = new GridBagConstraints();
        gbc_lblFileType.anchor = GridBagConstraints.EAST;
        gbc_lblFileType.insets = new Insets(0, 0, 5, 5);
        gbc_lblFileType.gridx = 0;
        gbc_lblFileType.gridy = 6;
        add(lblFileType, gbc_lblFileType);

        textFieldFileType = new JTextField();
        GridBagConstraints textFiled_FileType = new GridBagConstraints();
        textFiled_FileType.insets = new Insets(0, 0, 5, 0);
        textFiled_FileType.fill = GridBagConstraints.HORIZONTAL;
        textFiled_FileType.gridx = 1;
        textFiled_FileType.gridy = 6;
        add(textFieldFileType, textFiled_FileType);


        JLabel lblWidth = new JLabel("Width: ");
        GridBagConstraints gbc_lblWidth = new GridBagConstraints();
        gbc_lblWidth.anchor = GridBagConstraints.EAST;
        gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
        gbc_lblWidth.gridx = 0;
        gbc_lblWidth.gridy = 7;
        add(lblWidth, gbc_lblWidth);

        textFieldWidth = new JTextField();
        GridBagConstraints gbc_textFieldWith = new GridBagConstraints();
        gbc_textFieldWith.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldWith.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldWith.gridx = 1;
        gbc_textFieldWith.gridy = 7;
        add(textFieldWidth, gbc_textFieldWith);
        textFieldWidth.setColumns(10);

        JLabel lblHeight = new JLabel("Height: ");
        GridBagConstraints gbc_lblHeight = new GridBagConstraints();
        gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
        gbc_lblHeight.anchor = GridBagConstraints.EAST;
        gbc_lblHeight.gridx = 0;
        gbc_lblHeight.gridy = 8;
        add(lblHeight, gbc_lblHeight);

        textFieldHeight = new JTextField();
        GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
        gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldWidth.gridx = 1;
        gbc_textFieldWidth.gridy = 8;
        add(textFieldHeight, gbc_textFieldWidth);
        textFieldHeight.setColumns(25);

        JLabel lblColorSpaceData = new JLabel("Color Space Data: ");
        GridBagConstraints gbc_ColorSpaceData = new GridBagConstraints();
        gbc_ColorSpaceData.anchor = GridBagConstraints.EAST;
        gbc_ColorSpaceData.insets = new Insets(0, 0, 5, 5);
        gbc_ColorSpaceData.gridx = 0;
        gbc_ColorSpaceData.gridy = 9;
        add(lblColorSpaceData, gbc_ColorSpaceData);

        textFieldColorSpaceData = new JTextField();
        GridBagConstraints gbc_textFielColorSpaceData = new GridBagConstraints();
        gbc_textFielColorSpaceData.insets = new Insets(0, 0, 5, 0);
        gbc_textFielColorSpaceData.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFielColorSpaceData.gridx = 1;
        gbc_textFielColorSpaceData.gridy = 9;
        add(textFieldColorSpaceData, gbc_textFielColorSpaceData);
        textFieldColorSpaceData.setColumns(10);

        JButton btnSearch = new JButton("Search");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.gridwidth = 2;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 10;
        add(btnSearch, gbc_btnSearch);
    }

    public JTextField getTextFieldPath() {
        return textFieldPath;
    }

    public void setTextFieldPath(JTextField textFieldPath) {
        this.textFieldPath = textFieldPath;
    }

    public JTextField getTextFileName() {
        return textFileName;
    }

    public void setTextFileName(JTextField textFileName) {
        this.textFileName = textFileName;
    }

    public JTextField getTextFieldFileType() {
        return textFieldFileType;
    }

    public void setTextFieldFileType(JTextField textFieldFileType) {
        this.textFieldFileType = textFieldFileType;
    }

    public JTextField getTextFieldWidth() {
        return textFieldWidth;
    }

    public void setTextFieldWidth(JTextField textFieldWidth) {
        this.textFieldWidth = textFieldWidth;
    }

    public JTextField getTextFieldHeight() {
        return textFieldHeight;
    }

    public void setTextFieldHeight(JTextField textFieldHeight) {
        this.textFieldHeight = textFieldHeight;
    }

    public JTextField getTextFieldColorSpaceData() {
        return textFieldColorSpaceData;
    }

    public void setTextFieldColorSpaceData(JTextField textFieldColorSpaceData) {
        this.textFieldColorSpaceData = textFieldColorSpaceData;
    }
}
