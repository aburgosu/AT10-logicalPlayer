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
 * Implements the model class Audio and the getter and setter´s methods.
 *
 * @authors Andres Burgos.
 * @version 1.0
 */
public class Audio extends Multimedia{
    private int channel;
    private int sampleRate;

    /**
     * @return Audio Channel.
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Set Audio Channel.
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * @return Audio Sample Rate.
     */
    public int getSampleRate() {
        return sampleRate;
    }

    /**
     * Set Audio Sample Rate.
     */
    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    /**
     * Equals override to compare two audio searchCriteria.
     * @param criteria - Criteria to be compare with.
     * @return True if two searchCriteria are equal.
     */
    public boolean equals(Criteria criteria) {
        try {
            Audio audioCriteria = (Audio) criteria;
            if(this.getPath().equals(audioCriteria.getPath()) && this.getFileName().equals(audioCriteria.getFileName())
                    && this.getExtension().equals(audioCriteria.getExtension()) &&
                    this.channel == audioCriteria.channel && this.sampleRate == audioCriteria.sampleRate) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
