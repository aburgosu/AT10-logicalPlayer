package com.fundation.logic.view;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class CustomTable extends JTable {
    public CustomTable() {
        super();
        Color myColor = new Color(43,43,43);
        setBackground(myColor);
        setForeground(Color.WHITE);
        getTableHeader().setBackground(Color.RED);
        //getCellEditor(1,1).g
        setGridColor(Color.BLACK);

        JScrollPane scroll = new JScrollPane();

    }
}
