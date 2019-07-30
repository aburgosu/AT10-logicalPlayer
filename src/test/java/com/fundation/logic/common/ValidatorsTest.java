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

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Implements Validator unit test.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ValidatorsTest {

    /**
     * This unit test verify the path is correct.
     */
    @Test
    public void validatorTrue() {
        String path = "thirdParty/";
        boolean result = Validators.isValidPath(path);
        assertTrue(result);
    }

    /**
     * This unit test verify the path is incorrect.
     */
    @Test
    public void validatorFalse() {
        String path = "thirdParty/false";
        boolean result = Validators.isValidPath(path);
        assertFalse(result);
    }
}
