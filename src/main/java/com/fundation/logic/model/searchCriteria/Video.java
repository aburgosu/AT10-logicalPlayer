/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.searchCriteria;

/**
 * Implements the model class Video and the getter and setter´s methods.
 *
 * @authors Andres Burgos.
 * @version 1.0
 */
public class Video extends Multimedia {
    private String videoCodec;
    private String frameRate;
    private String height;

    /**
     * @return Video Codec.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * Set VideoCodec.
     */
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * @return Frame Rate.
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * Set FrameRate.
     */
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * @return Heigth.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Set Height.
     */
    public void setHeight(String height) {
        this.height = height;
    }
}
