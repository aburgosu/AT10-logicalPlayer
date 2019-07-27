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

import java.util.Date;

/**
 * Implements the model class Common and the getter and setter´s methods.
 *
 * @authors Andres Burgos.
 * @version 1.0
 */
public class Common extends Criteria {
    private String criteriaFileHidden;
    private String criteriaFileReadOnly;
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
    public void setCriteriaFileHidden(String criteriaFileHidden) {
        this.criteriaFileHidden = criteriaFileHidden;
    }

    /**
     * @return searchCriteria's hidden status.
     */
    public String getCriteriaFileHidden() {
        return criteriaFileHidden;
    }

    /**
     * Set searchCriteria's readOnly status.
     */
    public void setCriteriaFileReadOnly(String criteriaFileReadOnly) {
        this.criteriaFileReadOnly = criteriaFileReadOnly;
    }

    /**
     * @return searchCriteria's readOnly status.
     */
    public String getCriteriaFileReadOnly() {
        return criteriaFileReadOnly;
    }

    /**
     * Set lower limit for search by size searchCriteria.
     */
    public void setCriteriaSizeMin(Float criteriaSizeMin) {
        this.criteriaSizeMin = criteriaSizeMin;
    }

    /**
     * @return searchCriteria's lower limit for search.
     */
    public Float getCriteriaSizeMin() {
        return criteriaSizeMin;
    }

    /**
     * Set upper limit for search by size searchCriteria.
     */
    public void setCriteriaSizeMax(Float criteriaSizeMax) {
        this.criteriaSizeMax = criteriaSizeMax;
    }

    /**
     * @return searchCriteria's upper limit for search by size.
     */
    public Float getCriteriaSizeMax() {
        return criteriaSizeMax;
    }

    /**
     * Set lower limit for search by creation date searchCriteria.
     */
    public void setCriteriaCreationDateMin(Date criteriaCreationDateMin) {
        this.criteriaCreationDateMin = criteriaCreationDateMin;
    }

    /**
     * @return searchCriteria's lower limit for search by creation date.
     */
    public Date getCriteriaCreationDateMin() {
        return criteriaCreationDateMin;
    }

    /**
     * Set upper limit for search by creation date searchCriteria.
     */
    public void setCriteriaCreationDateMax(Date criteriaCreationDateMax) {
        this.criteriaCreationDateMax = criteriaCreationDateMax;
    }

    /**
     * @return searchCriteria's upper limit for search by creation date.
     */
    public Date getCriteriaCreationDateMax() {
        return criteriaCreationDateMax;
    }

    /**
     * Set lower limit for search by access date searchCriteria.
     */
    public void setCriteriaAccessDateMin(Date criteriaAccessDateMin) {
        this.criteriaAccessDateMin = criteriaAccessDateMin;
    }

    /**
     * @return searchCriteria's lower limit for search by access date.
     */
    public Date getCriteriaAccessDateMin() {
        return criteriaAccessDateMin;
    }

    /**
     * Set upper limit for search by access date searchCriteria.
     */
    public void setCriteriaAccessDateMax(Date criteriaAccessDateMax) {
        this.criteriaAccessDateMax = criteriaAccessDateMax;
    }

    /**
     * @return searchCriteria's upper limit for search by access date.
     */
    public Date getCriteriaAccessDateMax() {
        return criteriaAccessDateMax;
    }

    /**
     * Set lower limit for search by modification date searchCriteria.
     */
    public void setCriteriaModificationDateMin(Date criteriaModificationDateMin) {
        this.criteriaModificationDateMin = criteriaModificationDateMin;
    }

    /**
     * @return searchCriteria's lower limit for search by modification date.
     */
    public Date getCriteriaModificationDateMin() {
        return criteriaModificationDateMin;
    }

    /**
     * Set upper limit for search by modification date searchCriteria.
     */
    public void setCriteriaModificationDateMax(Date criteriaModificationDateMax) {
        this.criteriaModificationDateMax = criteriaModificationDateMax;
    }

    /**
     * @return searchCriteria's upper limit for search by modification date.
     */
    public Date getCriteriaModificationDateMax() {
        return criteriaModificationDateMax;
    }

    /**
     * Set searchCriteria's owner.
     */
    public void setCriteriaOwner(String criteriaOwner) {
        this.criteriaOwner = criteriaOwner;
    }

    /**
     * @return searchCriteria's owner.
     */
    public String getCriteriaOwner() {
        return criteriaOwner;
    }

    /**
     * Set searchCriteria's mimeType.
     */
    public void setCriteriaMimeType(String criteriaMimeType) {
        this.criteriaMimeType = criteriaMimeType;
    }

    /**
     * @return searchCriteria's mimeType.
     */
    public String getCriteriaMimeType() {
        return criteriaMimeType;
    }

    /**
     * Equals override to compare two common searchCriteria.
     * @param criteria - Criteria to be compare with.
     * @return True if two searchCriteria are equal.
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
