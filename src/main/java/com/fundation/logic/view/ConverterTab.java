/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.*;

/**
 * Implements the tabs of different options.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class ConverterTab extends JTabbedPane {
    private ConvertAudioPanel convertAudioPanel;
    private ConvertVideoPanel convertVideoPanel;
    private ConvertPPTPanel convertPPTPanel;


    /**
     * Initializes a SearchTabs instance for the search options.
     */
    public ConverterTab() {
        convertAudioPanel = new ConvertAudioPanel();
        addTab("Audio ", null, convertAudioPanel, "Convert audio");
        convertVideoPanel = new ConvertVideoPanel();
        addTab("Video ", null, convertVideoPanel, "Convert video");
        convertPPTPanel = new ConvertPPTPanel();
        addTab("PowerPoint ", null, convertPPTPanel, "Convert PPT to image");
    }
}