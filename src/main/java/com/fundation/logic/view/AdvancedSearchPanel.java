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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * Implements the tab of AdvancedSearch Panel.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class AdvancedSearchPanel extends JPanel {
    private JTextField textFieldVideoBitrate;
    private JTextField textFieldVideoFramerate;
    private JTextField textFieldAudioBitrate;

    public AdvancedSearchPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{66, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblVideo = new JLabel("Video");
        lblVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_lblVideo = new GridBagConstraints();
        gbc_lblVideo.gridwidth = 2;
        gbc_lblVideo.insets = new Insets(0, 0, 5, 0);
        gbc_lblVideo.gridx = 0;
        gbc_lblVideo.gridy = 0;
        add(lblVideo, gbc_lblVideo);

        JLabel lblCodecVideo = new JLabel("Codec: ");
        GridBagConstraints gbc_lblCodecVideo = new GridBagConstraints();
        gbc_lblCodecVideo.anchor = GridBagConstraints.EAST;
        gbc_lblCodecVideo.insets = new Insets(0, 0, 5, 5);
        gbc_lblCodecVideo.gridx = 0;
        gbc_lblCodecVideo.gridy = 1;
        add(lblCodecVideo, gbc_lblCodecVideo);

        JComboBox comboBoxVideoCodec = new JComboBox();
        GridBagConstraints gbc_comboBoxVideoCodec = new GridBagConstraints();
        gbc_comboBoxVideoCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxVideoCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxVideoCodec.gridx = 1;
        gbc_comboBoxVideoCodec.gridy = 1;
        add(comboBoxVideoCodec, gbc_comboBoxVideoCodec);

        JLabel lblBitrateVideo = new JLabel("Bitrate: ");
        GridBagConstraints gbc_lblBitrateVideo = new GridBagConstraints();
        gbc_lblBitrateVideo.anchor = GridBagConstraints.EAST;
        gbc_lblBitrateVideo.insets = new Insets(0, 0, 5, 5);
        gbc_lblBitrateVideo.gridx = 0;
        gbc_lblBitrateVideo.gridy = 2;
        add(lblBitrateVideo, gbc_lblBitrateVideo);

        textFieldVideoBitrate = new JTextField();
        GridBagConstraints gbc_textFieldVideoBitrate = new GridBagConstraints();
        gbc_textFieldVideoBitrate.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldVideoBitrate.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldVideoBitrate.gridx = 1;
        gbc_textFieldVideoBitrate.gridy = 2;
        add(textFieldVideoBitrate, gbc_textFieldVideoBitrate);
        textFieldVideoBitrate.setColumns(10);

        JLabel lblFramerate = new JLabel("Framerate: ");
        GridBagConstraints gbc_lblFramerate = new GridBagConstraints();
        gbc_lblFramerate.anchor = GridBagConstraints.EAST;
        gbc_lblFramerate.insets = new Insets(0, 0, 5, 5);
        gbc_lblFramerate.gridx = 0;
        gbc_lblFramerate.gridy = 3;
        add(lblFramerate, gbc_lblFramerate);

        textFieldVideoFramerate = new JTextField();
        GridBagConstraints gbc_textFieldVideoFramerate = new GridBagConstraints();
        gbc_textFieldVideoFramerate.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldVideoFramerate.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldVideoFramerate.gridx = 1;
        gbc_textFieldVideoFramerate.gridy = 3;
        add(textFieldVideoFramerate, gbc_textFieldVideoFramerate);
        textFieldVideoFramerate.setColumns(10);

        JLabel label = new JLabel("");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 4;
        add(label, gbc_label);

        JSeparator separator = new JSeparator();
        GridBagConstraints gbc_separator = new GridBagConstraints();
        gbc_separator.insets = new Insets(0, 0, 5, 5);
        gbc_separator.gridx = 0;
        gbc_separator.gridy = 5;
        add(separator, gbc_separator);

        JLabel lblAudio = new JLabel("Audio");
        lblAudio.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_lblAudio = new GridBagConstraints();
        gbc_lblAudio.insets = new Insets(0, 0, 5, 0);
        gbc_lblAudio.gridwidth = 2;
        gbc_lblAudio.gridx = 0;
        gbc_lblAudio.gridy = 6;
        add(lblAudio, gbc_lblAudio);

        JLabel lblCodecAudio = new JLabel("Codec: ");
        GridBagConstraints gbc_lblCodecAudio = new GridBagConstraints();
        gbc_lblCodecAudio.anchor = GridBagConstraints.EAST;
        gbc_lblCodecAudio.insets = new Insets(0, 0, 5, 5);
        gbc_lblCodecAudio.gridx = 0;
        gbc_lblCodecAudio.gridy = 7;
        add(lblCodecAudio, gbc_lblCodecAudio);

        JComboBox comboBoxAudioCodec = new JComboBox();
        GridBagConstraints gbc_comboBoxAudioCodec = new GridBagConstraints();
        gbc_comboBoxAudioCodec.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioCodec.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioCodec.gridx = 1;
        gbc_comboBoxAudioCodec.gridy = 7;
        add(comboBoxAudioCodec, gbc_comboBoxAudioCodec);

        JLabel lblChannels = new JLabel("Channels: ");
        GridBagConstraints gbc_lblChannels = new GridBagConstraints();
        gbc_lblChannels.anchor = GridBagConstraints.EAST;
        gbc_lblChannels.insets = new Insets(0, 0, 5, 5);
        gbc_lblChannels.gridx = 0;
        gbc_lblChannels.gridy = 8;
        add(lblChannels, gbc_lblChannels);

        JComboBox comboBoxAudioChannels = new JComboBox();
        GridBagConstraints gbc_comboBoxAudioChannels = new GridBagConstraints();
        gbc_comboBoxAudioChannels.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxAudioChannels.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxAudioChannels.gridx = 1;
        gbc_comboBoxAudioChannels.gridy = 8;
        add(comboBoxAudioChannels, gbc_comboBoxAudioChannels);

        JLabel lblBitrate = new JLabel("Bitrate: ");
        GridBagConstraints gbc_lblBitrate = new GridBagConstraints();
        gbc_lblBitrate.anchor = GridBagConstraints.EAST;
        gbc_lblBitrate.insets = new Insets(0, 0, 5, 5);
        gbc_lblBitrate.gridx = 0;
        gbc_lblBitrate.gridy = 9;
        add(lblBitrate, gbc_lblBitrate);

        textFieldAudioBitrate = new JTextField();
        GridBagConstraints gbc_textFieldAudioBitrate = new GridBagConstraints();
        gbc_textFieldAudioBitrate.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldAudioBitrate.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldAudioBitrate.gridx = 1;
        gbc_textFieldAudioBitrate.gridy = 9;
        add(textFieldAudioBitrate, gbc_textFieldAudioBitrate);
        textFieldAudioBitrate.setColumns(10);

        JButton btnSearch = new JButton("Search");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.gridwidth = 2;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 11;
        add(btnSearch, gbc_btnSearch);

    }
}
