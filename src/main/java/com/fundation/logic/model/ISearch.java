/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model;

import java.io.File;
import java.util.List;

/**
 * Implements the model class File and the getter and setter´s methods
 *
 * @author Andres Burgos
 * @version 1.0 *
 */
public interface ISearch {
    List<File> search() throws Exception;
}
