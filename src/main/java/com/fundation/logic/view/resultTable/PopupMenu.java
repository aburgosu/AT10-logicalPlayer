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
import java.util.List;

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
    private List<String> detailsList;

    /**
     * Initializes PopupMenu with options according on the file
     * @param filePath - File's path where the PopupMenu was triggered.
     */
    public PopupMenu(String filePath, List<String> detailsList) {
        this.filePath = filePath;
        this.detailsList = detailsList;
        if(FileInfo.isVideo(filePath) || FileInfo.isAudio(filePath)) {
            playItem = new JMenuItem("Play");
            add(playItem);
        }
        if(FileInfo.isVideo(filePath) || FileInfo.isAudio(filePath) || FileInfo.isPdf(filePath)) {
            convertItem = new JMenuItem("Convert");
            add(convertItem);
        }
        detailsItem = new JMenuItem("Details");
        add(detailsItem);
    }

    /**
     * Allows to get convert item.
     * @return convertItem.
     */
    public JMenuItem getConvertItem() {
        return convertItem;
    }

    /**
     * Allows to get play item.
     * @return playItem.
     */
    public JMenuItem getPlayItem() {
        return playItem;
    }

    /**
     * Allows to get details item.
     * @return detailsItem.
     */
    public JMenuItem getDetailsItem() {
        return detailsItem;
    }
}
