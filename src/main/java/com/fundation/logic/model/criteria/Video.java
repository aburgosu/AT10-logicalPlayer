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
 * Implements the model class Video and the getter and setter´s methods.
 *
 * @authors Andres Burgos.
 * @version 1.0
 */
public class Video extends Multimedia {
    private String videoCodec;
    private String frameRate;
    private int width;
    private int height;

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
     * @return Width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set Width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return Heigth.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set Audio Height.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Equals override to compare two video criteria.
     * @param criteria - Criteria to be compare with.
     * @return True if two criteria are equal.
     */
    public boolean equals(Criteria criteria) {
        try {
            Video videoCriteria = (Video) criteria;
            if(this.getPath().equals(videoCriteria.getPath()) && this.getFileName().equals(videoCriteria.getFileName())
                    && this.getExtension().equals(videoCriteria.getExtension()) &&
                    this.videoCodec.equals(videoCriteria.videoCodec) &&
                    this.frameRate.equals(videoCriteria.frameRate) && this.width == videoCriteria.width &&
                    this.height == videoCriteria.height) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
