package com.fundation.logic.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdvancedVideoPanel extends JPanel {
    private JLabel lblVideo;

    private JComboBox comboBoxVideoCodec;
    private JTextField textFieldVideoBitrate;
    private JComboBox comboBoxVideoFramerate;
    private JTextField textFieldWidth;
    private JTextField textFieldHeight;
    private JTextField textField;
    private JTextField textFieldFileType;
    private JTextField textFileName;
    private JTextField textFieldPath;
    private JComboBox comboBoxAudioCodecName;

    /**
     * Initializes a SearchTabs instance for the search options
     */
    public AdvancedVideoPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        lblVideo = new JLabel("Video Advanced Search");
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

        JLabel lblExtension = new JLabel("File Extension: ");
        GridBagConstraints gbc_lblFileType = new GridBagConstraints();
        gbc_lblFileType.anchor = GridBagConstraints.EAST;
        gbc_lblFileType.insets = new Insets(0, 0, 5, 5);
        gbc_lblFileType.gridx = 0;
        gbc_lblFileType.gridy = 6;
        add(lblExtension, gbc_lblFileType);

        textFieldFileType = new JTextField();
        GridBagConstraints gbc_textFieldFileExtension = new GridBagConstraints();
        gbc_textFieldFileExtension.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldFileExtension.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldFileExtension.gridx = 1;
        gbc_textFieldFileExtension.gridy = 6;
        add(textFieldFileType, gbc_textFieldFileExtension);
        textFieldFileType.setColumns(10);

        JLabel lblCodecVideo = new JLabel("Codec Video: ");
        GridBagConstraints gbc_lblCodecVideo = new GridBagConstraints();
        gbc_lblCodecVideo.anchor = GridBagConstraints.EAST;
        gbc_lblCodecVideo.insets = new Insets(0, 0, 5, 5);
        gbc_lblCodecVideo.gridx = 0;
        gbc_lblCodecVideo.gridy = 7;
        add(lblCodecVideo, gbc_lblCodecVideo);

        comboBoxVideoCodec = new JComboBox();
        GridBagConstraints gbc_comboBoxVideoCodec = new GridBagConstraints();
        gbc_comboBoxVideoCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoCodec.gridx = 1;
        gbc_comboBoxVideoCodec.gridy = 7;
        add(comboBoxVideoCodec, gbc_comboBoxVideoCodec);

        JLabel lblAudioCodecName = new JLabel("Codec Audio: ");
        GridBagConstraints gbc_lblAudioCodecName = new GridBagConstraints();
        gbc_lblAudioCodecName.anchor = GridBagConstraints.EAST;
        gbc_lblAudioCodecName.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioCodecName.gridx = 0;
        gbc_lblAudioCodecName.gridy = 8;
        add(lblAudioCodecName, gbc_lblAudioCodecName);

        comboBoxAudioCodecName = new JComboBox();
        GridBagConstraints textFiled_AudioCodecName = new GridBagConstraints();
        textFiled_AudioCodecName.insets = new Insets(0, 0, 5, 5);
        textFiled_AudioCodecName.fill = GridBagConstraints.HORIZONTAL;
        textFiled_AudioCodecName.gridx = 1;
        textFiled_AudioCodecName.gridy = 8;
        add(comboBoxAudioCodecName, textFiled_AudioCodecName);

        JLabel lblBitrateVideo = new JLabel("Bitrate: ");
        GridBagConstraints gbc_lblBitrateVideo = new GridBagConstraints();
        gbc_lblBitrateVideo.anchor = GridBagConstraints.EAST;
        gbc_lblBitrateVideo.insets = new Insets(0, 0, 5, 5);
        gbc_lblBitrateVideo.gridx = 0;
        gbc_lblBitrateVideo.gridy = 9;
        add(lblBitrateVideo, gbc_lblBitrateVideo);

        textFieldVideoBitrate = new JTextField();
        GridBagConstraints gbc_textFieldVideoBitrate = new GridBagConstraints();
        gbc_textFieldVideoBitrate.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldVideoBitrate.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldVideoBitrate.gridx = 1;
        gbc_textFieldVideoBitrate.gridy = 9;
        add(textFieldVideoBitrate, gbc_textFieldVideoBitrate);
        textFieldVideoBitrate.setColumns(10);

        JLabel lblFramerate = new JLabel("Framerate: ");
        GridBagConstraints gbc_lblFramerate = new GridBagConstraints();
        gbc_lblFramerate.anchor = GridBagConstraints.EAST;
        gbc_lblFramerate.insets = new Insets(0, 0, 5, 5);
        gbc_lblFramerate.gridx = 0;
        gbc_lblFramerate.gridy = 10;
        add(lblFramerate, gbc_lblFramerate);


        comboBoxVideoFramerate = new JComboBox();
        comboBoxVideoFramerate.setModel(new DefaultComboBoxModel(new String[] {"21", "24", "29.9", "30", "60"}));
        GridBagConstraints gbc_comboBoxVideoFramerate = new GridBagConstraints();
        gbc_comboBoxVideoFramerate.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxVideoFramerate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoFramerate.gridx = 1;
        gbc_comboBoxVideoFramerate.gridy = 10;
        add(comboBoxVideoFramerate, gbc_comboBoxVideoFramerate);


        JLabel lblWidth = new JLabel("Width: ");
        GridBagConstraints gbc_lblWidth = new GridBagConstraints();
        gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
        gbc_lblWidth.anchor = GridBagConstraints.EAST;
        gbc_lblWidth.gridx = 0;
        gbc_lblWidth.gridy = 11;
        add(lblWidth, gbc_lblWidth);

        textFieldWidth = new JTextField();
        GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
        gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldWidth.gridx = 1;
        gbc_textFieldWidth.gridy = 11;
        add(textFieldWidth, gbc_textFieldWidth);
        textFieldWidth.setColumns(25);

        JLabel lblHeight = new JLabel("Height: ");
        GridBagConstraints gbc_lblHeight = new GridBagConstraints();
        gbc_lblHeight.anchor = GridBagConstraints.EAST;
        gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
        gbc_lblHeight.gridx = 0;
        gbc_lblHeight.gridy = 12;
        add(lblHeight, gbc_lblHeight);

        textFieldHeight = new JTextField();
        GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
        gbc_textFieldHeight.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldHeight.gridx = 1;
        gbc_textFieldHeight.gridy = 12;
        add(textFieldHeight, gbc_textFieldHeight);
        textFieldHeight.setColumns(10);

        JLabel lblDuration = new JLabel("Duration: ");
        GridBagConstraints gbc_lblDuration = new GridBagConstraints();
        gbc_lblDuration.anchor = GridBagConstraints.EAST;
        gbc_lblDuration.insets = new Insets(0, 0, 5, 5);
        gbc_lblDuration.gridx = 0;
        gbc_lblDuration.gridy = 13;
        add(lblDuration, gbc_lblDuration);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 13;
        add(textField, gbc_textField);
        textField.setColumns(10);


        JButton btnSearch = new JButton("Search");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.gridwidth = 2;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 14;
        add(btnSearch, gbc_btnSearch);
    }

    public JComboBox getComboBoxVideoCodec() {
        return comboBoxVideoCodec;
    }

    public void setComboBoxVideoCodec(JComboBox comboBoxVideoCodec) {
        this.comboBoxVideoCodec = comboBoxVideoCodec;
    }

    public JTextField getTextFieldVideoBitrate() {
        return textFieldVideoBitrate;
    }

    public void setTextFieldVideoBitrate(JTextField textFieldVideoBitrate) {
        this.textFieldVideoBitrate = textFieldVideoBitrate;
    }

    public JComboBox getComboBoxVideoFramerate() {
        return comboBoxVideoFramerate;
    }

    public void setComboBoxVideoFramerate(JComboBox comboBoxVideoFramerate) {
        this.comboBoxVideoFramerate = comboBoxVideoFramerate;
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

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JTextField getTextFieldFileType() {
        return textFieldFileType;
    }

    public void setTextFieldFileType(JTextField textFieldFileType) {
        this.textFieldFileType = textFieldFileType;
    }

    public JTextField getTextFileName() {
        return textFileName;
    }

    public void setTextFileName(JTextField textFileName) {
        this.textFileName = textFileName;
    }

    public JTextField getTextFieldPath() {
        return textFieldPath;
    }

    public void setTextFieldPath(JTextField textFieldPath) {
        this.textFieldPath = textFieldPath;
    }

    public JComboBox getComboBoxAudioCodecName() {
        return comboBoxAudioCodecName;
    }

    public void setComboBoxAudioCodecName(JComboBox comboBoxAudioCodecName) {
        this.comboBoxAudioCodecName = comboBoxAudioCodecName;
    }
}
