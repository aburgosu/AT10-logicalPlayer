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

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

/**
 * Implements CustomComboBox class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomComboBox extends JComboBox {
    public CustomComboBox() {
        super();
        Color comboBoxColor = new Color(255, 240,245);
        setBackground(comboBoxColor);
        Font font = new Font("Calibri", 3, 14);
        setFont(font);
    }
}
