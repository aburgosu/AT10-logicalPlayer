 /*
  * Copyright (c) 2019 Jalasoft.
  * This software is the confidential and proprietary information of Jalasoft.
  * ("Confidential Information"). You shall not
  * disclose such Confidential Information and shall use it only in
  * accordance with the terms of the license agreement you entered into
  * with Jalasoft.
  */

 package com.fundation.logic.Model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

 /* Implements the model class File and the getter and setter´s methods
  * @author Jesus Menacho
  * @version 1.0 *
  */
public class SearchVideo implements ISearch {
static Criteria criteria;

    public SearchVideo(Criteria criteria){
        this.criteria = criteria;
    }

    public List searchAnyWant() {
        final String FILE_PATH = criteria.getPath();
        List<String> listFileAndDirectory = new ArrayList<String>();
        File file = new File(FILE_PATH);
        File[] allSubFiles=file.listFiles();
        for (File fileExtractor : allSubFiles) {
            if (criteria.getPath().equals(""))
            listFileAndDirectory.add(fileExtractor.getAbsolutePath());

        }
        return listFileAndDirectory;
    }
    public boolean searchByFile(){
        final String FILE_PATH = criteria.getPath();
        File file = new File(FILE_PATH);
        File[] allSubFiles=file.listFiles();
        for (File fileExtractor : allSubFiles) {
            if (file.getName().equals(criteria.getFileName())){
                return false;
            }
        }
        return false;
    }
    public List searchByExtencions(){
        final String FILE_PATH = criteria.getPath();
        List<String> listFileAndDirectory = new ArrayList<String>();
        File file = new File(FILE_PATH);
        File[] allSubFiles=file.listFiles();
        for (File fileExtractor : allSubFiles) {
            if (file.getName().substring((file.getName().length())-3),file.getName().length()).equals(criteria.getExtension()){
                listFileAndDirectory.add(fileExtractor.getAbsolutePath());
            }
        }
        return listFileAndDirectory;
    }



        public static void main(String arg[]){


        final String ROOT_FILE_PATH="/home/pepe";
        File f=new File(ROOT_FILE_PATH);
        File[] allSubFiles=f.listFiles();
        for (File file : allSubFiles) {
            if(file.isDirectory())
            {
                System.out.println(file.getAbsolutePath()+" is directory");

                //Steps for directory
            }
            else
            {
                System.out.println(file.getAbsolutePath()+" is file");
                //steps for files
                System.out.println(file.getName()+"AAAA");
            }
        }


    }
}

