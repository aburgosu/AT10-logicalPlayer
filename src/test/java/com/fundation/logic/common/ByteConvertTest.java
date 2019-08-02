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

import static junit.framework.TestCase.assertEquals;

/**
 * Implements Validator byte comvertions test.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ByteConvertTest {

    /**
     * This unit test verify the convertion from bytes to MBytes.
     */
    @Test
    public void byteConvertMBytes() {
        Float expected = new Float(3.0);
        Float result = ByteConvert.bytesConvert("3145728", "MBytes");
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the convertion from bytes to KBytes.
     */
    @Test
    public void byteConvertKBytes() {
        Float expected = new Float(1.0);
        Float result = ByteConvert.bytesConvert("1024", "KBytes");
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the convertion from bytes to GBytes.
     */
    @Test
    public void byteConvertGBytes() {
        Float expected = new Float(3.0);
        Float result = ByteConvert.bytesConvert("3221225472", "GBytes");
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the convertion from KBytes to Bytes.
     */
    @Test
    public void toByteConvertFromKBytes() {
        Float expected = new Float(1024);
        Float result = ByteConvert.anyConvertBytes("KBytes", "1");
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the convertion from MBytes to Bytes.
     */
    @Test
    public void toByteConvertFromMBytes() {
        Float expected = new Float(3145728);
        Float result = ByteConvert.anyConvertBytes("MBytes", "3.0");
        assertEquals(expected, result);
    }
}
