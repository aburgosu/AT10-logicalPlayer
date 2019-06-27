/**
 * Copyright (c) 2019 Jalasoft.
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
class PlayerJFrame extends JFrame {

    private JLabel playButton = new JLabel();
    private JLabel stopButton = new JLabel();
    private JLabel pauseButton = new JLabel();
    private int vol = 50;
    private JPanel headerPanel = new JPanel();
    private JPanel playingPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JSlider progressBar = new JSlider(0, 100, 0);
    private JSlider volumen = new JSlider(0, 100, vol);
    private EmbeddedMediaPlayerComponent player = new EmbeddedMediaPlayerComponent();
    private File fileToBePlayed = new File("resources/Wildlife.wmv");

    static {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC/");
    }

    public PlayerJFrame() {

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

        ButtonListener buttonListener = new ButtonListener(vol);
        buttonListener.listen(playButton, stopButton, pauseButton, player, fileToBePlayed, progressBar, volumen);
    }
}


