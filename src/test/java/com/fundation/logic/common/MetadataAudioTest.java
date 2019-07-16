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
 * Implements new MetadataAudioTest class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataAudioTest {

    //This unit test verify the correct metadata duration.
    @Test
    public void testDuration() {
        File path = new File(" resources/AudioPronunciacion.MP3");
        MetadataAudioExtractor metadata = new MetadataAudioExtractor();
        String expected = "0:01:05";
        String result = metadata.getDuration(path);
        assertEquals(expected, result);
    }

    //This unit test verify the correct metadata sampleRate.
    @Test
    public void testSampleRate()
    {
        File path = new File(" resources/AudioPronunciacion.MP3");
        MetadataAudioExtractor metadata = new MetadataAudioExtractor();
        String expected = "44100";
        String result = metadata.getSampleRate(path);
        assertEquals(expected, result);
    }

    //This unit test verify the correct audio channel.
    @Test
    public void testAudioChannel()
    {
        File path = new File(" resources/AudioPronunciacion.MP3");
        MetadataAudioExtractor metadata = new MetadataAudioExtractor();
        String expected = "Mono";
        String result = metadata.getAudioChannel(path);
        assertEquals(expected, result);
    }
}
