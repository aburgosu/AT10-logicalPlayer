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

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * This class is in charge of displaying Path, filename and type information.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class GeneralSearchPanelTest {

    @Test
    public void getFieldToDateCreation() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        Date expected=null;
        Date actual=generalSearchPanel.getFieldToDateCreation().getDate();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFieldFromDateCreation() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        Date expected=null;
        Date actual=generalSearchPanel.getTextFieldFromDateCreation().getDate();
        assertEquals(actual,expected);
    }

    @Test
    public void getFieldDateModificationFrom() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        Date expected=null;
        Date actual=generalSearchPanel.getFieldDateModificationFrom().getDate();
        assertEquals(actual,expected);
    }

    @Test
    public void getFieldDateModificationTo() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        Date expected=null;
        Date actual=generalSearchPanel.getFieldDateModificationTo().getDate();
        assertEquals(actual,expected);
    }

    @Test
    public void getFieldDateAccessFrom() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        Date expected=null;
        Date actual=generalSearchPanel.getFieldDateAccessFrom().getDate();
        assertEquals(actual,expected);
    }

    @Test
    public void getFieldDateAccessTo() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        Date expected=null;
        Date actual=generalSearchPanel.getFieldDateModificationTo().getDate();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFieldSizeFrom() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        String expected="";
        String actual=generalSearchPanel.getTextFieldSizeFrom().getText();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFieldSizeTo() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        String expected="";
        String actual=generalSearchPanel.getTextFieldSizeTo().getText();
        assertEquals(actual,expected);
    }

    @Test
    public void getCheckBoxReadOnly() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        boolean expected=true;
        boolean actual=generalSearchPanel.getCheckBoxReadOnly().isEnabled();
        assertEquals(actual,expected);
    }

    @Test
    public void getCheckBoxHidden() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        boolean expected=true;
        boolean actual=generalSearchPanel.getCheckBoxHidden().isEnabled();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFieldOwner() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        String expected="";
        String actual=generalSearchPanel.getTextFieldOwner().getText();
        assertEquals(actual,expected);
    }

    @Test
    public void getComboBoxSizeUnit() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        String expected="Bytes";
        String actual=(String) generalSearchPanel.getComboBoxSizeUnit().getSelectedItem();
        assertEquals(actual,expected);
    }

    @Test
    public void getComboBoxMimetype() {
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel();
        String expected="ALL";
        String actual=(String) generalSearchPanel.getComboBoxMimetype().getSelectedItem();
        assertEquals(actual,expected);
    }
}