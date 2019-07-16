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
import static junit.framework.TestCase.assertEquals;

/**
 * Implements new MetadataImageTest class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataImageTest {

    //This unit test verify the correct metadata width.
    @Test
    public void testWidth()
    {
        File path = new File("resources/Images/Play.png");
        MetadataImageExtractor metadata = new MetadataImageExtractor();
        String expected = "35";
        String result = metadata.getWidth(path);
        assertEquals(expected, result);
    }

    //This unit test verify the correct metadata height.
    @Test
    public void testHeight() {
        File path = new File("resources/Images/Play.png");
        MetadataImageExtractor metadata = new MetadataImageExtractor();
        String expected = "35";
        String result = metadata.getHeight(path);
        assertEquals(expected, result);
    }

    //This unit test verify the correct metadata color space.
    @Test
    public void testColorSpaceRGB() {
        File path = new File("resources/Images/Play.png");
        MetadataImageExtractor metadata = new MetadataImageExtractor();
        String expected = "RGB";
        String result = metadata.getColorSpace(path);
        assertEquals(expected, result);
    }
}
