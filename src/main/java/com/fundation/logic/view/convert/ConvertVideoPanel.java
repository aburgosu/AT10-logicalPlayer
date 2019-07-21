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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;

/**
 * Implements convert video form.
 *
 * @author Melissa Román
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
    private JCheckBox checkBoxKeyFrame;
    private JCheckBox checkBoxThumbnail;
    private JSpinner minuteSpinnerKeyFrame;
    private JSpinner minuteSpinnerThumbnail;
    private PanelSetter settingPanel;
    private JButton btnConvertVideo;

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
        comboBoxAudioCodec.setModel(new DefaultComboBoxModel(new String[]{"Default", "MP3", "WACPack", "AAC", "WMA",
            "Vorbis", "FLAC"}));
        GridBagConstraints gbc_comboBoxAudioCodec = new GridBagConstraints();
        gbc_comboBoxAudioCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioCodec.gridx = 1;
        gbc_comboBoxAudioCodec.gridy = 5;
        add(comboBoxAudioCodec, gbc_comboBoxAudioCodec);

        JLabel lblAudioBit = new JLabel("Audio bit rate: ");
        GridBagConstraints gbc_lblAudioBit = new GridBagConstraints();
        gbc_lblAudioBit.anchor = GridBagConstraints.EAST;
        gbc_lblAudioBit.insets = new Insets(0, 0, 5, 5);
        gbc_lblAudioBit.gridx = 0;
        gbc_lblAudioBit.gridy = 6;
        add(lblAudioBit, gbc_lblAudioBit);

        comboBoxAudioBit = new JComboBox();
        comboBoxAudioBit.setModel(new DefaultComboBoxModel(new String[]{"Default", "128000"}));
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

        JLabel lblVideoCodec = new JLabel("Video codec: ");
        GridBagConstraints gbc_lblVideoCodec = new GridBagConstraints();
        gbc_lblVideoCodec.anchor = GridBagConstraints.EAST;
        gbc_lblVideoCodec.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoCodec.gridx = 0;
        gbc_lblVideoCodec.gridy = 9;
        add(lblVideoCodec, gbc_lblVideoCodec);

        comboBoxVideoCodec = new JComboBox();
        comboBoxVideoCodec.setModel(new DefaultComboBoxModel(new String[]{"Default", "Xvid", "Theora", "RealViedo",
            "WMV", "MPEG-1", "MPEG-2", "MPEG-4", "H264"}));
        GridBagConstraints gbc_comboBoxVideoCodec = new GridBagConstraints();
        gbc_comboBoxVideoCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoCodec.gridx = 1;
        gbc_comboBoxVideoCodec.gridy = 9;
        add(comboBoxVideoCodec, gbc_comboBoxVideoCodec);

        JLabel lblVideoBit = new JLabel("Video bitrate: ");
        GridBagConstraints gbc_lblVideoBit = new GridBagConstraints();
        gbc_lblVideoBit.anchor = GridBagConstraints.EAST;
        gbc_lblVideoBit.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoBit.gridx = 0;
        gbc_lblVideoBit.gridy = 11;
        add(lblVideoBit, gbc_lblVideoBit);

        comboBoxVideoBit = new JComboBox();
        comboBoxVideoBit.setModel(new DefaultComboBoxModel(new String[]{"Default", "500000 bps"}));
        GridBagConstraints gbc_comboBoxVideoBit = new GridBagConstraints();
        gbc_comboBoxVideoBit.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoBit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoBit.gridx = 1;
        gbc_comboBoxVideoBit.gridy = 11;
        add(comboBoxVideoBit, gbc_comboBoxVideoBit);

        JLabel lblVideoRate = new JLabel("Frames per second: ");
        GridBagConstraints gbc_lblVideoRate = new GridBagConstraints();
        gbc_lblVideoRate.anchor = GridBagConstraints.EAST;
        gbc_lblVideoRate.insets = new Insets(0, 0, 5, 5);
        gbc_lblVideoRate.gridx = 0;
        gbc_lblVideoRate.gridy = 12;
        add(lblVideoRate, gbc_lblVideoRate);

        comboBoxVideoRate = new JComboBox();
        comboBoxVideoRate.setModel(new DefaultComboBoxModel(new String[]{"Default", "30"}));
        GridBagConstraints gbc_comboBoxVideoRate = new GridBagConstraints();
        gbc_comboBoxVideoRate.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoRate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoRate.gridx = 1;
        gbc_comboBoxVideoRate.gridy = 12;
        add(comboBoxVideoRate, gbc_comboBoxVideoRate);

        JLabel lblKeyFrame = new JLabel("Key frame: ");
        GridBagConstraints gbc_lblKeyFrame = new GridBagConstraints();
        gbc_lblKeyFrame.anchor = GridBagConstraints.EAST;
        gbc_lblKeyFrame.insets = new Insets(0, 0, 5, 5);
        gbc_lblKeyFrame.gridx = 0;//0
        gbc_lblKeyFrame.gridy = 13;
        add(lblKeyFrame, gbc_lblKeyFrame);

        checkBoxKeyFrame = new JCheckBox("");
        GridBagConstraints gbc_checkBoxKeyFrame = new GridBagConstraints();
        gbc_checkBoxKeyFrame.anchor = GridBagConstraints.WEST;
        gbc_checkBoxKeyFrame.insets = new Insets(0, 0, 5, 5);
        gbc_checkBoxKeyFrame.gridx = 1;//1
        gbc_checkBoxKeyFrame.gridy = 13;
        add(checkBoxKeyFrame, gbc_checkBoxKeyFrame);

        JLabel lblEvery = new JLabel("Every: ");
        GridBagConstraints gbc_lblEvery = new GridBagConstraints();
        gbc_lblEvery.anchor = GridBagConstraints.EAST;
        gbc_lblEvery.insets = new Insets(0, 0, 5, 5);
        gbc_lblEvery.gridx = 2;//0
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
        gbc_spinner.anchor = GridBagConstraints.EAST;
        gbc_spinner.gridx = 3;//0
        gbc_spinner.gridy = 13;
        add(minuteSpinnerKeyFrame, gbc_spinner);

        JLabel lblThumbnail = new JLabel("Thumbnail: ");
        GridBagConstraints gbc_lblThumbnail = new GridBagConstraints();
        gbc_lblThumbnail.anchor = GridBagConstraints.EAST;
        gbc_lblThumbnail.insets = new Insets(0, 0, 5, 5);
        gbc_lblThumbnail.gridx = 0;
        gbc_lblThumbnail.gridy = 14;
        add(lblThumbnail, gbc_lblThumbnail);

        checkBoxThumbnail = new JCheckBox("");
        GridBagConstraints gbc_checkBoxThumbnail = new GridBagConstraints();
        gbc_checkBoxThumbnail.anchor = GridBagConstraints.WEST;
        gbc_checkBoxThumbnail.insets = new Insets(0, 0, 5, 5);
        gbc_checkBoxThumbnail.gridx = 1;
        gbc_checkBoxThumbnail.gridy = 14;
        add(checkBoxThumbnail, gbc_checkBoxThumbnail);

        JLabel lblAt = new JLabel("At: ");
        GridBagConstraints gbc_lblAt = new GridBagConstraints();
        gbc_lblAt.anchor = GridBagConstraints.EAST;
        gbc_lblAt.insets = new Insets(0, 0, 5, 5);
        gbc_lblAt.gridx = 2;//0
        gbc_lblAt.gridy = 14;
        add(lblAt, gbc_lblAt);

        SpinnerDateModel minuteSpinnerModelTo = new SpinnerDateModel();
        minuteSpinnerModelTo.setValue(calendar.getTime());
        minuteSpinnerThumbnail = new JSpinner(minuteSpinnerModelTo);
        JSpinner.DateEditor dateEditorTo = new JSpinner.DateEditor(minuteSpinnerThumbnail, "mm:ss");
        dateEditorTo.getTextField().setEditable(false);
        minuteSpinnerThumbnail.setEditor(dateEditorTo);
        GridBagConstraints gbc_minuteSpinnerTo = new GridBagConstraints();
        gbc_minuteSpinnerTo.anchor = GridBagConstraints.EAST;
        gbc_minuteSpinnerTo.gridx = 3;
        gbc_minuteSpinnerTo.gridy = 14;
        add(minuteSpinnerThumbnail, gbc_minuteSpinnerTo);

        btnConvertVideo = new JButton("Convert");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.EAST;
        gbc_btnSearch.gridwidth = 2;
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
     * Allows to get comboBoxAudioRate.
     * @return comboBoxAudioRate
     */
    public JComboBox getComboBoxAudioRate() {
        return comboBoxAudioRate;
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
    public JComboBox getComboBoxVideoTag() {
        return comboBoxVideoTag;
    }

    /**
     * Allows to get comboBoxVideoBit.
     * @return comboBoxVideoBit
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
     * Allows to get convert video button.
     * @return btnConvertVideo
     */
    public JButton getBtnConvertVideo() {
        return btnConvertVideo;
    }
}
