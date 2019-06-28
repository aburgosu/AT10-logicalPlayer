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
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Implements the ButtonListener class which listen to player buttons
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ButtonListener {

    int vol;
    boolean actionInProgress;

    /**
     * Initializes a ButtonListener object with an initial volumen level given as parameter
     */
    public ButtonListener(int vol) {

        this.vol = vol;
        actionInProgress = true;
    }

    /**
     * This method is charge of listening on every button given as parameter and also sliders
     * to perform a specified action
     */
    public void listen(JLabel playButton, JLabel stopButton, JLabel pauseButton, EmbeddedMediaPlayerComponent player,
                       File file, JSlider progressBar, JSlider volumen) {

        playButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                player.getMediaPlayer().playMedia(file.getAbsolutePath());
                player.getMediaPlayer().setVolume(vol);
                progressBar.setEnabled(true);
            }
        });

        volumen.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                vol = volumen.getValue();
                player.getMediaPlayer().setVolume(vol);
            }
        });

        stopButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                player.getMediaPlayer().stop();
                progressBar.setValue(0);
                progressBar.setEnabled(false);
            }
        });

        pauseButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                player.getMediaPlayer().setPause(player.getMediaPlayer().isPlaying() ? true : false);
            }
        });

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

