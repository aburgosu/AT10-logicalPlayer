/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view.loadSaveCriteria;

import com.fundation.logic.view.customElements.CustomButton;
import com.fundation.logic.view.customElements.CustomPanelSecond;
import com.fundation.logic.view.customElements.CustomTable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Implements the tab of LoadSave Panel.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class LoadSavePanel extends CustomPanelSecond {
    private JTable dataTable;
    private DefaultTableModel model;

    /**
     * Create the panel.
     */
    public LoadSavePanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{40, 40, 40, 40};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        dataTable = new CustomTable();
        model = new DefaultTableModel(new Object[] {"Name", "Type", "Date", "ID"}, 0);
        model.addRow(new Object[]{"Name", "Type", "Date", "ID"});
        dataTable.setModel(model);
        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.gridwidth = 7;
        gbc_table.insets = new Insets(0, 0, 5, 0);
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 0;
        gbc_table.gridy = 0;
        add(dataTable, gbc_table);

        CustomButton btnLoad = new CustomButton(" Update ");
        GridBagConstraints gbc_btnLoad = new GridBagConstraints();
        gbc_btnLoad.fill = GridBagConstraints.CENTER;
        gbc_btnLoad.insets = new Insets(0, 0, 10, 5);
        gbc_btnLoad.gridx = 1;
        gbc_btnLoad.gridy = 1;
        add(btnLoad, gbc_btnLoad);

        CustomButton btnSave = new CustomButton(" Save ");
        GridBagConstraints gbc_btnSave = new GridBagConstraints();
        gbc_btnSave.fill = GridBagConstraints.CENTER;
        gbc_btnSave.insets = new Insets(0, 0, 10, 5);
        gbc_btnSave.gridx = 2;
        gbc_btnSave.gridy = 1;
        add(btnSave, gbc_btnSave);

        CustomButton btnDelete = new CustomButton("Delete");
        GridBagConstraints gbc_btnDelete = new GridBagConstraints();
        gbc_btnDelete.fill = GridBagConstraints.CENTER;
        gbc_btnDelete.insets = new Insets(0, 0, 10, 5);
        gbc_btnDelete.gridx = 3;
        gbc_btnDelete.gridy = 1;
        add(btnDelete, gbc_btnDelete);
    }


    /**
     * Adds a new row to ResultTable
     */
    public void addRegister(String name, String type, String date, String id) {
        model.addRow(new Object[]{name, type, date, id});
        revalidate();
    }

    /**
     * Removes all the rows in the ResultTable
     */
    public void clearTableResult() {
        model.getDataVector().removeAllElements();
        model.setRowCount(0);
        model.addRow(new Object[]{"Name", "Type", "Date", "ID"});
        model.fireTableDataChanged();
        revalidate();
    }

    /**
     * Allows to get table model.
     * @return Table model.
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * Allows to get datatable.
     * @return Data table.
     */
    public JTable getDataTable() {
        return dataTable;
    }
}
