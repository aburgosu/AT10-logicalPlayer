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
import com.fundation.logic.model.searchCriteria.Audio;
import com.fundation.logic.model.searchCriteria.Common;
import com.fundation.logic.model.searchCriteria.Image;
import com.fundation.logic.model.searchCriteria.Video;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implements tests of SearchController methods.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class SearchControllerTest {

    /**
     * This tests verifies makeSearch method by searching according to a common criteria.
     */
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
        CustomFile expectedResult = new CustomFile("resources/TestCommon/", "testImage", "bmp",
                false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }

    /**
     * This tests verifies makeSearch method by searching according to an image criteria.
     */
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
        CustomFile expectedResult = new CustomFile("resources/TestImage/", "testImage", "bmp",
                false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }

    /**
     * This tests verifies makeSearch method by searching according to an audio criteria.
     */
    @Test
    public void makeSearch_audioSearch() {
        Audio audioCriteria = new Audio();
        audioCriteria.setPath("resources/TestAudio/");
        audioCriteria.setFileName(null);
        audioCriteria.setExtension(null);
        audioCriteria.setDurationTo("12:00:00");
        audioCriteria.setDurationFrom("12:00:00");
        audioCriteria.setChannel("All");
        audioCriteria.setAudioCodec("All");
        audioCriteria.setSampleRate("All");
        SearchController searchController = new SearchController();
        List<CustomFile> actualResult = searchController.makeSearch(audioCriteria);
        CustomFile expectedResult = new CustomFile("resources/TestAudio/", "AudioPronunciacion", "MP3",
                false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }

    /**
     * This tests verifies makeSearch method by searching according to a video criteria.
     */
    @Test
    public void makeSearch_videoSearch() {
        Video videoCriteria = new Video();
        videoCriteria.setPath("resources/TestVideo/");
        videoCriteria.setFileName(null);
        videoCriteria.setExtension(null);
        videoCriteria.setDurationTo("12:00:00");
        videoCriteria.setDurationFrom("12:00:00");
        videoCriteria.setAudioCodec("All");
        videoCriteria.setVideoCodec("All");
        videoCriteria.setFrameRate("All");
        videoCriteria.setHeight("All");
        SearchController searchController = new SearchController();
        List<CustomFile> actualResult = searchController.makeSearch(videoCriteria);
        CustomFile expectedResult = new CustomFile("resources/TestVideo/", "Grammar_posesivo_genitivo",
                "mp4", false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }
}
