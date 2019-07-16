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

import com.fundation.logic.common.MetadataImageExtractor;
import org.junit.Test;
import java.io.File;
import static junit.framework.TestCase.assertEquals;

/**
 * Implements new MetadataImageExtractorTest class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataImageExtractorTest {

    @Test
    public void testWidth()
    {
        File path = new File("resources/Images/Play.png");
        MetadataImageExtractor metadata = new MetadataImageExtractor();
        String expected = "35";
        String result = metadata.getWidth(path);
        assertEquals(expected, result);
    }
}
