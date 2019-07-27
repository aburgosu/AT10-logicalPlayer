package com.fundation.logic.view;

import javax.swing.*;
import java.awt.*;

public class CustomTextField extends JTextField {
    public CustomTextField() {
        super();
        Color buttonColor = new Color(220, 220, 220);
        setBackground(buttonColor);
        Font fuente = new Font("Calibri", 3, 12);
        setFont(fuente);
    }
}
