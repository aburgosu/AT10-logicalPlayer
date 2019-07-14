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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Implements QueryForCriteria class which is in charge to saving, deleting and retrieving criteria from DB.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class QueryForCriteria {
    private Query query;

    public QueryForCriteria(){
        query = new Query();
    }

    public void saveCriteria(String criteriaName, Criteria criteria, String criteriaType) {
        String jsonCriteria = JsonConverter.criteriaToJson(criteria);
        String jsonRecord = criteriaType + " " + jsonCriteria;
        query.insertCriteria(criteriaName, jsonRecord);
    }

    public List getAllCriteriaInDB(){
        return query.getAllCriterias();
        //convertir a lista de objetos CriteriaRecord
    }

    public void findCriteria(Date date1, Date date2){
        String firstDate = date1.toString();
        String secondDate = date2.toString();
        List list = query.filterByDates(firstDate, secondDate);
        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }
    }
}
