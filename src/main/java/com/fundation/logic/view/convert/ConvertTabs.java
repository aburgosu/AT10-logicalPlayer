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

import javax.swing.JTabbedPane;

/**
 * Implements the ConvertTabs class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertTabs extends JTabbedPane {
    private ConvertAudioPanel convertAudioPanel;
    private ConvertVideoPanel convertVideoPanel;
    private ConvertPDFPanel convertPDFPanel;

    /**
     * Initializes a ConvertTabs instance for the convert options.
     */
    public ConvertTabs() {
        convertAudioPanel = new ConvertAudioPanel();
        addTab("Audio ", null, convertAudioPanel, "Convert audio");
        convertVideoPanel = new ConvertVideoPanel();
        addTab("Video ", null, convertVideoPanel, "Convert video");
        convertPDFPanel = new ConvertPDFPanel();
        addTab("PDF ", null, convertPDFPanel, "Convert PDF to image");
    }

    /**
     * This method return the content ConvertAudioPanel.
     * @return ConvertAudioPanel.
     */
    public ConvertAudioPanel getConvertAudioPanel() {
        return convertAudioPanel;
    }

    /**
     * This method return the content ConvertVideoPanel.
     * @return ConvertVideoPanel.
     */
    public ConvertVideoPanel getConvertVideoPanel() {
        return convertVideoPanel;
    }

    /**
     * This method return the content ConvertPPTPanel.
     * @return ConvertPDFPanel.
     */
    public ConvertPDFPanel getConvertPDFPanel() {
        return convertPDFPanel;
    }
}
