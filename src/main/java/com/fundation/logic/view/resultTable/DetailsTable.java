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

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Implements DetailsTable class which is in charge of show details of selected file.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class DetailsTable extends JTable {
    private DefaultTableModel model;

    public DetailsTable() {
        initSetting();
    }

    public void initSetting() {
        model = new DefaultTableModel(new Object[]{"Metadata", "MetadataInfo"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.setModel(model);
        //showMetadataTable();
    }

    public void addResult(String metadata, String metadataInfo) {
        model.addRow(new Object[]{metadata, metadataInfo});
    }

    public String getMetadataType(String detail) {
        int indexOfTwoPoints = detail.indexOf(":");
        return detail.substring(0, indexOfTwoPoints - 1);
    }

    public String getMetadataInfo(String detail) {
        int indexOfTwoPoints = detail.indexOf(":");
        return detail.substring(indexOfTwoPoints);
    }

    public void showMetadataTable(List<String> detailsList) {
        for (int index = 0; index < detailsList.size(); index++) {
            addResult(getMetadataType(detailsList.get(index)), getMetadataInfo(detailsList.get(index)));
        }
    }
}
