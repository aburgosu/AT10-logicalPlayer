/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.resultTable;

import com.fundation.logic.view.customElements.CustomButton;
import com.fundation.logic.view.customElements.CustomJFrame;
import com.fundation.logic.view.customElements.CustomPanel;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * Implements the player frame with playing control buttons
 *
 * @author Melissa Román, Maday Alcalá
 * @version 1.0
 */
public class PlayerFrame extends CustomJFrame {
    private CustomButton playButton;
    private CustomButton stopButton;
    private CustomButton pauseButton;
    private CustomPanel playingPanel;
    private CustomPanel bottomPanel;
    private JSlider progressBar;
    private JSlider volumeSlider;
    private int volumeLevel;
    private EmbeddedMediaPlayerComponent player;
    private File fileToBePlayed;
    private PlayerButtonListener buttonListener;

    /**
     * Searches for required vlc libraries: libvlc.dll libvlccore.dll
     */
    static {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "thirdParty/vlc-3.0.7.1/");
    }

    /**
     * Initializes a PlayerFrame object which will play the file in the given path.
     * @param path - Path of the file to be played.
     */
    public PlayerFrame(String path) {
        initComponent(path);
        initSetting();
        listenToFinishReproduction();
    }

    /**
     * Initializes a PlayerFrame object with all panels, labels and sliders required.
     * Player will play the file in the given path.
     * @param path
     */
    private void initComponent(String path) {
        playButton = new CustomButton("");
        playButton.setBackground(new Color(32, 178, 170));
        playButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(32, 178, 170)));
        stopButton = new CustomButton("");
        stopButton.setBackground(new Color(32, 178, 170));
        stopButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(32, 178, 170)));
        pauseButton = new CustomButton("");
        pauseButton.setBackground(new Color(32, 178, 170));
        pauseButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(32, 178, 170)));
        playingPanel = new CustomPanel();
        playingPanel.setBackground(new Color(32, 178, 170));
        bottomPanel = new CustomPanel();
        bottomPanel.setBackground(new Color(32, 178, 170));
        final int SLIDER_MIN_VALUE = 0;
        final int SLIDER_MAX_VALUE = 100;
        progressBar = new JSlider(SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, 0);
        progressBar.setBackground(new Color(32, 178, 170));
        volumeLevel = 50;
        volumeSlider = new JSlider(JSlider.VERTICAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, volumeLevel);
        volumeSlider.setBackground(new Color(32, 178, 170));
        player = new EmbeddedMediaPlayerComponent();
        fileToBePlayed = new File(path);
        buttonListener = new PlayerButtonListener(volumeLevel);
    }

    /**
     * Sets all PlayerFrame components
     */
    private void initSetting() {
        setLocationRelativeTo(null);
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

    /**
     * Finishes playing the file when window un closed.
     */
    private void listenToFinishReproduction() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                player.getMediaPlayer().stop();
            }
        });
    }
}
