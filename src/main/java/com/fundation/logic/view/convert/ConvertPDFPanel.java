/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.convert;

import com.fundation.logic.view.customElements.CustomPanelSecond;
import com.fundation.logic.view.customElements.CustomButton;
import com.fundation.logic.view.customElements.CustomCheckBox;
import com.fundation.logic.view.customElements.CustomComboBox;
import com.fundation.logic.view.customElements.CustomLabel;
import com.fundation.logic.view.PanelSetter;

import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Implements convert PDF panel.
 *
 * @author Melissa Román, Maday Alcalá
 * @version 1.0
 */
public class ConvertPDFPanel extends CustomPanelSecond {
    private CustomComboBox comboBoxNewFormat;
    private CustomComboBox comboBoxDpi;
    private CustomComboBox comboBoxColorFormat;
    private CustomCheckBox checkBoxThumbnail;
    private CustomComboBox comboBoxThumbnailFormat;
    private PanelSetter settingPanel;
    private CustomButton btnConvertAudio;

    /**
     * This constructor initializes the component.
     */
    public ConvertPDFPanel() {
        initComponent();
    }

    /**
     * This method initializes the panel with the form.
     */
    public void initComponent() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        showPDFConvertCriteriaForm();
    }

    /**
     * This method show convert PDF form.
     */
    private void showPDFConvertCriteriaForm() {
        CustomLabel lblNewFormat = new CustomLabel("New Format:");
        GridBagConstraints gbc_lblNewFormat = new GridBagConstraints();
        gbc_lblNewFormat.anchor = GridBagConstraints.EAST;
        gbc_lblNewFormat.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewFormat.gridx = 1;
        gbc_lblNewFormat.gridy = 4;
        add(lblNewFormat, gbc_lblNewFormat);

        comboBoxNewFormat = new CustomComboBox();
        comboBoxNewFormat.setModel(new DefaultComboBoxModel(new String[]{"png", "jpg"}));
        GridBagConstraints gbc_comboBoxNewFormat = new GridBagConstraints();
        gbc_comboBoxNewFormat.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxNewFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxNewFormat.gridx = 2;
        gbc_comboBoxNewFormat.gridy = 4;
        add(comboBoxNewFormat, gbc_comboBoxNewFormat);

        CustomLabel lblFormatColor = new CustomLabel("Color Format:");
        GridBagConstraints gbc_lblFormatColor = new GridBagConstraints();
        gbc_lblFormatColor.anchor = GridBagConstraints.EAST;
        gbc_lblFormatColor.insets = new Insets(0, 0, 5, 5);
        gbc_lblFormatColor.gridx = 1;
        gbc_lblFormatColor.gridy = 5;
        add(lblFormatColor, gbc_lblFormatColor);

        comboBoxColorFormat = new CustomComboBox();
        comboBoxColorFormat.setModel(new DefaultComboBoxModel(new String[]{"RGB", "RGBA", "GRAY", "BILEVEL"}));
        GridBagConstraints gbc_comboBoxColorFormat = new GridBagConstraints();
        gbc_comboBoxColorFormat.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxColorFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxColorFormat.gridx = 2;
        gbc_comboBoxColorFormat.gridy = 5;
        add(comboBoxColorFormat, gbc_comboBoxColorFormat);

        CustomLabel lblDpi = new CustomLabel("DPI:");
        GridBagConstraints gbc_lblDpi = new GridBagConstraints();
        gbc_lblDpi.anchor = GridBagConstraints.EAST;
        gbc_lblDpi.insets = new Insets(0, 0, 5, 5);
        gbc_lblDpi.gridx = 1;
        gbc_lblDpi.gridy = 6;
        add(lblDpi, gbc_lblDpi);

        comboBoxDpi = new CustomComboBox();
        comboBoxDpi.setModel(new DefaultComboBoxModel(new String[]{"72", "96", "160", "300", "600", "4000"}));
        GridBagConstraints gbc_comboBoxDpi = new GridBagConstraints();
        gbc_comboBoxDpi.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxDpi.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxDpi.gridx = 2;
        gbc_comboBoxDpi.gridy = 6;
        add(comboBoxDpi, gbc_comboBoxDpi);

        CustomLabel lblThumbnail = new CustomLabel("Thumbnail:");
        GridBagConstraints gbc_lblThumbnail = new GridBagConstraints();
        gbc_lblThumbnail.anchor = GridBagConstraints.EAST;
        gbc_lblThumbnail.insets = new Insets(0, 0, 5, 5);
        gbc_lblThumbnail.gridx = 1;
        gbc_lblThumbnail.gridy = 7;
        add(lblThumbnail, gbc_lblThumbnail);

        checkBoxThumbnail = new CustomCheckBox("");
        GridBagConstraints gbc_checkBoxThumbnail = new GridBagConstraints();
        gbc_checkBoxThumbnail.anchor = GridBagConstraints.WEST;
        gbc_checkBoxThumbnail.insets = new Insets(0, 0, 5, 5);
        gbc_checkBoxThumbnail.gridx = 2;
        gbc_checkBoxThumbnail.gridy = 7;
        add(checkBoxThumbnail, gbc_checkBoxThumbnail);

        CustomLabel lblThumbnailFormat = new CustomLabel("Format: ");
        GridBagConstraints gbc_lblThumbnailFormat = new GridBagConstraints();
        gbc_lblThumbnailFormat.anchor = GridBagConstraints.EAST;
        gbc_lblThumbnailFormat.insets = new Insets(0, 0, 5, 5);
        gbc_lblThumbnailFormat.gridx = 2;
        gbc_lblThumbnailFormat.gridy = 7;
        add(lblThumbnailFormat, gbc_lblThumbnailFormat);

        comboBoxThumbnailFormat = new CustomComboBox();
        comboBoxThumbnailFormat.setModel(new DefaultComboBoxModel(new String[]{"BMP", "PNG", "JPG"}));
        GridBagConstraints gbc_comboBoxThumbnailFormat = new GridBagConstraints();
        gbc_comboBoxThumbnailFormat.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxThumbnailFormat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxThumbnailFormat.gridx = 3;
        gbc_comboBoxThumbnailFormat.gridy = 7;
        add(comboBoxThumbnailFormat, gbc_comboBoxThumbnailFormat);

        btnConvertAudio = new CustomButton("Convert");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.CENTER;
        gbc_btnSearch.insets = new Insets(0, 0, 10, 0);
        gbc_btnSearch.gridwidth = 6;
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 17;
        add(btnConvertAudio, gbc_btnSearch);
    }

    /**
     * Allows to get comboBoxNewFormat.
     * @return
     */
    public CustomComboBox getComboBoxNewFormat() {
        return comboBoxNewFormat;
    }

    /**
     * Allows to get comboBoxNewDpi.
     * @return
     */
    public CustomComboBox getComboBoxDpi() {
        return comboBoxDpi;
    }

    /**
     * Allows to get comboBoxColorFormat.
     * @return
     */
    public CustomComboBox getComboBoxColorFormat() {
        return comboBoxColorFormat;
    }

    /**
     * Allows to get CheckBoxThumbnail.
     * @return
     */
    public CustomCheckBox getCheckBoxThumbnail() {
        return checkBoxThumbnail;
    }

    /**
     * Allows to get ComboBoxThumbnailFormat.
     * @return
     */
    public CustomComboBox getComboBoxThumbnailFormat() {
        return comboBoxThumbnailFormat;
    }

    /**
     * Allows to get comboBoxNewFormat.
     * @return btnConvertAudio
     */
    public CustomButton getBtnConvertAudio() {
        return btnConvertAudio;
    }
}
