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

import javax.swing.JOptionPane;

/**
 * Implements the PopUpMessage class
 *
 * @author Melissa Román, Maday Alcalá
 * @version 1.0
 */
public class PopUpMessage {
    /**
     * Shows a popup message
     * @param messageTittle - Tittle of the message
     * @param messageText - Text of the message
     */
    public static void showPopupMessage(String messageTittle, String messageText) {
        JOptionPane.showMessageDialog(null, messageText,
                messageTittle, JOptionPane.WARNING_MESSAGE);
    }
}
