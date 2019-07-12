/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JTabbedPane;

/**
 * Implements the tabs of different options.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class SearchAdvanceTab extends JTabbedPane {
    private AdvancedVideoPanel panelAdvanced;
    private AdvancedImagePanel panelImageAdvanced;
    private AdvancedAudioPanel panelAudioAdvanced;

    /**
     * Initializes a SearchTabs instance for the search options
     */
    public SearchAdvanceTab() {

        //this.setSize(1,1);
        panelAdvanced= new AdvancedVideoPanel();
        addTab("Video ", null, panelAdvanced, "Search advance Video");
        panelImageAdvanced= new AdvancedImagePanel();
        addTab("Image ", null, panelImageAdvanced, "Search advance Image");
        panelAudioAdvanced= new AdvancedAudioPanel();
        addTab("Audio ", null, panelAudioAdvanced, "Audio");

    }
}