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
  * Implements the model class File and the getter and setter´s methods
  *
  * @authors Andres Burgos, Jesus Menacho, Melissa Román
  * @version 1.1
  */

 public class Criteria {
     private String criteriaPath;
     private String criteriaFileName;
     private String criteriaExtension;
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
      * Sets criteria's fileHidden status.
      * @param criteriaFileHidden - Value to be assigned to fileHidden status.
      */
     public void setCriteriaFileHidden(Boolean criteriaFileHidden) {
         this.criteriaFileHidden = criteriaFileHidden;
     }

     /**
      * Allows to get criteria's fileHidden status.
      * @return Criteria's hidden status.
      */
     public Boolean getCriteriaFileHidden() {
         return criteriaFileHidden;
     }

     /**
      * Sets criteria's readOnly status.
      * @param criteriaFileReadOnly - Value to be assigned to criteria's fileHidden status.
      */
     public void setCriteriaFileReadOnly(Boolean criteriaFileReadOnly) {
         this.criteriaFileReadOnly = criteriaFileReadOnly;
     }

     /**
      * Allows to get criteria's readOnly status.
      * @return Criteria's readOnly status.
      */
     public Boolean getCriteriaFileReadOnly() {
         return criteriaFileReadOnly;
     }

     /**
      * Sets criteria's path.
      * @param criteriaPath - Value to be assigned to criteria's path.
      */
     public void setCriteriaPath(String criteriaPath) {
         this.criteriaPath = criteriaPath;
     }

     /**
      * Allows to get criteria's path.
      * @return Criteria's Path.
      */
     public String getCriteriaPath() {
         return criteriaPath;
     }

     /**
      * Sets criteria's fileName.
      * @param criteriaFileName - Value to be assigned to criteria's fileName.
      */
     public void setCriteriaFileName(String criteriaFileName) {
         this.criteriaFileName = criteriaFileName;
     }

     /**
      * Allows to get criteria's fileName.
      * @return Criteria's fileName.
      */
     public String getCriteriaFileName() {
         return criteriaFileName;
     }

     /**
      * Sets criteria's extension.
      * @param criteriaExtension - Value to be assigned to criteria's extension.
      */
     public void setCriteriaExtension(String criteriaExtension) {
         this.criteriaExtension = criteriaExtension;
     }

     /**
      * Allows to get criteria's extension.
      * @return Criteria's extension.
      */
     public String getCriteriaExtension() {
         return criteriaExtension;
     }

     /**
      * Sets criteria's minimum size.
      * @param criteriaSizeMin - Value to be assigned to criteria's minimum size.
      */
     public void setCriteriaSizeMin(Float criteriaSizeMin) {
         this.criteriaSizeMin = criteriaSizeMin;
     }

     /**
      * Allows to get criteria's minimum size.
      * @return Criteria's minimum size.
      */
     public Float getCriteriaSizeMin() {
         return criteriaSizeMin;
     }

     /**
      * Sets criteria's maximum size.
      * @param criteriaSizeMax - Value to be assigned to criteria's maximum size.
      */
     public void setCriteriaSizeMax(Float criteriaSizeMax) {
         this.criteriaSizeMax = criteriaSizeMax;
     }

     /**
      * Allows to get criteria's maximum size.
      * @return Criteria's maximum size.
      */
     public Float getCriteriaSizeMax() {
         return criteriaSizeMax;
     }

     /**
      * Sets criteria's minimum creation date.
      * @param criteriaCreationDateMin - Value to be assigned to criteria's minimum creation date.
      */
     public void setCriteriaCreationDateMin(Date criteriaCreationDateMin) {
         this.criteriaCreationDateMin = criteriaCreationDateMin;
     }

     /**
      * Allows to get criteria's minimum creation date.
      * @return Criteria's minimum creation date..
      */
     public Date getCriteriaCreationDateMin() {
         return criteriaCreationDateMin;
     }

     /**
      * Sets criteria's maximum creation date.
      * @param criteriaCreationDateMax - Value to be assigned to criteria's maximum creation date.
      */
     public void setCriteriaCreationDateMax(Date criteriaCreationDateMax) {
         this.criteriaCreationDateMax = criteriaCreationDateMax;
     }

     /**
      * Allows to get criteria's maximum creation date.
      * @return Criteria's maximum creation date.
      */
     public Date getCriteriaCreationDateMax() {
         return criteriaCreationDateMax;
     }

     /**
      * Sets criteria's minimum access date.
      * @param criteriaAccessDateMin - Value to be assigned to criteria's minimum access date.
      */
     public void setCriteriaAccessDateMin(Date criteriaAccessDateMin) {
         this.criteriaAccessDateMin = criteriaAccessDateMin;
     }

     /**
      * Allows to get criteria's minimum access date.
      * @return Criteria's minimum access date.
      */
     public Date getCriteriaAccessDateMin() {
         return criteriaAccessDateMin;
     }

     /**
      * Sets criteria's maximum access date.
      * @param criteriaAccessDateMax - Value to be assigned to criteria's maximum access date.
      */
     public void setCriteriaAccessDateMax(Date criteriaAccessDateMax) {
         this.criteriaAccessDateMax = criteriaAccessDateMax;
     }

     /**
      * Allows to get criteria's maximum access date.
      * @return Criteria's maximum access date.
      */
     public Date getCriteriaAccessDateMax() {
         return criteriaAccessDateMax;
     }

     /**
      * Sets criteria's minimum modification date.
      * @param criteriaModificationDateMin - Value to be assigned to criteria's minimum modification date.
      */
     public void setCriteriaModificationDateMin(Date criteriaModificationDateMin) {
         this.criteriaModificationDateMin = criteriaModificationDateMin;
     }

     /**
      * Allows to get criteria's minimum modification date.
      * @return Criteria's minimum modification date.
      */
     public Date getCriteriaModificationDateMin() {
         return criteriaModificationDateMin;
     }

     /**
      * Sets criteria's maximum modification date.
      * @param criteriaModificationDateMax - Value to be assigned to criteria's maximum modification date.
      */
     public void setCriteriaModificationDateMax(Date criteriaModificationDateMax) {
         this.criteriaModificationDateMax = criteriaModificationDateMax;
     }

     /**
      * Allows to get criteria's maximum modification date.
      * @return Criteria's maximum modification date.
      */
     public Date getCriteriaModificationDateMax() {
         return criteriaModificationDateMax;
     }

     /**
      * Sets criteria's owner.
      * @param criteriaOwner - Value to be assigned to criteria's owner.
      */
     public void setCriteriaOwner(String criteriaOwner) {
         this.criteriaOwner = criteriaOwner;
     }

     /**
      * Allows to get criteria's owner.
      * @return Criteria's owner.
      */
     public String getCriteriaOwner() {
         return criteriaOwner;
     }

     /**
      * Sets criteria's mimeType.
      * @param criteriaMimeType - Value to be assigned to criteria's mimeType.
      */
     public void setCriteriaMimeType(String criteriaMimeType) {
         this.criteriaMimeType = criteriaMimeType;
     }

     /**
      * Allows to get criteria's mimeType.
      * @return Criteria's mimeType.
      */
     public String getCriteriaMimeType() {
         return criteriaMimeType;
     }
 }
