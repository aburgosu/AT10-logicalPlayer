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

import com.fundation.logic.view.CustomTable;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

/**
 * Implements the Table Result to show to the users the results of th searches.
 *
 * @author Andres Burgos, Jesus Menacho, Melissa Román
 * @version 1.0
 */
public class TableResult extends CustomTable {
    private DefaultTableModel model;

    /**
     * Initializes a TableResult instance with headers
     */
    public TableResult() {
        model = new DefaultTableModel(new Object[]{"Path", "Name", "Extension", "Size", "Date created", "Date modified",
                "Date last accessed", "Metadata"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        this.setModel(model);

        this.getColumn(this.getColumnName(7)).setMaxWidth(0);
        this.getColumn(this.getColumnName(0)).setPreferredWidth(300);
        this.initListen();

    }

    /**
     * Adds a new row to ResultTable
     */
    public void addResult(String path, String file, String extension, String size, Date creationDate,
            Date modificationDate, Date lastAccessDate, List metadata) {
        model.addRow(new Object[]{path, file, extension, size, creationDate, modificationDate,
            lastAccessDate, metadata});
    }

    /**
     * Removes all the rows in the ResultTable
     */
    public void clearTableResult() {
        model.getDataVector().removeAllElements();
        model.setRowCount(0);
//        model.addRow(new Object[]{"Path", "Name", "Extension", "Size", "Date created", "Date modified",
//            "Date last accessed", "Metadata"});
        model.fireTableDataChanged();
        revalidate();
    }

    /**
     * Listen to right click to play the selected row's file.
     */
    public void initListen() {
        try {
            this.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
                    if (me.getButton() == MouseEvent.BUTTON3) {
                        int row = getSelectedRow();
                        final int PATH_COLUMN = 0;
                        final int METADATA_COLUMN = 7;
                        String filePath = (String) model.getValueAt(row, PATH_COLUMN);
                        List<String> metadata = (List) model.getValueAt(row, METADATA_COLUMN);
                        PopupMenu menu = new PopupMenu(filePath, metadata);
                        menu.show(me.getComponent(), me.getX(), me.getY());
                        menu.setVisible(true);
                    }
                }
            });
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
