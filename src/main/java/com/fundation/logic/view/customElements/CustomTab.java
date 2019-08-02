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

import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;

/**
 * Implements CustomTab class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomTab extends JTabbedPane {
    public CustomTab() {
        super();
        Color tabColor = new Color(32, 178, 170);
        setBackground(tabColor);
        Font font = new Font("Arial", 3, 15);
        setFont(font);
        setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0,139,139)));
    }
}
