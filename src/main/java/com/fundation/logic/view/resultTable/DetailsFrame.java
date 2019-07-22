/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.resultTable;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.io.File;

/**
 * Implements DetailsFrame class which is in charge of show details of selected file.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class DetailsFrame extends JFrame {
    private DetailsTable detailsTable;

    /**
     * Inits details frame.
     * @param path - Path of the file to show details from
     */
    public DetailsFrame(String path) {
       initSetting(path);
    }

    /**
     * Inits frame to show details.
     * @param path - Path of the file to show details from
     */
    public void initSetting(String path) {
        setBounds(new Rectangle(700, 100, 400, 400));
        File file = new File(path);
        setTitle(file.getName() + " Metadata");
        detailsTable = new DetailsTable();
        add(detailsTable);
    }

}