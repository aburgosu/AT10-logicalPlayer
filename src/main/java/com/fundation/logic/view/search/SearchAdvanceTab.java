/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.search;

import javax.swing.JTabbedPane;

/**
 * Implements the tabs of different options.
 *
 * @author Jesus Menacho, Melissa Román
 * @version 1.0
 */
public class SearchAdvanceTab extends JTabbedPane {
    private GeneralSearchPanel generalSearchPanel;
    private AdvancedVideoPanel panelVideoAdvanced;
    private AdvancedImagePanel panelImageAdvanced;
    private AdvancedAudioPanel panelAudioAdvanced;

    /**
     * Initializes a MainTabs instance for the search options.
     */
    public SearchAdvanceTab() {
        generalSearchPanel = new GeneralSearchPanel();
        addTab("General",null, generalSearchPanel,"General search");
        panelImageAdvanced = new AdvancedImagePanel();
        addTab("Image ", null, panelImageAdvanced, "Advance image search");
        panelAudioAdvanced = new AdvancedAudioPanel();
        addTab("Audio ", null, panelAudioAdvanced, "Advance audio search");
        panelVideoAdvanced = new AdvancedVideoPanel();
        addTab("Video ", null, panelVideoAdvanced, "Advance video search");
    }

    /**
     * This method return the content the getGeneralSearchPanel.
     * @return generalSearchPanel.
     */
    public GeneralSearchPanel getGeneralSearchPanel() {
        return generalSearchPanel;
    }

    /**
     * This method return the content the PanelVideoAdvanced.
     * @return generalSearchPanel.
     */
    public AdvancedVideoPanel getPanelVideoAdvanced() {
        return panelVideoAdvanced;
    }

    /**
     * This method return the content the PanelImageAdvanced.
     * @return generalSearchPanel.
     */
    public AdvancedImagePanel getPanelImageAdvanced() {
        return panelImageAdvanced;
    }

    /**
     * This method return the content the PanelAudioAdvanced.
     * @return generalSearchPanel.
     */
    public AdvancedAudioPanel getPanelAudioAdvanced() {
        return panelAudioAdvanced;
    }
}