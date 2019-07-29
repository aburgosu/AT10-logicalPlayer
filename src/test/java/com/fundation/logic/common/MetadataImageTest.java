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
public class MetadataImageTest {

    /**
     * This unit test verify the correct metadata width.
     * @throws IOException
     */
    @Test
    public void testWidth() throws IOException {
        String path = "thirdParty/exiftool.exe resources/Images/Play.png";
        MetadataImageExtractor metadata = new MetadataImageExtractor();
        String expected = "35";
        metadata.run(path);
        String result = MetadataImageExtractor.getWidth();
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the correct metadata height.
     * @throws IOException
     */
    @Test
    public void testHeight() throws IOException {
        String path ="thirdParty/exiftool.exe resources/Images/Play.png";
        MetadataImageExtractor metadata = new MetadataImageExtractor();
        String expected = "35";
        metadata.run(path);
        String result = MetadataImageExtractor.getHeight();
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the correct metadata color space.
     * @throws IOException
     */
    @Test
    public void testColorSpaceRGB() throws IOException {
        String path = "thirdParty/exiftool.exe resources/Images/Play.png";
        MetadataImageExtractor metadata = new MetadataImageExtractor();
        String expected = "RGB";
        metadata.run(path);
        String result = MetadataImageExtractor.getSearchColorSpace();
        assertEquals(expected, result);
    }
}