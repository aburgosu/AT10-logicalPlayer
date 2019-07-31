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
import com.fundation.logic.model.searchCriteria.Audio;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implements CommonSearch class tests.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class AudioSearchTest {

    /**
     * Verifies search methods result.
     */
    @Test
    public void search() {
        Audio audioCriteria = new Audio();
        audioCriteria.setPath("resources/TestAudio/");
        audioCriteria.setFileName(null);
        audioCriteria.setExtension(null);
        audioCriteria.setDurationTo("12:00:00");
        audioCriteria.setDurationFrom("12:00:00");
        audioCriteria.setChannel("All");
        audioCriteria.setAudioCodec("All");
        audioCriteria.setSampleRate("All");
        AudioSearch audioSearch = new AudioSearch(audioCriteria);
        List<CustomFile> actualResult = audioSearch.search();
        CustomFile expectedResult = new CustomFile("resources/TestAudio/", "AudioPronunciacion", "MP3",
                false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }

    /**
     * Verifies searchInPath methods result.
     */
    @Test
    public void searchInPath() {
        Audio audioCriteria = new Audio();
        audioCriteria.setPath("resources/TestAudio/");
        audioCriteria.setFileName(null);
        audioCriteria.setExtension(null);
        audioCriteria.setDurationTo("12:00:00");
        audioCriteria.setDurationFrom("12:00:00");
        audioCriteria.setChannel("All");
        audioCriteria.setAudioCodec("All");
        audioCriteria.setSampleRate("All");
        AudioSearch audioSearch = new AudioSearch(audioCriteria);
        List<CustomFile> actualResult = audioSearch.searchInPath(audioCriteria.getPath());
        CustomFile expectedResult = new CustomFile("resources/TestAudio/", "AudioPronunciacion", "MP3",
                false, false, null, null, null,
                null, null, null, null);
        assertEquals(expectedResult.getName(), actualResult.get(0).getName());
        assertEquals(expectedResult.getExtension(), actualResult.get(0).getExtension());
    }
}