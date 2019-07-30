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

import com.fundation.logic.view.customElements.CustomButton;
import com.fundation.logic.view.customElements.CustomLabel;
import com.fundation.logic.view.customElements.CustomPanel;
import com.fundation.logic.view.customElements.CustomTextField;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

/**
 * Implements the NameFrame class
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class NameFrame extends JFrame {
    private CustomLabel textName;
    private CustomTextField textFieldName;
    private CustomButton btnSave;


    /**
     * Inits Nameframe class.
     */
    public NameFrame() {
        initSetting();
    }

    /**
     * Inits frame to show NameFrame class.
     */
    public void initSetting() {
        setSize(200, 120);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("resources/Images/icon.png").getImage());
        setResizable(false);
        CustomPanel namePanel = new CustomPanel();
        textName = new CustomLabel("Name: ");
        textName.setFont(new Font("Arial", Font.PLAIN, 16));
        textName.setForeground(Color.WHITE);
        textFieldName = new CustomTextField();
        textFieldName.setColumns(10);
        btnSave = new CustomButton("Save");
        btnSave.setFont(new Font("Calibri", 3, 15));
        namePanel.add(textName);
        namePanel.add(textFieldName);
        namePanel.add(btnSave);
        add(namePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * This method return the content of TextName.
     * @return TextName.
     */
    public JLabel getTextName() {
        return textName;
    }

    /**
     * This method return the content of textFieldName.
     * @return textFieldName.
     */
    public JTextField getTextFieldName() {
        return textFieldName;
    }
}
