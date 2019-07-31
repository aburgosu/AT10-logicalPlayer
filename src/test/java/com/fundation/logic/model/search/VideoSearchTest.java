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
import com.fundation.logic.model.searchCriteria.Video;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implements ImageSearch class tests.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class VideoSearchTest {

    /**
     * Verifies search methods result.
     */
    @Test
    public void search() {
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
        VideoSearch videoSearch = new VideoSearch(videoCriteria);
        List<CustomFile> actualResult = videoSearch.search();
        CustomFile expectedResult = new CustomFile("resources/TestVideo/", "Grammar_posesivo_genitivo",
                "mp4", false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }

    /**
     * Verifies searchInPath methods result.
     */
    @Test
    public void searchInPath() {
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
        VideoSearch videoSearch = new VideoSearch(videoCriteria);
        List<CustomFile> actualResult = videoSearch.searchInPath(videoCriteria.getPath());
        CustomFile expectedResult = new CustomFile("resources/TestVideo/", "Grammar_posesivo_genitivo",
                "mp4", false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }
}