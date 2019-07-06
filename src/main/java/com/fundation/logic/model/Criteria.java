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
     private Float criteriaSizeLowerLimit;
     private Float criteriaSizeUpperLimit;
     private Date criteriaCreationDateLL;
     private Date criteriaCreationDateUL;
     private Date criteriaAccessDateLL;
     private Date criteriaAccessDateUL;
     private Date criteriaModificationDateLL;
     private Date criteriaModificationDateUL;

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
     public void setCriteriaSizeLowerLimit(Float criteriaSizeLowerLimit) {
         this.criteriaSizeLowerLimit = criteriaSizeLowerLimit;
     }

     /**
      * @return Criteria's lower limit for search.
      */
     public Float getCriteriaSizeLowerLimit() {
         return criteriaSizeLowerLimit;
     }

     /**
      * Set upper limit for search by size criteria.
      */
     public void setCriteriaSizeUpperLimit(Float criteriaSizeUpperLimit) {
         this.criteriaSizeUpperLimit = criteriaSizeUpperLimit;
     }

     /**
      * @return Criteria's upper limit for search by size.
      */
     public Float getCriteriaSizeUpperLimit() {
         return criteriaSizeUpperLimit;
     }

     /**
      * Set lower limit for search by creation date criteria.
      */
     public void setCriteriaCreationDateLL(Date criteriaCreationDateLL) {
         this.criteriaCreationDateLL = criteriaCreationDateLL;
     }

     /**
      * @return Criteria's lower limit for search by creation date.
      */
     public Date getCriteriaCreationDateLL() {
         return criteriaCreationDateLL;
     }

     /**
      * Set upper limit for search by creation date criteria.
      */
     public void setCriteriaCreationDateUL(Date criteriaCreationDateUL) {
         this.criteriaCreationDateUL = criteriaCreationDateUL;
     }

     /**
      * @return Criteria's upper limit for search by creation date.
      */
     public Date getCriteriaCreationDateUL() {
         return criteriaCreationDateUL;
     }

     /**
      * Set lower limit for search by access date criteria.
      */
     public void setCriteriaAccessDateLL(Date criteriaAccessDateLL) {
         this.criteriaAccessDateLL = criteriaAccessDateLL;
     }

     /**
      * @return Criteria's lower limit for search by access date.
      */
     public Date getCriteriaAccessDateLL() {
         return criteriaAccessDateLL;
     }

     /**
      * Set upper limit for search by access date criteria.
      */
     public void setCriteriaAccessDateUL(Date criteriaAccessDateUL) {
         this.criteriaAccessDateUL = criteriaAccessDateUL;
     }

     /**
      * @return Criteria's upper limit for search by access date.
      */
     public Date getCriteriaAccessDateUL() {
         return criteriaAccessDateUL;
     }

     /**
      * Set lower limit for search by modification date criteria.
      */
     public void setCriteriaModificationDateLL(Date criteriaModificationDateLL) {
         this.criteriaModificationDateLL = criteriaModificationDateLL;
     }

     /**
      * @return Criteria's lower limit for search by modification date.
      */
     public Date getCriteriaModificationDateLL() {
         return criteriaModificationDateLL;
     }

     /**
      * Set upper limit for search by modification date criteria.
      */
     public void setCriteriaModificationDateUL(Date criteriaModificationDateUL) {
         this.criteriaModificationDateUL = criteriaModificationDateUL;
     }

     /**
      * @return Criteria's upper limit for search by modification date.
      */
     public Date getCriteriaModificationDateUL() {
         return criteriaModificationDateUL;
     }
 }
