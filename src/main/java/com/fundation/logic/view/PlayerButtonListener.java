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

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Implements the PlayerButtonListener class which listen to player buttons
 *
 * @author Melissa Román
 * @version 1.0
 */
public class PlayerButtonListener {
    int volumeLevel;
    boolean actionInProgress;

    /**
     * Initializes a PlayerButtonListener object with an initial volume level given as parameter
     */
    public PlayerButtonListener(int volumeLevel) {
        this.volumeLevel = volumeLevel;
        actionInProgress = true;
    }

    /**
     * This method is charge of listening on every button given as parameter and also sliders
     * to perform a specified action
     */
    public void listen(JButton playButton, JButton stopButton, JButton pauseButton, EmbeddedMediaPlayerComponent player,
            File file, JSlider progressBar, JSlider volume) {
        //Actions to perform when playButton is pressed
        playButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            player.getMediaPlayer().playMedia(file.getAbsolutePath());
            player.getMediaPlayer().setVolume(volumeLevel);
            progressBar.setEnabled(true);
            }
        });

        //Set volume in player
        volume.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                volumeLevel = volume.getValue();
                player.getMediaPlayer().setVolume(volumeLevel);
            }
        });

        //Actions to perform when stopButton is pressed
        stopButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            player.getMediaPlayer().stop();
            progressBar.setValue(0);
            progressBar.setEnabled(false);
            }
        });

        //Actions to perform when pauseButton is pressed
        pauseButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            player.getMediaPlayer().setPause(player.getMediaPlayer().isPlaying() ? true : false);
            }
        });

        //Actions related to changes in progressBar
        progressBar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                actionInProgress = false;
            }

            public void mouseReleased(MouseEvent e) {
                actionInProgress = true;
            }
        });

        progressBar.addChangeListener(new ChangeListener() {
            public synchronized void stateChanged(ChangeEvent e) {
                if (!actionInProgress) {
                    float position = progressBar.getValue() / 100f;
                    player.getMediaPlayer().setPosition(position);
                }
            }
        });

        player.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            public void positionChanged(MediaPlayer mp, float position) {
            if (actionInProgress) {
                int value = Math.min(100, Math.round(position * 100.0f));
                progressBar.setValue(value);
            }
            }
        });
    }
}

