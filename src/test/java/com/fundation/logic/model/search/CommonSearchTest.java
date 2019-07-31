/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.search;

import com.fundation.logic.model.CustomFile;
import com.fundation.logic.model.searchCriteria.Common;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implements CommonSearch class tests.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CommonSearchTest {

    /**
     * Verifies search methods result.
     */
    @Test
    public void search() {
        Common commonCriteria = new Common();
        commonCriteria.setPath("resources/TestCommon/");
        commonCriteria.setFileName(null);
        commonCriteria.setExtension(null);
        commonCriteria.setCriteriaFileHidden("All");
        commonCriteria.setCriteriaFileReadOnly("All");
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
        CommonSearch commonSearch = new CommonSearch(commonCriteria);
        List<CustomFile> actualResult = commonSearch.search();
        CustomFile expectedResult = new CustomFile("resources/TestCommon/", "testImage", "bmp",
                false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }

    /**
     * Verifies searchInPath method result.
     */
    @Test
    public void searchInPath_correctResult() {
        Common commonCriteria = new Common();
        commonCriteria.setPath("resources/TestCommon/");
        commonCriteria.setFileName(null);
        commonCriteria.setExtension(null);
        commonCriteria.setCriteriaFileHidden("All");
        commonCriteria.setCriteriaFileReadOnly("All");
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
        CommonSearch commonSearch = new CommonSearch(commonCriteria);
        List<CustomFile> actualResult = commonSearch.searchInPath(commonCriteria.getPath());
        CustomFile expectedResult = new CustomFile("resources/TestCommon/", "testImage", "bmp",
                false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }
}
