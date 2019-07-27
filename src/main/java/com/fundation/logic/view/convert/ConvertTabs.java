/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.convert;

import com.fundation.logic.view.CustomTab;

import javax.swing.JTabbedPane;

/**
 * Implements the ConvertTabs class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertTabs extends CustomTab {
    private ConvertAudioPanel convertAudioPanel;
    private ConvertVideoPanel convertVideoPanel;
    private ConvertPPTPanel convertPPTPanel;

    /**
     * Initializes a ConvertTabs instance for the convert options.
     */
    public ConvertTabs() {
        convertAudioPanel = new ConvertAudioPanel();
        addTab("Audio ", null, convertAudioPanel, "Convert audio");
        convertVideoPanel = new ConvertVideoPanel();
        addTab("Video ", null, convertVideoPanel, "Convert video");
        convertPPTPanel = new ConvertPPTPanel();
        addTab("PowerPoint ", null, convertPPTPanel, "Convert PPT to image");
    }
}