/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic;

import com.fundation.logic.view.SearchVideoFrame;
import com.fundation.logic.controller.Controller;

import java.io.File;
import java.util.List;

/**
 * Implements the main class
 *
 * @author Andres Burgos
 * @version 1.0 *
 */
public class main {

    public static void main(String[] arg) {
        SearchVideoFrame searchFrame = new SearchVideoFrame();
        Controller controller = new Controller(searchFrame);
        List<File> filesInPath;

        System.out.println("Search by path");
        filesInPath = controller.makeSearch(controller.setCriteria("C:/Users/MelissaRoman/Downloads/",
            null, null, false, false));
        for (int index = 0; index < filesInPath.size(); index++) {
            System.out.println(filesInPath.get(index));
        }
        System.out.println();

        System.out.println("Search by path and filename");
        filesInPath = controller.makeSearch(controller.setCriteria("C:/Users/MelissaRoman/Downloads/",
            "desktop", "", false, false));
        for (int index = 0; index < filesInPath.size(); index++) {
            System.out.println(filesInPath.get(index));
        }
        System.out.println();

        System.out.println("Search by path and extension");
        filesInPath = controller.makeSearch(controller.setCriteria("C:/Users/MelissaRoman/Downloads/",
            "", "docx", false, false));
        for (int index = 0; index < filesInPath.size(); index++) {
            System.out.println(filesInPath.get(index));
        }
        System.out.println();

        System.out.println("Search by path including hidden files");
        filesInPath = controller.makeSearch(controller.setCriteria("C:/Users/MelissaRoman/Downloads/",
            "", "", true, false));
        for (int index = 0; index < filesInPath.size(); index++) {
            System.out.println(filesInPath.get(index));
        }
        System.out.println();

        System.out.println("Search by path read only files only");
        filesInPath = controller.makeSearch(controller.setCriteria("C:/Users/MelissaRoman/Downloads/",
            "", "", false, true));
        for (int index = 0; index < filesInPath.size(); index++) {
            System.out.println(filesInPath.get(index));
        }
        System.out.println();

        System.out.println("Search by path, filename and extension");
        filesInPath = controller.makeSearch(controller.setCriteria("C:/Users/MelissaRoman/Downloads/",
                "1.-libro-base", "zip", false, false));
        for (int index = 0; index < filesInPath.size(); index++) {
            System.out.println(filesInPath.get(index));
        }
        System.out.println();
    }
}
