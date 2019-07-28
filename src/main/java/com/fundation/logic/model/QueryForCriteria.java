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
import com.fundation.logic.model.searchCriteria.Criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implements QueryForCriteria class which is in charge of saving, deleting and retrieving searchCriteria from database.
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
     * Saves given searchCriteria in database.
     * @param criteriaName - Name under which the searchCriteria is saved.
     * @param criteria - The searchCriteria to be saved.
     * @param criteriaType - Criteria's type. It could be Audio, Common, Image or Video.
     */
    public void saveCriteria(String criteriaName, Criteria criteria, String criteriaType) {
        String jsonCriteria = JsonConverter.searchCriteriaToJson(criteria);
        String jsonRecord = criteriaType + " " + jsonCriteria;
        query.insertCriteria(criteriaName, jsonRecord);
    }

    /**
     * Allows to get a list of all searchCriteria saved in the database.
     * @return List of CriteriaRecord objects containing all data from database.
     */
    public List<CriteriaRecord> getAllCriteriaInDB() {
        List criteriaInDB = query.getAllCriteria();
        return registerToCriteriaRecordList(criteriaInDB);
    }

    /**
     * Converts list of registers from database to a list of criteriaRecord objects.
     * @param list - Register list from database.
     * @return List of criteriaRecord objects.
     */
    public List<CriteriaRecord> registerToCriteriaRecordList(List<String> list) {
        List<CriteriaRecord> criteriaRecords = new ArrayList<CriteriaRecord>();
        for (int index = 0; index < list.size(); index++) {
            String DBItem = list.get(index).toString();
            CriteriaRecord record = registerToCriteriaRecord(DBItem);
            criteriaRecords.add(record);
        }
        return criteriaRecords;
    }

    /**
     * Converts a register from database to a CriteriaRecord object.
     * @param DBItem - Register from database.
     * @return CriteriaRecord object.
     */
    public CriteriaRecord registerToCriteriaRecord(String DBItem) {
        final int DATE_LENGTH = 11;
        int indexTabDate = DBItem.indexOf("\t", 3);
        int lastIndexDate = indexTabDate + DATE_LENGTH;
        String date = DBItem.substring(indexTabDate + 1, lastIndexDate);
        int indexTabName = DBItem.indexOf("\t");
        String name = DBItem.substring(indexTabName + 1, indexTabDate);
        String idAux = DBItem.substring(0, indexTabName);
        int id = Integer.parseInt(idAux);
        String json = DBItem.substring(DBItem.indexOf("{"), DBItem.indexOf("}") + 1);
        String type = DBItem.substring(lastIndexDate + 1, DBItem.indexOf("{") - 1);
        CriteriaRecord record = new CriteriaRecord(id, name, date, type, json);
        return record;
    }

    /**
     * Allows to get last criteria saved in database converted to criteriaRecord object.
     * @return Last criteriaRecord saved.
     */
    public CriteriaRecord getLastCriteriaRecord() {
        List<CriteriaRecord> criteriaRecords;
        criteriaRecords = getAllCriteriaInDB();
        int recordsLength = criteriaRecords.size();
        return criteriaRecords.get(recordsLength - 1);
    }

    /**
     * Deletes a register in database based on its id.
     * @param id - Id from register to be deleted.
     */
    public void deleteById(int id) {
        String idToDelete = Integer.toString(id);
        query.deleteByIde(idToDelete);
    }

    /**
     * Finds searchCriteria that were saved between two given dates.
     * @param date1 - Start date.
     * @param date2 - End date.
     */
    public List<CriteriaRecord> findCriteria(Date date1, Date date2) {
        String firstDate = date1.toString();
        String secondDate = date2.toString();
        List filterResult = query.filterByDates(firstDate, secondDate);
        return registerToCriteriaRecordList(filterResult);
    }
}
