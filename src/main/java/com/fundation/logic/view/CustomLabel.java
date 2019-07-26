package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel {
    public CustomLabel(String name) {
        super(name);
        Color buttonColor = new Color(0, 255, 128);
        setBackground(buttonColor);
        Font fuente = new Font("Agency FB",3, 20);
        setFont(fuente);
    }
}
