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

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implements the model class File and the getter and setter´s methods
 *
 * @authors Jesus Menacho.
 * @version 1.0
 */
public class SearchVideoTest {
    Criteria criteria;
    SearchVideo searchVideo;
    @Before
    public void initVariables() {
        criteria = new Criteria();
        searchVideo = new SearchVideo(criteria);
    }
    @Test
    public void search_SendPath_ResultTrue() {
        boolean expected = true;
        boolean actual = false;
        SearchVideo search;
        Criteria criteria = new Criteria();
        criteria.setPath("c:/");
        search = new SearchVideo(criteria);
        List<File> foundFiles = search.search();
        for (int index = 0; index < foundFiles.size(); index++) {
            if (foundFiles.get(index).toString().equals("c:\\Windows")) {
                actual = true;
            }
        }
        assertEquals(expected, actual);
    }
    @Test
    public void search_sbyPathAndFile_ResultTrue() {
        boolean expected = true;
        boolean actual = true;
        SearchVideo search;
        Criteria criteria = new Criteria();
        criteria.setPath("c:/");
        criteria.setFileName("$Recycle");
        criteria.setFileHidden(true);
        search = new SearchVideo(criteria);
        List<File> foundFiles = search.search();
        for (int index = 0; index < foundFiles.size(); index++) {
            if (foundFiles.get(index).toString().equals("c:\\$Recycle.Bin")) {
                actual = true;
            }
        }
        assertEquals(expected, actual);
    }
    @Test
    public void FoundAnyFilesbyPathAndFileAndExtencions_ResultTrue() {
        boolean expected = true;
        boolean actual = true;
        SearchVideo search;
        Criteria criteria = new Criteria();
        criteria.setPath("c:/");
        criteria.setExtension(".Bin");
        criteria.setFileName("$Recycle");
        criteria.setFileHidden(true);
        search = new SearchVideo(criteria);
        List<File> foundFiles = search.search();
        for (int index = 0; index < foundFiles.size(); index++) {
            if (foundFiles.get(index).toString().equals("c:\\$Recycle.Bin")) {
                actual = true;
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void FoundAnyFilesbyPathAndFileAndExtencionsAndFileHidden_ResultTrue() {
        boolean expected = true;
        boolean actual = true;
        SearchVideo search;
        Criteria criteria = new Criteria();
        criteria.setPath("c:/");
        criteria.setExtension(".Bin");
        criteria.setFileName("$Recycle");
        criteria.setFileHidden(true);
        search = new SearchVideo(criteria);
        List<File> foundFiles = search.search();
        for (int index = 0; index < foundFiles.size(); index++) {
            if (foundFiles.get(index).toString().equals("c:\\$Recycle.Bin")) {
                actual = true;
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void Search_FoundFilesReadOnlyAndHiddenSelect_ResultTrue() {
        boolean expected = true;
        boolean actual = true;
        SearchVideo search;
        Criteria criteria = new Criteria();
        criteria.setPath("c:/");
        criteria.setFileReadOnly(true);
        criteria.setFileHidden(true);
        search = new SearchVideo(criteria);
        List<File> foundFiles = search.search();
        for (int index = 0; index < foundFiles.size(); index++) {
            if (foundFiles.get(index).toString().equals("c:\\bootmgr")) {
                actual = true;
            }
        }
        assertEquals(expected, actual);
    }
}
