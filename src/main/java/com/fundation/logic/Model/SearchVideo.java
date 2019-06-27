 /*
  * Copyright (c) 2019 Jalasoft.
  * This software is the confidential and proprietary information of Jalasoft.
  * ("Confidential Information"). You shall not
  * disclose such Confidential Information and shall use it only in
  * accordance with the terms of the license agreement you entered into
  * with Jalasoft.
  */
 /* Implements the model class File and the getter and setter´s methods
  * @author Jesus Menacho
  * @version 1.0 *
  */
package com.fundation.logic.Model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SearchVideo implements ISearch {

    public SearchVideo(){
    }
    public static List searchByPath(final String pathDirectory) {
        List<String> listFileAndDirectory = new ArrayList<String>();
        File file=new File(pathDirectory);
        File[] allSubFiles=file.listFiles();
        for (File fileExtractor : allSubFiles) {
            listFileAndDirectory.add(fileExtractor.getAbsolutePath());
        }
        return listFileAndDirectory;
    }
}
