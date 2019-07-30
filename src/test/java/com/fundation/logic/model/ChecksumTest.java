/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class serves as unit test class for checksum class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class ChecksumTest {
    @Test
    public void getChecksum() throws Exception {
        String filename = "resources/Research Data Types.pdf";
        String algorithm = "MD5";
        String actual = Checksum.getChecksum(filename, algorithm);
        String expected = "42c0e7c9c36230a917b30ea942cdd0ba";
        assertEquals(expected, actual);
    }
}
