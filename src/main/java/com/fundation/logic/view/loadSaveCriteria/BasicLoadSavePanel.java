/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.loadSaveCriteria;

import com.fundation.logic.view.customElements.CustomPanelSecond;
import com.fundation.logic.view.customElements.CustomButton;
import com.fundation.logic.view.PanelSetter;
import com.fundation.logic.view.customElements.CustomLabel;
import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This class displays the filter fields by date.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class BasicLoadSavePanel extends CustomPanelSecond {
    private PanelSetter settingPanel;
    private CustomButton btnFilterByDate;
    private JDateChooser fieldDateFirstDate;
    private JDateChooser fieldDateSecondDate;

    /**
     *  The constructor let it initializer.
     */
    public BasicLoadSavePanel() {
        dateSearchInitializer();
    }

    /**
     * This method initializes the content of Basic search and also sets it.
     */
    public void dateSearchInitializer() {
        settingPanel = new PanelSetter();
        settingPanel.setPanel(this);
        contentBasicSearch();
    }

    /**
     * This method is responsible for displaying the content of BasicSearchPanel.
     */
    private void contentBasicSearch() {
        CustomLabel title = new CustomLabel("Search Criteria");
        title.setFont(new Font("Arial", Font.PLAIN, 14));
        GridBagConstraints gbc_lblVideo = new GridBagConstraints();
        gbc_lblVideo.gridwidth = 7;
        gbc_lblVideo.insets = new Insets(5, 5, 5, 5);
        gbc_lblVideo.gridx = 0;
        gbc_lblVideo.gridy = 0;
        add(title, gbc_lblVideo);

        CustomLabel lblPath = new CustomLabel("Date saved:");
        GridBagConstraints gbc_lblPath = new GridBagConstraints();
        gbc_lblPath.anchor = GridBagConstraints.EAST;
        gbc_lblPath.insets = new Insets(0, 0, 5, 5);
        gbc_lblPath.gridx = 1;
        gbc_lblPath.gridy = 1;
        add(lblPath, gbc_lblPath);

        fieldDateFirstDate = new JDateChooser();
        GridBagConstraints gbc_FieldToDateCreation = new GridBagConstraints();
        gbc_FieldToDateCreation.insets = new Insets(0, 0, 5, 5);
        gbc_FieldToDateCreation.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldToDateCreation.gridx = 2;
        gbc_FieldToDateCreation.gridy = 1;
        add(fieldDateFirstDate, gbc_FieldToDateCreation);

        fieldDateSecondDate = new JDateChooser();
        GridBagConstraints gbc_FieldToDateSecondDate = new GridBagConstraints();
        gbc_FieldToDateSecondDate.insets = new Insets(0, 0, 5, 5);
        gbc_FieldToDateSecondDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_FieldToDateSecondDate.gridx = 3;
        gbc_FieldToDateSecondDate.gridy = 1;
        add(fieldDateSecondDate, gbc_FieldToDateSecondDate);

        btnFilterByDate = new CustomButton(" Filter ");
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.gridwidth = 1;
        gbc_btnSearch.anchor = GridBagConstraints.NORTH;
        gbc_btnSearch.gridx = 4;
        gbc_btnSearch.gridy = 1;
        add(btnFilterByDate, gbc_btnSearch);
    }

    /**
     * This method returns getBtnFilterByDate.
     * @return getBtnFilterByDate
     */
    public CustomButton getBtnFilterByDate() {
        return btnFilterByDate;
    }

    /**
     * This method returns getFieldDateFirstDate.
     * @return getFieldDateFirstDate
     */
    public JDateChooser getFieldDateFirstDate() {
        return fieldDateFirstDate;
    }

    /**
     * This method returns getFieldDateSecondDate.
     * @return
     */
    public JDateChooser getFieldDateSecondDate() {
        return fieldDateSecondDate;
    }
}