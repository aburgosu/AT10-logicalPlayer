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

import com.fundation.logic.common.FileInfo;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

/**
 * Implements the Table Result to show to the users the results of th searches.
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class TableResult extends JTable {
    private DefaultTableModel model;

    /**
     * Initializes a TableResult instance with headers
     */
    public TableResult(){
        model = new DefaultTableModel(new Object[] {"path","file", "extension","size","creationDate","modificationDate","lastAccessDate","attributes"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addRow(new Object[]{"PATH","FILE","EXTENSION","SIZE","CREATION DATE","MODIFICATION DATE","LAST ACCESS DATE","ATTRIBUTE"});
        this.setModel(model);
        this.initListen();
    }

    /**
     * Adds a new row to ResultTable
     */
    public void addResult(String path,String file, String extension, Float size, Date creationDate,Date modificationDate ,Date lastAccessDate,String attribute) {
        model.addRow(new Object[]{path, file, extension, size+" bytes", creationDate,modificationDate,lastAccessDate, attribute});
    }

    /**
     * Removes all the rows in the ResultTable
     */
    public void clearTableResult() {
        model.getDataVector().removeAllElements();
        model.setRowCount(0);
        model.addRow(new Object[]{"PATH","FILE","EXTENSION","SIZE","CREATION DATE","MODIFICATION DATE","LAST ACCESS DATE","ATTRIBUTE"});
        model.fireTableDataChanged();
        revalidate();
    }

    /**
     * Listen to right click to play the selected row's file.
     */
    public void initListen() {
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON3) {
                    int row = getSelectedRow();
                    final int PATH_COLUMN = 0;
                    String filePath = (String) model.getValueAt(row, PATH_COLUMN);
                    if (FileInfo.isVideo(filePath) || FileInfo.isAudio(filePath)) {
                        PlayerFrame playerWindow = new PlayerFrame(filePath);
                        playerWindow.setVisible(true);
                    }
                }
            }
        });
    }
}
