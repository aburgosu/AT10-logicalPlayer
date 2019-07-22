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

import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

/**
 * Implements the player frame with playing control buttons
 *
 * @author Melissa Román
 * @version 1.0
 */
public class PlayerFrame extends JFrame {
    private JButton playButton;
    private JButton stopButton;
    private JButton pauseButton;
    private JPanel playingPanel;
    private JPanel bottomPanel;
    private JSlider progressBar;
    private JSlider volumeSlider;
    private int volumeLevel;
    private EmbeddedMediaPlayerComponent player;
    private File fileToBePlayed;
    private PlayerButtonListener buttonListener;

    /**
     * Searchs for required vlc libraries: libvlc.dll libvlccore.dll
     */
    static {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC/");
    }

    /**
     * Initializes a PlayerFrame object which will play the file in the given path.
     * @param path - Path of the file to be played.
     */
    public PlayerFrame(String path) {
        initComponent(path);
        initSetting();
    }

    /**
     * Initializes a PlayerFrame object with all panels, labels and sliders required.
     * Player will play the file in the given path.
     * @param path
     */
    private void initComponent(String path) {
        playButton = new JButton();
        stopButton = new JButton();
        pauseButton = new JButton();
        playingPanel = new JPanel();
        bottomPanel = new JPanel();
        final int SLIDER_MIN_VALUE = 0;
        final int SLIDER_MAX_VALUE = 100;
        progressBar = new JSlider(SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, 0);
        volumeLevel = 50;
        volumeSlider = new JSlider(JSlider.VERTICAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, volumeLevel);
        player = new EmbeddedMediaPlayerComponent();
        fileToBePlayed = new File(path);
        buttonListener = new PlayerButtonListener(volumeLevel);
    }

    /**
     * Set all PlayerFrame components
     */
    private void initSetting() {
        final int BUTTON_SIDE_SIZE = 35;
        final int PLAYER_FRAME_WIDTH = 800;
        final int PLAYER_FRAME_HEIGHT = 540;
        final int PROGRESS_BAR_LENGTH = 610;
        final int PROGRESS_BAR_HEIGHT = 20;
        final int VOLUME_BAR_HEIGHT = 50;
        final int VOLUME_BAR_LENGTH = 20;
        final int FRAME_X_POSITION = 80;
        final int FRAME_Y_POSITION = 100;
        setBounds(new Rectangle(FRAME_X_POSITION, FRAME_Y_POSITION, PLAYER_FRAME_WIDTH, PLAYER_FRAME_HEIGHT));
        setTitle(fileToBePlayed.getName());
        add(bottomPanel, BorderLayout.SOUTH);
        playButton.setIcon(new ImageIcon("resources/Images/Play.png"));
        playButton.setPreferredSize(new Dimension(BUTTON_SIDE_SIZE, BUTTON_SIDE_SIZE));
        bottomPanel.add(playButton);
        pauseButton.setIcon(new ImageIcon("resources/Images/Pause.png"));
        pauseButton.setPreferredSize(new Dimension(BUTTON_SIDE_SIZE, BUTTON_SIDE_SIZE));
        bottomPanel.add(pauseButton);
        stopButton.setIcon(new ImageIcon("resources/Images/Stop.png"));
        stopButton.setPreferredSize(new Dimension(BUTTON_SIDE_SIZE, BUTTON_SIDE_SIZE));
        bottomPanel.add(stopButton);
        progressBar.setPreferredSize(new Dimension(PROGRESS_BAR_LENGTH, PROGRESS_BAR_HEIGHT));
        progressBar.setEnabled(false);
        bottomPanel.add(progressBar);
        volumeSlider.setPreferredSize(new Dimension(VOLUME_BAR_LENGTH, VOLUME_BAR_HEIGHT));
        bottomPanel.add(volumeSlider);
        add(playingPanel, BorderLayout.CENTER);
        playingPanel.setBackground(Color.BLACK);
        add(player);
        player.setSize(playingPanel.getSize());
        player.setVisible(true);
        setVisible(true);
        //Initializes playing
        player.getMediaPlayer().playMedia(fileToBePlayed.getAbsolutePath());
        player.getMediaPlayer().setVolume(volumeLevel);
        progressBar.setEnabled(true);
        //Sends all required arguments to buttonListener's listen method
        buttonListener.listen(playButton, stopButton, pauseButton, player, fileToBePlayed, progressBar, volumeSlider);
    }
}