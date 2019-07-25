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

import javax.swing.JPanel;
import java.awt.Color;

/**
 * Implements CustomPanel class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CustomPanel extends JPanel {
    public CustomPanel() {
        super();

        Color panelColor = new Color(26, 243, 112);
        setBackground(panelColor);
    }
}
