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

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;
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

    /**
     * This unit test verify mime type video.
     */
    @Test
    public void mimeTypeVideo(){
        File path = new File("resources/Grammar_posesivo_genitivo.mp4");
        String actual = FileInfo.getMimeType(path);
        String expected = "video/mp4";
        assertEquals(expected,actual);
    }

    /**
     * This unit test verify file date.
     */
    @Test
    public void fileDate() throws ParseException {
        File path = new File("resources/Grammar_posesivo_genitivo.mp4");
        Date actualDate = FileInfo.getFileDate(path,"creation");
        String actual = actualDate.toString();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateHour = "2019-07-30 09:56:55";
        Date expectedDate = date.parse(dateHour);
        String expected = expectedDate.toString();
        assertEquals(expected,actual);
    }

    /**
     * This unit test verify file size.
     */
    @Test
    public void sizeFile() {
        File path = new File("resources/Grammar_posesivo_genitivo.mp4");
        Float actual = FileInfo.getFileSize(path);
        Float expected = new Float(4335709.0);
        assertEquals(expected,actual);
    }
}
