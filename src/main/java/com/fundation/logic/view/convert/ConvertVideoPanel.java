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

import com.fundation.logic.view.customElements.CustomPanelSecond;
import com.fundation.logic.view.customElements.CustomButton;
import com.fundation.logic.view.customElements.CustomCheckBox;
import com.fundation.logic.view.customElements.CustomLabel;
import com.fundation.logic.view.customElements.CustomComboBox;
import com.fundation.logic.view.PanelSetter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;

/**
 * Implements convert video form.
 *
 * @author Melissa Román, Maday Alcalá
 * @version 1.0
 */
public class ConvertVideoPanel extends CustomPanelSecond {
    private JComboBox comboBoxNewFormat;
    private JComboBox comboBoxAudioCodec;
    private JComboBox comboBoxAudioBit;
    private JComboBox comboBoxAudioChannel;
    private JComboBox comboBoxVideoCodec;
    private JComboBox comboBoxVideoBit;
    private JComboBox comboBoxVideoRate;
    private JComboBox comboBoxKeyFrameFormat;
    private JComboBox comboBoxThumbnailFormat;
    private JCheckBox checkBoxKeyFrame;
    private JCheckBox checkBoxThumbnail;
    private JSpinner minuteSpinnerKeyFrame;
    private JSpinner minuteSpinnerThumbnail;
    private PanelSetter settingPanel;
    private CustomButton btnConvertVideo;

    /**
     * This constructor initializes the component.
     */
    public ConvertVideoPanel() {
        initComponent();
    }

