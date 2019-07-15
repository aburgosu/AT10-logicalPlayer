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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This class show the content the advance video panel.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class AdvancedVideoPanel extends JPanel {

    private SettingPanel settingPanel;
    private JComboBox comboBoxVideoCodec;
    private JComboBox comboBoxVideoBitrate;
    private JComboBox comboBoxVideoFramerate;
    private JComboBox comboBoxResolution;
    private JTextField textFieldDurationsSecond;
    private JTextField textFieldDurationFirst;
    private JComboBox comboBoxAudioCodecName;
    private JButton btnSearchAdvanceVideoPanel;

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
        settingPanel = new SettingPanel();
        settingPanel.settingPanelAdvanceSearch(this);
        videoContentPanel();
    }

    /**
     * This method show the content the panel.
     */
    private void videoContentPanel() {
        JLabel lblCodecVideo = new JLabel("Codec Video: ");
        GridBagConstraints gbc_lblCodecVideo = new GridBagConstraints();
        gbc_lblCodecVideo.anchor = GridBagConstraints.EAST;
        gbc_lblCodecVideo.insets = new Insets(0, 0, 5, 5);
        gbc_lblCodecVideo.gridx = 0;
        gbc_lblCodecVideo.gridy = 7;
        add(lblCodecVideo, gbc_lblCodecVideo);

        comboBoxVideoCodec = new JComboBox();
        comboBoxVideoCodec.setModel(new DefaultComboBoxModel(new String[]{"MPEG-4", "WMV","All"}));

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
        comboBoxAudioCodecName.setModel(new DefaultComboBoxModel(new String[]{"MPEG", "WMA", "AAC","All"}));
        GridBagConstraints textFiled_AudioCodecName = new GridBagConstraints();
        textFiled_AudioCodecName.insets = new Insets(0, 0, 5, 0);
        textFiled_AudioCodecName.fill = GridBagConstraints.HORIZONTAL;
        textFiled_AudioCodecName.gridx = 1;
        textFiled_AudioCodecName.gridy = 8;
        add(comboBoxAudioCodecName, textFiled_AudioCodecName);

        JLabel lblFramerate = new JLabel("Framerate: ");
        GridBagConstraints gbc_lblFramerate = new GridBagConstraints();
        gbc_lblFramerate.anchor = GridBagConstraints.EAST;
        gbc_lblFramerate.insets = new Insets(0, 0, 5, 5);
        gbc_lblFramerate.gridx = 0;
        gbc_lblFramerate.gridy = 10;
        add(lblFramerate, gbc_lblFramerate);

        comboBoxVideoFramerate = new JComboBox();
        comboBoxVideoFramerate.setModel(new DefaultComboBoxModel(new String[]{"All", "21", "24", "30", "60"}));
        GridBagConstraints gbc_comboBoxVideoFramerate = new GridBagConstraints();
        gbc_comboBoxVideoFramerate.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoFramerate.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoFramerate.gridx = 1;
        gbc_comboBoxVideoFramerate.gridy = 10;
        add(comboBoxVideoFramerate, gbc_comboBoxVideoFramerate);

        JLabel lblResolution = new JLabel("Resolution: ");
        GridBagConstraints gbc_lblWidth = new GridBagConstraints();
        gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
        gbc_lblWidth.anchor = GridBagConstraints.EAST;
        gbc_lblWidth.gridx = 0;
        gbc_lblWidth.gridy = 11;
        add(lblResolution, gbc_lblWidth);

        comboBoxResolution = new JComboBox();
        comboBoxResolution.setModel(new DefaultComboBoxModel(new String[]{"1280x720", "1920x1080", "320x240", "640x480"}));

        GridBagConstraints gbc_comboBoxResolution = new GridBagConstraints();
        gbc_comboBoxResolution.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxResolution.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxResolution.gridx = 1;
        gbc_comboBoxResolution.gridy = 11;
        add(comboBoxResolution, gbc_comboBoxResolution);

        JLabel lblDuration = new JLabel("Duration: ");
        GridBagConstraints gbc_lblDuration = new GridBagConstraints();
        gbc_lblDuration.anchor = GridBagConstraints.EAST;
        gbc_lblDuration.insets = new Insets(0, 0, 5, 5);
        gbc_lblDuration.gridx = 0;
        gbc_lblDuration.gridy = 12;
        add(lblDuration, gbc_lblDuration);

        textFieldDurationFirst = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 12;
        add(textFieldDurationFirst, gbc_textField);
        textFieldDurationFirst.setColumns(10);

        textFieldDurationsSecond = new JTextField();
        GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
        gbc_textFieldHeight.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldHeight.gridx = 1;
        gbc_textFieldHeight.gridy = 13;
        add(textFieldDurationsSecond, gbc_textFieldHeight);
        textFieldDurationsSecond.setColumns(10);

        btnSearchAdvanceVideoPanel = new JButton("Search");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.EAST;
        gbc_btnSearch.gridwidth = 2;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 14;
        add(btnSearchAdvanceVideoPanel, gbc_btnSearch);
    }

    /**
     * This method return comboBoxVideoCodec.
     * @return comboBoxVideoCodec
     */
    public JComboBox getComboBoxVideoCodec() {
        return comboBoxVideoCodec;
    }

    /**
     * This method return comboBoxVideoBitrate.
     * @return comboBoxVideoBitrate
     */
    public JComboBox getComboBoxVideoBitrate() {
        return comboBoxVideoBitrate;
    }

    /**
     * This method return comboBoxVideoFramerate.
     * @return comboBoxVideoFramerate
     */
    public JComboBox getComboBoxVideoFramerate() {
        return comboBoxVideoFramerate;
    }

    /**
     * This method return comboBoxResolution.
     * @return comboBoxResolution.
     */
    public JComboBox getComboBoxResolution() {
        return comboBoxResolution;
    }

    /**
     * This method return textFieldDurationsSecond.
     * @return textFieldDurationsSecond
     */
    public JTextField getTextFieldDurationsSecond() {
        return textFieldDurationsSecond;
    }

    /**
     * This method return textFieldDurationFirst.
     * @return textFieldDurationFirst
     */
    public JTextField getTextFieldDurationFirst() {
        return textFieldDurationFirst;
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
}
