/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.customElements;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;

/**
 * Implements CustomPanelSecond class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomPanelSecond extends JPanel {
    public CustomPanelSecond() {
        super();
        Color panelColor = new Color(32, 178, 170);
        setBackground(panelColor);
        setForeground(Color.orange);
    }
}
