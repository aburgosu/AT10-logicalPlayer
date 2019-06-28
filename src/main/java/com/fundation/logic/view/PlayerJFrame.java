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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.WindowConstants;
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

    private JLabel playButton;
    private JLabel stopButton;
    private JLabel pauseButton;
    private int vol;
    private JPanel headerPanel;
    private JPanel playingPanel;
    private JPanel bottomPanel;
    private JSlider progressBar;
    private JSlider volumen;
    private EmbeddedMediaPlayerComponent player;
    private File fileToBePlayed;

    /**
     * Searchs for required vlc libraries: libvlc.dll libvlccore.dll
     */
    static {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC/");
    }

    /**
     * Initializes a PlayerJFrame object with all panels, labels and sliders required
     */
    public PlayerJFrame(String path) {

        playButton = new JLabel();
        stopButton = new JLabel();
        pauseButton = new JLabel();
        vol = 50;
        headerPanel = new JPanel();
        playingPanel = new JPanel();
        bottomPanel = new JPanel();
        progressBar = new JSlider(0, 100, 0);
        volumen = new JSlider(0, 100, vol);
        player = new EmbeddedMediaPlayerComponent();
        fileToBePlayed = new File(path);

        setBounds(new Rectangle(80, 100, 800, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("LogicalPlayer");

        try {
            playButton.setIcon(new ImageIcon("resources/Play.png"));
            stopButton.setIcon(new ImageIcon("resources/Stop.png"));
            pauseButton.setIcon(new ImageIcon("resources/Pause.png"));
        } catch (NullPointerException e) {
            System.out.println("Icons cannot be found..");
        }

        Box headerBox = Box.createHorizontalBox();
        Box playButtonBox = Box.createVerticalBox();
        Box pauseButtonBox = Box.createVerticalBox();
        Box stopButtonBox = Box.createVerticalBox();
        Box progressBarBox = Box.createVerticalBox();

        add(headerPanel, BorderLayout.NORTH);
        headerPanel.setBackground(Color.BLUE);
        headerBox.setPreferredSize(new Dimension(100, 50));
        headerPanel.add(headerBox);

        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBackground(Color.BLUE);
        playButtonBox.setPreferredSize(new Dimension(50, 50));
        playButtonBox.add(playButton);
        bottomPanel.add(playButtonBox);

        pauseButtonBox.setPreferredSize(new Dimension(50, 50));
        pauseButtonBox.add(pauseButton);
        bottomPanel.add(pauseButtonBox);
        stopButtonBox.setPreferredSize(new Dimension(50, 50));
        stopButtonBox.add(stopButton);
        bottomPanel.add(stopButtonBox);

        progressBarBox.setPreferredSize(new Dimension(300, 50));
        progressBarBox.add(progressBar);
        progressBar.setEnabled(false);
        progressBarBox.add(volumen);
        bottomPanel.add(progressBarBox);

        add(playingPanel, BorderLayout.CENTER);
        playingPanel.setBackground(Color.BLACK);
        add(player);
        player.setSize(playingPanel.getSize());
        player.setVisible(true);
        setVisible(true);

        //Initializes an instance of ButtonListener class
        ButtonListener buttonListener = new ButtonListener(vol);
        buttonListener.listen(playButton, stopButton, pauseButton, player, fileToBePlayed, progressBar, volumen);
    }
}