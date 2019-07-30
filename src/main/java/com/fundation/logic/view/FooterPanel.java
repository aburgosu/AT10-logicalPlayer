package com.fundation.logic.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Label;

public class FooterPanel extends JPanel {
    Label copyRight = new Label();
    public FooterPanel(){
        copyRight.setText("Copyright");
        copyRight.setForeground(Color.BLACK);
        add(copyRight);
    }
}
