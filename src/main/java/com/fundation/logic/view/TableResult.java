/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 * Implements the Table Result to show to the users the results of th searches.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class TableResult extends JTable {
    DefaultTableModel model;

    /**
     * Initializes a TableResult instance with headers
     */
    public TableResult(){
        model = new DefaultTableModel(new Object[] { "Path", "Extension","Size","Date","Attributes" }, 0);
        model.addRow(new Object[]{"FILE","EXTENSION","SIZE","DATE","ATTRIBUTE"});
        this.setModel(model);
    }

    /**
     * Add a new row to ResultTable
     */
    public void addResult(String path, String extension, Float size, Date date, String attribute) {
        model.addRow(new Object[]{path, extension, size, date, attribute});
    }

    /**
     * Removes all the rows in the ResultTable
     */
    public void clearTableResult()
    {
        model.getDataVector().removeAllElements();
        revalidate();
    }
}
