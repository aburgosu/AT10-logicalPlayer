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
 * Implements new MetadataAudioTest class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class MetadataAudioTest {

    /**
     * This unit test verify the correct metadata duration.
     * @throws IOException
     */
    @Test
    public void testDuration() throws IOException {
        String path = "thirdParty/exiftool.exe resources/AudioPronunciacion.MP3";
        MetadataAudioExtractor metadata = new MetadataAudioExtractor();
        Float expected = new Float(0.018055556);
        metadata.run(path);
        Float result = MetadataAudioExtractor.getSearchDuration();
        assertEquals(expected, result);
    }

    /**
     * This unit test verify the correct metadata sampleRate.
     * @throws IOException
     */
    @Test
    public void testSampleRate() throws IOException {
        String path = "thirdParty/exiftool.exe resources/AudioPronunciacion.MP3";
        MetadataAudioExtractor metadata = new MetadataAudioExtractor();
        String expected = "44100 Hz";
        metadata.run(path);
        String result = MetadataAudioExtractor.getSearchSampleRate();
        assertEquals(expected, result);
    }
}
