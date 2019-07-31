package com.fundation.logic.common;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.HOUR_OF_DAY;

public class DateSetterTest {

    /**
     * This unit test verify the setStartOfDay.
     */
    @Test
    public void DateStarTest(){
        Date dateStart = new Date(2019, 05,02, 05, 20, 22);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateStart);
        cal.set(HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date expected = cal.getTime();
        Date actual = DateSetter.setStartOfDay(dateStart);
        Assert.assertEquals(expected,actual);
    }

    /**
     * This unit test verify the setEndOfDay.
     */
    @Test
    public void EndOfDayTest(){
        Date dateEnd = new Date(2019, 05,02, 05, 20, 22);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateEnd);
        cal.set(HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Date expected = cal.getTime();
        Date actual = DateSetter.setEndOfDay(dateEnd);
        Assert.assertEquals(expected,actual);
    }
}
