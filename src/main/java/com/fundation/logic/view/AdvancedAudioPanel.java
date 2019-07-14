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
 * This class allows you to display content related to the audio.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class AdvancedAudioPanel extends JPanel {
    private JTextField textFieldDurationSecond;
    private JButton btnSearchAdvanceAudio;
    private JComboBox comboBoxAudioCodecName;
    private JComboBox comboBoxAudioChannel;
    private JComboBox comboBoxAudioSampleRate;
    private JTextField textFieldDurationFirst;
    private SettingPanel settingPanel;

    /**
     * The constructor let initializer component.
     */
    public AdvancedAudioPanel() {
        initComponent();
    }

    /**
     * This method set the panel and show the content panel audio.
     */
    public void initComponent(){
        settingPanel = new SettingPanel();
        settingPanel.settingPanelAdvanceSearch(this);
        audioContentPanel();
    }

    /**
     * This method show the content audio panel.
     */
    private void audioContentPanel() {
        JLabel lblAudioCodecName = new JLabel("Codec Name: ");
        GridBagConstraints gbc_lblAudioCodecName = new GridBagConstraints();
        gbc_lblAudioCodecName.anchor = GridBagConstraints.EAST;
        gbc_lblAudioCodecName.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioCodecName.gridx = 0;
        gbc_lblAudioCodecName.gridy = 7;
        add(lblAudioCodecName, gbc_lblAudioCodecName);

        comboBoxAudioCodecName = new JComboBox();
        comboBoxAudioCodecName.setModel(new DefaultComboBoxModel(new String[]{"MPEG-4 ALS", "WAV", "MP3", "RTA"}));
        GridBagConstraints comboBox_AudioCodecName = new GridBagConstraints();
        comboBox_AudioCodecName.insets = new Insets(0, 0, 5, 0);
        comboBox_AudioCodecName.fill = GridBagConstraints.HORIZONTAL;
        comboBox_AudioCodecName.gridx = 1;
        comboBox_AudioCodecName.gridy = 7;
        add(comboBoxAudioCodecName, comboBox_AudioCodecName);

        JLabel lblAudioChanel = new JLabel("Channel: ");
        GridBagConstraints gbc_lblAudioChannel = new GridBagConstraints();
        gbc_lblAudioChannel.anchor = GridBagConstraints.EAST;
        gbc_lblAudioChannel.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioChannel.gridx = 0;
        gbc_lblAudioChannel.gridy = 8;
        add(lblAudioChanel, gbc_lblAudioChannel);

        comboBoxAudioChannel = new JComboBox();
        comboBoxAudioChannel.setModel(new DefaultComboBoxModel(new String[]{"0", "1.0","2.0", "2.1", "5.1", "6.1", "7.1","All"}));
        GridBagConstraints gbc_comboBoxAudioChannel = new GridBagConstraints();
        gbc_comboBoxAudioChannel.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioChannel.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioChannel.gridx = 1;
        gbc_comboBoxAudioChannel.gridy = 8;
        add(comboBoxAudioChannel, gbc_comboBoxAudioChannel);

        JLabel lblAudioSampleRate = new JLabel("Sample Rate: ");
        GridBagConstraints gbc_lblAudioSampleRate = new GridBagConstraints();
        gbc_lblAudioSampleRate.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioSampleRate.anchor = GridBagConstraints.EAST;
        gbc_lblAudioSampleRate.gridx = 0;
        gbc_lblAudioSampleRate.gridy = 9;
        add(lblAudioSampleRate, gbc_lblAudioSampleRate);

        comboBoxAudioSampleRate = new JComboBox();
        comboBoxAudioSampleRate.setModel(new DefaultComboBoxModel(new String[]{"8000 Hz", "11025 Hz","16000 Hz", "22050 Hz", "32000 Hz", "37800 Hz", "44056 Hz","47250 Hz","48000 Hz","50000 Hz","50400 Hz", "64000 Hz", "88200 Hz", "96000 Hz", "176400 Hz", "192000 Hz", "352800 Hz", "All"}));
        GridBagConstraints gbc_comboBoxAudioSampleRate = new GridBagConstraints();
        gbc_comboBoxAudioSampleRate.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioSampleRate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioSampleRate.gridx = 1;
        gbc_comboBoxAudioSampleRate.gridy = 9;
        add(comboBoxAudioSampleRate, gbc_comboBoxAudioSampleRate);

        JLabel lblDuration = new JLabel("Duration: ");
        GridBagConstraints gbc_lblDuration = new GridBagConstraints();
        gbc_lblDuration.anchor = GridBagConstraints.EAST;
        gbc_lblDuration.insets = new Insets(0, 0, 5, 5);
        gbc_lblDuration.gridx = 0;
        gbc_lblDuration.gridy = 10;
        add(lblDuration, gbc_lblDuration);

        textFieldDurationFirst = new JTextField();
        GridBagConstraints gbc_textFieldDurationFirst = new GridBagConstraints();
        gbc_textFieldDurationFirst.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldDurationFirst.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDurationFirst.gridx = 1;
        gbc_textFieldDurationFirst.gridy = 10;
        add(textFieldDurationFirst, gbc_textFieldDurationFirst);

        textFieldDurationSecond = new JTextField();
        GridBagConstraints gbc_textFieldDurationSecond = new GridBagConstraints();
        gbc_textFieldDurationSecond.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldDurationSecond.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDurationSecond.gridx = 1;
        gbc_textFieldDurationSecond.gridy = 11;
        add(textFieldDurationSecond, gbc_textFieldDurationSecond);

        btnSearchAdvanceAudio = new JButton("Search");
        GridBagConstraints gbc_btnSearchAdvanceAudio = new GridBagConstraints();
        gbc_btnSearchAdvanceAudio.gridwidth = 2;
        gbc_btnSearchAdvanceAudio.gridx = 1;
        gbc_btnSearchAdvanceAudio.gridy = 12;
        add(btnSearchAdvanceAudio, gbc_btnSearchAdvanceAudio);
    }

    /**
     * This method return the JButton related btnSearch Advance Audio.
     * @return btnSearchAdvanceAudio
     */
    public JButton getBtnSearchAdvanceAudio() {
        return btnSearchAdvanceAudio;
    }

    /**
     * This method return comboBoxAudioCodecName
     * @return comboBoxAudioCodecName
     */
    public JComboBox getComboBoxAudioCodecName() {
        return comboBoxAudioCodecName;
    }

    /**
     * This method return comboBoxAudioChannel
     * @return comboBoxAudioChannel
     */
    public JComboBox getComboBoxAudioChannel() {
        return comboBoxAudioChannel;
    }

    /**
     * This method return comboBoxAudioSampleRate
     * @return comboBoxAudioSampleRate
     */
    public JComboBox getComboBoxAudioSampleRate() {
        return comboBoxAudioSampleRate;
    }

    /**
     * This method return textFieldDurationFirst
     * @return textFieldDurationFirst
     */
    public JTextField getTextFieldDurationFirst() {
        return textFieldDurationFirst;
    }

    /**
     * This method return settingPanel.
     * @return settingPanel.
     */
    public SettingPanel getSettingPanel() {
        return settingPanel;
    }
}
