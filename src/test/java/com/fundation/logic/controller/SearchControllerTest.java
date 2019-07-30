/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.controller;

import com.fundation.logic.model.CustomFile;
import com.fundation.logic.model.searchCriteria.Common;
import com.fundation.logic.model.searchCriteria.Image;
import com.fundation.logic.view.MainFrame;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Implements tests of SearchController methods.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class SearchControllerTest {

    @Test
    public void makeSearch_commonSearch() {
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
        SearchController searchController = new SearchController();
        List<CustomFile> actualResult = searchController.makeSearch(commonCriteria);
        CustomFile expectedResult = new CustomFile("resources/Test/", "testImage", "bmp",
                false, false, null, null, null,
                null, null, "null", null);
        assertTrue(expectedResult.getName().equals(actualResult.get(0).getName()));
        assertTrue(expectedResult.getExtension().equals(actualResult.get(0).getExtension()));
    }

    @Test
    public void makeSearch_imageSearch() {
        Image imageCriteria = new Image();
        imageCriteria.setPath("resources/TestImage/");
        imageCriteria.setFileName(null);
        imageCriteria.setExtension(null);
        imageCriteria.setWidth(304);
        imageCriteria.setHeight(293);
        imageCriteria.setColorSpaceData("All");
        SearchController searchController = new SearchController();
        List<CustomFile> actualResult = searchController.makeSearch(imageCriteria);
        CustomFile expectedResult = new CustomFile("resources/Test/", "testImage", "bmp",
                false, false, null, null, null,
                null, null, "null", null);
        System.out.println("Results length: " + actualResult.size());
        assertTrue(expectedResult.getName().equals(actualResult.get(0).getName()));
        assertTrue(expectedResult.getExtension().equals(actualResult.get(0).getExtension()));
    }

    @Test
    public void showSearchResult() {
    }

    @Test
    public void getCommonCriteria() {
    }

    @Test
    public void getImageCriteria() {
    }

    @Test
    public void getAudioCriteria() {
    }

    @Test
    public void getVideoCriteria() {
    }

    @Test
    public void listenSearchButtons() {
    }
}