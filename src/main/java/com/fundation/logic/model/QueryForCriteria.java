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
import com.fundation.logic.database.Query;
import com.fundation.logic.model.criteria.Criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implements QueryForCriteria class which is in charge to saving, deleting and retrieving criteria from database.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class QueryForCriteria {
    private Query query;

    /**
     * Initializes the query.
     */
    public QueryForCriteria() {
        query = new Query();
    }

    /**
     * Saves given criteria in database.
     * @param criteriaName - Name under which the criteria is saved.
     * @param criteria - The criteria to be saved.
     * @param criteriaType - Criteria's type. It could be Audio, Common, Image or Video.
     */
    public void saveCriteria(String criteriaName, Criteria criteria, String criteriaType) {
        String jsonCriteria = JsonConverter.criteriaToJson(criteria);
        String jsonRecord = criteriaType + " " + jsonCriteria;
        query.insertCriteria(criteriaName, jsonRecord);
    }

    /**
     * Allows to get a list of all criteria saved in the database.
     * @return List of CriteriaRecord objects.
     */
    public List<CriteriaRecord> getAllCriteriaInDB() {
        List<CriteriaRecord> criteriaRecords = new ArrayList<CriteriaRecord>();
        List criteriaInDB = query.getAllCriterias();
        for (int index = 0; index < criteriaInDB.size(); index++) {
            String DBItem = criteriaInDB.get(index).toString();
            int indexTabDate = DBItem.indexOf("\t", 3);
            final int DATE_LENGTH = 11;
            int lastIndexDate = indexTabDate + DATE_LENGTH;
            String date = DBItem.substring(indexTabDate + 1, lastIndexDate);
            int indexTabName = DBItem.indexOf("\t");
            String name = DBItem.substring(indexTabName + 1, indexTabDate);
            String id = DBItem.substring(0, indexTabName);
            String json = DBItem.substring(DBItem.indexOf("{"), DBItem.indexOf("}") + 1);
            String type = DBItem.substring(lastIndexDate + 1, DBItem.indexOf("{") - 1);
            CriteriaRecord record = new CriteriaRecord(id, name, date, type, json);
            criteriaRecords.add(record);
        }
        return criteriaRecords;
    }

    /**
     * Prints all criteria in database.
     */
    public void showCriteriaInDB() {
        List criteria = query.getAllCriterias();
        for (int index = 0; index < criteria.size(); index++) {
            System.out.println(criteria.get(index));
        }
    }

    /**
     * Finds criteria that were saved between two given dates.
     * @param date1 - Start date.
     * @param date2 - End date.
     */
    public void findCriteria(Date date1, Date date2) {
        String firstDate = date1.toString();
        String secondDate = date2.toString();
        List list = query.filterByDates(firstDate, secondDate);
        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }
    }
}
