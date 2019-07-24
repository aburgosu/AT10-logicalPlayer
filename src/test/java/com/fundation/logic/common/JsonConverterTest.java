/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.common;

import com.fundation.logic.model.searchCriteria.Common;
import com.fundation.logic.model.searchCriteria.Criteria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implements JsonConverter test class to implement unit tests on its methods..
 *
 * @author Melissa Román
 * @version 1.0
 */
public class JsonConverterTest {

    /**
     * Compare criteriaToJson method actual return with the expected string.
     */
    @Test
    public void criteriaToJson_compareNewCriteria() {
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
        String actual = JsonConverter.criteriaToJson(commonCriteria);
        String expected = "{\"path\":\"resources/\"}";
        assertEquals(expected, actual);
    }

    /**
     * Compare jsonToCriteria method actual result with expected criteria object.
     */
    @Test
    public void jsonToCriteria_commonCriteria() {
        Common expectedCriteria = new Common();
        expectedCriteria.setPath("resources/");
        expectedCriteria.setFileName(null);
        expectedCriteria.setExtension(null);
        expectedCriteria.setCriteriaFileHidden(null);
        expectedCriteria.setCriteriaFileReadOnly(null);
        expectedCriteria.setCriteriaSizeMin(null);
        expectedCriteria.setCriteriaSizeMax(null);
        expectedCriteria.setCriteriaCreationDateMin(null);
        expectedCriteria.setCriteriaCreationDateMax(null);
        expectedCriteria.setCriteriaAccessDateMin(null);
        expectedCriteria.setCriteriaAccessDateMax(null);
        expectedCriteria.setCriteriaModificationDateMin(null);
        expectedCriteria.setCriteriaModificationDateMax(null);
        expectedCriteria.setCriteriaOwner(null);
        expectedCriteria.setCriteriaMimeType(null);
        String json = "{\"path\":\"resources/\"}";
        Criteria actual = JsonConverter.jsonToCriteria(json, "Common");
        Common actualCommon = (Common) actual;
        assertEquals(expectedCriteria.getPath(), actualCommon.getPath());
        assertEquals(expectedCriteria.getFileName(), actualCommon.getFileName());
        assertEquals(expectedCriteria.getExtension(), actualCommon.getExtension());
        assertEquals(expectedCriteria.getCriteriaFileHidden(), actualCommon.getCriteriaFileHidden());
    }
}