/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model;

import com.fundation.logic.common.MetadataVideoExtractor;

import org.junit.Test;
import java.io.File;
import static junit.framework.TestCase.assertEquals;

/**
 * Implements new Video Search class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataVideoExtractorTest {

    //This unit test verify the correct metadata frame rate
    @Test
    public void testFrame() {
        File path = new File("resources/Grammar_posesivo_genitivo.mp4");
        MetadataVideoExtractor metadata = new MetadataVideoExtractor();
        String expected = "30";
        String result = metadata.getFrameRate(path);
        assertEquals(expected, result);
    }

    //This unit test verify the correct metadata duration
    @Test
    public void testDuration() {
        File path = new File("resources/Wildlife.wmv");
        MetadataVideoExtractor metadata = new MetadataVideoExtractor();
        String expected = "0:00:37";
        String result = metadata.getDuration(path);
        assertEquals(expected, result);
    }
}
