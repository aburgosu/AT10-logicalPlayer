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

import com.fundation.logic.view.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * Implements the GeneralSearch Panel.
 *
 * @author Andres Burgos, Jesus Menacho, Melissa Román
 * @version 1.0
 */
public class GeneralSearchPanel extends CustomPanelSecond {
    private JTextField textFieldOwner;
    private JDateChooser fieldToDateCreation;
    private JDateChooser textFieldFromDateCreation;
    private JDateChooser fieldDateModificationFrom;
    private JDateChooser fieldDateModificationTo;
    private JDateChooser fieldDateAccessFrom;
    private JDateChooser fieldDateAccessTo;
    private JTextField textFieldSizeFrom;
    private JTextField textFieldSizeTo;
    private CustomButton btnSearch;
    private JComboBox comboBoxReadOnly;
    private JComboBox comboBoxHidden;
    private JCheckBox checkBoxReadOnly;
    private JCheckBox checkBoxHidden;
    private JComboBox comboBoxSizeUnit;
    private JComboBox comboBoxMimeType;

    /**
     * Initializes a MainTabs instance for the search options
     */
    public GeneralSearchPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 80, 80, 80, 80, 5};
        gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblDateCreation = new CustomLabel("Date created:");
        GridBagConstraints gbc_lblDateCreation = new GridBagConstraints();
        gbc_lblDateCreation.anchor = GridBagConstraints.EAST;
        gbc_lblDateCreation.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateCreation.gridx = 1;
        gbc_lblDateCreation.gridy = 3;
        add(lblDateCreation, gbc_lblDateCreation);

        textFieldFromDateCreation = new JDateChooser();
        GridBagConstraints gbc_textFieldToDateCreation = new GridBagConstraints();
        gbc_textFieldToDateCreation.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldToDateCreation.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldToDateCreation.gridx = 2;
        gbc_textFieldToDateCreation.gridy = 3;
        add(textFieldFromDateCreation, gbc_textFieldToDateCreation);

        fieldToDateCreation = new JDateChooser();
        GridBagConstraints gbc_FieldToDateCreation = new GridBagConstraints();
        gbc_FieldToDateCreation.insets = new Insets(0, 0, 5, 5);
        gbc_FieldToDateCreation.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldToDateCreation.gridx = 3;
        gbc_FieldToDateCreation.gridy = 3;
        add(getFieldToDateCreation(), gbc_FieldToDateCreation);

        JLabel lblDateModification = new CustomLabel("Date modified:");
        GridBagConstraints gbc_lblDateModification = new GridBagConstraints();
        gbc_lblDateModification.anchor = GridBagConstraints.EAST;
        gbc_lblDateModification.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateModification.gridx = 1;
        gbc_lblDateModification.gridy = 4;
        add(lblDateModification, gbc_lblDateModification);

        fieldDateModificationFrom = new JDateChooser();
        GridBagConstraints gbc_FieldDateModificationFrom = new GridBagConstraints();
        gbc_FieldDateModificationFrom.insets = new Insets(0, 0, 5, 5);
        gbc_FieldDateModificationFrom.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldDateModificationFrom.gridx = 2;
        gbc_FieldDateModificationFrom.gridy = 4;
        add(getFieldDateModificationFrom(), gbc_FieldDateModificationFrom);

        fieldDateModificationTo = new JDateChooser();
        GridBagConstraints gbc_FieldDateModificationTo = new GridBagConstraints();
        gbc_FieldDateModificationTo.insets = new Insets(0, 0, 5, 5);
        gbc_FieldDateModificationTo.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldDateModificationTo.gridx = 3;
        gbc_FieldDateModificationTo.gridy = 4;
        add(getFieldDateModificationTo(), gbc_FieldDateModificationTo);

        JLabel labelDateAccess = new CustomLabel("Date last accessed:");
        GridBagConstraints gbc_labelDateAccess = new GridBagConstraints();
        gbc_labelDateAccess.anchor = GridBagConstraints.EAST;
        gbc_labelDateAccess.insets = new Insets(0, 0, 5, 5);
        gbc_labelDateAccess.gridx = 1;
        gbc_labelDateAccess.gridy = 5;
        add(labelDateAccess, gbc_labelDateAccess);

        fieldDateAccessFrom = new JDateChooser();
        GridBagConstraints gbc_FieldDateAccessFrom = new GridBagConstraints();
        gbc_FieldDateAccessFrom.insets = new Insets(0, 0, 5, 5);
        gbc_FieldDateAccessFrom.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldDateAccessFrom.gridx = 2;
        gbc_FieldDateAccessFrom.gridy = 5;
        add(getFieldDateAccessFrom(), gbc_FieldDateAccessFrom);

        fieldDateAccessTo = new JDateChooser();
        GridBagConstraints gbc_FieldDateAccessTo = new GridBagConstraints();
        gbc_FieldDateAccessTo.insets = new Insets(0, 0, 5, 5);
        gbc_FieldDateAccessTo.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldDateAccessTo.gridx = 3;
        gbc_FieldDateAccessTo.gridy = 5;
        add(getFieldDateAccessTo(), gbc_FieldDateAccessTo);

        JLabel labelSize = new CustomLabel("Size: ");
        GridBagConstraints gbc_labelSize = new GridBagConstraints();
        gbc_labelSize.anchor = GridBagConstraints.EAST;
        gbc_labelSize.insets = new Insets(0, 0, 5, 5);
        gbc_labelSize.gridx = 1;
        gbc_labelSize.gridy = 6;
        add(labelSize, gbc_labelSize);

        textFieldSizeFrom = new CustomTextField();
        GridBagConstraints gbc_textFieldSizeFrom = new GridBagConstraints();
        gbc_textFieldSizeFrom.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldSizeFrom.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSizeFrom.gridx = 2;
        gbc_textFieldSizeFrom.gridy = 6;
        add(getTextFieldSizeFrom(), gbc_textFieldSizeFrom);

        textFieldSizeTo = new CustomTextField();
        GridBagConstraints gbc_textFieldSizeTo = new GridBagConstraints();
        gbc_textFieldSizeTo.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldSizeTo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSizeTo.gridx = 3;
        gbc_textFieldSizeTo.gridy = 6;
        add(getTextFieldSizeTo(), gbc_textFieldSizeTo);

        comboBoxSizeUnit = new CustomComboBox();
        comboBoxSizeUnit.setModel(new DefaultComboBoxModel(new String[] {"Bytes", "KBytes", "MBytes", "GBytes"}));
        GridBagConstraints gbc_comboBoxSizeUnit = new GridBagConstraints();
        gbc_comboBoxSizeUnit.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxSizeUnit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxSizeUnit.gridx = 4;
        gbc_comboBoxSizeUnit.gridy = 6;
        add(comboBoxSizeUnit, gbc_comboBoxSizeUnit);

        JLabel lblMimeType = new CustomLabel("Mime type:");
        GridBagConstraints gbc_lblMimeType = new GridBagConstraints();
        gbc_lblMimeType.anchor = GridBagConstraints.EAST;
        gbc_lblMimeType.insets = new Insets(0, 0, 5, 5);
        gbc_lblMimeType.gridx = 1;
        gbc_lblMimeType.gridy = 7;
        add(lblMimeType, gbc_lblMimeType);

        comboBoxMimeType = new CustomComboBox();
        comboBoxMimeType.setModel(new DefaultComboBoxModel(new String[] {"All","Audio", "Video", "Image", "Text",
            "Application"}));
        GridBagConstraints gbc_comboBoxMimeType = new GridBagConstraints();
        gbc_comboBoxMimeType.gridwidth = 2;
        gbc_comboBoxMimeType.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxMimeType.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxMimeType.gridx = 2;
        gbc_comboBoxMimeType.gridy = 7;
        add(comboBoxMimeType, gbc_comboBoxMimeType);

        JLabel lblOwner = new CustomLabel("Owner:");
        GridBagConstraints gbc_lblOwner = new GridBagConstraints();
        gbc_lblOwner.anchor = GridBagConstraints.EAST;
        gbc_lblOwner.insets = new Insets(0, 0, 5, 5);
        gbc_lblOwner.gridx = 1;
        gbc_lblOwner.gridy = 8;
        add(lblOwner, gbc_lblOwner);

        textFieldOwner = new CustomTextField();
        GridBagConstraints gbc_textFieldOwner = new GridBagConstraints();
        gbc_textFieldOwner.gridwidth = 2;
        gbc_textFieldOwner.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldOwner.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldOwner.gridx = 2;
        gbc_textFieldOwner.gridy = 8;
        add(textFieldOwner, gbc_textFieldOwner);

        JLabel labelHidden = new CustomLabel("Hidden:");
        GridBagConstraints gbc_labelHidden = new GridBagConstraints();
        gbc_labelHidden.anchor = GridBagConstraints.EAST;
        gbc_labelHidden.insets = new Insets(0, 0, 5, 5);
        gbc_labelHidden.gridx = 1;
        gbc_labelHidden.gridy = 14;
        add(labelHidden, gbc_labelHidden);

        checkBoxHidden = new CustomCheckBox("");
        GridBagConstraints gbc_checkBoxHidden = new GridBagConstraints();
        gbc_checkBoxHidden.anchor = GridBagConstraints.WEST;
        gbc_checkBoxHidden.insets = new Insets(0, 0, 5, 5);
        gbc_checkBoxHidden.gridx = 2;
        gbc_checkBoxHidden.gridy = 14;
        add(checkBoxHidden, gbc_checkBoxHidden);

        comboBoxHidden = new JComboBox();
        comboBoxHidden.setModel(new DefaultComboBoxModel(new String[] {"All", "Only hidden", "All but hidden"}));
        GridBagConstraints gbc_comboBoxHidden = new GridBagConstraints();
        gbc_comboBoxHidden.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxHidden.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxHidden.gridx = 2;
        gbc_comboBoxHidden.gridy = 14;
        add(comboBoxHidden, gbc_comboBoxHidden);

        JLabel lblReadOnly = new CustomLabel("Read only:");
        GridBagConstraints gbc_lblReadOnly = new GridBagConstraints();
        gbc_lblReadOnly.anchor = GridBagConstraints.EAST;
        gbc_lblReadOnly.insets = new Insets(0, 0, 5, 5);
        gbc_lblReadOnly.gridx = 1;
        gbc_lblReadOnly.gridy = 15;
        add(lblReadOnly, gbc_lblReadOnly);

        checkBoxReadOnly = new CustomCheckBox("");
        GridBagConstraints gbc_checkBoxReadOnly = new GridBagConstraints();
        gbc_checkBoxReadOnly.anchor = GridBagConstraints.WEST;
        gbc_checkBoxReadOnly.insets = new Insets(0, 0, 5, 5);
        gbc_checkBoxReadOnly.gridx = 2;
        gbc_checkBoxReadOnly.gridy = 15;
        add(checkBoxReadOnly, gbc_checkBoxReadOnly);

        comboBoxReadOnly = new JComboBox();
        comboBoxReadOnly.setModel(new DefaultComboBoxModel(new String[] {"All", "Only read-only", "All but read-only"}));
        GridBagConstraints gbc_comboBoxReadOnly = new GridBagConstraints();
        gbc_comboBoxReadOnly.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxReadOnly.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxReadOnly.gridx = 2;
        gbc_comboBoxReadOnly.gridy = 15;
        add(comboBoxReadOnly, gbc_comboBoxReadOnly);

        btnSearch = new CustomButton("Search");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.gridwidth = 6;
        gbc_btnSearch.anchor = GridBagConstraints.CENTER;
        gbc_btnSearch.insets = new Insets(0, 0, 10, 0);
        gbc_btnSearch.gridx = 0;
        gbc_btnSearch.gridy = 17;
        add(btnSearch, gbc_btnSearch);
    }

    /**
     * This method return the CommonSearch Button
     */
    public JButton getSearchButton() {
        return btnSearch;
    }

    /**
     * This method return the fieldToDateCreation
     */
    public JDateChooser getFieldToDateCreation() {
        return fieldToDateCreation;
    }

    /**
     * This method return the FieldFromDateCreation
     */
    public JDateChooser getTextFieldFromDateCreation() {
        return textFieldFromDateCreation;
    }
    /**
     * This method return the fieldDateModificationFrom
     */
    public JDateChooser getFieldDateModificationFrom() {
        return fieldDateModificationFrom;
    }

    /**
     * This method return the fieldDateModificationTo
     */
    public JDateChooser getFieldDateModificationTo() {
        return fieldDateModificationTo;
    }

    /**
     * This method return the Field Date Access From
     */
    public JDateChooser getFieldDateAccessFrom() {
        return fieldDateAccessFrom;
    }

    /**
     * This method return the fieldDateModificationTo
     */
    public JDateChooser getFieldDateAccessTo() {
        return fieldDateAccessTo;
    }

    /**
     * This method return the Field SizeFrom
     */
    public JTextField getTextFieldSizeFrom() {
        return textFieldSizeFrom;
    }

    /**
     * This method return the Field SizeTo
     */
    public JTextField getTextFieldSizeTo() {
        return textFieldSizeTo;
    }

    /**
     * This method return the ComboBox Read Only
     */
    public JComboBox getComboBoxReadOnly() {
        return comboBoxReadOnly;
    }

    /**
     * This method return the ComboBox Hidden
     */
    public JComboBox getComboBoxHidden() {
        return comboBoxHidden;
    }

    /**
     * This method return the TextField Owner
     */
    public JTextField getTextFieldOwner() {
        return textFieldOwner;
    }

    /**
     * This method return the ComboBox SizeUnit
     */
    public JComboBox getComboBoxSizeUnit() {
        return comboBoxSizeUnit;
    }

    /**
     * This method return the ComboBox Mimetype
     */
    public JComboBox getComboBoxMimeType() {
        return comboBoxMimeType;
    }

    /**
     * This method set the Field DateModificationFrom
     */
    public void setFieldDateModificationFrom(JDateChooser fieldDateModificationFrom) {
        this.fieldDateModificationFrom = fieldDateModificationFrom;
    }

    /**
     * This method set theField DateModificationTo
     */
    public void setFieldDateModificationTo(JDateChooser fieldDateModificationTo) {
        this.fieldDateModificationTo = fieldDateModificationTo;
    }

    /**
     * This method set the Field DateAccessFrom
     */
    public void setFieldDateAccessFrom(JDateChooser fieldDateAccessFrom) {
        this.fieldDateAccessFrom = fieldDateAccessFrom;
    }

    /**
     * This method set the Field DateAccessTo
     */
    public void setFieldDateAccessTo(JDateChooser fieldDateAccessTo) {
        this.fieldDateAccessTo = fieldDateAccessTo;
    }

    /**
     * This method set the TextField SizeFrom
     */
    public void setTextFieldSizeFrom(JTextField textFieldSizeFrom) {
        this.textFieldSizeFrom = textFieldSizeFrom;
    }

    /**
     * This method set the TextField SizeTo
     */
    public void setTextFieldSizeTo(JTextField textFieldSizeTo) {
        this.textFieldSizeTo = textFieldSizeTo;
    }
}
