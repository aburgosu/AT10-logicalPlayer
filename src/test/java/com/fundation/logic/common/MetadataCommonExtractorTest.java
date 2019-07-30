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
 * Implements new MetadataImageTest class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataCommonExtractorTest {

    /**
     * This unit test verify the correct metadata mime type.
     * @throws IOException
     */
    @Test
    public void mimeTypeVideo() throws IOException {
        MetadataCommonExtractor metadataCommonExtractor = new MetadataCommonExtractor();
        String path = "thirdParty/exiftool.exe resources/Grammar_posesivo_genitivo.mp4";
        metadataCommonExtractor.run(path);
        String expected = "Video";
        String actual = MetadataCommonExtractor.getSearchMimeType();
        assertEquals(expected, actual);
    }
}