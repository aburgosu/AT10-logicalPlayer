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

/**
 * Implements CriteriaRecord class which is used to save and get criteria details.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CriteriaRecord {
    String id;
    String date;
    String name;
    String type;
    String json;

    /**
     * Constructs a CriteriaRecord object based on given parameters.
     * @param id - Criteria's ID on database.
     * @param date - Date when the criteria was saved.
     * @param name - Name under which the criteria is saved.
     * @param type - Criteria's type. It could be Audio, Common, Image or Video.
     * @param json - The criteria to be saved.
     */
    public CriteriaRecord(String id, String name, String date, String type, String json) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.json = json;
    }

    /**
     * Allows to get criteria's ID.
     * @return Criteria's ID.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Allows to get criteria's name.
     * @return Criteria's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Allows to get the day the criteria was saved.
     * @return Date the criteria was saved.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Allows to get criteria's type
     * @return Criteria's type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Allows to get criteria's json.
     * @return Criteria's json.
     */
    public String getJson() {
        return this.json;
    }
}
