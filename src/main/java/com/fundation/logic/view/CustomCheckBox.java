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

import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;

/**
 * Implements CustomCheckBox class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomCheckBox extends JCheckBox {
    public CustomCheckBox(String check) {
        super();
        Color checkBoxColor = new Color(119, 136, 153);
        setBackground(checkBoxColor);
        Font font = new Font("Calibri", 3, 20);
        setFont(font);
    }
}
