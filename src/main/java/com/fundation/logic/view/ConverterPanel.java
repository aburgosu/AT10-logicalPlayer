/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * Implements the Converter Panel
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class ConverterPanel extends JPanel {
    private JTextField textFieldSource;
    private JTextField textFieldDestain;

    /**
     * Create the panel.
     */
    public ConverterPanel(){
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblInput = new JLabel("Input");
        lblInput.setFont(new Font("Tahoma", Font.BOLD, 12));
        GridBagConstraints gbc_lblInput = new GridBagConstraints();
        gbc_lblInput.gridwidth = 3;
        gbc_lblInput.insets = new Insets(0, 0, 5, 0);
        gbc_lblInput.gridx = 0;
        gbc_lblInput.gridy = 0;
        add(lblInput, gbc_lblInput);

        JLabel lblSource = new JLabel("Source: ");
        GridBagConstraints gbc_lblSource = new GridBagConstraints();
        gbc_lblSource.anchor = GridBagConstraints.EAST;
        gbc_lblSource.insets = new Insets(0, 0, 5, 5);
        gbc_lblSource.gridx = 0;
        gbc_lblSource.gridy = 1;
        add(lblSource, gbc_lblSource);

        textFieldSource = new JTextField();
        GridBagConstraints gbc_textFieldSource = new GridBagConstraints();
        gbc_textFieldSource.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldSource.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSource.gridx = 1;
        gbc_textFieldSource.gridy = 1;
        add(textFieldSource, gbc_textFieldSource);
        textFieldSource.setColumns(10);

        JButton btnBrowseSource = new JButton("Browse");
        GridBagConstraints gbc_btnBrowseSource = new GridBagConstraints();
        gbc_btnBrowseSource.insets = new Insets(0, 0, 5, 0);
        gbc_btnBrowseSource.gridx = 2;
        gbc_btnBrowseSource.gridy = 1;
        add(btnBrowseSource, gbc_btnBrowseSource);

        JLabel labelOutput = new JLabel("Output");
        labelOutput.setFont(new Font("Tahoma", Font.BOLD, 12));
        GridBagConstraints gbc_labelOutput = new GridBagConstraints();
        gbc_labelOutput.insets = new Insets(0, 0, 5, 0);
        gbc_labelOutput.gridwidth = 3;
        gbc_labelOutput.gridx = 0;
        gbc_labelOutput.gridy = 2;
        add(labelOutput, gbc_labelOutput);

        JLabel lblDestain = new JLabel("Destain: ");
        GridBagConstraints gbc_lblDestain = new GridBagConstraints();
        gbc_lblDestain.anchor = GridBagConstraints.EAST;
        gbc_lblDestain.insets = new Insets(0, 0, 5, 5);
        gbc_lblDestain.gridx = 0;
        gbc_lblDestain.gridy = 3;
        add(lblDestain, gbc_lblDestain);

        textFieldDestain = new JTextField();
        GridBagConstraints gbc_textFieldDestain = new GridBagConstraints();
        gbc_textFieldDestain.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldDestain.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDestain.gridx = 1;
        gbc_textFieldDestain.gridy = 3;
        add(textFieldDestain, gbc_textFieldDestain);
        textFieldDestain.setColumns(10);

        JButton btnBrowse = new JButton("Browse");
        GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
        gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
        gbc_btnBrowse.gridx = 2;
        gbc_btnBrowse.gridy = 3;
        add(btnBrowse, gbc_btnBrowse);

        JLabel lblAudioCodec = new JLabel("Audio Codec: ");
        GridBagConstraints gbc_lblAudioCodec = new GridBagConstraints();
        gbc_lblAudioCodec.anchor = GridBagConstraints.EAST;
        gbc_lblAudioCodec.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioCodec.gridx = 0;
        gbc_lblAudioCodec.gridy = 4;
        add(lblAudioCodec, gbc_lblAudioCodec);

        JComboBox comboBoxAudioCodec = new JComboBox();
        GridBagConstraints gbc_comboBoxAudioCodec = new GridBagConstraints();
        gbc_comboBoxAudioCodec.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxAudioCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioCodec.gridx = 1;
        gbc_comboBoxAudioCodec.gridy = 4;
        add(comboBoxAudioCodec, gbc_comboBoxAudioCodec);

        JLabel lblAudioBitrate = new JLabel("Audio Bitrate: ");
        GridBagConstraints gbc_lblAudioBitrate = new GridBagConstraints();
        gbc_lblAudioBitrate.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioBitrate.gridx = 0;
        gbc_lblAudioBitrate.gridy = 5;
        add(lblAudioBitrate, gbc_lblAudioBitrate);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(0, 0, 128000, 100));
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.anchor = GridBagConstraints.EAST;
        gbc_spinner.insets = new Insets(0, 0, 5, 5);
        gbc_spinner.gridx = 1;
        gbc_spinner.gridy = 5;
        add(spinner, gbc_spinner);

        JLabel lblVideoCodec = new JLabel("Video Codec: ");
        GridBagConstraints gbc_lblVideoCodec = new GridBagConstraints();
        gbc_lblVideoCodec.anchor = GridBagConstraints.EAST;
        gbc_lblVideoCodec.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoCodec.gridx = 0;
        gbc_lblVideoCodec.gridy = 6;
        add(lblVideoCodec, gbc_lblVideoCodec);

        JComboBox comboBoxVideoCodec = new JComboBox();
        GridBagConstraints gbc_comboBoxVideoCodec = new GridBagConstraints();
        gbc_comboBoxVideoCodec.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxVideoCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoCodec.gridx = 1;
        gbc_comboBoxVideoCodec.gridy = 6;
        add(comboBoxVideoCodec, gbc_comboBoxVideoCodec);

        JLabel lblVideoBitrate = new JLabel("Video Bitrate: ");
        GridBagConstraints gbc_lblVideoBitrate = new GridBagConstraints();
        gbc_lblVideoBitrate.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoBitrate.gridx = 0;
        gbc_lblVideoBitrate.gridy = 7;
        add(lblVideoBitrate, gbc_lblVideoBitrate);

        JSpinner spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerNumberModel(0, 0, 128000, 100));
        GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
        gbc_spinner_1.anchor = GridBagConstraints.EAST;
        gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
        gbc_spinner_1.gridx = 1;
        gbc_spinner_1.gridy = 7;
        add(spinner_1, gbc_spinner_1);

        JLabel lblResolution = new JLabel("Resolution: ");
        GridBagConstraints gbc_lblResolution = new GridBagConstraints();
        gbc_lblResolution.anchor = GridBagConstraints.EAST;
        gbc_lblResolution.insets = new Insets(0, 0, 5, 5);
        gbc_lblResolution.gridx = 0;
        gbc_lblResolution.gridy = 8;
        add(lblResolution, gbc_lblResolution);

        JComboBox comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 8;
        add(comboBox, gbc_comboBox);

        JLabel lblFramerate = new JLabel("Framerate");
        GridBagConstraints gbc_lblFramerate = new GridBagConstraints();
        gbc_lblFramerate.anchor = GridBagConstraints.EAST;
        gbc_lblFramerate.insets = new Insets(0, 0, 5, 5);
        gbc_lblFramerate.gridx = 0;
        gbc_lblFramerate.gridy = 9;
        add(lblFramerate, gbc_lblFramerate);

        JSpinner spinner_2 = new JSpinner();
        spinner_2.setModel(new SpinnerNumberModel(0, 0, 2048, 10));
        GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
        gbc_spinner_2.anchor = GridBagConstraints.EAST;
        gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
        gbc_spinner_2.gridx = 1;
        gbc_spinner_2.gridy = 9;
        add(spinner_2, gbc_spinner_2);

        JButton btnConvert = new JButton("Convert");
        GridBagConstraints gbc_btnConvert = new GridBagConstraints();
        gbc_btnConvert.insets = new Insets(0, 0, 0, 5);
        gbc_btnConvert.gridx = 1;
        gbc_btnConvert.gridy = 10;
        add(btnConvert, gbc_btnConvert);
    }
}
