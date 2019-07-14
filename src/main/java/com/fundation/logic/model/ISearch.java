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

import java.util.List;

/**
 * Implements ISearch interface with search method.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public interface ISearch {

    /**
     * @return CommonSearch result, list of found files.
     */
    List search();
}
