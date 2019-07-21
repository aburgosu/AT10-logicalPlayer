/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.convert;

import com.fundation.logic.view.PanelSetter;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Implements convert audio criteria panel.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertAudioPanel extends JPanel {
    private JComboBox comboBoxNewFormat;
    private JComboBox comboBoxCodec;
    private JComboBox comboBoxBit;
    private JComboBox comboBoxChannel;
    private PanelSetter settingPanel;
    private JButton btnConvertAudio;

    /**
     * This constructor initializes the component.
     */
    public ConvertAudioPanel() {
        initComponent();
    }

    /**
     * This method initializes the convert audio panel.
     */
    public void initComponent() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        showAudioCriteriaConvertForm();
    }

    /**
     * This method show the form to set a convert criteria.
     */
    private void showAudioCriteriaConvertForm() {
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
        comboBoxCodec.setModel(new DefaultComboBoxModel(new String[]{"Default", "MP3", "WACPack", "AAC", "WMA",
            "Vorbis", "FLAC"}));
        GridBagConstraints gbc_comboBoxCodec = new GridBagConstraints();
        gbc_comboBoxCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCodec.gridx = 1;
        gbc_comboBoxCodec.gridy = 5;
        add(comboBoxCodec, gbc_comboBoxCodec);

        JLabel lblBit = new JLabel("Bitrate: ");
        GridBagConstraints gbc_lblBit = new GridBagConstraints();
        gbc_lblBit.anchor = GridBagConstraints.EAST;
        gbc_lblBit.insets = new Insets(0, 0, 5, 5);
        gbc_lblBit.gridx = 0;
        gbc_lblBit.gridy = 6;
        add(lblBit, gbc_lblBit);

        comboBoxBit = new JComboBox();
        comboBoxBit.setModel(new DefaultComboBoxModel(new String[]{"Default", "128000"}));
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

        btnConvertAudio = new JButton("Convert");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.EAST;
        gbc_btnSearch.gridwidth = 2;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 9;
        add(btnConvertAudio, gbc_btnSearch);
    }

    /**
     * Allows to get comboBoxNewFormat.
     * @return comboBoxNewFormat
     */
    public JComboBox getComboBoxNewFormat() {
        return comboBoxNewFormat;
    }

    /**
     * Allows to get comboBoxCodec.
     * @return comboBoxCodec
     */
    public JComboBox getComboBoxCodec() {
        return comboBoxCodec;
    }

    /**
     * Allows to get comboBoxBit.
     * @return comboBoxBit
     */
    public JComboBox getComboBoxBit() {
        return comboBoxBit;
    }

    /**
     * Allows to get comboBoxChannel.
     * @return comboBoxChannel
     */
    public JComboBox getComboBoxChannel() {
        return comboBoxChannel;
    }

    /**
     * Allows to get convertAudio button.
     * @return btnConvertAudio
     */
    public JButton getBtnConvertAudio() {
        return btnConvertAudio;
    }
}
