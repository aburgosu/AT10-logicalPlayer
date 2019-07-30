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
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Implements new Video Search class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataVideoTest {

    /**
     * This unit test verify the correct metadata frame rate.
     * @throws IOException
     */
    @Test
    public void testFrame() throws IOException {
        String path = "thirdParty/exiftool.exe resources/Grammar_posesivo_genitivo.mp4";
        MetadataVideoExtractor metadata = new MetadataVideoExtractor();
        String expected = "30";
        metadata.run(path);
        String result = MetadataVideoExtractor.getSearchFrameRate();
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the correct metadata duration
     * @throws IOException
     */
    @Test
    public void testDuration() throws IOException {
        String path = "thirdParty/exiftool.exe resources/Wildlife.wmv";
        MetadataVideoExtractor metadata = new MetadataVideoExtractor();
        Float expected =new Float(0.010555555);
        metadata.run(path);
        Float result = MetadataVideoExtractor.getSearchDuration();
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the correct metadata file type wmv.
      * @throws IOException
     */
    @Test
    public void testFileMimeTypeVideo() throws IOException {
        String path = "thirdParty/exiftool.exe resources/Wildlife.wmv";
        MetadataVideoExtractor metadata = new MetadataVideoExtractor();
        String expected = "Video";
        metadata.run(path);
        String result = MetadataVideoExtractor.getSearchMimeType();
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the correct metadata image height.
     * @throws IOException
     */
    @Test
    public void testHeight() throws IOException {
        String path ="thirdParty/exiftool.exe resources/Wildlife.wmv";
        MetadataVideoExtractor metadata = new MetadataVideoExtractor();
        String expected = "720";
        metadata.run(path);
        String result = MetadataVideoExtractor.getSearchHeight();
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the correct metadata video codec.
     * @throws IOException
     */
    @Test
    public void testVideoCodec() throws IOException {
        String path ="thirdParty/exiftool.exe resources/Wildlife.wmv";
        MetadataVideoExtractor metadata = new MetadataVideoExtractor();
        String expected = "WMV";
        metadata.run(path);
        String result = MetadataVideoExtractor.getSearchVideoCodec();
        assertEquals(expected, result);
    }
}
