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

import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * This class allows you to separate the panels.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class SplitPanelConvert extends JPanel {
    private ConvertBasicPanel basicConvert;
    private ConvertTabs converterTab;

    /**
     * The constructor allows components to be initialized.
     */
    public SplitPanelConvert() {
        initComponent();
    }

    /**
     * This method initializes the component.
     */
    public void initComponent() {
        convertSplitPanel();
    }

    /**
     * This method shows the content of the division of panels in a splitPane.
     */
    public void convertSplitPanel() {
        basicConvert = new ConvertBasicPanel();
        converterTab = new ConvertTabs();
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, basicConvert,
            converterTab);
        splitPane.setOneTouchExpandable(false);
        add(splitPane);
    }
}
