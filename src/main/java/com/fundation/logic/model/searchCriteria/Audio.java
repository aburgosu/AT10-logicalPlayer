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
public class Audio extends Multimedia {
    private String channel;
    private String sampleRate;

    /**
     * @return Audio Channel.
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Set Audio Channel.
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * @return Audio Sample Rate.
     */
    public String  getSampleRate() {
        return sampleRate;
    }

    /**
     * Set Audio Sample Rate.
     */
    public void setSampleRate(String  sampleRate) {
        this.sampleRate = sampleRate;
    }
}
