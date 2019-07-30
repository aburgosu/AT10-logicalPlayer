package com.fundation.logic.view;

import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class PopUpMessage {
    /**
     * Shows a popup message
     * @param messageTittle - Tittle of the message
     * @param messageText - Text of the message
     */
    public static void showPopupMessage(String messageTittle, String messageText) {
        JOptionPane.showMessageDialog(null, messageText,
                messageTittle, JOptionPane.WARNING_MESSAGE);
//        message.setBounds(50, 200, 350, 150);
//        message.setSize(350, 120);
//        JPanel messageTextPanel = new JPanel();
//        JLabel text = new JLabel(messageText);
//        text.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        text.setForeground(Color.red);
//        messageTextPanel.add(text, SwingConstants.CENTER);
//        message.add(messageTextPanel, BorderLayout.CENTER);
//        message.setVisible(true);
    }
}
