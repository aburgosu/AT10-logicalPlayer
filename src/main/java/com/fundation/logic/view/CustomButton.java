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

import javax.swing.JButton;
import java.awt.*;

/**
 * Implements CustomButton class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CustomButton extends JButton {
    public CustomButton(String name) {
        super(name);
        Color buttonColor = new Color(0, 139, 139);
        setBackground(buttonColor);
        Font fuente = new Font("Calibri", 3, 18);
        setFont(fuente);
    }
}
