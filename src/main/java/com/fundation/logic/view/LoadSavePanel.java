package com.fundation.logic.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Implements the tab of LoadSave Panel.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class LoadSavePanel extends JPanel {
    private JTable dataTable;

    /**
     * Create the panel.
     */
    public LoadSavePanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{121, 70, 0, 70, 0, 70, 91, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        dataTable = new JTable();
        DefaultTableModel model = new DefaultTableModel(new Object[] {"NAME","DATE"}, 0);
        model.addRow(new Object[]{"NAME","DATE"});
        dataTable.setModel(model);
        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.gridwidth = 7;
        gbc_table.insets = new Insets(0, 0, 5, 0);
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 0;
        gbc_table.gridy = 0;
        add(dataTable, gbc_table);

        JButton btnLoad = new JButton("Load");
        GridBagConstraints gbc_btnLoad = new GridBagConstraints();
        gbc_btnLoad.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnLoad.insets = new Insets(0, 0, 0, 5);
        gbc_btnLoad.gridx = 1;
        gbc_btnLoad.gridy = 1;
        add(btnLoad, gbc_btnLoad);

        JButton btnSave = new JButton("Save");
        GridBagConstraints gbc_btnSave = new GridBagConstraints();
        gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnSave.insets = new Insets(0, 0, 0, 5);
        gbc_btnSave.gridx = 3;
        gbc_btnSave.gridy = 1;
        add(btnSave, gbc_btnSave);

        JButton btnDelete = new JButton("Delete ");
        GridBagConstraints gbc_btnDelete = new GridBagConstraints();
        gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
        gbc_btnDelete.gridx = 5;
        gbc_btnDelete.gridy = 1;
        add(btnDelete, gbc_btnDelete);
    }
}