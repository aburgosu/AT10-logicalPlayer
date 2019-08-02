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

import com.fundation.logic.model.searchCriteria.Common;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Implements QueryForCriteria test class to implement unit tests on its methods..
 *
 * @author Melissa Román
 * @version 1.0
 */
public class QueryForCriteriaTest {

    /**
     * Test saveCriteria method by comparing last saved criteria with expected criteria.
     */
    @Test
    public void saveCriteria_createNewCriteria_saveOnDB_compareToLastOne() {
        Common commonCriteria = new Common();
        commonCriteria.setPath("resources/");
        commonCriteria.setFileName(null);
        commonCriteria.setExtension(null);
        commonCriteria.setCriteriaFileHidden(null);
        commonCriteria.setCriteriaFileReadOnly(null);
        commonCriteria.setCriteriaSizeMin(null);
        commonCriteria.setCriteriaSizeMax(null);
        commonCriteria.setCriteriaCreationDateMin(null);
        commonCriteria.setCriteriaCreationDateMax(null);
        commonCriteria.setCriteriaAccessDateMin(null);
        commonCriteria.setCriteriaAccessDateMax(null);
        commonCriteria.setCriteriaModificationDateMin(null);
        commonCriteria.setCriteriaModificationDateMax(null);
        commonCriteria.setCriteriaOwner(null);
        commonCriteria.setCriteriaMimeType(null);
        QueryForCriteria queryForCriteria = new QueryForCriteria();
        String idLastCriteria = queryForCriteria.getLastCriteriaRecord().getId();
        int idLast = Integer.parseInt(idLastCriteria) + 1;
        String idLastString = Integer.toString(idLast);
        queryForCriteria.saveCriteria("Criteria Test", commonCriteria, "Common");
        CriteriaRecord actualCriteriaRecord = queryForCriteria.getLastCriteriaRecord();
        CriteriaRecord expectedCriteriaRecord = new CriteriaRecord(idLastString, "Criteria Test",
            "2019-07-29", "Common", "{\"path\":\"resources/\"}");
        assertEquals(expectedCriteriaRecord.getJson(), actualCriteriaRecord.getJson());
        assertEquals(expectedCriteriaRecord.getId(), actualCriteriaRecord.getId());
        assertEquals(expectedCriteriaRecord.getName(), actualCriteriaRecord.getName());
        assertEquals(expectedCriteriaRecord.getType(), actualCriteriaRecord.getType());
        queryForCriteria.deleteById(idLastString);
    }
}
