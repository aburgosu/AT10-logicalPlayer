/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JPanel;

/**
 * Implements the tab of AdvancedSearch Panel.
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class AdvancedSearchPanel extends JPanel {
    private SearchAdvanceTab tabAdvance;

    /**
     * This method setting the size panel advance search
     */
    public AdvancedSearchPanel() {
        tabAdvance= new SearchAdvanceTab();
        tabAdvance.setSize(380,400);
        this.add(tabAdvance);
    }
}
