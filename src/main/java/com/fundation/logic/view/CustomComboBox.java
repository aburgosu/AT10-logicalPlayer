package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;

public class CustomComboBox extends JComboBox {
    public CustomComboBox() {
        super();
        Color buttonColor = new Color(255, 240,245);
        setBackground(buttonColor);
        Font fuente = new Font("Calibri", 3, 14);
        setFont(fuente);
    }
}
