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
 * This class show the Advance image in a panel.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class ConvertVideoPanel extends JPanel {
    private JComboBox comboBoxNewFormat;
    private JComboBox comboBoxAudioCodec;
    private JComboBox comboBoxAudioBit;
    private JComboBox comboBoxAudioChannel;
    private JComboBox comboBoxAudioRate;
    private JComboBox comboBoxVideoCodec;
    private JComboBox comboBoxVideoTag;
    private JComboBox comboBoxVideoBit;
    private JComboBox comboBoxVideoRate;
    private SettingPanel settingPanel;
    private JButton btnConvertVideo;

    /**
     * This constructor initializer the component.
     */
    public ConvertVideoPanel() {
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
        comboBoxNewFormat.setModel(new DefaultComboBoxModel(new String[]{"MP4", "AVI", "MKV", "FLV", "MOV", "WMV"}));
        GridBagConstraints gbc_comboBoxNewFormat = new GridBagConstraints();
        gbc_comboBoxNewFormat.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxNewFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxNewFormat.gridx = 1;
        gbc_comboBoxNewFormat.gridy = 4;
        add(comboBoxNewFormat, gbc_comboBoxNewFormat);

        JLabel lblAudioCodec = new JLabel("Audio codec: ");
        GridBagConstraints gbc_lblAudioCodec = new GridBagConstraints();
        gbc_lblAudioCodec.anchor = GridBagConstraints.EAST;
        gbc_lblAudioCodec.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioCodec.gridx = 0;
        gbc_lblAudioCodec.gridy = 5;
        add(lblAudioCodec, gbc_lblAudioCodec);

        comboBoxAudioCodec = new JComboBox();
        comboBoxAudioCodec.setModel(new DefaultComboBoxModel(new String[]{"Default", "MP3", "WACPack", "AAC", "WMA", "Vorbis", "FLAC"}));
        GridBagConstraints gbc_comboBoxAudioCodec = new GridBagConstraints();
        gbc_comboBoxAudioCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioCodec.gridx = 1;
        gbc_comboBoxAudioCodec.gridy = 5;
        add(comboBoxAudioCodec, gbc_comboBoxAudioCodec);

        JLabel lblAudioBit = new JLabel("Audio bit: ");
        GridBagConstraints gbc_lblAudioBit = new GridBagConstraints();
        gbc_lblAudioBit.anchor = GridBagConstraints.EAST;
        gbc_lblAudioBit.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioBit.gridx = 0;
        gbc_lblAudioBit.gridy = 6;
        add(lblAudioBit, gbc_lblAudioBit);

        comboBoxAudioBit = new JComboBox();
        comboBoxAudioBit.setModel(new DefaultComboBoxModel(new String[]{"Default", "PNG", "JPG", "BMP", "TIF", "GIF"}));
        GridBagConstraints gbc_comboBoxAudioBit = new GridBagConstraints();
        gbc_comboBoxAudioBit.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioBit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioBit.gridx = 1;
        gbc_comboBoxAudioBit.gridy = 6;
        add(comboBoxAudioBit, gbc_comboBoxAudioBit);

        JLabel lblAudioChannel = new JLabel("Audio channel: ");
        GridBagConstraints gbc_lblAudioChannel = new GridBagConstraints();
        gbc_lblAudioChannel.anchor = GridBagConstraints.EAST;
        gbc_lblAudioChannel.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioChannel.gridx = 0;
        gbc_lblAudioChannel.gridy = 7;
        add(lblAudioChannel, gbc_lblAudioChannel);

        comboBoxAudioChannel = new JComboBox();
        comboBoxAudioChannel.setModel(new DefaultComboBoxModel(new String[]{"Default", "1", "2", "5.1", "7.1"}));
        GridBagConstraints gbc_comboBoxAudioChannel = new GridBagConstraints();
        gbc_comboBoxAudioChannel.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioChannel.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioChannel.gridx = 1;
        gbc_comboBoxAudioChannel.gridy = 7;
        add(comboBoxAudioChannel, gbc_comboBoxAudioChannel);

        JLabel lblAudioRate = new JLabel("Audio rate: ");
        GridBagConstraints gbc_lblAudioRate = new GridBagConstraints();
        gbc_lblAudioRate.anchor = GridBagConstraints.EAST;
        gbc_lblAudioRate.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioRate.gridx = 0;
        gbc_lblAudioRate.gridy = 8;
        add(lblAudioRate, gbc_lblAudioRate);

        comboBoxAudioRate = new JComboBox();
        comboBoxAudioRate.setModel(new DefaultComboBoxModel(new String[]{"Default", "PNG", "JPG", "BMP", "TIF", "GIF"}));
        GridBagConstraints gbc_comboBoxAudioRate = new GridBagConstraints();
        gbc_comboBoxAudioRate.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioRate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioRate.gridx = 1;
        gbc_comboBoxAudioRate.gridy = 8;
        add(comboBoxAudioRate, gbc_comboBoxAudioRate);

        JLabel lblVideoCodec = new JLabel("Video codec: ");
        GridBagConstraints gbc_lblVideoCodec = new GridBagConstraints();
        gbc_lblVideoCodec.anchor = GridBagConstraints.EAST;
        gbc_lblVideoCodec.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoCodec.gridx = 0;
        gbc_lblVideoCodec.gridy = 9;
        add(lblVideoCodec, gbc_lblVideoCodec);

        comboBoxVideoCodec = new JComboBox();
        comboBoxVideoCodec.setModel(new DefaultComboBoxModel(new String[]{"Default", "PNG", "JPG", "BMP", "TIF", "GIF"}));
        GridBagConstraints gbc_comboBoxVideoCodec = new GridBagConstraints();
        gbc_comboBoxVideoCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoCodec.gridx = 1;
        gbc_comboBoxVideoCodec.gridy = 9;
        add(comboBoxVideoCodec, gbc_comboBoxVideoCodec);

        JLabel lblVideoTag = new JLabel("Video tag: ");
        GridBagConstraints gbc_lblVideoTag = new GridBagConstraints();
        gbc_lblVideoTag.anchor = GridBagConstraints.EAST;
        gbc_lblVideoTag.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoTag.gridx = 0;
        gbc_lblVideoTag.gridy = 10;
        add(lblVideoTag, gbc_lblVideoTag);

        comboBoxVideoTag = new JComboBox();
        comboBoxVideoTag.setModel(new DefaultComboBoxModel(new String[]{"Default", "PNG", "JPG", "BMP", "TIF", "GIF"}));
        GridBagConstraints gbc_comboBoxVideoTag = new GridBagConstraints();
        gbc_comboBoxVideoTag.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoTag.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoTag.gridx = 1;
        gbc_comboBoxVideoTag.gridy = 10;
        add(comboBoxVideoTag, gbc_comboBoxVideoTag);

        JLabel lblVideoBit = new JLabel("Video bit: ");
        GridBagConstraints gbc_lblVideoBit = new GridBagConstraints();
        gbc_lblVideoBit.anchor = GridBagConstraints.EAST;
        gbc_lblVideoBit.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoBit.gridx = 0;
        gbc_lblVideoBit.gridy = 11;
        add(lblVideoBit, gbc_lblVideoBit);

        comboBoxVideoBit = new JComboBox();
        comboBoxVideoBit.setModel(new DefaultComboBoxModel(new String[]{"Default", "PNG", "JPG", "BMP", "TIF", "GIF"}));
        GridBagConstraints gbc_comboBoxVideoBit = new GridBagConstraints();
        gbc_comboBoxVideoBit.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoBit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoBit.gridx = 1;
        gbc_comboBoxVideoBit.gridy = 11;
        add(comboBoxVideoBit, gbc_comboBoxVideoBit);

        JLabel lblVideoRate = new JLabel("Video rate: ");
        GridBagConstraints gbc_lblVideoRate = new GridBagConstraints();
        gbc_lblVideoRate.anchor = GridBagConstraints.EAST;
        gbc_lblVideoRate.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoRate.gridx = 0;
        gbc_lblVideoRate.gridy = 12;
        add(lblVideoRate, gbc_lblVideoRate);

        comboBoxVideoRate = new JComboBox();
        comboBoxVideoRate.setModel(new DefaultComboBoxModel(new String[]{"Default", "PNG", "JPG", "BMP", "TIF", "GIF"}));
        GridBagConstraints gbc_comboBoxVideoRate = new GridBagConstraints();
        gbc_comboBoxVideoRate.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoRate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoRate.gridx = 1;
        gbc_comboBoxVideoRate.gridy = 12;
        add(comboBoxVideoRate, gbc_comboBoxVideoRate);

        btnConvertVideo = new JButton("Convert");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.EAST;
        gbc_btnSearch.gridwidth = 2;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 13;
        add(btnConvertVideo, gbc_btnSearch);
    }
}
