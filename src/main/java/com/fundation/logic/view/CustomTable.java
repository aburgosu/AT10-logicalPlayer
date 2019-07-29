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

import com.fundation.logic.view.resultTable.DetailsTable;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.*;

/**
 * Implements CustomTable class.
 *
 * @author Maday Alcalá
 * @version 1.0
 */
public class CustomTable extends JTable {
    public CustomTable() {
        super();

        Color tableColor = new Color(43,43,43);
        setBackground(tableColor);
        setFont(new Font("Calibri", 2, 14));
        setForeground(new Color(237, 234, 229));
        getTableHeader().setBackground(Color.cyan);
        setGridColor(Color.WHITE);
    }
}
