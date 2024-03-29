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

import com.fundation.logic.view.customElements.CustomTable;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Implements DetailsTable class which is in charge of show details of selected file.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class DetailsTable extends CustomTable {
    private DefaultTableModel model;

    /**
     * Constructs the details table.
     */
    public DetailsTable(List<String> detailsList) {
        initSetting(detailsList);
    }

    /**
     * Inits details table.
     */
    public void initSetting(List<String> detailsList) {
        model = new DefaultTableModel(new Object[]{"Metadata type", "Metadata info"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.setModel(model);
        showMetadataTable(detailsList);
    }

    /**
     * Adds a row to metadata table.
     * @param metadata - Type of metadata
     * @param metadataInfo - Metadata info
     */
    public void addMetadata(String metadata, String metadataInfo) {
        model.addRow(new Object[]{metadata, metadataInfo});
    }

    /**
     * Allows to get metadata type from a string.
     * @param detail
     * @return metadataType
     */
    public String getMetadataType(String detail) {
        int indexOfTwoPoints = detail.indexOf(":");
        return detail.substring(0, indexOfTwoPoints - 1);
    }

    /**
     * Allows to get metadata info from a string.
     * @param detail
     * @return metadataInfo
     */
    public String getMetadataInfo(String detail) {
        int indexOfTwoPoints = detail.indexOf(":");
        return detail.substring(indexOfTwoPoints + 1);
    }

    /**
     * Shows metadata table.
     * @param detailsList
     */
    public void showMetadataTable(List<String> detailsList) {
        for (int index = 1; index < detailsList.size(); index++) {
            addMetadata(getMetadataType(detailsList.get(index)), getMetadataInfo(detailsList.get(index)));
        }
    }
}
