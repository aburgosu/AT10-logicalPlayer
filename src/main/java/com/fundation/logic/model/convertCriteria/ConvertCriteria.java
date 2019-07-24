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
 * Implements ConvertCriteria class which is used to set the convert criteria.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ConvertCriteria {
    private String sourcePath;
    private String destinationPath;
    private String newName;
    private String metadataFormat;
    private String newFormat;

    /**
     * Allows to get source path.
     * @return file to be converted source path.
     */
    public String getSourcePath() {
        return sourcePath;
    }

    /**
     * Allows to set source path.
     * @param sourcePath - Source path to be set.
     */
    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    /**
     * Allows to get destination path.
     * @return file to be converted destination path.
     */
    public String getDestinationPath() {
        return destinationPath;
    }

    /**
     * Allows to set destination path.
     * @param destinationPath - Destination path to be set.
     */
    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    /**
     * Allows to get new name.
     * @return converted file new name.
     */
    public String getNewName() {
        return newName;
    }

    /**
     * Allows to set new name.
     * @param newName - Desired new name.
     */
    public void setNewName(String newName) {
        this.newName = newName;
    }

    /**
     * Allows to get required metadata format.
     * @return metadata format.
     */
    public String getMetadataFormat() {
        return metadataFormat;
    }

    /**
     * Allows to set metadata format.
     * @param metadataFormat - Desired metadata format.
     */
    public void setMetadataFormat(String metadataFormat) {
        this.metadataFormat = metadataFormat;
    }

    /**
     * Allows to get required new format.
     * @return new format.
     */
    public String getNewFormat() {
        return newFormat;
    }

    /**
     * Allows to set required new format.
     * @param newFormat - Desired new format.
     */
    public void setNewFormat(String newFormat) {
        this.newFormat = newFormat;
    }
}
