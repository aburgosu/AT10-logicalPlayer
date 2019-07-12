/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.Criteria;

/**
 * Implements the model class Image and the getter and setter´s methods.
 *
 * @authors Andres Burgos.
 * @version 1.1
 */
public class Image {
    private int width;
    private int height;
    private String colorSpaceData;

    /**
     * @return Image Width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set Image Width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return Image Height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set Image Height.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return Image Color Space Data.
     */
    public String getColorSpaceData() {
        return colorSpaceData;
    }

    /**
     * Set Image Color Space Data.
     */
    public void setColorSpaceData(String colorSpaceData) {
        this.colorSpaceData = colorSpaceData;
    }
}
