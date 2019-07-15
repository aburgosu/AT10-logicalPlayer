/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.criteria;

/**
 * Implements the model class Multimedia and the getter and setter´s methods.
 *
 * @authors Andres Burgos.
 * @version 1.0
 */
public class Multimedia extends Criteria {
    private String audioCodec;
    private int duration;
    private int bitrate;

    /**
     * @return Audio Codec.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * Set Audio Codec.
     */
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * @return Duration.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Set Duration.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return bitrate.
     */
    public int getBitrate() {
        return bitrate;
    }

    /**
     * Set Bitrate.
     */
    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }
}
