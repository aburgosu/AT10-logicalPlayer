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

import com.fundation.logic.view.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;

/**
 * This class show the content the advance video panel.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class AdvancedVideoPanel extends CustomPanelSecond {

    private PanelSetter settingPanel;
    private JComboBox comboBoxVideoCodec;
    private JComboBox comboBoxVideoFrameRate;
    private JComboBox comboBoxResolution;
    private JComboBox comboBoxAudioCodecName;
    private JSpinner minuteSpinner;
    private JSpinner minuteSpinnerTo;
    private CustomButton btnSearchAdvanceVideoPanel;
    private CustomButton btnSaveAdvanceVideo;

    /**
     * This constructor initializer the component.
     */
    public AdvancedVideoPanel() {
        initComponet();
    }

    /**
     * This method setting the panel and initializer the video content panel.
     */
    public void initComponet() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        videoContentPanel();
    }

    /**
     * This method show the content the panel.
     */
    private void videoContentPanel() {
        JLabel lblCodecVideo = new CustomLabel("Video codec:");
        GridBagConstraints gbc_lblCodecVideo = new GridBagConstraints();
        gbc_lblCodecVideo.anchor = GridBagConstraints.EAST;
        gbc_lblCodecVideo.insets = new Insets(0, 0, 5, 5);
        gbc_lblCodecVideo.gridx = 1;
        gbc_lblCodecVideo.gridy = 7;
        add(lblCodecVideo, gbc_lblCodecVideo);

        comboBoxVideoCodec = new CustomComboBox();
        comboBoxVideoCodec.setModel(new DefaultComboBoxModel(new String[]{"All", "MPEG-4", "WMV"}));
        GridBagConstraints gbc_comboBoxVideoCodec = new GridBagConstraints();
        gbc_comboBoxVideoCodec.gridwidth = 2;
        gbc_comboBoxVideoCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoCodec.gridx = 2;
        gbc_comboBoxVideoCodec.gridy = 7;
        add(comboBoxVideoCodec, gbc_comboBoxVideoCodec);

        JLabel lblAudioCodecName = new CustomLabel("Audio codec:");
        GridBagConstraints gbc_lblAudioCodecName = new GridBagConstraints();
        gbc_lblAudioCodecName.anchor = GridBagConstraints.EAST;
        gbc_lblAudioCodecName.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioCodecName.gridx = 1;
        gbc_lblAudioCodecName.gridy = 8;
        add(lblAudioCodecName, gbc_lblAudioCodecName);

        comboBoxAudioCodecName = new CustomComboBox();
        comboBoxAudioCodecName.setModel(new DefaultComboBoxModel(new String[]{"All", "MPEG", "WMA", "AAC"}));
        GridBagConstraints textFiled_AudioCodecName = new GridBagConstraints();
        textFiled_AudioCodecName.gridwidth = 2;
        textFiled_AudioCodecName.insets = new Insets(0, 0, 5, 0);
        textFiled_AudioCodecName.fill = GridBagConstraints.HORIZONTAL;
        textFiled_AudioCodecName.gridx = 2;
        textFiled_AudioCodecName.gridy = 8;
        add(comboBoxAudioCodecName, textFiled_AudioCodecName);

        JLabel lblFrameRate = new CustomLabel("Frame rate:");
        GridBagConstraints gbc_lblFrameRate = new GridBagConstraints();
        gbc_lblFrameRate.anchor = GridBagConstraints.EAST;
        gbc_lblFrameRate.insets = new Insets(0, 0, 5, 5);
        gbc_lblFrameRate.gridx = 1;
        gbc_lblFrameRate.gridy = 10;
        add(lblFrameRate, gbc_lblFrameRate);

        comboBoxVideoFrameRate = new CustomComboBox();
        comboBoxVideoFrameRate.setModel(new DefaultComboBoxModel(new String[]{"All", "21", "24", "30", "60"}));
        GridBagConstraints gbc_comboBoxVideoFrameRate = new GridBagConstraints();
        gbc_comboBoxVideoFrameRate.gridwidth = 2;
        gbc_comboBoxVideoFrameRate.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoFrameRate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoFrameRate.gridx = 2;
        gbc_comboBoxVideoFrameRate.gridy = 10;
        add(comboBoxVideoFrameRate, gbc_comboBoxVideoFrameRate);

        JLabel lblResolution = new CustomLabel("Resolution:");
        GridBagConstraints gbc_lblWidth = new GridBagConstraints();
        gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
        gbc_lblWidth.anchor = GridBagConstraints.EAST;
        gbc_lblWidth.gridx = 1;
        gbc_lblWidth.gridy = 11;
        add(lblResolution, gbc_lblWidth);

        comboBoxResolution = new CustomComboBox();
        comboBoxResolution.setModel(new DefaultComboBoxModel(new String[]{"All", "256x144", "426x144", "640x360",
            "1280x720", "1920x1080"}));
        GridBagConstraints gbc_comboBoxResolution = new GridBagConstraints();
        gbc_comboBoxResolution.gridwidth = 2;
        gbc_comboBoxResolution.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxResolution.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxResolution.gridx = 2;
        gbc_comboBoxResolution.gridy = 11;
        add(comboBoxResolution, gbc_comboBoxResolution);

        JLabel lblDuration = new CustomLabel("Duration:");
        GridBagConstraints gbc_lblDuration = new GridBagConstraints();
        gbc_lblDuration.anchor = GridBagConstraints.EAST;
        gbc_lblDuration.insets = new Insets(0, 0, 5, 5);
        gbc_lblDuration.gridx = 1;
        gbc_lblDuration.gridy = 12;
        add(lblDuration, gbc_lblDuration);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        SpinnerDateModel minuteSpinnerModelFrom = new SpinnerDateModel();
        minuteSpinnerModelFrom.setValue(calendar.getTime());
        minuteSpinner = new JSpinner(minuteSpinnerModelFrom);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(minuteSpinner, "00:mm:ss");
        dateEditor.getTextField().setEditable(false);
        minuteSpinner.setEditor(dateEditor);
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.anchor = GridBagConstraints.EAST;
        gbc_spinner.gridx = 2;
        gbc_spinner.gridy = 12;
        add(minuteSpinner, gbc_spinner);

        SpinnerDateModel minuteSpinnerModelTo = new SpinnerDateModel();
        minuteSpinnerModelTo.setValue(calendar.getTime());
        minuteSpinnerTo = new JSpinner(minuteSpinnerModelTo);
        JSpinner.DateEditor dateEditorTo = new JSpinner.DateEditor(minuteSpinnerTo, "00:mm:ss");
        dateEditorTo.getTextField().setEditable(false);
        minuteSpinnerTo.setEditor(dateEditorTo);
        GridBagConstraints gbc_minuteSpinnerTo = new GridBagConstraints();
        gbc_minuteSpinnerTo.anchor = GridBagConstraints.EAST;
        gbc_minuteSpinnerTo.gridx = 3;
        gbc_minuteSpinnerTo.gridy = 12;
        add(minuteSpinnerTo, gbc_minuteSpinnerTo);

        btnSearchAdvanceVideoPanel = new CustomButton("Search");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.insets = new Insets(5, 0, 10, 0);
        gbc_btnSearch.gridwidth = 6;
        gbc_btnSearch.anchor = GridBagConstraints.CENTER;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 17;
        add(btnSearchAdvanceVideoPanel, gbc_btnSearch);

        btnSaveAdvanceVideo = new CustomButton("Save");
        GridBagConstraints gbc_btnSaveAdvanceVideo = new GridBagConstraints();
        gbc_btnSaveAdvanceVideo.gridwidth = 6;
        gbc_btnSaveAdvanceVideo.anchor = GridBagConstraints.CENTER;
        gbc_btnSaveAdvanceVideo.insets = new Insets(0, 0, 10, 0);
        gbc_btnSaveAdvanceVideo.gridx = 4;
        gbc_btnSaveAdvanceVideo.gridy = 17;
        add(btnSaveAdvanceVideo, gbc_btnSaveAdvanceVideo);
    }

    /**
     * This method return comboBoxVideoCodec.
     * @return comboBoxVideoCodec
     */
    public JComboBox getComboBoxVideoCodec() {
        return comboBoxVideoCodec;
    }

    /**
     * This method return comboBoxVideoFrameRate.
     * @return comboBoxVideoFrameRate
     */
    public JComboBox getComboBoxVideoFrameRate() {
        return comboBoxVideoFrameRate;
    }

    /**
     * This method return comboBoxResolution.
     * @return comboBoxResolution.
     */
    public JComboBox getComboBoxResolution() {
        return comboBoxResolution;
    }

    /**
     * This method return comboBoxAudioCodecName.
     * @return comboBoxAudioCodecName
     */
    public JComboBox getComboBoxAudioCodecName() {
        return comboBoxAudioCodecName;
    }

    /**
     * This method return btnSearchAdvanceVideoPanel.
     * @return btnSearchAdvanceVideoPanel
     */
    public JButton getBtnSearchAdvanceVideoPanel() {
        return btnSearchAdvanceVideoPanel;
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
     * This method return the btnSaveAdvanceVideo button.
     */
    public CustomButton getbtnSaveAdvanceVideo() {
        return btnSaveAdvanceVideo;
    }
}
