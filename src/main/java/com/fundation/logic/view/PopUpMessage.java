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

import com.fundation.logic.view.customElements.CustomPanelSecond;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;

/**
 * Implements the PopUpMessage class
 *
 * @author Melissa Román, Maday Alcalá
 * @version 1.0
 */
public class PopUpMessage extends CustomPanelSecond {
    /**
     * Shows a popup message
     * @param messageTittle - Tittle of the message
     * @param messageText - Text of the message
     */
    public static void showPopupMessage(String messageTittle, String messageText) {
        UIManager UI=new UIManager();
        UI.put("OptionPane.background", new Color(32, 178, 170));
        UI.put("Panel.background", new Color(32, 178, 170));
        UI.put("Button.background", new Color(60, 139, 139));

        JOptionPane.showMessageDialog(null, messageText,
                messageTittle, JOptionPane.WARNING_MESSAGE);
    }
    public static void showPopupMessage(MainFrame mainFrame ,String messageTittle, String messageText) {
        UIManager UI=new UIManager();
        UI.put("OptionPane.background", new Color(32, 178, 170));
        UI.put("Panel.background", new Color(32, 178, 170));
        UI.put("Button.background", new Color(60, 139, 139));

        JOptionPane.showMessageDialog(mainFrame, messageText,
                messageTittle, JOptionPane.INFORMATION_MESSAGE);
    }
}
