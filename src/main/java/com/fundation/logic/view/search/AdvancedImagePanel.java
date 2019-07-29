/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.search;

import com.fundation.logic.view.customElements.CustomPanelSecond;
import com.fundation.logic.view.customElements.CustomButton;
import com.fundation.logic.view.PanelSetter;
import com.fundation.logic.view.customElements.CustomLabel;
import com.fundation.logic.view.customElements.CustomComboBox;
import com.fundation.logic.view.customElements.CustomTextField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.Insets;
import java.awt.Event;
import javax.swing.InputMap;
import java.awt.GridBagConstraints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class show the Advance image in a panel.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class AdvancedImagePanel extends CustomPanelSecond {
    private CustomButton btnSearchAdvanceImage;
    private CustomButton btnSaveAdvanceImage;
    private JTextField textFieldWidth;
    private JTextField textFieldHeight;
    private JComboBox comboBoxColorSpaceData;
    private PanelSetter settingPanel;

    /**
     * This constructor initializer the component.
     */
    public AdvancedImagePanel() {
        initComponent();
    }

    /**
     * This method initializer the set to the panel and content image panel.
     */
    public void initComponent() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        imageContentPanel();
    }

    /**
     * This method show the content panel.
     */
    private void imageContentPanel() {
        JLabel lblWidth = new CustomLabel("Width:");
        GridBagConstraints gbc_lblWidth = new GridBagConstraints();
        gbc_lblWidth.anchor = GridBagConstraints.EAST;
        gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
        gbc_lblWidth.gridx = 1;
        gbc_lblWidth.gridy = 4;
        add(lblWidth, gbc_lblWidth);

        textFieldWidth = new CustomTextField();
        GridBagConstraints gbc_textFieldWith = new GridBagConstraints();
        gbc_textFieldWith.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldWith.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldWith.gridx = 2;
        gbc_textFieldWith.gridy = 4;
        add(textFieldWidth, gbc_textFieldWith);
        InputMap invalidSizeTo = textFieldWidth.getInputMap(JTextField.WHEN_FOCUSED);
        invalidSizeTo.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        textFieldWidth.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char isNumber = e.getKeyChar();
                if (((isNumber < '0') || (isNumber > '9')) && (isNumber != '\b')) {
                    e.consume();
                }
            }
        });

        JLabel lblPixels = new CustomLabel("  pixels");
        GridBagConstraints gbc_lblPixels = new GridBagConstraints();
        gbc_lblPixels.anchor = GridBagConstraints.WEST;
        gbc_lblPixels.insets = new Insets(0, 0, 5, 5);
        gbc_lblPixels.gridx = 3;
        gbc_lblPixels.gridy = 4;
        add(lblPixels, gbc_lblPixels);

        JLabel lblHeight = new CustomLabel("Height:");
        GridBagConstraints gbc_lblHeight = new GridBagConstraints();
        gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
        gbc_lblHeight.anchor = GridBagConstraints.EAST;
        gbc_lblHeight.gridx = 1;
        gbc_lblHeight.gridy = 5;
        add(lblHeight, gbc_lblHeight);

        textFieldHeight = new CustomTextField();
        GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
        gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldWidth.gridx = 2;
        gbc_textFieldWidth.gridy = 5;
        add(textFieldHeight, gbc_textFieldWidth);
        InputMap invalidHeight = textFieldHeight.getInputMap(JTextField.WHEN_FOCUSED);
        invalidHeight.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        textFieldHeight.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char isNumber = e.getKeyChar();
                if (((isNumber < '0') || (isNumber > '9')) && (isNumber != '\b')) {
                    e.consume();
                }
            }
        });

        JLabel lblPixelsH = new CustomLabel("  pixels");
        GridBagConstraints gbc_lblPixelsH = new GridBagConstraints();
        gbc_lblPixelsH.anchor = GridBagConstraints.WEST;
        gbc_lblPixelsH.insets = new Insets(0, 0, 5, 5);
        gbc_lblPixelsH.gridx = 3;
        gbc_lblPixelsH.gridy = 5;
        add(lblPixelsH, gbc_lblPixelsH);

        JLabel lblColorSpaceData = new CustomLabel("Color space data:");
        GridBagConstraints gbc_ColorSpaceData = new GridBagConstraints();
        gbc_ColorSpaceData.anchor = GridBagConstraints.EAST;
        gbc_ColorSpaceData.insets = new Insets(0, 0, 5, 5);
        gbc_ColorSpaceData.gridx = 1;
        gbc_ColorSpaceData.gridy = 6;
        add(lblColorSpaceData, gbc_ColorSpaceData);

        comboBoxColorSpaceData = new CustomComboBox();
        comboBoxColorSpaceData.setModel(new DefaultComboBoxModel(new String[]{"All", "RGB","sRGB", "MCY", "RG", "CMYK"}));
        GridBagConstraints gbc_ComboBoxColorSpaceData = new GridBagConstraints();
        gbc_ComboBoxColorSpaceData.insets = new Insets(0, 0, 5, 0);
        gbc_ComboBoxColorSpaceData.fill = GridBagConstraints.HORIZONTAL;
        gbc_ComboBoxColorSpaceData.gridx = 2;
        gbc_ComboBoxColorSpaceData.gridy = 6;
        add(comboBoxColorSpaceData, gbc_ComboBoxColorSpaceData);

        btnSearchAdvanceImage = new CustomButton("Search");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.gridwidth = 6;
        gbc_btnSearch.anchor = GridBagConstraints.CENTER;
        gbc_btnSearch.insets = new Insets(0, 0, 10, 0);
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 17;
        add(btnSearchAdvanceImage, gbc_btnSearch);

        btnSaveAdvanceImage = new CustomButton("Save");
        GridBagConstraints gbc_btnSaveAdvanceImage = new GridBagConstraints();
        gbc_btnSaveAdvanceImage.gridwidth = 6;
        gbc_btnSaveAdvanceImage.anchor = GridBagConstraints.CENTER;
        gbc_btnSaveAdvanceImage.insets = new Insets(0, 0, 10, 0);
        gbc_btnSaveAdvanceImage.gridx = 4;
        gbc_btnSaveAdvanceImage.gridy = 17;
        add(btnSaveAdvanceImage, gbc_btnSaveAdvanceImage);
    }

    /**
     * This method return btnSearchAdvanceImage.
     * @return
     */
    public JButton getBtnSearchAdvanceImage() {
        return btnSearchAdvanceImage;
    }

    /**
     * This method return textFieldWidth.
     * @return textFieldWidth
     */
    public JTextField getTextFieldWidth() {
        return textFieldWidth;
    }

    /**
     * This method return textFieldHeight.
     * @return textFieldHeight
     */
    public JTextField getTextFieldHeight() {
        return textFieldHeight;
    }

    /**
     * This method return comboBoxColorSpaceData.
     * @return comboBoxColorSpaceData
     */
    public JComboBox getComboBoxColorSpaceData() {
        return comboBoxColorSpaceData;
    }

    /**
     * This method return the btnSaveAdvanceImage button.
     */
    public CustomButton getbtnSaveAdvanceImage() {
        return btnSaveAdvanceImage;
    }
}
