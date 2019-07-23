package com.fundation.logic.model;

import com.fundation.logic.model.searchCriteria.Common;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueryForCriteriaTest {

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
        int idLastCriteria = queryForCriteria.getLastCriteriaRecord().getId();
        queryForCriteria.saveCriteria("Criteria Test", commonCriteria, "Common");
        CriteriaRecord actualCriteriaRecord = queryForCriteria.getLastCriteriaRecord();
        CriteriaRecord expectedCriteriaRecord = new CriteriaRecord((idLastCriteria + 1), "Criteria Test",
            "2019-07-16", "Common", "{\"path\":\"resources/\"}");
        assertTrue(expectedCriteriaRecord.equals(actualCriteriaRecord));
        queryForCriteria.deleteById(idLastCriteria + 1);
    }

    @Test
    public void getAllCriteriaInDB() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void findCriteria() {
    }
}