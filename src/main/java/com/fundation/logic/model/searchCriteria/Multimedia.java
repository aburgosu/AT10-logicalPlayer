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
 * Implements the model class Multimedia and the getter and setter´s methods.
 *
 * @authors Andres Burgos.
 * @version 1.0
 */
public abstract class Multimedia extends Criteria {
    private String audioCodec;
    private String durationFrom;
    private String durationTo;

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
     * Allows to get durationFrom.
     * @return durationFrom.
     */
    public String getDurationFrom() {
        return durationFrom;
    }

    /**
     * Allows to set durationFrom.
     * @param durationFrom - Lower limit to find by duration.
     */
    public void setDurationFrom(String durationFrom) {
        this.durationFrom = durationFrom;
    }

    /**
     * Allows to get durationTo.
     * @return durationTo.
     */
    public String getDurationTo() {
        return durationTo;
    }

    /**
     * Allows to set durationTo.
     * @param durationTo - Upper limit to find by duration.
     */
    public void setDurationTo(String durationTo) {
        this.durationTo = durationTo;
    }
}
