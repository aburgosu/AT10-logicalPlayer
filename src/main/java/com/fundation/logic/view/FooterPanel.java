package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel {
    Label copyRight = new Label();
    public FooterPanel(){
        copyRight.setText("Copyright");
        copyRight.setForeground(Color.BLACK);
        add(copyRight);
    }
}
