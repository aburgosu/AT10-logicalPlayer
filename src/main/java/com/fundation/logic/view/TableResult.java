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

/**
 * Implements the Table Result to show to the users the results of th searches.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class TableResult extends JTable {

    DefaultTableModel model;

    public TableResult(){
        model = new DefaultTableModel(new Object[] { "Path", "Extension","Size","Date","Attributes" }, 45);
        this.setModel(model);
    }
}
