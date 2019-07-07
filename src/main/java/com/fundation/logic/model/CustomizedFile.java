/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model;

import java.util.Date;

/**
 * Implements CustomizedFile class which is the new kind of file that will return the main search method.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CustomizedFile {
    private String path;
    private String name;
    private String extension;
    private boolean hiddenStatus;
    private boolean readOnlyStatus;
    private Float size;
    private Date creationDate;
    private Date accessDate;
    private Date modificationDate;
    private String owner;
    private String mimeType;

    /**
     * CustomizedFile constructor. It requires all parameters so them will be assigned to each attribute.
     * @param path
     * @param name
     * @param extension
     * @param hiddenStatus
     * @param readOnlyStatus
     * @param size
     * @param creationDate
     * @param accessDate
     * @param modificationDate
     * @param owner
     */
    public CustomizedFile( String path, String name, String extension, boolean hiddenStatus, boolean readOnlyStatus,
            Float size, Date creationDate, Date accessDate, Date modificationDate, String owner, String mimeType) {
        this.path = path;
        this.name = name;
        this.extension = extension;
        this.hiddenStatus = hiddenStatus;
        this.readOnlyStatus = readOnlyStatus;
        this.size = size;
        this.creationDate = creationDate;
        this.accessDate = accessDate;
        this.modificationDate = modificationDate;
        this.owner = owner;
        this.mimeType = mimeType;
    }

    /**
     * @return File's path.
     */
    public String getPath() {
        return path;
    }

    /**
     * @return File's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return File's extension.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @return File's hidden status.
     */
    public boolean getHiddenStatus() {
        return hiddenStatus;
    }

    /**
     * @return File's readOnly status.
     */
    public boolean getReadOnly() {
        return readOnlyStatus;
    }

    /**
     * @return File's size in bytes.
     */
    public Float getSize() {
        return size;
    }

    /**
     * @return File's creation date.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @return File's last access date.
     */
    public Date getAccessDate() {
        return accessDate;
    }

    /**
     * @return File's last modification date.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * @return File's owner user.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @return File's mimeType.
     */
    public String getMimeType() {
        return mimeType;
    }
}
