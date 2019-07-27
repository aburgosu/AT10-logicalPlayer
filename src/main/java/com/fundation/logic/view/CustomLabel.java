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

import javax.swing.JLabel;
import java.awt.Font;

/**
 * Implements CustomLabel class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomLabel extends JLabel {
    public CustomLabel(String name) {
        super(name);
        Font font = new Font("Agency FB",3, 20);
        setFont(font);
    }
}
