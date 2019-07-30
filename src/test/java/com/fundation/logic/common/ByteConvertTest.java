/**
 * Copyright (c) 2019 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.common;

import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Implements Validator byte comvertions test.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ByteConvertTest {

    /**
     * This unit test verify the path is correct.
     */
    @Test
    public void byteConvertMBytes() {
        Float expected = new Float(1.0);
        Float result = ByteConvert.bytesConvert("1048000","MBytes");
        assertEquals(expected,result);
    }

    /**
     * This unit test verify the path is correct.
     */
    @Test
    public void byteConvertKBytes() {
        Float expected = new Float(1.0);
        Float result = ByteConvert.bytesConvert("1024","KBytes");
        assertEquals(expected,result);
    }

    /**
     * This unit test verify the path is correct.
     */
    @Test
    public void byteConvertGBytes() {
        Float expected = new Float(1.0);
        Float result = ByteConvert.bytesConvert("1240000000","GBytes");
        assertEquals(expected,result);
    }
}


