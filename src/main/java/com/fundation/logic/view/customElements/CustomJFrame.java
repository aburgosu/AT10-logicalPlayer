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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * Implements CustomJFrame class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomJFrame extends JFrame {
    JLabel label = new JLabel("Welcome!", JLabel.CENTER);
    public CustomJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(label, BorderLayout.CENTER);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(43,43,43)));
        setVisible(true);
    }
}
