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

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

/**
 * Implements CustomTextField class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomTextField extends JTextField {
    public CustomTextField() {
        super();
        Color textFieldColor = new Color(220, 220, 220);
        setBackground(textFieldColor);
        Font font = new Font("Calibri", 3, 12);
        setFont(font);
    }
}
