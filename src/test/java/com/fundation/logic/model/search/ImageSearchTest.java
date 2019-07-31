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
import com.fundation.logic.model.searchCriteria.Image;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implements ImageSearch class tests.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ImageSearchTest {

    /**
     * Verifies search method result.
     */
    @Test
    public void search() {
        Image imageCriteria = new Image();
        imageCriteria.setPath("resources/TestImage/");
        imageCriteria.setFileName(null);
        imageCriteria.setExtension(null);
        imageCriteria.setWidth(304);
        imageCriteria.setHeight(293);
        imageCriteria.setColorSpaceData("All");
        ImageSearch imageSearch = new ImageSearch(imageCriteria);
        List<CustomFile> actualResult = imageSearch.search();
        CustomFile expectedResult = new CustomFile("resources/TestImage/", "testImage", "bmp",
                false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }

    /**
     * Verifies searchInPath method result.
     */
    @Test
    public void searchInPath() {
        Image imageCriteria = new Image();
        imageCriteria.setPath("resources/TestImage/");
        imageCriteria.setFileName(null);
        imageCriteria.setExtension(null);
        imageCriteria.setWidth(304);
        imageCriteria.setHeight(293);
        imageCriteria.setColorSpaceData("All");
        ImageSearch imageSearch = new ImageSearch(imageCriteria);
        List<CustomFile> actualResult = imageSearch.searchInPath(imageCriteria.getPath());
        CustomFile expectedResult = new CustomFile("resources/TestImage/", "testImage", "bmp",
                false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }
}
