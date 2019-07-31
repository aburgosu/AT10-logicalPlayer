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

import com.fundation.logic.model.searchCriteria.Audio;
import com.fundation.logic.model.searchCriteria.Common;
import com.fundation.logic.model.searchCriteria.Image;
import com.fundation.logic.model.searchCriteria.Video;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Implements ImageSearch class tests.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class SearchFactoryTest {

    /**
     * Verifies createSearch output when input is a Common criteria.
     */
    @Test
    public void createSearch_common() {
        SearchFactory searchFactory = new SearchFactory();
        Common commonCriteria = new Common();
        assertTrue(searchFactory.createSearch(commonCriteria) instanceof CommonSearch);
    }

    /**
     * Verifies createSearch output when input is an Image criteria.
     */
    @Test
    public void createSearch_image() {
        SearchFactory searchFactory = new SearchFactory();
        Image imageCriteria = new Image();
        assertTrue(searchFactory.createSearch(imageCriteria) instanceof ImageSearch);
    }

    /**
     * Verifies createSearch output when input is an Audio criteria.
     */
    @Test
    public void createSearch_audio() {
        SearchFactory searchFactory = new SearchFactory();
        Audio audioCriteria = new Audio();
        assertTrue(searchFactory.createSearch(audioCriteria) instanceof AudioSearch);
    }

    /**
     * Verifies createSearch output when input is a Video criteria.
     */
    @Test
    public void createSearch_video() {
        SearchFactory searchFactory = new SearchFactory();
        Video videoCriteria = new Video();
        assertTrue(searchFactory.createSearch(videoCriteria) instanceof VideoSearch);
    }
}