    /**
     * This method initializes the convert video form.
     */
    public void initComponent() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        videoCriteriaConvertPanel();
    }

    /**
     * This method shows the convert video form.
     */
    private void videoCriteriaConvertPanel() {
        JLabel lblNewFormat = new CustomLabel("New format:");
        GridBagConstraints gbc_lblNewFormat = new GridBagConstraints();
        gbc_lblNewFormat.anchor = GridBagConstraints.EAST;
        gbc_lblNewFormat.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewFormat.gridx = 1;
        gbc_lblNewFormat.gridy = 4;
        add(lblNewFormat, gbc_lblNewFormat);

        comboBoxNewFormat = new CustomComboBox();
        comboBoxNewFormat.setModel(new DefaultComboBoxModel(new String[]{"mp4", "avi", "mkv", "flv", "mov", "wmv"}));
        GridBagConstraints gbc_comboBoxNewFormat = new GridBagConstraints();
        gbc_comboBoxNewFormat.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxNewFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxNewFormat.gridx = 2;
        gbc_comboBoxNewFormat.gridy = 4;
        add(comboBoxNewFormat, gbc_comboBoxNewFormat);

        JLabel lblAudioCodec = new CustomLabel("Audio codec:");
        GridBagConstraints gbc_lblAudioCodec = new GridBagConstraints();
        gbc_lblAudioCodec.anchor = GridBagConstraints.EAST;
        gbc_lblAudioCodec.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioCodec.gridx = 1;
        gbc_lblAudioCodec.gridy = 5;
        add(lblAudioCodec, gbc_lblAudioCodec);

        comboBoxAudioCodec = new CustomComboBox();
        comboBoxAudioCodec.setModel(new DefaultComboBoxModel(new String[]{"Default", "mp3", "wacpack", "aac", "wma",
            "libvorbis", "FLAC"}));
        GridBagConstraints gbc_comboBoxAudioCodec = new GridBagConstraints();
        gbc_comboBoxAudioCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioCodec.gridx = 2;
        gbc_comboBoxAudioCodec.gridy = 5;
        add(comboBoxAudioCodec, gbc_comboBoxAudioCodec);

        JLabel lblAudioBit = new CustomLabel("Audio bitrate:");
        GridBagConstraints gbc_lblAudioBit = new GridBagConstraints();
        gbc_lblAudioBit.anchor = GridBagConstraints.EAST;
        gbc_lblAudioBit.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioBit.gridx = 1;
        gbc_lblAudioBit.gridy = 6;
        add(lblAudioBit, gbc_lblAudioBit);

        comboBoxAudioBit = new CustomComboBox();
        comboBoxAudioBit.setModel(new DefaultComboBoxModel(new String[]{"Default", "128000"}));
        GridBagConstraints gbc_comboBoxAudioBit = new GridBagConstraints();
        gbc_comboBoxAudioBit.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioBit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioBit.gridx = 2;
        gbc_comboBoxAudioBit.gridy = 6;
        add(comboBoxAudioBit, gbc_comboBoxAudioBit);

        JLabel lblAudioChannel = new CustomLabel("Audio channel:");
        GridBagConstraints gbc_lblAudioChannel = new GridBagConstraints();
        gbc_lblAudioChannel.anchor = GridBagConstraints.EAST;
        gbc_lblAudioChannel.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioChannel.gridx = 1;
        gbc_lblAudioChannel.gridy = 7;
        add(lblAudioChannel, gbc_lblAudioChannel);

        comboBoxAudioChannel = new CustomComboBox();
        comboBoxAudioChannel.setModel(new DefaultComboBoxModel(new String[]{"Default", "1", "2"}));
        GridBagConstraints gbc_comboBoxAudioChannel = new GridBagConstraints();
        gbc_comboBoxAudioChannel.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioChannel.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioChannel.gridx = 2;
        gbc_comboBoxAudioChannel.gridy = 7;
        add(comboBoxAudioChannel, gbc_comboBoxAudioChannel);

        JLabel lblVideoCodec = new CustomLabel("Video codec:");
        GridBagConstraints gbc_lblVideoCodec = new GridBagConstraints();
        gbc_lblVideoCodec.anchor = GridBagConstraints.EAST;
        gbc_lblVideoCodec.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoCodec.gridx = 1;
        gbc_lblVideoCodec.gridy = 9;
        add(lblVideoCodec, gbc_lblVideoCodec);

        comboBoxVideoCodec = new CustomComboBox();
        comboBoxVideoCodec.setModel(new DefaultComboBoxModel(new String[]{"Default", "xvid", "theora", "realvideo",
            "wmv", "mpeg1", "mpeg2", "mpeg4", "h264"}));
        GridBagConstraints gbc_comboBoxVideoCodec = new GridBagConstraints();
        gbc_comboBoxVideoCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoCodec.gridx = 2;
        gbc_comboBoxVideoCodec.gridy = 9;
        add(comboBoxVideoCodec, gbc_comboBoxVideoCodec);

        JLabel lblVideoBit = new CustomLabel("Video bitrate:");
        GridBagConstraints gbc_lblVideoBit = new GridBagConstraints();
        gbc_lblVideoBit.anchor = GridBagConstraints.EAST;
        gbc_lblVideoBit.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoBit.gridx = 1;
        gbc_lblVideoBit.gridy = 11;
        add(lblVideoBit, gbc_lblVideoBit);

        comboBoxVideoBit = new CustomComboBox();
        comboBoxVideoBit.setModel(new DefaultComboBoxModel(new String[]{"Default", "160000"}));
        GridBagConstraints gbc_comboBoxVideoBit = new GridBagConstraints();
        gbc_comboBoxVideoBit.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoBit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoBit.gridx = 2;
        gbc_comboBoxVideoBit.gridy = 11;
        add(comboBoxVideoBit, gbc_comboBoxVideoBit);

        JLabel lblFps = new CustomLabel("Frames per second:");
        GridBagConstraints gbc_lblFps = new GridBagConstraints();
        gbc_lblFps.anchor = GridBagConstraints.EAST;
        gbc_lblFps.insets = new Insets(0, 0, 5, 5);
        gbc_lblFps.gridx = 1;
        gbc_lblFps.gridy = 12;
        add(lblFps, gbc_lblFps);

        comboBoxVideoRate = new CustomComboBox();
        comboBoxVideoRate.setModel(new DefaultComboBoxModel(new String[]{"Default", "30"}));
        GridBagConstraints gbc_comboBoxVideoRate = new GridBagConstraints();
        gbc_comboBoxVideoRate.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoRate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoRate.gridx = 2;
        gbc_comboBoxVideoRate.gridy = 12;
        add(comboBoxVideoRate, gbc_comboBoxVideoRate);

        JLabel lblKeyFrame = new CustomLabel("Key frame:");
        GridBagConstraints gbc_lblKeyFrame = new GridBagConstraints();
        gbc_lblKeyFrame.anchor = GridBagConstraints.EAST;
        gbc_lblKeyFrame.insets = new Insets(0, 0, 5, 5);
        gbc_lblKeyFrame.gridx = 1;
        gbc_lblKeyFrame.gridy = 13;
        add(lblKeyFrame, gbc_lblKeyFrame);

        checkBoxKeyFrame = new CustomCheckBox("");
        GridBagConstraints gbc_checkBoxKeyFrame = new GridBagConstraints();
        gbc_checkBoxKeyFrame.anchor = GridBagConstraints.WEST;
        gbc_checkBoxKeyFrame.insets = new Insets(0, 0, 5, 5);
        gbc_checkBoxKeyFrame.gridx = 2;
        gbc_checkBoxKeyFrame.gridy = 13;
        add(checkBoxKeyFrame, gbc_checkBoxKeyFrame);

        JLabel lblFormatKeyframe = new JLabel("Format:");
        GridBagConstraints gbc_lblFormatKeyframe = new GridBagConstraints();
        gbc_lblFormatKeyframe.anchor = GridBagConstraints.EAST;
        gbc_lblFormatKeyframe.insets = new Insets(0, 0, 5, 5);
        gbc_lblFormatKeyframe.gridx = 2;
        gbc_lblFormatKeyframe.gridy = 13;
        add(lblFormatKeyframe, gbc_lblFormatKeyframe);

        comboBoxKeyFrameFormat = new JComboBox();
        comboBoxKeyFrameFormat.setModel(new DefaultComboBoxModel(new String[]{"png", "jpg", "tiff"}));
        GridBagConstraints gbc_comboBoxKeyFrameFormat = new GridBagConstraints();
        gbc_comboBoxKeyFrameFormat.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxKeyFrameFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxKeyFrameFormat.gridx = 3;
        gbc_comboBoxKeyFrameFormat.gridy = 13;
        add(comboBoxKeyFrameFormat, gbc_comboBoxKeyFrameFormat);

        JLabel lblEvery = new CustomLabel("Every:");
        GridBagConstraints gbc_lblEvery = new GridBagConstraints();
        gbc_lblEvery.anchor = GridBagConstraints.EAST;
        gbc_lblEvery.insets = new Insets(0, 0, 5, 5);
        gbc_lblEvery.gridx = 4;
        gbc_lblEvery.gridy = 13;
        add(lblEvery, gbc_lblEvery);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        SpinnerDateModel minuteSpinnerModelFrom = new SpinnerDateModel();
        minuteSpinnerModelFrom.setValue(calendar.getTime());
        minuteSpinnerKeyFrame = new JSpinner(minuteSpinnerModelFrom);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(minuteSpinnerKeyFrame, "mm:ss");
        dateEditor.getTextField().setEditable(false);
        minuteSpinnerKeyFrame.setEditor(dateEditor);
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.anchor = GridBagConstraints.WEST;
        gbc_spinner.gridx = 5;
        gbc_spinner.gridy = 13;
        add(minuteSpinnerKeyFrame, gbc_spinner);

        JLabel lblThumbnail = new CustomLabel("Thumbnail:");
        GridBagConstraints gbc_lblThumbnail = new GridBagConstraints();
        gbc_lblThumbnail.anchor = GridBagConstraints.EAST;
        gbc_lblThumbnail.insets = new Insets(0, 0, 5, 5);
        gbc_lblThumbnail.gridx = 1;
        gbc_lblThumbnail.gridy = 14;
        add(lblThumbnail, gbc_lblThumbnail);

        checkBoxThumbnail = new CustomCheckBox("");
        GridBagConstraints gbc_checkBoxThumbnail = new GridBagConstraints();
        gbc_checkBoxThumbnail.anchor = GridBagConstraints.WEST;
        gbc_checkBoxThumbnail.insets = new Insets(0, 0, 5, 5);
        gbc_checkBoxThumbnail.gridx = 2;
        gbc_checkBoxThumbnail.gridy = 14;
        add(checkBoxThumbnail, gbc_checkBoxThumbnail);

        JLabel lblThumbnailFormat = new JLabel("Format:");
        GridBagConstraints gbc_ThumbnailFormat = new GridBagConstraints();
        gbc_ThumbnailFormat.anchor = GridBagConstraints.EAST;
        gbc_ThumbnailFormat.insets = new Insets(0, 0, 5, 5);
        gbc_ThumbnailFormat.gridx = 2;
        gbc_ThumbnailFormat.gridy = 14;
        add(lblThumbnailFormat, gbc_ThumbnailFormat);

        comboBoxThumbnailFormat = new JComboBox();
        comboBoxThumbnailFormat.setModel(new DefaultComboBoxModel(new String[]{"bmp", "png", "jpg"}));
        GridBagConstraints gbc_comboBoxThumbnailFormat = new GridBagConstraints();
        gbc_comboBoxThumbnailFormat.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxThumbnailFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxThumbnailFormat.gridx = 3;
        gbc_comboBoxThumbnailFormat.gridy = 14;
        add(comboBoxThumbnailFormat, gbc_comboBoxThumbnailFormat);

        JLabel lblAt = new CustomLabel("At:");
        GridBagConstraints gbc_lblAt = new GridBagConstraints();
        gbc_lblAt.anchor = GridBagConstraints.EAST;
        gbc_lblAt.insets = new Insets(0, 0, 5, 5);
        gbc_lblAt.gridx = 4;
        gbc_lblAt.gridy = 14;
        add(lblAt, gbc_lblAt);

        SpinnerDateModel minuteSpinnerModelTo = new SpinnerDateModel();
        minuteSpinnerModelTo.setValue(calendar.getTime());
        minuteSpinnerThumbnail = new JSpinner(minuteSpinnerModelTo);
        JSpinner.DateEditor dateEditorTo = new JSpinner.DateEditor(minuteSpinnerThumbnail, "mm:ss");
        dateEditorTo.getTextField().setEditable(false);
        minuteSpinnerThumbnail.setEditor(dateEditorTo);
        GridBagConstraints gbc_minuteSpinnerTo = new GridBagConstraints();
        gbc_minuteSpinnerTo.anchor = GridBagConstraints.WEST;
        gbc_minuteSpinnerTo.gridx = 5;
        gbc_minuteSpinnerTo.gridy = 14;
        add(minuteSpinnerThumbnail, gbc_minuteSpinnerTo);

        btnConvertVideo = new CustomButton("Convert");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.CENTER;
        gbc_btnSearch.insets = new Insets(0,0,10,0);
        gbc_btnSearch.gridwidth = 6;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 17;
        add(btnConvertVideo, gbc_btnSearch);
    }

    /**
     * Allows to get comboBoxNewFormat.
     * @return comboBoxNewFormat
     */
    public JComboBox getComboBoxNewFormat() {
        return comboBoxNewFormat;
    }

    /**
     * Allows to get comboBoxAudioCodec.
     * @return comboBoxAudioCodec
     */
    public JComboBox getComboBoxAudioCodec() {
        return comboBoxAudioCodec;
    }

    /**
     * Allows to get comboBoxAudioBit.
     * @return comboBoxAudioBit
     */
    public JComboBox getComboBoxAudioBit() {
        return comboBoxAudioBit;
    }

    /**
     * Allows to get comboBoxAudioChannel.
     * @return comboBoxAudioChannel
     */
    public JComboBox getComboBoxAudioChannel() {
        return comboBoxAudioChannel;
    }

    /**
     * Allows to get comboBoxVideoCodec.
     * @return comboBoxVideoCodec
     */
    public JComboBox getComboBoxVideoCodec() {
        return comboBoxVideoCodec;
    }

    /**
     * Allows to get comboBoxVideoTag.
     * @return comboBoxVideoTag
     */

    public JComboBox getComboBoxVideoBit() {
        return comboBoxVideoBit;
    }

    /**
     * Allows to get comboBoxVideoRate.
     * @return comboBoxVideoRate
     */
    public JComboBox getComboBoxVideoRate() {
        return comboBoxVideoRate;
    }

    /**
     * Allows to get comboBoxKeyFrame.
     * @return checkBoxKeyFrame
     */
    public JCheckBox getCheckBoxKeyFrame() {
        return checkBoxKeyFrame;
    }

    /**
     * Allows to get comboBoxThumbnail.
     * @return checkBoxThumbnail
     */
    public JCheckBox getCheckBoxThumbnail() {
        return checkBoxThumbnail;
    }

    /**
     * Allows to get comboBoxKeyFrameFormat.
     * @return checkBoxKeyFrameFormat
     */
    public JComboBox getComboBoxKeyFrameFormat() {
        return comboBoxKeyFrameFormat;
    }

    /**
     * Allows to get comboBoxThumbnailFormat.
     * @return checkBoxThumbnailFormat
     */
    public JComboBox getComboBoxThumbnailFormat() {
        return comboBoxThumbnailFormat;
    }

    /**
     * Allows to get convert video button.
     * @return btnConvertVideo
     */
    public JButton getBtnConvertVideo() {
        return btnConvertVideo;
    }

    /**
     * Allows to get MinuteSpinnerKeyFrame .
     * @return MinuteSpinnerKeyFrame.
     */
    public JSpinner getMinuteSpinnerKeyFrame() {
        return minuteSpinnerKeyFrame;
    }

    /**
     * Allows to get MinuteSpinnerThumbnail.
     * @return MinuteSpinnerThumbnail.
     */
    public JSpinner getMinuteSpinnerThumbnail() {
        return minuteSpinnerThumbnail;
    }
}
