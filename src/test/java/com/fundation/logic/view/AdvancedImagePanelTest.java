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

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is in charge of displaying Path, filename and type information.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class AdvancedImagePanelTest {

    @Test
    public void getTextFieldWidth() {
        eneralSearchPanel advancedImagePanel = new eneralSearchPanel();
        String expected="";
        String actual=advancedImagePanel.getTextFieldWidth().getText();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFieldHeight() {
        eneralSearchPanel advancedImagePanel = new eneralSearchPanel();
        String expected="";
        String actual= advancedImagePanel.getTextFieldHeight().getText();
        assertEquals(actual,expected);
    }

    @Test
    public void getComboBoxColorSpaceData() {
        eneralSearchPanel advancedImagePanel = new eneralSearchPanel();
        String expected="ALL";
        String actual=(String) advancedImagePanel.getComboBoxColorSpaceData().getSelectedItem();
        assertEquals(actual,expected);
    }
}