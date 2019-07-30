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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

/**
 * Implements CustomButton class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CustomButton extends JButton {
    public CustomButton(String name) {
        super(name);
        Color buttonColor = new Color(60, 139, 139);
        setBackground(buttonColor);
        setForeground(new Color(230, 227, 210));
        Font font = new Font("Calibri", 3, 18);
        setFont(font);
    }
}
