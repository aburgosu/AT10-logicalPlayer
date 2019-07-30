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
     * Equals override to be implemented in subclasses.
     * @param criteria - Criteria to be compare with.
     * @return True if two searchCriteria are equal.
     */
    public abstract boolean equals(Criteria criteria);
}
