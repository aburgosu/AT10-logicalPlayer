package com.fundation.logic.view;

import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

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

    private boolean AccionProgres = true;

    private EmbeddedMediaPlayerComponent player = new EmbeddedMediaPlayerComponent();
    private File file1 = new File("resources/Wildlife.wmv");

    static {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC/");
    }

    public PlayerJFrame() {

        setBounds(new Rectangle(80, 200, 800, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("LogicalPlayer");

        // Icons buttons
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

        new ButtonListener();
    }

    class ButtonListener {

        public ButtonListener() {

            playButton.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    player.getMediaPlayer().playMedia(file1.getAbsolutePath());
                    player.getMediaPlayer().setVolume(vol);
                    progressBar.setEnabled(true);
                    setTitle(file1.getName() + " - LogicalPlayer");
                }
            });

            volumen.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    vol = volumen.getValue();
                    player.getMediaPlayer().setVolume(vol);
                    System.out.println(vol);
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
                    AccionProgres = false;
                }

                public void mouseReleased(MouseEvent e) {
                    AccionProgres = true;
                }
            });

            progressBar.addChangeListener(new ChangeListener() {
                public synchronized void stateChanged(ChangeEvent e) {
                    if (!AccionProgres) {
                        float position = progressBar.getValue() / 100f;
                        player.getMediaPlayer().setPosition(position);
                    }
                }
            });

            player.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
                public void positionChanged(MediaPlayer mp, float position) {
                    if (AccionProgres) {
                        int value = Math.min(100, Math.round(position * 100.0f));
                        progressBar.setValue(value);
                    }
                }
            });
        }
    }
}


