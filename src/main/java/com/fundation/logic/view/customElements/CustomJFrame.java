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

import javax.swing.*;
import java.awt.BorderLayout;

/**
 * Implements CustomJFrame class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomJFrame extends JFrame {
    JLabel image = new JLabel("", JLabel.CENTER);

    public CustomJFrame() {
        image.setIcon(new ImageIcon("resources/Images/welcome.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(image, BorderLayout.CENTER);
        setVisible(true);
    }
}
