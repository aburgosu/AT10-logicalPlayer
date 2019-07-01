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
public class PlayerJFrame extends JFrame {
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
    ButtonListener buttonListener;

    /**
     * Searchs for required vlc libraries: libvlc.dll libvlccore.dll
     */
    static {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC/");
    }

    /**
     * Initializes a PlayerJFrame object
     */
    public PlayerJFrame(String path) {
        initComponent(path);
        initSetting();
    }

    /**
     * Initializes a PlayerJFrame object with all panels, labels and sliders required
     */
    private void initComponent(String path) {
        playButton = new JButton();
        stopButton = new JButton();
        pauseButton = new JButton();
        playingPanel = new JPanel();
        bottomPanel = new JPanel();
        progressBar = new JSlider(0, 100, 0);
        volumeLevel = 50;
        volumeSlider = new JSlider(JSlider.VERTICAL, 0, 100, volumeLevel);
        player = new EmbeddedMediaPlayerComponent();
        fileToBePlayed = new File(path);
        buttonListener = new ButtonListener(volumeLevel);
    }

    /**
     * Set all PlayerJFrame components
     */
    private void initSetting() {
        setBounds(new Rectangle(80, 100, 800, 540));
        setTitle("LogicalPlayer");
        try {
            playButton.setIcon(new ImageIcon("resources/Play.png"));
            stopButton.setIcon(new ImageIcon("resources/Stop.png"));
            pauseButton.setIcon(new ImageIcon("resources/Pause.png"));
        } catch (NullPointerException e) {
            System.out.println("Player icons cannot be found..");
        }

        add(bottomPanel, BorderLayout.SOUTH);
        playButton.setPreferredSize(new Dimension(35, 35));
        bottomPanel.add(playButton);
        pauseButton.setPreferredSize(new Dimension(35, 35));
        bottomPanel.add(pauseButton);
        stopButton.setPreferredSize(new Dimension(35, 35));
        bottomPanel.add(stopButton);
        progressBar.setPreferredSize(new Dimension(610, 20));
        progressBar.setEnabled(false);
        bottomPanel.add(progressBar);
        volumeSlider.setPreferredSize(new Dimension(20, 50));
        bottomPanel.add(volumeSlider);
        add(playingPanel, BorderLayout.CENTER);
        playingPanel.setBackground(Color.BLACK);
        add(player);
        player.setSize(playingPanel.getSize());
        player.setVisible(true);
        setVisible(true);
        //Sends all required arguments to buttonListener's listen method
        buttonListener.listen(playButton, stopButton, pauseButton, player, fileToBePlayed, progressBar, volumeSlider);
    }
}
