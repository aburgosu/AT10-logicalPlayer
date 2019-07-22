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

import java.util.Date;

/**
 * Implements the model class Common and the getter and setter´s methods.
 *
 * @authors Andres Burgos.
 * @version 1.0
 */
public class Common extends Criteria {
    private Boolean criteriaFileHidden;
    private Boolean criteriaFileReadOnly;
    private Float criteriaSizeMin;
    private Float criteriaSizeMax;
    private Date criteriaCreationDateMin;
    private Date criteriaCreationDateMax;
    private Date criteriaAccessDateMin;
    private Date criteriaAccessDateMax;
    private Date criteriaModificationDateMin;
    private Date criteriaModificationDateMax;
    private String criteriaOwner;
    private String criteriaMimeType;

    /**
     * Set criteriaFileHidden.
     */
    public void setCriteriaFileHidden(Boolean criteriaFileHidden) {
        this.criteriaFileHidden = criteriaFileHidden;
    }

    /**
     * @return criteria's hidden status.
     */
    public Boolean getCriteriaFileHidden() {
        return criteriaFileHidden;
    }

    /**
     * Set criteria's readOnly status.
     */
    public void setCriteriaFileReadOnly(Boolean criteriaFileReadOnly) {
        this.criteriaFileReadOnly = criteriaFileReadOnly;
    }

    /**
     * @return criteria's readOnly status.
     */
    public Boolean getCriteriaFileReadOnly() {
        return criteriaFileReadOnly;
    }

    /**
     * Set lower limit for search by size criteria.
     */
    public void setCriteriaSizeMin(Float criteriaSizeMin) {
        this.criteriaSizeMin = criteriaSizeMin;
    }

    /**
     * @return criteria's lower limit for search.
     */
    public Float getCriteriaSizeMin() {
        return criteriaSizeMin;
    }

    /**
     * Set upper limit for search by size criteria.
     */
    public void setCriteriaSizeMax(Float criteriaSizeMax) {
        this.criteriaSizeMax = criteriaSizeMax;
    }

    /**
     * @return criteria's upper limit for search by size.
     */
    public Float getCriteriaSizeMax() {
        return criteriaSizeMax;
    }

    /**
     * Set lower limit for search by creation date criteria.
     */
    public void setCriteriaCreationDateMin(Date criteriaCreationDateMin) {
        this.criteriaCreationDateMin = criteriaCreationDateMin;
    }

    /**
     * @return criteria's lower limit for search by creation date.
     */
    public Date getCriteriaCreationDateMin() {
        return criteriaCreationDateMin;
    }

    /**
     * Set upper limit for search by creation date criteria.
     */
    public void setCriteriaCreationDateMax(Date criteriaCreationDateMax) {
        this.criteriaCreationDateMax = criteriaCreationDateMax;
    }

    /**
     * @return criteria's upper limit for search by creation date.
     */
    public Date getCriteriaCreationDateMax() {
        return criteriaCreationDateMax;
    }

    /**
     * Set lower limit for search by access date criteria.
     */
    public void setCriteriaAccessDateMin(Date criteriaAccessDateMin) {
        this.criteriaAccessDateMin = criteriaAccessDateMin;
    }

    /**
     * @return criteria's lower limit for search by access date.
     */
    public Date getCriteriaAccessDateMin() {
        return criteriaAccessDateMin;
    }

    /**
     * Set upper limit for search by access date criteria.
     */
    public void setCriteriaAccessDateMax(Date criteriaAccessDateMax) {
        this.criteriaAccessDateMax = criteriaAccessDateMax;
    }

    /**
     * @return criteria's upper limit for search by access date.
     */
    public Date getCriteriaAccessDateMax() {
        return criteriaAccessDateMax;
    }

    /**
     * Set lower limit for search by modification date criteria.
     */
    public void setCriteriaModificationDateMin(Date criteriaModificationDateMin) {
        this.criteriaModificationDateMin = criteriaModificationDateMin;
    }

    /**
     * @return criteria's lower limit for search by modification date.
     */
    public Date getCriteriaModificationDateMin() {
        return criteriaModificationDateMin;
    }

    /**
     * Set upper limit for search by modification date criteria.
     */
    public void setCriteriaModificationDateMax(Date criteriaModificationDateMax) {
        this.criteriaModificationDateMax = criteriaModificationDateMax;
    }

    /**
     * @return criteria's upper limit for search by modification date.
     */
    public Date getCriteriaModificationDateMax() {
        return criteriaModificationDateMax;
    }

    /**
     * Set criteria's owner.
     */
    public void setCriteriaOwner(String criteriaOwner) {
        this.criteriaOwner = criteriaOwner;
    }

    /**
     * @return criteria's owner.
     */
    public String getCriteriaOwner() {
        return criteriaOwner;
    }

    /**
     * Set criteria's mimeType.
     */
    public void setCriteriaMimeType(String criteriaMimeType) {
        this.criteriaMimeType = criteriaMimeType;
    }

    /**
     * @return criteria's mimeType.
     */
    public String getCriteriaMimeType() {
        return criteriaMimeType;
    }

    /**
     * Equals override to compare two common criteria.
     * @param criteria - Criteria to be compare with.
     * @return True if two criteria are equal.
     */
    public boolean equals(Criteria criteria) {
            Common commonCriteria = (Common) criteria;
            if(this.getPath().equals(commonCriteria.getPath()) &&
                    this.getFileName().equals(commonCriteria.getFileName()) &&
                    this.getExtension().equals(commonCriteria.getExtension()) &&
                    this.criteriaFileHidden.equals(commonCriteria.criteriaFileHidden) &&
                    this.criteriaFileReadOnly.equals(commonCriteria.criteriaFileReadOnly) &&
                    this.criteriaSizeMin.equals(commonCriteria.criteriaSizeMin) &&
                    this.criteriaSizeMax.equals(commonCriteria.criteriaSizeMax) &&
                    this.criteriaCreationDateMin.equals(commonCriteria.criteriaCreationDateMin) &&
                    this.criteriaCreationDateMax.equals(commonCriteria.criteriaCreationDateMax) &&
                    this.criteriaAccessDateMin.equals(commonCriteria.criteriaAccessDateMin) &&
                    this.criteriaAccessDateMax.equals(commonCriteria.criteriaAccessDateMax) &&
                    this.criteriaModificationDateMin.equals(commonCriteria.criteriaModificationDateMin) &&
                    this.criteriaModificationDateMax.equals(commonCriteria.criteriaModificationDateMax) &&
                    this.criteriaOwner.equals(commonCriteria.criteriaOwner) &&
                    this.criteriaMimeType.equals(commonCriteria.criteriaMimeType)) {
                return true;
            }
        return false;
    }
}
