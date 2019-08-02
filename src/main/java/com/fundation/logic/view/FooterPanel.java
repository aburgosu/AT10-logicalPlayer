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

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Label;

/**
 * Implements the FooterPanel class
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class FooterPanel extends JPanel {
    Label copyRight = new Label();

    /**
     * Build the FooterPanel and shows the copyright of the company.
     */
    public FooterPanel(){
        copyRight.setText("Copyright (c) 2019 Jalasoft, all rights reserved.");
        copyRight.setForeground(Color.BLACK);
        add(copyRight);
    }
}
