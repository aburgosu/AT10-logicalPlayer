/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.convertCriteriaBuilderPattern;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implements tests of ConvertCriteria class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertCriteriaTest {
    ConvertCriteria convertCriteria = new ConvertCriteria.ConvertCriteriaBuilder("resources/TestVideo/Grammar_posesivo_genitivo.mp4",
            "resources/", "converted", "avi", "video").setMetadata("None")
            .setAudioCodec("Default").setAudioBitRate("Default").setAudioChannel("Default").setVideoCodec("Default")
            .setVideoBitRate("Default").setKeyframes("Default").setKeyframeTime("Default").setKeyframeFormat("Default")
            .setFps("Default").setThumbnail("Default").setThumbnailTime("Default").setThumbnailFormat("Default")
            .setFormatColor("Default").setDpi("Default").build();

    /**
     * Verifies source path.
     */
    @Test
    public void getSourcePath_correctResult() {
        String expected = "resources/TestVideo/Grammar_posesivo_genitivo.mp4";
        String actual = convertCriteria.getSourcePath();
        assertEquals(expected, actual);
    }

    /**
     * Verifies destination path.
     */
    @Test
    public void getDestPath_correctResult() {
        String expected = "resources/";
        String actual = convertCriteria.getDestPath();
        assertEquals(expected, actual);
    }

    /**
     * Verifies new name.
     */
    @Test
    public void getNewName_correctResult() {
        String expected = "converted";
        String actual = convertCriteria.getNewName();
        assertEquals(expected, actual);
    }

    /**
     * Verifies metadata.
     */
    @Test
    public void getMetadata_correctResult() {
        String expected = "None";
        String actual = convertCriteria.getMetadata();
        assertEquals(expected, actual);
    }

    /**
     * Verifies new format.
     */
    @Test
    public void getNewFormat_correctResult() {
        String expected = "avi";
        String actual = convertCriteria.getNewFormat();
        assertEquals(expected, actual);
    }

    /**
     * Verifies convert type.
     */
    @Test
    public void getConvertType_correctResult() {
        String expected = "video";
        String actual = convertCriteria.getConvertType();
        assertEquals(expected, actual);
    }


    /**
     * Verifies audio codec.
     */
    @Test
    public void getAudioCodec_correctResult() {
        String expected = "Default";
        String actual = convertCriteria.getAudioCodec();
        assertEquals(expected, actual);
    }

    /**
     * Verifies audio bitrate.
     */
    @Test
    public void getAudioBitRate_correctResult() {
        String expected = "Default";
        String actual = convertCriteria.getAudioBitRate();
        assertEquals(expected, actual);
    }
}
