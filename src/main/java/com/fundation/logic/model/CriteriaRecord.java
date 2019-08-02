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

import com.fundation.logic.common.JsonConverter;
import com.fundation.logic.model.searchCriteria.Criteria;

/**
 * Implements CriteriaRecord class which is used to save and get searchCriteria details.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CriteriaRecord {
    private String id;
    private String date;
    private String name;
    private String type;
    private String json;

    /**
     * Constructs a CriteriaRecord object based on given parameters.
     * @param id - Criteria's ID on database.
     * @param date - Date when the searchCriteria was saved.
     * @param name - Name under which the searchCriteria is saved.
     * @param type - Criteria's type. It could be Audio, Common, Image or Video.
     * @param json - The searchCriteria to be saved.
     */
    public CriteriaRecord(String id, String name, String date, String type, String json) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.json = json;
    }

    /**
     * Allows to get searchCriteria's ID.
     * @return Criteria's ID.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Allows to get searchCriteria's name.
     * @return Criteria's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Allows to get the day the searchCriteria was saved.
     * @return Date the searchCriteria was saved.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Allows to get searchCriteria's type.
     * @return Criteria's type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Allows to get searchCriteria's json.
     * @return Criteria's json.
     */
    public String getJson() {
        return this.json;
    }

    /**
     * Allows to get a Criteria instance according to type input.
     * @return Criteria according to type.
     */
    public Criteria getCriteria() {
        return JsonConverter.jsonToSearchCriteria(json, type);
    }
}
