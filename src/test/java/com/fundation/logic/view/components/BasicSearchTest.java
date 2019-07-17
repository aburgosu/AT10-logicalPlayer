/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.components;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is in charge of displaying Path, filename and type information.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class BasicSearchTest {
    @Test
    public void getTextFieldPath() {
        BasicSearch basicSearch = new BasicSearch();
        String expected="";
        String actual=basicSearch.getTextFieldPath().getText();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFileName() {
        BasicSearch basicSearch = new BasicSearch();
        String expected="";
        String actual=basicSearch.getTextFileName().getText();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFieldFileType() {
        BasicSearch basicSearch = new BasicSearch();
        String expected="";
        String actual=basicSearch.getTextFieldFileType().getText();
        assertEquals(actual,expected);
    }

}