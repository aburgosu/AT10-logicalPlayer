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
 * Implements the model class Image and the getter and setter´s methods.
 *
 * @authors Andres Burgos
 * @version 1.0
 */
public class Image extends Criteria {
    private int width;
    private int height;
    private String colorSpaceData;

    /**
     * @return Image Width.
     */
    public String getWidth() {
        return Integer.toString(width);
    }

    /**
     * Sets Image Width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return Image Height.
     */
    public String getHeight() {
        return Integer.toString(height);
    }

    /**
     * Sets Image Height.
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
     * Sets Image Color Space Data.
     */
    public void setColorSpaceData(String colorSpaceData) {
        this.colorSpaceData = colorSpaceData;
    }

    /**
     * Equals override to compare two image searchCriteria.
     * @param criteria - Criteria to be compare with.
     * @return True if two searchCriteria are equal.
     */
    public boolean equals(Criteria criteria) {
        try {
            Image imageCriteria = (Image) criteria;
            if(this.getPath().equals(imageCriteria.getPath()) && this.getFileName().equals(imageCriteria.getFileName())
                    && this.getExtension().equals(imageCriteria.getExtension()) &&
                    this.width == imageCriteria.width && this.height == imageCriteria.height &&
                    this.colorSpaceData.equals(imageCriteria.colorSpaceData)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
