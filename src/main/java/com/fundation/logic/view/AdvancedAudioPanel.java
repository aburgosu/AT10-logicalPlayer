package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdvancedAudioPanel extends JPanel {
private JTextField textFieldPath;
private JTextField textFileName;
private JTextField textFieldAudioCodecName;
private JTextField textFieldAudioChannel;
private JTextField textFieldAudioSampleRate;
private JTextField textField;
    public AdvancedAudioPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

        setLayout(gridBagLayout);

        JLabel lblVideo = new JLabel("Audio Advanced Search");
        lblVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_lblVideo = new GridBagConstraints();
        gbc_lblVideo.gridwidth = 2;
        gbc_lblVideo.insets = new Insets(0, 0, 5, 0);
        gbc_lblVideo.gridx = 0;
        gbc_lblVideo.gridy = 3;
        add(lblVideo, gbc_lblVideo);

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

        JLabel lblAudioCodecName = new JLabel("Audio Codec Name: ");
        GridBagConstraints gbc_lblAudioCodecName = new GridBagConstraints();
        gbc_lblAudioCodecName.anchor = GridBagConstraints.EAST;
        gbc_lblAudioCodecName.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioCodecName.gridx = 0;
        gbc_lblAudioCodecName.gridy = 6;
        add(lblAudioCodecName, gbc_lblAudioCodecName);

        textFieldAudioCodecName = new JTextField();
        GridBagConstraints textFiled_AudioCodecName = new GridBagConstraints();
        textFiled_AudioCodecName.insets = new Insets(0, 0, 5, 0);
        textFiled_AudioCodecName.fill = GridBagConstraints.HORIZONTAL;
        textFiled_AudioCodecName.gridx = 1;
        textFiled_AudioCodecName.gridy = 6;
        add(textFieldAudioCodecName, textFiled_AudioCodecName);


        JLabel lblAudioChanel = new JLabel("Audio Channel: ");
        GridBagConstraints gbc_lblAudioChannel = new GridBagConstraints();
        gbc_lblAudioChannel.anchor = GridBagConstraints.EAST;
        gbc_lblAudioChannel.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioChannel.gridx = 0;
        gbc_lblAudioChannel.gridy = 7;
        add(lblAudioChanel, gbc_lblAudioChannel);

        textFieldAudioChannel = new JTextField();
        GridBagConstraints gbc_textFieldAudioChannel = new GridBagConstraints();
        gbc_textFieldAudioChannel.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldAudioChannel.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldAudioChannel.gridx = 1;
        gbc_textFieldAudioChannel.gridy = 7;
        add(textFieldAudioChannel, gbc_textFieldAudioChannel);
        textFieldAudioChannel.setColumns(10);

        JLabel lblAudioSampleRate = new JLabel("Audio Sample Rate: ");
        GridBagConstraints gbc_lblAudioSampleRate = new GridBagConstraints();
        gbc_lblAudioSampleRate.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioSampleRate.anchor = GridBagConstraints.EAST;
        gbc_lblAudioSampleRate.gridx = 0;
        gbc_lblAudioSampleRate.gridy = 8;
        add(lblAudioSampleRate, gbc_lblAudioSampleRate);

        textFieldAudioSampleRate = new JTextField();
        GridBagConstraints gbc_textFieldAudioSampleRate = new GridBagConstraints();
        gbc_textFieldAudioSampleRate.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldAudioSampleRate.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldAudioSampleRate.gridx = 1;
        gbc_textFieldAudioSampleRate.gridy = 8;
        add(textFieldAudioSampleRate, gbc_textFieldAudioSampleRate);
        textFieldAudioSampleRate.setColumns(25);

        JLabel lblDuration = new JLabel("Duration: ");
        GridBagConstraints gbc_lblDuration = new GridBagConstraints();
        gbc_lblDuration.anchor = GridBagConstraints.EAST;
        gbc_lblDuration.insets = new Insets(0, 0, 5, 5);
        gbc_lblDuration.gridx = 0;
        gbc_lblDuration.gridy = 9;
        add(lblDuration, gbc_lblDuration);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 9;
        add(textField, gbc_textField);
        textField.setColumns(10);

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

    public JTextField getTextFieldAudioCodecName() {
        return textFieldAudioCodecName;
    }

    public void setTextFieldAudioCodecName(JTextField textFieldAudioCodecName) {
        this.textFieldAudioCodecName = textFieldAudioCodecName;
    }

    public JTextField getTextFieldAudioChannel() {
        return textFieldAudioChannel;
    }

    public void setTextFieldAudioChannel(JTextField textFieldAudioChannel) {
        this.textFieldAudioChannel = textFieldAudioChannel;
    }

    public JTextField getTextFieldAudioSampleRate() {
        return textFieldAudioSampleRate;
    }

    public void setTextFieldAudioSampleRate(JTextField textFieldAudioSampleRate) {
        this.textFieldAudioSampleRate = textFieldAudioSampleRate;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }
}
