package com.fundation.logic.view.loadSaveCriteria;

import com.fundation.logic.view.CustomButton;
import com.fundation.logic.view.CustomPanelSecond;
import com.fundation.logic.view.CustomTable;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

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

        model = new DefaultTableModel(new Object[] {"Name", "Type", "Date"}, 0);
        //model.addRow(new Object[]{"Name", "Type", "Date"});
        dataTable.setModel(model);
        JScrollPane tableScrollPanel = new JScrollPane(add(dataTable));
        tableScrollPanel.getViewport().setBackground(new Color(43,43,43));
        GridBagConstraints gbc_table = new GridBagConstraints();

        gbc_table.gridwidth = 7;
        gbc_table.insets = new Insets(0, 0, 5, 0);
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 0;
        gbc_table.gridy = 0;
        add(tableScrollPanel, gbc_table);

        CustomButton btnLoad = new CustomButton(" Load ");
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
    public void addRegister(String name, String type, String date) {
        model.addRow(new Object[]{name, type, date});
        revalidate();
    }

    /**
     * Removes all the rows in the ResultTable
     */
    public void clearTableResult() {
        model.getDataVector().removeAllElements();
        model.setRowCount(0);
        //model.addRow(new Object[]{"Name", "Type", "Date"});
        model.fireTableDataChanged();
        revalidate();
    }
}
