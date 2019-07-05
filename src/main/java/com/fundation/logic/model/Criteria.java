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
     private String path;
     private String fileName;
     private String extension;
     private Boolean fileHidden = false;
     private Boolean fileReadOnly = false;
     private Float sizeLowerLimit;
     private Float sizeUpperLimit;
     private Date creationDateLL;
     private Date creationDateUL;
     private Date accessDateLL;
     private Date accessDateUL;
     private Date modificationDateLL;
     private Date modificationDateUL;

     /**
      * Set criteria's fileHidden.
      */
     public void setFileHidden(Boolean fileHidden) {
         this.fileHidden = fileHidden;
     }

     /**
      * @return Criteria's hidden status.
      */
     public Boolean getFileHidden() {
         return fileHidden;
     }

     /**
      * Set criteria's readOnly status.
      */
     public void setFileReadOnly(Boolean fileReadOnly){
         this.fileReadOnly = fileReadOnly;
     }

     /**
      * @return Criteria's readOnly status.
      */
     public Boolean getFileReadOnly() {
         return fileReadOnly;
     }

     /**
      * Set criteria's path.
      */
     public void setPath(String path) {
         this.path = path;
     }

     /**
      * @return Criteria's path.
      */
     public String getPath() {
         return path;
     }

     /**
      * Set criteria's fileName.
      */
     public void setFileName(String fileName) {
         this.fileName = fileName;
     }

     /**
      * @return Criteria's fileName.
      */
     public String getFileName() {
         return fileName;
     }

     /**
      * Set criteria's extension.
      */
     public void setExtension(String extension) {
         this.extension = extension;
     }

     /**
      * @return Criteria's extension.
      */
     public String getExtension() {
         return extension;
     }

     /**
      * Set lower limit for search by size criteria.
      */
     public void setSizeLowerLimit(Float sizeLowerLimit) {
         this.sizeLowerLimit = sizeLowerLimit;
     }

     /**
      * @return Criteria's lower limit for search.
      */
     public Float getSizeLowerLimit() {
         return sizeLowerLimit;
     }

     /**
      * Set upper limit for search by size criteria.
      */
     public void setSizeUpperLimit(Float sizeUpperLimit) {
         this.sizeUpperLimit = sizeUpperLimit;
     }

     /**
      * @return Criteria's upper limit for search by size.
      */
     public Float getSizeUpperLimit() {
         return sizeUpperLimit;
     }

     /**
      * Set lower limit for search by creation date criteria.
      */
     public void setCreationDateLL(Date creationDateLL) {
         this.creationDateLL = creationDateLL;
     }

     /**
      * @return Criteria's lower limit for search by creation date.
      */
     public Date getCreationDateLL() {
         return creationDateLL;
     }

     /**
      * Set upper limit for search by creation date criteria.
      */
     public void setCreationDateUL(Date creationDateUL) {
         this.creationDateUL = creationDateUL;
     }

     /**
      * @return Criteria's upper limit for search by creation date.
      */
     public Date getCreationDateUL() {
         return creationDateUL;
     }

     /**
      * Set lower limit for search by access date criteria.
      */
     public void setAccessDateLL(Date accessDateLL) {
         this.accessDateLL = accessDateLL;
     }

     /**
      * @return Criteria's lower limit for search by access date.
      */
     public Date getAccessDateLL() {
         return accessDateLL;
     }

     /**
      * Set upper limit for search by access date criteria.
      */
     public void setAccessDateUL(Date accessDateUL) {
         this.accessDateUL = accessDateUL;
     }

     /**
      * @return Criteria's upper limit for search by access date.
      */
     public Date getAccessDateUL() {
         return accessDateUL;
     }

     /**
      * Set lower limit for search by modification date criteria.
      */
     public void setModificationDateLL(Date modificationDateLL) {
         this.modificationDateLL = modificationDateLL;
     }

     /**
      * @return Criteria's lower limit for search by modification date.
      */
     public Date getModificationDateLL() {
         return modificationDateLL;
     }

     /**
      * Set upper limit for search by modification date criteria.
      */
     public void setModificationDateUL(Date modificationDateUL) {
         this.modificationDateUL = modificationDateUL;
     }

     /**
      * @return Criteria's upper limit for search by modification date.
      */
     public Date getModificationDateUL() {
         return modificationDateUL;
     }
 }
