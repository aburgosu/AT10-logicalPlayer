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

import java.util.Calendar;
import java.util.Date;

/**
 * Implements DateSetter abstract class which is used to set Date to start of the day and end of day.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class DateSetter {
    /**
     * Allows to get a date from the input and changing the hour to start of the day.
     * @param date - Initial date.
     * @return date with 00:00:00 hour
     */
    public static Date setStartOfDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * Allows to get a date from the input and changing the hour to end of the day.
     * @param date - Initial date.
     * @return date with 23:59:59 hour
     */
    public static Date setEndOfDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }
}
