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

/**
 * This class implements convert audio panel.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertAudioPanel extends JPanel {
    private JComboBox comboBoxNewFormat;
    private JComboBox comboBoxCodec;
    private JComboBox comboBoxBit;
    private JComboBox comboBoxChannel;
    private JComboBox comboBoxRate;
    private SettingPanel settingPanel;
    private JButton btnConvertAudio;

    /**
     * This constructor initializer the component.
     */
    public ConvertAudioPanel() {
        initComponent();
    }

    /**
     * This method initializer the set to the panel and content image panel.
     */
    public void initComponent() {
        settingPanel = new SettingPanel();
        settingPanel.setPanel(this);
        videoCriteriaConvertPanel();
    }

    /**
     * This method show the content panel.
     */
    private void videoCriteriaConvertPanel() {
        JLabel lblNewFormat = new JLabel("New format: ");
        GridBagConstraints gbc_lblNewFormat = new GridBagConstraints();
        gbc_lblNewFormat.anchor = GridBagConstraints.EAST;
        gbc_lblNewFormat.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewFormat.gridx = 0;
        gbc_lblNewFormat.gridy = 4;
        add(lblNewFormat, gbc_lblNewFormat);

        comboBoxNewFormat = new JComboBox();
        comboBoxNewFormat.setModel(new DefaultComboBoxModel(new String[]{"MP3", "WAV", "AIFF", "WMA", "FLAC"}));
        GridBagConstraints gbc_comboBoxNewFormat = new GridBagConstraints();
        gbc_comboBoxNewFormat.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxNewFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxNewFormat.gridx = 1;
        gbc_comboBoxNewFormat.gridy = 4;
        add(comboBoxNewFormat, gbc_comboBoxNewFormat);

        JLabel lblCodec = new JLabel("Codec: ");
        GridBagConstraints gbc_lblCodec = new GridBagConstraints();
        gbc_lblCodec.anchor = GridBagConstraints.EAST;
        gbc_lblCodec.insets = new Insets(0, 0, 5, 5);
        gbc_lblCodec.gridx = 0;
        gbc_lblCodec.gridy = 5;
        add(lblCodec, gbc_lblCodec);

        comboBoxCodec = new JComboBox();
        comboBoxCodec.setModel(new DefaultComboBoxModel(new String[]{"Default", "MP3", "WACPack", "AAC", "WMA", "Vorbis", "FLAC"}));
        GridBagConstraints gbc_comboBoxCodec = new GridBagConstraints();
        gbc_comboBoxCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCodec.gridx = 1;
        gbc_comboBoxCodec.gridy = 5;
        add(comboBoxCodec, gbc_comboBoxCodec);

        JLabel lblBit = new JLabel("Bit: ");
        GridBagConstraints gbc_lblBit = new GridBagConstraints();
        gbc_lblBit.anchor = GridBagConstraints.EAST;
        gbc_lblBit.insets = new Insets(0, 0, 5, 5);
        gbc_lblBit.gridx = 0;
        gbc_lblBit.gridy = 6;
        add(lblBit, gbc_lblBit);

        comboBoxBit = new JComboBox();
        comboBoxBit.setModel(new DefaultComboBoxModel(new String[]{"Default", "PNG", "JPG", "BMP", "TIF", "GIF"}));
        GridBagConstraints gbc_comboBoxBit = new GridBagConstraints();
        gbc_comboBoxBit.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxBit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxBit.gridx = 1;
        gbc_comboBoxBit.gridy = 6;
        add(comboBoxBit, gbc_comboBoxBit);

        JLabel lblChannel = new JLabel("Channel: ");
        GridBagConstraints gbc_lblChannel = new GridBagConstraints();
        gbc_lblChannel.anchor = GridBagConstraints.EAST;
        gbc_lblChannel.insets = new Insets(0, 0, 5, 5);
        gbc_lblChannel.gridx = 0;
        gbc_lblChannel.gridy = 7;
        add(lblChannel, gbc_lblChannel);

        comboBoxChannel = new JComboBox();
        comboBoxChannel.setModel(new DefaultComboBoxModel(new String[]{"Default", "1", "2", "5.1", "7.1"}));
        GridBagConstraints gbc_comboBoxChannel = new GridBagConstraints();
        gbc_comboBoxChannel.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxChannel.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxChannel.gridx = 1;
        gbc_comboBoxChannel.gridy = 7;
        add(comboBoxChannel, gbc_comboBoxChannel);

        JLabel lblRate = new JLabel("Rate: ");
        GridBagConstraints gbc_lblRate = new GridBagConstraints();
        gbc_lblRate.anchor = GridBagConstraints.EAST;
        gbc_lblRate.insets = new Insets(0, 0, 5, 5);
        gbc_lblRate.gridx = 0;
        gbc_lblRate.gridy = 8;
        add(lblRate, gbc_lblRate);

        comboBoxRate = new JComboBox();
        comboBoxRate.setModel(new DefaultComboBoxModel(new String[]{"Default", "16000", "22050", "24000", "32000", "44100", "48000"}));
        GridBagConstraints gbc_comboBoxRate = new GridBagConstraints();
        gbc_comboBoxRate.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxRate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxRate.gridx = 1;
        gbc_comboBoxRate.gridy = 8;
        add(comboBoxRate, gbc_comboBoxRate);

        btnConvertAudio = new JButton("Convert");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.EAST;
        gbc_btnSearch.gridwidth = 2;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 9;
        add(btnConvertAudio, gbc_btnSearch);
    }
}
