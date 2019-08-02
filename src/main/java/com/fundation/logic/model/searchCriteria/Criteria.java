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
  * Implements the model class searchCriteria and the getter and setter´s methods.
  *
  * @authors Andres Burgos, Jesus Menacho, Melissa Román
  * @version 1.0
  */
 public abstract class Criteria {
     private String path;
     private String fileName;
     private String extension;

     /**
      * @return Extension.
      */
     public String getExtension() {
         return extension;
     }

     /**
      * Set Extension.
      */
     public void setExtension(String extension) {
         this.extension = extension;
     }

     /**
      * Set path.
      */
     public void setPath(String path) {
         this.path = path;
     }

     /**
      * @return path.
      */
     public String getPath() {
         return path;
     }

     /**
      * Set searchCriteria's fileName.
      */
     public void setFileName(String fileName) {
         this.fileName = fileName;
     }

     /**
      * @return fileName.
      */
     public String getFileName() {
         return fileName;
     }
 }
