package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;

public class CustomJFrame extends JFrame {
    JLabel label = new JLabel("Welcome!", JLabel.CENTER);
    public CustomJFrame(){
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add(label, BorderLayout.CENTER);
        setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);




        //getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        //this.getContentPane().setBackground(Color.orange);
        setVisible(true);
        getRootPane().getLayeredPane().setBackground(Color.BLACK);

    }
}
