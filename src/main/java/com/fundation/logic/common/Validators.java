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

import java.io.File;

/**
 * Implements FileInfo abstract class which is used to get file details.
 *
 * @author Maday Alcalá Cuba
 * @version 1.0
 */
public class Validators {

    /**
     *This method verifies that a path is valid.
     */
    public static boolean isValidPath(String path) {
        File file = new File(path);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
}
