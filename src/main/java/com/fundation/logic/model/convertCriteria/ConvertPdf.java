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
 * Implements ConvertPdf class which is used to set pdf convert criteria.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertPdf extends ConvertCriteria{
    private String colorFormat;
    private String dpi;

    /**
     * Allows to get desired color format.
     * @return Desired color format.
     */
    public String getColorFormat() {
        return colorFormat;
    }

    /**
     * Allows to set desired color format.
     * @param colorFormat - Desired color format.
     */
    public void setColorFormat(String colorFormat) {
        this.colorFormat = colorFormat;
    }

    /**
     * Allows to get desired dpi.
     * @return Desired dpi.
     */
    public String getDpi() {
        return dpi;
    }

    /**
     * Allows to set desired dpi.
     * @param dpi - Desired dpi.
     */
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
}
