/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.criteria;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Implements CriteriaRecord class which is used to get criteria details.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CriteriaRecord {
    String date;
    String name;

    public CriteriaRecord(String date, String name) {
        this.date = date;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }
}
