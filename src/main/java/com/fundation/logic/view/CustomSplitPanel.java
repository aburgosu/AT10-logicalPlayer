/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JSplitPane;
import java.awt.Color;

/**
 * Implements CustomSplitPanel class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomSplitPanel extends JSplitPane {
    public CustomSplitPanel() {
        super();
        Color panelColor = new Color(16, 151, 152);
        setBackground(panelColor);
    }
}
