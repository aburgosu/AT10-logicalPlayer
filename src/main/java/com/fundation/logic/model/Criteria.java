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

 /** 
  * Implements the model class File and the getter and setter´s methods
  * @author Andres Burgos
  * @version 1.0 *
  */
 public class Criteria {
     private String path;
     private String fileName;
     private String extension;

     public String getPath() {
         return path;
     }

     public void setPath(String path) {
         this.path = path;
     }

     public String getFileName() {
         return fileName;
     }

     public void setFileName(String fileName) {
         this.fileName = fileName;
     }

     public String getExtension() {
         return extension;
     }

     public void setExtension(String extension) {
         this.extension = extension;
     }
 }