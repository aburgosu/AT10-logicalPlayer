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

import com.fundation.logic.common.FileInfo;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Implements PopupMenu class which is in charge of show play, details and convert options on file.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class PopupMenu extends JPopupMenu {
    private JMenuItem playItem;
    private JMenuItem detailsItem;
    private JMenuItem convertItem;
    private String filePath;

    /**
     * Initializes PopupMenu with options according on the file
     * @param filePath - File's path where the PopupMenu was triggered.
     */
    public PopupMenu(String filePath) {
        this.filePath = filePath;
        if(FileInfo.isVideo(filePath) || FileInfo.isAudio(filePath)) {
            playItem = new JMenuItem("Play");
            add(playItem);
        }
        detailsItem = new JMenuItem("Details");
        add(detailsItem);
        convertItem = new JMenuItem("convert");
        add(convertItem);
        initItemMenuListener();
    }

    /**
     * Initializes item menu listener.
     */
    public void initItemMenuListener(){
        try {
            playItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        PlayerFrame playerWindow = new PlayerFrame(filePath);
                        playerWindow.setVisible(true);
                    }
                }
            });
        } catch (Exception e) {
            e.getMessage();
        }
    }
}