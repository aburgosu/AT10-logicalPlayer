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

     /**
      * Set criteriaFileHidden.
      */
     public void setCriteriaFileHidden(Boolean criteriaFileHidden) {
         this.criteriaFileHidden = criteriaFileHidden;
     }

     /**
      * @return Criteria's hidden status.
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
      * @return Criteria's readOnly status.
      */
     public Boolean getCriteriaFileReadOnly() {
         return criteriaFileReadOnly;
     }

     /**
      * Set criteriaPath.
      */
     public void setCriteriaPath(String criteriaPath) {
         this.criteriaPath = criteriaPath;
     }

     /**
      * @return criteriaPath.
      */
     public String getCriteriaPath() {
         return criteriaPath;
     }

     /**
      * Set criteria's fileName.
      */
     public void setCriteriaFileName(String criteriaFileName) {
         this.criteriaFileName = criteriaFileName;
     }

     /**
      * @return criteriaFileName.
      */
     public String getCriteriaFileName() {
         return criteriaFileName;
     }

     /**
      * Set criteria's extension.
      */
     public void setCriteriaExtension(String criteriaExtension) {
         this.criteriaExtension = criteriaExtension;
     }

     /**
      * @return criteriaExtension.
      */
     public String getCriteriaExtension() {
         return criteriaExtension;
     }

     /**
      * Set lower limit for search by size criteria.
      */
     public void setCriteriaSizeMin(Float criteriaSizeMin) {
         this.criteriaSizeMin = criteriaSizeMin;
     }

     /**
      * @return Criteria's lower limit for search.
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
      * @return Criteria's upper limit for search by size.
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
      * @return Criteria's lower limit for search by creation date.
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
      * @return Criteria's upper limit for search by creation date.
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
      * @return Criteria's lower limit for search by access date.
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
      * @return Criteria's upper limit for search by access date.
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
      * @return Criteria's lower limit for search by modification date.
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
      * @return Criteria's upper limit for search by modification date.
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
      * @return Criteria's owner.
      */
     public String getCriteriaOwner() {
         return criteriaOwner;
     }
 }
