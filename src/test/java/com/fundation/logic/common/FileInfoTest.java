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

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Implements JsonConverter test class to implement unit tests on its methods..
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class FileInfoTest {

    /**
     * This unit test verify is the file is audio.
     */
    @Test
    public void isAudioTrue(){
        String path = "resources/AudioPronunciacion.MP3";
        boolean actual = FileInfo.isAudio(path);
        assertTrue(actual);
    }

    /**
     * This unit test verify isn't the file is audio.
     */
    @Test
    public void isAudioFalse(){
        String path = "resources/Grammar_posesivo_genitivo.mp4";
        boolean actual = FileInfo.isAudio(path);
        assertFalse(actual);
    }

    /**
     * This unit test verify is the file is image.
     */
    @Test
    public void isImageTrue(){
        String path = "resources/Images/Play.png";
        boolean actual = FileInfo.isImage(path);
        assertTrue(actual);
    }

    /**
     * This unit test verify is the file is video.
     */
    @Test
    public void isVideoTrue(){
        String path = "resources/Grammar_posesivo_genitivo.mp4";
        boolean actual = FileInfo.isVideo(path);
        assertTrue(actual);
    }
}
