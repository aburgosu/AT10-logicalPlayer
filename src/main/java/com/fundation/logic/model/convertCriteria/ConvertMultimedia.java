/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.convertCriteria;

/**
 * Implements ConvertMultimedia class which is used us father class to set convert criteria for audio and video.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertMultimedia extends ConvertCriteria{
    private String audioCodec;
    private String audioBitrate;
    private String audioChannel;

    /**
     * Allows to get required audio codec.
     * @return desired audio coded.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * Allows to set desired audio codec.
     * @param audioCodec - Desired audio codec.
     */
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * Allows to get desired audio bitrate.
     * @return required audio bitrate.
     */
    public String getAudioBitrate() {
        return audioBitrate;
    }

    /**
     * Allows to set desired audio bitrate.
     * @param audioBitrate - Desired audio codec.
     */
    public void setAudioBitrate(String audioBitrate) {
        this.audioBitrate = audioBitrate;
    }

    /**
     * Allows to get desired audio channel.
     * @return Desired audio channel.
     */
    public String getAudioChannel() {
        return audioChannel;
    }

    /**
     * Allows to set desired audio channel.
     * @param audioChannel - Desired audio channel.
     */
    public void setAudioChannel(String audioChannel) {
        this.audioChannel = audioChannel;
    }
}
