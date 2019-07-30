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

/**
 * Implements StringToHour class which is used to get hours, minutes and seconds from a string.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class StringToHour {
    private final static int START_HOUR = 0;
    private final static int END_HOUR = 2;
    private final static int START_MINUTES = 3;
    private final static int END_MINUTES = 5;
    private final static int START_SECONDS = 6;
    private final static int END_SECONDS = 8;

    /**
     * Allows to get hours from string.
     * @param str - String.
     * @return Hours.
     */
    public static int getHours(String str) {
        String hour = str.substring(START_HOUR, END_HOUR);
        return Integer.parseInt(hour);
    }

    /**
     * Allows to get minutes from string.
     * @param str - String.
     * @return Minutes.
     */
    public static int getMinutes(String str) {
        String minutes = str.substring(START_MINUTES, END_MINUTES);
        return Integer.parseInt(minutes);
    }

    /**
     * Allows to get seconds from string.
     * @param str - String.
     * @return Seconds.
     */
    public static int getSeconds(String str) {
        String seconds = str.substring(START_SECONDS, END_SECONDS);
        return Integer.parseInt(seconds);
    }
}

