/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implements StringToHour tests.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class StringToHourTest {

    /**
     * Verifies hours result.
     */
    @Test
    public void getHours_correctResult() {
        String str = "12:04:51";
        assertEquals(12, StringToHour.getHours(str));
    }

    /**
     * Verifies minutes result.
     */
    @Test
    public void getMinutes_correctResult() {
        String str = "12:04:51";
        assertEquals(4, StringToHour.getMinutes(str));
    }

    /**
     * Verifies seconds result.
     */
    @Test
    public void getSeconds_correctResult() {
        String str = "12:34:51";
        assertEquals(51, StringToHour.getSeconds(str));
    }
}
