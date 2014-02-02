package com.sport.coach.utils;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author luku00
 */
public class ConvertionUtilTest {

    public ConvertionUtilTest() {
    }


    /**
     * Test of convertSecondsToTimeString method, of class ConvertionUtil.
     */
    @Test
    public void testConvertSecondsToTimeString() {
        System.out.println("convertSecondsToTimeString");
        Long sec = 4207l;
        String expResult = "1:10:7";
        String result = ConvertionUtil.convertSecondsToTimeString(sec);
        assertEquals(expResult, result);
    }

}
