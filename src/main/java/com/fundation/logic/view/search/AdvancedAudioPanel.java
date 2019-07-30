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

import com.fundation.logic.view.customElements.CustomPanelSecond;
import com.fundation.logic.view.customElements.CustomButton;
import com.fundation.logic.view.PanelSetter;
import com.fundation.logic.view.customElements.CustomLabel;
import com.fundation.logic.view.customElements.CustomComboBox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;

/**
 * This class allows you to display content related to the audio.
 *
 * @author Jesus Menacho, Melissa Román
 * @version 1.0
 */
public class AdvancedAudioPanel extends CustomPanelSecond {
    private CustomButton btnSearchAdvanceAudio;
    private CustomButton btnSaveAdvanceAudio;
    private CustomComboBox comboBoxAudioCodecName;
    private CustomComboBox comboBoxAudioChannel;
    private CustomComboBox comboBoxAudioSampleRate;
    private JSpinner minuteSpinner;
    private JSpinner minuteSpinnerTo;
    private PanelSetter settingPanel;

    /**
     * The constructor let initializer component.
     */
    public AdvancedAudioPanel() {
        initComponent();
    }

    /**
     * This method set the panel and show the content panel audio.
     */
    public void initComponent() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        audioContentPanel();
    }

    /**
     * This method show the content audio panel.
     */
    private void audioContentPanel() {
        CustomLabel lblAudioCodecName = new CustomLabel("Codec:");
        GridBagConstraints gbc_lblAudioCodecName = new GridBagConstraints();
        gbc_lblAudioCodecName.anchor = GridBagConstraints.EAST;
        gbc_lblAudioCodecName.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioCodecName.gridx = 1;
        gbc_lblAudioCodecName.gridy = 7;
        add(lblAudioCodecName, gbc_lblAudioCodecName);

        comboBoxAudioCodecName = new CustomComboBox();
        comboBoxAudioCodecName.setModel(new DefaultComboBoxModel(new String[]{"All", "MPEG-4 ALS", "WAV", "MP3",
            "RTA"}));
        GridBagConstraints comboBox_AudioCodecName = new GridBagConstraints();
        comboBox_AudioCodecName.gridwidth = 2;
        comboBox_AudioCodecName.insets = new Insets(0, 0, 5, 0);
        comboBox_AudioCodecName.fill = GridBagConstraints.HORIZONTAL;
        comboBox_AudioCodecName.gridx = 2;
        comboBox_AudioCodecName.gridy = 7;
        add(comboBoxAudioCodecName, comboBox_AudioCodecName);

        CustomLabel lblAudioChanel = new CustomLabel("Channel:");
        GridBagConstraints gbc_lblAudioChannel = new GridBagConstraints();
        gbc_lblAudioChannel.anchor = GridBagConstraints.EAST;
        gbc_lblAudioChannel.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioChannel.gridx = 1;
        gbc_lblAudioChannel.gridy = 8;
        add(lblAudioChanel, gbc_lblAudioChannel);

        comboBoxAudioChannel = new CustomComboBox();
        comboBoxAudioChannel.setModel(new DefaultComboBoxModel(new String[]{"All", "0", "1.0", "2.0", "2.1", "5.1",
            "6.1", "7.1"}));
        GridBagConstraints gbc_comboBoxAudioChannel = new GridBagConstraints();
        gbc_comboBoxAudioChannel.gridwidth = 2;
        gbc_comboBoxAudioChannel.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioChannel.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioChannel.gridx = 2;
        gbc_comboBoxAudioChannel.gridy = 8;
        add(comboBoxAudioChannel, gbc_comboBoxAudioChannel);

        CustomLabel lblAudioSampleRate = new CustomLabel("Sample rate:");
        GridBagConstraints gbc_lblAudioSampleRate = new GridBagConstraints();
        gbc_lblAudioSampleRate.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioSampleRate.anchor = GridBagConstraints.EAST;
        gbc_lblAudioSampleRate.gridx = 1;
        gbc_lblAudioSampleRate.gridy = 9;
        add(lblAudioSampleRate, gbc_lblAudioSampleRate);

        comboBoxAudioSampleRate = new CustomComboBox();
        comboBoxAudioSampleRate.setModel(new DefaultComboBoxModel(new String[]{"All", "8000 Hz", "11025 Hz", "16000 Hz",
            "22050 Hz", "32000 Hz", "37800 Hz", "44100 Hz", "47250 Hz", "48000 Hz", "50000 Hz", "50400 Hz", "64000 Hz",
            "88200 Hz", "96000 Hz", "176400 Hz", "192000 Hz", "352800 Hz"}));
        GridBagConstraints gbc_comboBoxAudioSampleRate = new GridBagConstraints();
        gbc_comboBoxAudioSampleRate.gridwidth = 2;
        gbc_comboBoxAudioSampleRate.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioSampleRate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioSampleRate.gridx = 2;
        gbc_comboBoxAudioSampleRate.gridy = 9;
        add(comboBoxAudioSampleRate, gbc_comboBoxAudioSampleRate);

        CustomLabel lblDuration = new CustomLabel("Duration:");
        GridBagConstraints gbc_lblDuration = new GridBagConstraints();
        gbc_lblDuration.anchor = GridBagConstraints.EAST;
        gbc_lblDuration.insets = new Insets(0, 0, 5, 5);
        gbc_lblDuration.gridx = 1;
        gbc_lblDuration.gridy = 10;
        add(lblDuration, gbc_lblDuration);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        SpinnerDateModel minuteSpinnerModelFrom = new SpinnerDateModel();
        minuteSpinnerModelFrom.setValue(calendar.getTime());
        minuteSpinner = new JSpinner(minuteSpinnerModelFrom);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(minuteSpinner, "HH:mm:ss");
        dateEditor.getTextField().setEditable(false);
        minuteSpinner.setEditor(dateEditor);
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.anchor = GridBagConstraints.EAST;
        gbc_spinner.gridx = 2;
        gbc_spinner.gridy = 10;
        add(minuteSpinner, gbc_spinner);

        SpinnerDateModel minuteSpinnerModelTo = new SpinnerDateModel();
        minuteSpinnerModelTo.setValue(calendar.getTime());
        minuteSpinnerTo = new JSpinner(minuteSpinnerModelTo);
        JSpinner.DateEditor dateEditorTo = new JSpinner.DateEditor(minuteSpinnerTo, "HH:mm:ss");
        dateEditorTo.getTextField().setEditable(false);
        minuteSpinnerTo.setEditor(dateEditorTo);
        GridBagConstraints gbc_minuteSpinnerTo = new GridBagConstraints();
        gbc_minuteSpinnerTo.anchor = GridBagConstraints.EAST;
        gbc_minuteSpinnerTo.gridx = 3;
        gbc_minuteSpinnerTo.gridy = 10;
        add(minuteSpinnerTo, gbc_minuteSpinnerTo);

        btnSearchAdvanceAudio = new CustomButton("Search");
        GridBagConstraints gbc_btnSearchAdvanceAudio = new GridBagConstraints();
        gbc_btnSearchAdvanceAudio.gridwidth = 6;
        gbc_btnSearchAdvanceAudio.anchor = GridBagConstraints.CENTER;
        gbc_btnSearchAdvanceAudio.insets = new Insets(0, 0, 10, 0);
        gbc_btnSearchAdvanceAudio.gridx = 0;
        gbc_btnSearchAdvanceAudio.gridy = 17;
        add(btnSearchAdvanceAudio, gbc_btnSearchAdvanceAudio);

        btnSaveAdvanceAudio = new CustomButton("Save");
        GridBagConstraints gbc_btnSaveAdvanceAudio = new GridBagConstraints();
        gbc_btnSaveAdvanceAudio.gridwidth = 6;
        gbc_btnSaveAdvanceAudio.anchor = GridBagConstraints.CENTER;
        gbc_btnSaveAdvanceAudio.insets = new Insets(0, 0, 10, 0);
        gbc_btnSaveAdvanceAudio.gridx = 4;
        gbc_btnSaveAdvanceAudio.gridy = 17;
        add(btnSaveAdvanceAudio, gbc_btnSaveAdvanceAudio);
    }

    /**
     * This method return the JButton related btnSearch Advance Audio.
     * @return btnSearchAdvanceAudio
     */
    public CustomButton getBtnSearchAdvanceAudio() {
        return btnSearchAdvanceAudio;
    }

    /**
     * This method return comboBoxAudioCodecName.
     * @return comboBoxAudioCodecName
     */
    public CustomComboBox getComboBoxAudioCodecName() {
        return comboBoxAudioCodecName;
    }

    /**
     * This method return comboBoxAudioChannel.
     * @return comboBoxAudioChannel
     */
    public CustomComboBox getComboBoxAudioChannel() {
        return comboBoxAudioChannel;
    }

    /**
     * This method return comboBoxAudioSampleRate.
     * @return comboBoxAudioSampleRate
     */
    public CustomComboBox getComboBoxAudioSampleRate() {
        return comboBoxAudioSampleRate;
    }

    /**
     * Allows to get minuteSpinner.
     * @return minuteSpinner value
     */
    public String getMinuteSpinner() {
        return minuteSpinner.getValue().toString();
    }

    /**
     * Allows to get minuteSpinnerTo.
     * @return minuteSpinnerTo value
     */
    public String getMinuteSpinnerTo() {
        return minuteSpinnerTo.getValue().toString();
    }

    /**
     * This method return the btnSaveAdvanceAudio button.
     */
    public CustomButton getbtnSaveAdvanceAudio() {
        return btnSaveAdvanceAudio;
    }

}
