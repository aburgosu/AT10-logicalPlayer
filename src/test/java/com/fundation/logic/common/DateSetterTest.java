package com.fundation.logic.common;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateSetterTest {
    @Test
    public void DateStarTest(){
        Date fato = new Date(2019, 05,02, 05, 20, 2222);
        Date expected = new Date(2019, 05,02, 00, 00, 00);
        Date actual = DateSetter.setStartOfDay(fato);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void FinalStarTest(){
        Date fato = new Date(2019, 05,02, 05, 20, 20);
        GregorianCalendar cal;
        cal = new GregorianCalendar();
        // discard time of day so we only have the date
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(23));
        cal.set(Calendar.MINUTE, cal.getActualMinimum(59));
        cal.set(Calendar.SECOND, cal.getActualMinimum(59));
        cal.set(Calendar.MILLISECOND, cal.getActualMinimum(999));
        Date format = new Date(String.valueOf(cal.getTime()));
        Date expected = new Date(String.valueOf(format));
        Date actual = DateSetter.setStartOfDay(fato);
        Assert.assertEquals(expected,actual);
    }

}
