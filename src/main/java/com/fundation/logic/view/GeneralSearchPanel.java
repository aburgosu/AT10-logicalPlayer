/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Implements the GeneralSearch Panel.
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class GeneralSearchPanel extends JPanel {
    private final JTextField textFieldOwner;
    private JDateChooser FieldToDateCreation;
    private JDateChooser textFieldFromDateCreation;
    private JDateChooser FieldDateModificationFrom;
    private JDateChooser FieldDateModificationTo;
    private JDateChooser FieldDateAccessFrom;
    private JDateChooser FieldDateAccessTo;
    private JTextField textFieldSizeFrom;
    private JTextField textFieldSizeTo;
    private JButton btnSearch;
    private JCheckBox checkBoxReadOnly;
    private JCheckBox checkBoxHidden;
    private JComboBox comboBoxSizeUnit;
    private JComboBox comboBoxMimetype;

    /**
     * Initializes a SearchTabs instance for the search options
     */
    public GeneralSearchPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{29, 246, 67, 0};
        gridBagLayout.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);


        JLabel lblDateCreation = new JLabel("Creation Date");
        GridBagConstraints gbc_lblDateCreation = new GridBagConstraints();
        gbc_lblDateCreation.anchor = GridBagConstraints.EAST;
        gbc_lblDateCreation.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateCreation.gridx = 0;
        gbc_lblDateCreation.gridy = 3;
        add(lblDateCreation, gbc_lblDateCreation);

        FieldToDateCreation = new JDateChooser();
        GridBagConstraints gbc_FieldToDateCreation = new GridBagConstraints();
        gbc_FieldToDateCreation.insets = new Insets(0, 0, 5, 5);
        gbc_FieldToDateCreation.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldToDateCreation.gridx = 1;
        gbc_FieldToDateCreation.gridy = 4;
        add(getFieldToDateCreation(), gbc_FieldToDateCreation);

        textFieldFromDateCreation = new JDateChooser();
        GridBagConstraints gbc_textFieldToDateCreation = new GridBagConstraints();
        gbc_textFieldToDateCreation.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldToDateCreation.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldToDateCreation.gridx = 1;
        gbc_textFieldToDateCreation.gridy = 3;
        add(textFieldFromDateCreation, gbc_textFieldToDateCreation);

        JLabel lblDateModification = new JLabel("Date Modification: ");
        GridBagConstraints gbc_lblDateModification = new GridBagConstraints();
        gbc_lblDateModification.anchor = GridBagConstraints.EAST;
        gbc_lblDateModification.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateModification.gridx = 0;
        gbc_lblDateModification.gridy = 5;
        add(lblDateModification, gbc_lblDateModification);

        setFieldDateModificationFrom(new JDateChooser());
        GridBagConstraints gbc_FieldDateModificationFrom = new GridBagConstraints();
        gbc_FieldDateModificationFrom.insets = new Insets(0, 0, 5, 5);
        gbc_FieldDateModificationFrom.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldDateModificationFrom.gridx = 1;
        gbc_FieldDateModificationFrom.gridy = 6;
        add(getFieldDateModificationFrom(), gbc_FieldDateModificationFrom);

        setFieldDateModificationTo(new JDateChooser());

        GridBagConstraints gbc_FieldDateModificationTo = new GridBagConstraints();
        gbc_FieldDateModificationTo.insets = new Insets(0, 0, 5, 5);
        gbc_FieldDateModificationTo.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldDateModificationTo.gridx = 1;
        gbc_FieldDateModificationTo.gridy = 5;
        add(getFieldDateModificationTo(), gbc_FieldDateModificationTo);

        JLabel labelDateAccess = new JLabel("Date Access: ");
        GridBagConstraints gbc_labelDateAccess = new GridBagConstraints();
        gbc_labelDateAccess.anchor = GridBagConstraints.EAST;
        gbc_labelDateAccess.insets = new Insets(0, 0, 5, 5);
        gbc_labelDateAccess.gridx = 0;
        gbc_labelDateAccess.gridy = 7;
        add(labelDateAccess, gbc_labelDateAccess);

        setFieldDateAccessFrom(new JDateChooser());
        GridBagConstraints gbc_FieldDateAccessFrom = new GridBagConstraints();
        gbc_FieldDateAccessFrom.insets = new Insets(0, 0, 5, 5);
        gbc_FieldDateAccessFrom.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldDateAccessFrom.gridx = 1;
        gbc_FieldDateAccessFrom.gridy = 8;
        add(getFieldDateAccessFrom(), gbc_FieldDateAccessFrom);

        setFieldDateAccessTo(new JDateChooser());
        GridBagConstraints gbc_FieldDateAccessTo = new GridBagConstraints();
        gbc_FieldDateAccessTo.insets = new Insets(0, 0, 5, 5);
        gbc_FieldDateAccessTo.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldDateAccessTo.gridx = 1;
        gbc_FieldDateAccessTo.gridy = 7;
        add(getFieldDateAccessTo(), gbc_FieldDateAccessTo);

        JLabel labelSize = new JLabel("Size: ");
        GridBagConstraints gbc_labelSize = new GridBagConstraints();
        gbc_labelSize.anchor = GridBagConstraints.EAST;
        gbc_labelSize.insets = new Insets(0, 0, 5, 5);
        gbc_labelSize.gridx = 0;
        gbc_labelSize.gridy = 9;
        add(labelSize, gbc_labelSize);

        setTextFieldSizeFrom(new JTextField());
        getTextFieldSizeFrom().setColumns(10);
        GridBagConstraints gbc_textFieldSizeFrom = new GridBagConstraints();
        gbc_textFieldSizeFrom.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldSizeFrom.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSizeFrom.gridx = 1;
        gbc_textFieldSizeFrom.gridy = 9;
        add(getTextFieldSizeFrom(), gbc_textFieldSizeFrom);

        setTextFieldSizeTo(new JTextField());
        getTextFieldSizeTo().setColumns(10);
        GridBagConstraints gbc_textFieldSizeTo = new GridBagConstraints();
        gbc_textFieldSizeTo.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldSizeTo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSizeTo.gridx = 1;
        gbc_textFieldSizeTo.gridy = 10;
        add(getTextFieldSizeTo(), gbc_textFieldSizeTo);

        JLabel lblSizeUnits = new JLabel("Size units: ");
        GridBagConstraints gbc_lblSizeUnits = new GridBagConstraints();
        gbc_lblSizeUnits.anchor = GridBagConstraints.EAST;
        gbc_lblSizeUnits.insets = new Insets(0, 0, 5, 5);
        gbc_lblSizeUnits.gridx = 0;
        gbc_lblSizeUnits.gridy = 11;
        add(lblSizeUnits, gbc_lblSizeUnits);

        comboBoxSizeUnit = new JComboBox();
        comboBoxSizeUnit.setModel(new DefaultComboBoxModel(new String[] {"Bytes", "KBytes", "MBytes", "GBytes"}));
        GridBagConstraints gbc_comboBoxSizeUnit = new GridBagConstraints();
        gbc_comboBoxSizeUnit.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxSizeUnit.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxSizeUnit.gridx = 1;
        gbc_comboBoxSizeUnit.gridy = 11;
        add(comboBoxSizeUnit, gbc_comboBoxSizeUnit);

        JLabel lblMimetype = new JLabel("Mimetype: ");
        GridBagConstraints gbc_lblMimetype = new GridBagConstraints();
        gbc_lblMimetype.anchor = GridBagConstraints.EAST;
        gbc_lblMimetype.insets = new Insets(0, 0, 5, 5);
        gbc_lblMimetype.gridx = 0;
        gbc_lblMimetype.gridy = 12;
        add(lblMimetype, gbc_lblMimetype);

        comboBoxMimetype = new JComboBox();
        comboBoxMimetype.setModel(new DefaultComboBoxModel(new String[] {"ALL","Audio", "Video", "Image", "Text", "Application"}));
        GridBagConstraints gbc_comboBoxMimetype = new GridBagConstraints();
        gbc_comboBoxMimetype.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxMimetype.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxMimetype.gridx = 1;
        gbc_comboBoxMimetype.gridy = 12;
        add(comboBoxMimetype, gbc_comboBoxMimetype);

        JLabel lblOwner = new JLabel("Owner: ");
        GridBagConstraints gbc_lblOwner = new GridBagConstraints();
        gbc_lblOwner.anchor = GridBagConstraints.EAST;
        gbc_lblOwner.insets = new Insets(0, 0, 5, 5);
        gbc_lblOwner.gridx = 0;
        gbc_lblOwner.gridy = 13;
        add(lblOwner, gbc_lblOwner);

        textFieldOwner = new JTextField();
        GridBagConstraints gbc_textFieldOwner = new GridBagConstraints();
        gbc_textFieldOwner.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldOwner.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldOwner.gridx = 1;
        gbc_textFieldOwner.gridy = 13;
        add(textFieldOwner, gbc_textFieldOwner);
        textFieldOwner.setColumns(10);

        JLabel labelHidden = new JLabel("Hidden: ");
        GridBagConstraints gbc_labelHidden = new GridBagConstraints();
        gbc_labelHidden.anchor = GridBagConstraints.EAST;
        gbc_labelHidden.insets = new Insets(0, 0, 5, 5);
        gbc_labelHidden.gridx = 0;
        gbc_labelHidden.gridy = 14;
        add(labelHidden, gbc_labelHidden);

        checkBoxHidden = new JCheckBox("");
        GridBagConstraints gbc_checkBoxHidden = new GridBagConstraints();
        gbc_checkBoxHidden.anchor = GridBagConstraints.WEST;
        gbc_checkBoxHidden.insets = new Insets(0, 0, 5, 5);
        gbc_checkBoxHidden.gridx = 1;
        gbc_checkBoxHidden.gridy = 14;
        add(checkBoxHidden, gbc_checkBoxHidden);

        JLabel lblReadOnly = new JLabel("Read Only: ");
        GridBagConstraints gbc_lblReadOnly = new GridBagConstraints();
        gbc_lblReadOnly.anchor = GridBagConstraints.EAST;
        gbc_lblReadOnly.insets = new Insets(0, 0, 5, 5);
        gbc_lblReadOnly.gridx = 0;
        gbc_lblReadOnly.gridy = 15;
        add(lblReadOnly, gbc_lblReadOnly);

        checkBoxReadOnly = new JCheckBox("");
        GridBagConstraints gbc_checkBoxReadOnly = new GridBagConstraints();
        gbc_checkBoxReadOnly.anchor = GridBagConstraints.WEST;
        gbc_checkBoxReadOnly.insets = new Insets(0, 0, 5, 5);
        gbc_checkBoxReadOnly.gridx = 1;
        gbc_checkBoxReadOnly.gridy = 15;
        add(checkBoxReadOnly, gbc_checkBoxReadOnly);

        btnSearch = new JButton("Search");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.anchor = GridBagConstraints.EAST;
        gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
        gbc_btnSearch.gridx = 1;
        gbc_btnSearch.gridy = 16;
        add(btnSearch, gbc_btnSearch);
    }

    /**
     * This method return the CommonSearch Button
     */
    public JButton getSearchButton() {
        return btnSearch;
    }

    /**
     * This method return the FieldToDateCreation
     */
    public JDateChooser getFieldToDateCreation() {
        return FieldToDateCreation;
    }

    /**
     * This method return the FieldFromDateCreation
     */
    public JDateChooser getTextFieldFromDateCreation() {
        return textFieldFromDateCreation;
    }
    /**
     * This method return the FieldDateModificationFrom
     */
    public JDateChooser getFieldDateModificationFrom() {
        return FieldDateModificationFrom;
    }

    /**
     * This method return the FieldDateModificationTo
     */
    public JDateChooser getFieldDateModificationTo() {
        return FieldDateModificationTo;
    }

    /**
     * This method return the Field Date Access From
     */
    public JDateChooser getFieldDateAccessFrom() {
        return FieldDateAccessFrom;
    }

    /**
     * This method return the FieldDateModificationTo
     */
    public JDateChooser getFieldDateAccessTo() {
        return FieldDateAccessTo;
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
     * This method return the CheckBox Read Only
     */
    public JCheckBox getCheckBoxReadOnly() {
        return checkBoxReadOnly;
    }

    /**
     * This method return the CheckBox Hidden
     */
    public JCheckBox getCheckBoxHidden() {
        return checkBoxHidden;
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
    public JComboBox getComboBoxMimetype() {
        return comboBoxMimetype;
    }

    /**
     * This method set the Field DateModificationFrom
     */
    public void setFieldDateModificationFrom(JDateChooser fieldDateModificationFrom) {
        FieldDateModificationFrom = fieldDateModificationFrom;
    }

    /**
     * This method set theField DateModificationTo
     */
    public void setFieldDateModificationTo(JDateChooser fieldDateModificationTo) {
        FieldDateModificationTo = fieldDateModificationTo;
    }

    /**
     * This method set the Field DateAccessFrom
     */
    public void setFieldDateAccessFrom(JDateChooser fieldDateAccessFrom) {
        FieldDateAccessFrom = fieldDateAccessFrom;
    }

    /**
     * This method set the Field DateAccessTo
     */
    public void setFieldDateAccessTo(JDateChooser fieldDateAccessTo) {
        FieldDateAccessTo = fieldDateAccessTo;
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
